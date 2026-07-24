package scorned.riverside.block.entity;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.component.DataComponentGetter;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.component.DataComponentPatch;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.Containers;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.RandomizableContainer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.component.ItemContainerContents;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.PotDecorations;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.storage.ValueInput;
import net.minecraft.world.level.storage.ValueOutput;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.ticks.ContainerSingleItem;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import scorned.riverside.data.ModDataComponents;
import scorned.riverside.recipe.ModRecipes;
import scorned.riverside.recipe.custom.PicklingRecipe;
import scorned.riverside.recipe.custom.PicklingRecipeInput;

import java.util.Optional;
import java.util.List;

public class PicklingVesselBlockEntity extends BlockEntity implements ContainerSingleItem.BlockContainerSingleItem, RandomizableContainer {
    public long wobbleStartedAtTick;
    public PicklingVesselBlockEntity.@Nullable WobbleStyle lastWobbleStyle;
    private PotDecorations decorations;
    private ItemStack item = ItemStack.EMPTY;
    protected @Nullable ResourceKey<LootTable> lootTable;
    protected long lootTableSeed;


    private int pickleAge = 0;
    private boolean isActive = false;
    private int lastChecked;


    public int pickleAge() {
        return this.pickleAge;
    }

    public boolean isActive() {
        return this.isActive;
    }

    public int lastChecked() {
        return this.lastChecked;
    }

