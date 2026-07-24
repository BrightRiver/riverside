package scorned.riverside.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ColorParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;

import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import scorned.riverside.block.entity.ModBlockEntities;
import scorned.riverside.block.entity.PicklingVesselBlockEntity;
import scorned.riverside.tag.ModTags;

import java.util.List;

public class PicklingVesselBlock extends BaseEntityBlock implements SimpleWaterloggedBlock {
    public static final MapCodec<scorned.riverside.block.PicklingVesselBlock> CODEC = simpleCodec(scorned.riverside.block.PicklingVesselBlock::new);
    public static final Identifier SHERDS_DYNAMIC_DROP_ID = Identifier.withDefaultNamespace("sherds");
    public static final EnumProperty<Direction> HORIZONTAL_FACING = BlockStateProperties.HORIZONTAL_FACING;
    public static final BooleanProperty CRACKED = BlockStateProperties.CRACKED;
    public static final BooleanProperty WATERLOGGED = BlockStateProperties.WATERLOGGED;
    private static final VoxelShape SHAPE = Block.column(14.0, 0.0, 16.0);
    public static final Integer PICKLE_AMOUNT = 16;


    @Override
    public @NonNull MapCodec<scorned.riverside.block.PicklingVesselBlock> codec() {
        return CODEC;
    }

    /**
     * Access widened by fabric-transitive-access-wideners-v1 to accessible
     */
    public PicklingVesselBlock(final BlockBehaviour.Properties properties) {
        super(properties);
        this.registerDefaultState(
                this.stateDefinition
                        .any()
                        .setValue(HORIZONTAL_FACING, Direction.NORTH)
                        .setValue(WATERLOGGED, false)
                        .setValue(CRACKED, false)
        );
    }

    @Override
    protected @NonNull BlockState updateShape(
            final BlockState state,
            final @NonNull LevelReader level,
            final @NonNull ScheduledTickAccess ticks,
            final @NonNull BlockPos pos,
            final @NonNull Direction directionToNeighbour,
            final @NonNull BlockPos neighbourPos,
            final @NonNull BlockState neighbourState,
            final @NonNull RandomSource random
    ) {
        if (state.getValue(WATERLOGGED)) {
            ticks.scheduleTick(pos, Fluids.WATER, Fluids.WATER.getTickDelay(level));
        }

        return super.updateShape(state, level, ticks, pos, directionToNeighbour, neighbourPos, neighbourState, random);
    }

    @Override
    public BlockState getStateForPlacement(final BlockPlaceContext context) {
        FluidState replacedFluidState = context.getLevel().getFluidState(context.getClickedPos());
        return this.defaultBlockState()
                .setValue(HORIZONTAL_FACING, context.getHorizontalDirection())
                .setValue(WATERLOGGED, replacedFluidState.is(Fluids.WATER))
                .setValue(CRACKED, false);
    }


    @Override
    protected @NonNull InteractionResult useItemOn(
            final @NonNull ItemStack itemStack,
            final @NonNull BlockState state,
            final Level level,
            final @NonNull BlockPos pos,
            final @NonNull Player player,
            final @NonNull InteractionHand hand,
            final @NonNull BlockHitResult hitResult
    ) {
        if (level.getBlockEntity(pos) instanceof PicklingVesselBlockEntity picklingVessel) {
            if (level.isClientSide()) {
                return InteractionResult.SUCCESS;
            }
            if (itemStack.isEmpty()) {
                return InteractionResult.TRY_WITH_EMPTY_HAND;
            }

            if (itemStack.is(Items.SPYGLASS)) {
                debugOutput(player, picklingVessel);
            }

            if (picklingVessel.getTheItem().isEmpty()
                    && itemStack.getCount() >= PICKLE_AMOUNT
                    && picklingVessel.hasRecipe(itemStack)
                    && itemStack.is(ModTags.Items.PICKLEABLE)
            ) {
                return startPickling(picklingVessel, player, itemStack, level, pos, state);
            }

            if (itemStack.is(Items.GLASS_BOTTLE)) {
                return picklingVessel.bottlePickle(player, hand, level, pos);
            }
            return InteractionResult.TRY_WITH_EMPTY_HAND;

        } else {
            return InteractionResult.PASS;
        }
    }

