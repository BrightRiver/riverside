package scorned.riverside.client.datagen;

import com.mojang.math.Quadrant;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;


import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.data.models.model.TextureMapping;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.client.renderer.block.dispatch.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

import org.jspecify.annotations.NonNull;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricPackOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockModelGenerators) {
        generateOliveBlockModels(blockModelGenerators);
    }


    private void generateHangingSign(BlockModelGenerators blockModelGenerators, Block hangingSign, Block wallSign, Block particleBlock, Item hanging_sign_item) {
        TextureMapping mapping = (new TextureMapping()).put(TextureSlot.ALL, TextureMapping.getBlockTexture(hangingSign)).put(TextureSlot.PARTICLE, TextureMapping.getBlockTexture(particleBlock));
        VariantMutator NOP = (v) -> v;
        VariantMutator Y_ROT_90 = VariantMutator.Y_ROT.withValue(Quadrant.R90);
        VariantMutator Y_ROT_180 = VariantMutator.Y_ROT.withValue(Quadrant.R180);
        VariantMutator Y_ROT_270 = VariantMutator.Y_ROT.withValue(Quadrant.R270);


        PropertyDispatch<VariantMutator> ROTATION_HORIZONTAL_FACING_ALT =
                PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
                        .select(Direction.SOUTH, NOP)
                        .select(Direction.WEST, Y_ROT_90)
                        .select(Direction.NORTH, Y_ROT_180)
                        .select(Direction.EAST, Y_ROT_270);


        blockModelGenerators.createHangingSign(
                hangingSign,
                blockModelGenerators.plainVariant(
                        ModelTemplates.HANGING_SIGN_ROT_0
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_0"),
                                        mapping, blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.HANGING_SIGN_ROT_1
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_1"),
                                        mapping, blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.HANGING_SIGN_ROT_2
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_2"),
                                        mapping,
                                        blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.HANGING_SIGN_ROT_3
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_rot_3"),
                                        mapping, blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.ATTACHED_HANGING_SIGN_ROT_0
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_0"),
                                        mapping, blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.ATTACHED_HANGING_SIGN_ROT_1
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_1"),
                                        mapping, blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.ATTACHED_HANGING_SIGN_ROT_2
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_2"),
                                        mapping, blockModelGenerators.modelOutput)),
                blockModelGenerators.plainVariant(
                        ModelTemplates.ATTACHED_HANGING_SIGN_ROT_3
                                .create(ModelLocationUtils.getModelLocation(hangingSign, "_attached_rot_3"),
                                        mapping,
                                        blockModelGenerators.modelOutput)));

        MultiVariant wallModel = blockModelGenerators.plainVariant(
                ModelTemplates.WALL_HANGING_SIGN.create(wallSign, mapping, blockModelGenerators.modelOutput));
        blockModelGenerators.blockStateOutput.accept(MultiVariantGenerator.dispatch(wallSign, wallModel).with(ROTATION_HORIZONTAL_FACING_ALT));
        blockModelGenerators.registerSimpleFlatItemModel(hanging_sign_item);


    }

    private void generateOliveBlockModels(BlockModelGenerators blockModelGenerators) {
        BlockModelGenerators.BlockFamilyProvider woodFamily = blockModelGenerators.family(ModBlocks.OLIVE_PLANKS);
        woodFamily.stairs(ModBlocks.OLIVE_STAIR);
        woodFamily.slab(ModBlocks.OLIVE_SLAB);
        woodFamily.wall(ModBlocks.OLIVE_WALL);
        woodFamily.fence(ModBlocks.OLIVE_FENCE);
        woodFamily.fenceGate(ModBlocks.OLIVE_FENCE_GATE);
        woodFamily.button(ModBlocks.OLIVE_BUTTON);
        woodFamily.pressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE);

        generateHangingSign(
                blockModelGenerators,
//                Block.byItem(ModItems.OLIVE_HANGING_SIGN),
                ModBlocks.OLIVE_HANGING_SIGN,
                ModBlocks.OLIVE_WALL_HANGING_SIGN, ModBlocks.STRIPPED_OLIVE_LOG,
                ModItems.OLIVE_HANGING_SIGN);

        // requires item texture
        blockModelGenerators.createDoor(ModBlocks.OLIVE_DOOR);

        blockModelGenerators.createTrapdoor(ModBlocks.OLIVE_TRAPDOOR);

        blockModelGenerators.woodProvider(ModBlocks.OLIVE_LOG)
                .log(ModBlocks.OLIVE_LOG)
                .wood(ModBlocks.OLIVE_WOOD);

        blockModelGenerators.woodProvider(ModBlocks.STRIPPED_OLIVE_LOG)
                .log(ModBlocks.STRIPPED_OLIVE_LOG)
                .wood(ModBlocks.STRIPPED_OLIVE_WOOD);

        blockModelGenerators.createShelf(ModBlocks.OLIVE_SHELF, ModBlocks.STRIPPED_OLIVE_LOG);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(ModItems.OLIVE, ModelTemplates.FLAT_ITEM);
//        itemModelGenerators.generateFlatItem(ModItems.OLIVE_HANGING_SIGN, ModelTemplates.FLAT_ITEM);

    }
}