    public void setPickleAge(int pickleAge) {
        this.pickleAge = pickleAge;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public void setLastChecked(int lastChecked) {
        this.lastChecked = lastChecked;
    }

    public PicklingVesselBlockEntity(final BlockPos worldPosition, final BlockState blockState) {
        super(ModBlockEntities.PICKLING_VESSEL, worldPosition, blockState);
        this.decorations = PotDecorations.EMPTY;
    }

    @Override
    protected void saveAdditional(final @NonNull ValueOutput output) {
        super.saveAdditional(output);
        if (!this.decorations.equals(PotDecorations.EMPTY)) {
            output.store("sherds", PotDecorations.CODEC, this.decorations);
        }

        if (!this.trySaveLootTable(output) && !this.item.isEmpty()) {
            output.store("item", ItemStack.CODEC, this.item);
        }

        output.putInt("pickleAge", this.pickleAge);
        output.putBoolean("isActive", this.isActive);
        output.putInt("lastChecked", this.lastChecked);
    }

    public static void tick(
            Level level,
            BlockPos pos,
            BlockState state,
            PicklingVesselBlockEntity vessel
    ) {

        if (!vessel.isActive()) {
            return;
        }

        int currentDay = (int) (level.getGameTime() / 24000L);
        if (currentDay == vessel.lastChecked()) {
            return;
        }

        vessel.setLastChecked(currentDay);
        vessel.setPickleAge(vessel.pickleAge() + 1);

        vessel.setChanged();

        level.sendBlockUpdated(
                pos,
                state,
                state,
                3
        );
    }


    public void setDecorations(PotDecorations decorations) {
        this.decorations = decorations;
    }

    @Override
    protected void loadAdditional(final @NonNull ValueInput input) {
        super.loadAdditional(input);
        this.decorations = input.read("sherds", PotDecorations.CODEC).orElse(PotDecorations.EMPTY);
        if (!this.tryLoadLootTable(input)) {
            this.item = input.read("item", ItemStack.CODEC).orElse(ItemStack.EMPTY);
        } else {
            this.item = ItemStack.EMPTY;
        }
        this.pickleAge = input.read("pickleAge", Codec.INT).orElse(0);
        this.isActive = input.read("isActive", Codec.BOOL).orElse(false);
        this.lastChecked = input.read("lastChecked", Codec.INT).orElse(0);

    }

    public ClientboundBlockEntityDataPacket getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @NonNull CompoundTag getUpdateTag(final HolderLookup.@NonNull Provider registries) {
        return this.saveCustomOnly(registries);
    }

    public Direction getDirection() {
        return this.getBlockState().getValue(BlockStateProperties.HORIZONTAL_FACING);
    }

    public PotDecorations getDecorations() {
        return this.decorations;
    }

    public static ItemStackTemplate createPicklingVesselTemplate(final PotDecorations decorations) {
        return new ItemStackTemplate(Items.DECORATED_POT, DataComponentPatch.builder().set(DataComponents.POT_DECORATIONS, decorations).build());
    }

    public static ItemStack createPicklingVesselInstance(final PotDecorations decorations) {
        return createPicklingVesselTemplate(decorations).create();
    }

    @Override
    public @Nullable ResourceKey<LootTable> getLootTable() {
        return this.lootTable;
    }

    @Override
    public void setLootTable(final @Nullable ResourceKey<LootTable> lootTable) {
        this.lootTable = lootTable;
    }

    @Override
    public long getLootTableSeed() {
        return this.lootTableSeed;
    }

    @Override
    public void setLootTableSeed(final long lootTableSeed) {
        this.lootTableSeed = lootTableSeed;
    }

    @Override
    protected void collectImplicitComponents(final DataComponentMap.@NonNull Builder components) {
        super.collectImplicitComponents(components);
        components.set(DataComponents.POT_DECORATIONS, this.decorations);
        components.set(DataComponents.CONTAINER, ItemContainerContents.fromItems(List.of(this.item)));
    }


    public boolean hasRecipe(ItemStack input) {
        assert level != null;
        Optional<RecipeHolder<PicklingRecipe>> recipe = ((ServerLevel) level).recipeAccess().getRecipeFor(ModRecipes.PICKLING_TYPE, new PicklingRecipeInput(input), level);
        return recipe.isPresent();
    }

    @Override
    protected void applyImplicitComponents(final @NonNull DataComponentGetter components) {
        super.applyImplicitComponents(components);
        this.decorations = components.getOrDefault(DataComponents.POT_DECORATIONS, PotDecorations.EMPTY);
        this.item = components.getOrDefault(DataComponents.CONTAINER, ItemContainerContents.EMPTY).copyOne();
    }

    public InteractionResult bottlePickle(
            Player player,
            final @NonNull InteractionHand hand,
            Level level,
            BlockPos pos
    ) {
        if (!isActive()) {
            return InteractionResult.TRY_WITH_EMPTY_HAND;
        }

        //return original items
        if (pickleAge() < 1) {
            ItemStack stored = getTheItem();
            if (!stored.isEmpty()) {
                Containers.dropItemStack(
                        level,
                        pos.getX(),
                        pos.getY(),
                        pos.getZ(),
                        stored
                );
            }
            reset();
            return InteractionResult.SUCCESS;

        }

        Optional<RecipeHolder<PicklingRecipe>> recipe =
                getCurrentRecipe();

        if (recipe.isEmpty()) {
            return InteractionResult.FAIL;
        }

        ItemStack result = recipe.get()
                .value()
                .assemble(new PicklingRecipeInput(getTheItem()));
        result.set(ModDataComponents.PICKLE_AGE, pickleAge());

        player.getItemInHand(hand).consumeAndReturn(1, player);
        player.addItem(result);

        reset();
        return InteractionResult.SUCCESS;

    }

    private Optional<RecipeHolder<PicklingRecipe>> getCurrentRecipe() {
        assert level != null;
        return ((ServerLevel) level).recipeAccess()
                .getRecipeFor(ModRecipes.PICKLING_TYPE, new PicklingRecipeInput(getTheItem()), level);
    }

    private void reset() {
        setPickleAge(0);
        setIsActive(false);
        setLastChecked(0);
        setTheItem(ItemStack.EMPTY);
        setChanged();

        if (level != null) {
            level.sendBlockUpdated(worldPosition, getBlockState(), getBlockState(), 3);
        }
    }

    @Override
    public @NonNull ItemStack getTheItem() {
        this.unpackLootTable(null);
        return this.item;
    }

    @Override
    public @NonNull ItemStack splitTheItem(final int count) {
        this.unpackLootTable(null);
        ItemStack result = this.item.split(count);
        if (this.item.isEmpty()) {
            this.item = ItemStack.EMPTY;
        }

        return result;
    }

    @Override
    public void setTheItem(final @NonNull ItemStack itemStack) {
        this.unpackLootTable(null);
        this.item = itemStack;
    }

    @Override
    public @NonNull BlockEntity getContainerBlockEntity() {
        return this;
    }

    public void wobble(final PicklingVesselBlockEntity.WobbleStyle wobbleStyle) {
        if (this.level != null && !this.level.isClientSide()) {
            this.level.blockEvent(this.getBlockPos(), this.getBlockState().getBlock(), 1, wobbleStyle.ordinal());
        }
    }

    @Override
    public boolean triggerEvent(final int event, final int data) {
        if (this.level != null && event == 1 && data >= 0 && data < PicklingVesselBlockEntity.WobbleStyle.values().length) {
            this.wobbleStartedAtTick = this.level.getGameTime();
            this.lastWobbleStyle = PicklingVesselBlockEntity.WobbleStyle.values()[data];
            return true;
        } else {
            return super.triggerEvent(event, data);
        }
    }

    public enum WobbleStyle {
        POSITIVE(7),
        NEGATIVE(10);

        public final int duration;

        WobbleStyle(final int duration) {
            this.duration = duration;
        }
    }
}