    public void debugOutput(Player player, PicklingVesselBlockEntity picklingVessel) {
        player.sendSystemMessage(Component.literal("Pickling Vessel"));
        player.sendSystemMessage(Component.literal("_______________________"));

        if (picklingVessel.isActive()) {
            player.sendSystemMessage(Component.literal("Contents: ").append(picklingVessel.getTheItem().getHoverName()));
            if (picklingVessel.pickleAge() == 1) {
                player.sendSystemMessage(Component.literal("Age: 1 day"));
            } else {
                player.sendSystemMessage(Component.literal("Age: " + picklingVessel.pickleAge() + " days"));
            }
        } else {
            player.sendSystemMessage(Component.literal("Ready to pickle"));
        }
        player.sendSystemMessage(Component.literal("_______________________"));
    }

    private InteractionResult startPickling(
            PicklingVesselBlockEntity picklingVessel,
            Player player,
            ItemStack itemStack,
            Level level,
            BlockPos pos,
            BlockState state) {
        picklingVessel.wobble(PicklingVesselBlockEntity.WobbleStyle.POSITIVE);
        player.awardStat(Stats.ITEM_USED.get(itemStack.getItem()));
        ItemStack awardedItem = itemStack.consumeAndReturn(PICKLE_AMOUNT, player);
        picklingVessel.setTheItem(awardedItem);

        picklingVessel.setLastChecked((int) (level.getGameTime()) / 24000);
        picklingVessel.setIsActive(true);

        level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT, SoundSource.BLOCKS, 1.0F, 0.9F);
        if (level instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.DUST_PLUME, pos.getX() + 0.5, pos.getY() + 1.2, pos.getZ() + 0.5, 7, 0.0, 0.0, 0.0, 0.0);
        }

        picklingVessel.setChanged();
        level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);

        level.sendBlockUpdated(
                pos,
                state,
                state,
                3
        );

        return InteractionResult.SUCCESS;
    }


    @Override
    public void animateTick(
            @NonNull BlockState state,
            @NonNull Level level,
            @NonNull BlockPos pos,
            @NonNull RandomSource random
    ) {
        BlockEntity blockEntity = level.getBlockEntity(pos);

        if (!(blockEntity instanceof PicklingVesselBlockEntity vessel)) {
            return;
        }

        if (!vessel.isActive()) {
            return;
        }

        // Current pickle age
        int age = vessel.pickleAge();

        var rand = random.nextInt(10);
        // Don't spawn every tick
        if (age / 5 > rand) {
            return;
        }

        // Clamp between 0 and 3 for now
        float progress = Math.min(age / 3.0F, 1.0F);

        // Light green -> dark green
        float red = (float) (0.70 - (0.50 * progress));
        float green = (float) (1.00 - (0.45 * progress));
        float blue = (float) (0.55 - (0.45 * progress));

        // Slightly random position above the vessel
        double x = pos.getX() + 0.5 + (random.nextDouble() - 0.5) * 0.2;
        double y = pos.getY() + 1.05;
        double z = pos.getZ() + 0.5 + (random.nextDouble() - 0.5) * 0.2;

        ParticleOptions particle = ColorParticleOption.create(ParticleTypes.ENTITY_EFFECT, red, green, blue);
        level.addParticle(particle, x, y, z, 7, 0.0, 0.0);

    }

    @Override
    protected @NonNull InteractionResult useWithoutItem(
            final @NonNull BlockState state,
            final Level level,
            final @NonNull BlockPos pos,
            final @NonNull Player player,
            final @NonNull BlockHitResult hitResult
    ) {
        if (level.getBlockEntity(pos) instanceof PicklingVesselBlockEntity picklingVessel) {
            level.playSound(null, pos, SoundEvents.DECORATED_POT_INSERT_FAIL, SoundSource.BLOCKS, 1.0F, 1.0F);
            picklingVessel.wobble(PicklingVesselBlockEntity.WobbleStyle.NEGATIVE);
            level.gameEvent(player, GameEvent.BLOCK_CHANGE, pos);
            return InteractionResult.SUCCESS;
        } else {
            return InteractionResult.PASS;
        }
    }


    protected boolean isPathfindable(final @NonNull BlockState state, final @NonNull PathComputationType type) {
        return false;
    }

    @Override
    protected @NonNull VoxelShape getShape(
            final @NonNull BlockState state,
            final @NonNull BlockGetter level,
            final @NonNull BlockPos pos,
            final @NonNull CollisionContext context
    ) {
        return SHAPE;
    }

    @Override
    protected void createBlockStateDefinition(final StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(HORIZONTAL_FACING, WATERLOGGED, CRACKED);
    }

    @Override
    public @Nullable BlockEntity newBlockEntity(final @NonNull BlockPos worldPosition, final @NonNull BlockState blockState) {
        return new PicklingVesselBlockEntity(worldPosition, blockState);
    }

    @Override
    protected void affectNeighborsAfterRemoval(final @NonNull BlockState state, final @NonNull ServerLevel level, final @NonNull BlockPos pos, final boolean movedByPiston) {
        Containers.updateNeighboursAfterDestroy(state, level, pos);
    }

    @Override
    protected @NonNull List<ItemStack> getDrops(final @NonNull BlockState state, final LootParams.Builder params) {
        BlockEntity maybeEntity = params.getOptionalParameter(LootContextParams.BLOCK_ENTITY);
        if (maybeEntity instanceof PicklingVesselBlockEntity entity) {
            params.withDynamicDrop(SHERDS_DYNAMIC_DROP_ID, output -> {
                for (Item item : entity.getDecorations().ordered()) {
                    output.accept(item.getDefaultInstance());
                }
            });
        }

        return super.getDrops(state, params);
    }

    @Override
    public @NonNull BlockState playerWillDestroy(final @NonNull Level level, final @NonNull BlockPos pos, final @NonNull BlockState state, final Player player) {
        ItemStack destroyedWith = player.getMainHandItem();
        BlockState nextState = state;
        if (destroyedWith.is(ItemTags.BREAKS_DECORATED_POTS) && !EnchantmentHelper.hasTag(destroyedWith, EnchantmentTags.PREVENTS_DECORATED_POT_SHATTERING)) {
            nextState = state.setValue(CRACKED, true);
            level.setBlock(pos, nextState, 260);
        }

        return super.playerWillDestroy(level, pos, nextState, player);
    }

    @Override
    protected @NonNull FluidState getFluidState(final BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    protected @NonNull SoundType getSoundType(final BlockState state) {
        return state.getValue(CRACKED) ? SoundType.DECORATED_POT_CRACKED : SoundType.DECORATED_POT;
    }

    @Override
    protected void onProjectileHit(final @NonNull Level level, final @NonNull BlockState state, final BlockHitResult blockHit, final @NonNull Projectile projectile) {
        BlockPos pos = blockHit.getBlockPos();
        if (level instanceof ServerLevel serverLevel && projectile.mayInteract(serverLevel, pos) && projectile.mayBreak(serverLevel)) {
            level.setBlock(pos, state.setValue(CRACKED, true), 260);
            level.destroyBlock(pos, true, projectile);
        }
    }

    @Override
    protected @NonNull ItemStack getCloneItemStack(final LevelReader level, final @NonNull BlockPos pos, final @NonNull BlockState state, final boolean includeData) {
        if (level.getBlockEntity(pos) instanceof PicklingVesselBlockEntity picklingVesselBlockEntity) {
            PotDecorations decorations = picklingVesselBlockEntity.getDecorations();
            return PicklingVesselBlockEntity.createPicklingVesselInstance(decorations);
        } else {
            return super.getCloneItemStack(level, pos, state, includeData);
        }
    }

    @Override
    protected boolean hasAnalogOutputSignal(final @NonNull BlockState state) {
        return true;
    }

    @Override
    protected int getAnalogOutputSignal(final @NonNull BlockState state, final Level level, final @NonNull BlockPos pos, final @NonNull Direction direction) {
        return AbstractContainerMenu.getRedstoneSignalFromBlockEntity(level.getBlockEntity(pos));
    }

    @Override
    protected @NonNull BlockState rotate(final BlockState state, final Rotation rotation) {
        return state.setValue(HORIZONTAL_FACING, rotation.rotate(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    protected @NonNull BlockState mirror(final BlockState state, final Mirror mirror) {
        return state.rotate(mirror.getRotation(state.getValue(HORIZONTAL_FACING)));
    }

    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(
            @NonNull Level level,
            @NonNull BlockState state,
            @NonNull BlockEntityType<T> type
    ) {
        return createTickerHelper(
                type,
                ModBlockEntities.PICKLING_VESSEL,
                PicklingVesselBlockEntity::tick
        );
    }
}


