package river.riverside.core.generators;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.StairsShape;
import river.riverside.feature.stoneworks.StoneWorkSet;

import net.minecraft.client.data.models.model.ModelTemplate;
import net.minecraft.client.data.models.model.TextureSlot;
import net.minecraft.resources.Identifier;
import river.riverside.feature.stoneworks.blocks.Cornice;

import java.util.Optional;


public class StoneWorks {


    private static final ModelTemplate PILLAR = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/pillar")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate PILLAR_BASE = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/pillar_base")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate PILLAR_TOP = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/pillar_top")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate CORNICE = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/cornice")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate CORNICE_INNER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/cornice_inner")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate CORNICE_OUTER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/cornice_outer")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SILL = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/sill")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate COPING = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/coping")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate COPING_SIDE = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/coping_side")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SUPPORT = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/support")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SLOPE = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/slope")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SLOPE_INNER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/slope_inner")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SLOPE_OUTER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/slope_outer")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SHALLOW_SLOPE_LOWER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/shallow_slope_lower")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SHALLOW_SLOPE_LOWER_INNER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/shallow_slope_lower_inner")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SHALLOW_SLOPE_LOWER_OUTER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/shallow_slope_lower_outer")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SHALLOW_SLOPE_UPPER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/shallow_slope_upper")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SHALLOW_SLOPE_UPPER_INNER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/shallow_slope_upper_inner")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );

    private static final ModelTemplate SHALLOW_SLOPE_UPPER_OUTER = new ModelTemplate(
            Optional.of(Identifier.fromNamespaceAndPath("riverside", "block/shallow_slope_upper_outer")),
            Optional.empty(),
            TextureSlot.TEXTURE
    );


    public static void generate(BlockModelGenerators generators, StoneWorkSet blockSet) {
        generatePillar(generators, blockSet);
        generatePillarBase(generators, blockSet);
        generatePillarTop(generators, blockSet);
        generateSill(generators, blockSet);
        generateSupport(generators, blockSet);
        generateCornice(generators, blockSet);
        generateCoping(generators, blockSet);
        generateSlope(generators, blockSet);
        generateShallowSlopeLower(generators, blockSet);
        generateShallowSlopeUpper(generators, blockSet);
    }


    private static void generatePillar(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {

        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.pillar());

        PILLAR.create(
                target.withPrefix("block/"),
                blockSet.textureMapping(),
                generators.modelOutput
        );

        generators.blockStateOutput.accept(
                BlockModelGenerators.createSimpleBlock(
                        blockSet.pillar(),
                        BlockModelGenerators.plainVariant(
                                target.withPrefix("block/")
                        )
                )
        );
        generateItemModel(generators, blockSet.pillar());

    }

    private static void generatePillarBase(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.pillarBase());

        PILLAR_BASE.create(
                target.withPrefix("block/"),
                blockSet.textureMapping(),
                generators.modelOutput
        );
        generators.blockStateOutput.accept(
                BlockModelGenerators.createSimpleBlock(
                        blockSet.pillarBase(),
                        BlockModelGenerators.plainVariant(
                                target.withPrefix("block/")
                        )
                )
        );
        generateItemModel(generators, blockSet.pillarBase());

    }

    private static void generatePillarTop(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.pillarTop());

        PILLAR_TOP.create(
                target.withPrefix("block/"),
                blockSet.textureMapping(),
                generators.modelOutput
        );
        generators.blockStateOutput.accept(
                BlockModelGenerators.createSimpleBlock(
                        blockSet.pillarTop(),
                        BlockModelGenerators.plainVariant(
                                target.withPrefix("block/")
                        )
                )
        );
        generateItemModel(generators, blockSet.pillarTop());

    }

    private static void generateCornice(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.cornice());

        Identifier model = target.withPrefix("block/");
        Identifier innerModel = model.withSuffix("_inner");
        Identifier outerModel = model.withSuffix("_outer");

        CORNICE.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        CORNICE_INNER.create(
                innerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        CORNICE_OUTER.create(
                outerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        MultiVariant straight = BlockModelGenerators.plainVariant(model)
                .with(BlockModelGenerators.UV_LOCK);

        MultiVariant inner = BlockModelGenerators.plainVariant(innerModel)
                .with(BlockModelGenerators.UV_LOCK);

        MultiVariant outer = BlockModelGenerators.plainVariant(outerModel)
                .with(BlockModelGenerators.UV_LOCK);

        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(blockSet.cornice())
                        .with(
                                PropertyDispatch.initial(
                                                BlockStateProperties.HORIZONTAL_FACING,
                                                Cornice.SHAPE
                                        )
                                        // EAST
                                        .select(Direction.EAST, StairsShape.INNER_LEFT, inner)
                                        .select(Direction.EAST, StairsShape.INNER_RIGHT, inner.with(BlockModelGenerators.Y_ROT_90))
                                        .select(Direction.EAST, StairsShape.OUTER_LEFT, outer)
                                        .select(Direction.EAST, StairsShape.OUTER_RIGHT, outer.with(BlockModelGenerators.Y_ROT_90))
                                        .select(Direction.EAST, StairsShape.STRAIGHT, straight)

                                        // NORTH
                                        .select(Direction.NORTH, StairsShape.INNER_LEFT, inner.with(BlockModelGenerators.Y_ROT_270))
                                        .select(Direction.NORTH, StairsShape.INNER_RIGHT, inner)
                                        .select(Direction.NORTH, StairsShape.OUTER_LEFT, outer.with(BlockModelGenerators.Y_ROT_270))
                                        .select(Direction.NORTH, StairsShape.OUTER_RIGHT, outer)
                                        .select(Direction.NORTH, StairsShape.STRAIGHT, straight.with(BlockModelGenerators.Y_ROT_270))

                                        // SOUTH
                                        .select(Direction.SOUTH, StairsShape.INNER_LEFT, inner.with(BlockModelGenerators.Y_ROT_90))
                                        .select(Direction.SOUTH, StairsShape.INNER_RIGHT, inner.with(BlockModelGenerators.Y_ROT_180))
                                        .select(Direction.SOUTH, StairsShape.OUTER_LEFT, outer.with(BlockModelGenerators.Y_ROT_90))
                                        .select(Direction.SOUTH, StairsShape.OUTER_RIGHT, outer.with(BlockModelGenerators.Y_ROT_180))
                                        .select(Direction.SOUTH, StairsShape.STRAIGHT, straight.with(BlockModelGenerators.Y_ROT_90))

                                        // WEST
                                        .select(Direction.WEST, StairsShape.INNER_LEFT, inner.with(BlockModelGenerators.Y_ROT_180))
                                        .select(Direction.WEST, StairsShape.INNER_RIGHT, inner.with(BlockModelGenerators.Y_ROT_270))
                                        .select(Direction.WEST, StairsShape.OUTER_LEFT, outer.with(BlockModelGenerators.Y_ROT_180))
                                        .select(Direction.WEST, StairsShape.OUTER_RIGHT, outer.with(BlockModelGenerators.Y_ROT_270))
                                        .select(Direction.WEST, StairsShape.STRAIGHT, straight.with(BlockModelGenerators.Y_ROT_180))
                        )
        );
        generateItemModel(generators, blockSet.cornice());

    }

    private static void generateSill(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.sill());
        Identifier model = target.withPrefix("block/");

        SILL.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        MultiVariant variant = BlockModelGenerators.plainVariant(model);

        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(blockSet.sill())
                        .with(
                                PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                                        .select(Direction.NORTH, variant)
                                        .select(Direction.EAST, variant.with(BlockModelGenerators.Y_ROT_90))
                                        .select(Direction.SOUTH, variant.with(BlockModelGenerators.Y_ROT_180))
                                        .select(Direction.WEST, variant.with(BlockModelGenerators.Y_ROT_270))
                        )
        );
        generateItemModel(generators, blockSet.sill());

    }

    private static void generateCoping(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.coping());

        Identifier model = target.withPrefix("block/");
        Identifier sideModel = target.withPrefix("block/").withSuffix("_side");
        COPING.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        COPING_SIDE.create(
                sideModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        generators.blockStateOutput.accept(
                BlockModelGenerators.createFence(
                        blockSet.coping(),
                        BlockModelGenerators.plainVariant(model),
                        BlockModelGenerators.plainVariant(sideModel)
                )
        );
        generateItemModel(generators, blockSet.coping());

    }


    private static void generateSupport(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.support());
        Identifier model = target.withPrefix("block/");

        SUPPORT.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        MultiVariant variant = BlockModelGenerators.plainVariant(model);

        generators.blockStateOutput.accept(
                MultiVariantGenerator.dispatch(blockSet.support())
                        .with(
                                PropertyDispatch.initial(BlockStateProperties.HORIZONTAL_FACING)
                                        .select(Direction.NORTH, variant.with(BlockModelGenerators.Y_ROT_90))
                                        .select(Direction.EAST, variant.with(BlockModelGenerators.Y_ROT_180))
                                        .select(Direction.SOUTH, variant.with(BlockModelGenerators.Y_ROT_270))
                                        .select(Direction.WEST, variant)
                        )
        );
        generateItemModel(generators, blockSet.support());

    }

    private static void generateSlope(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.slope());

        Identifier model = target.withPrefix("block/");
        Identifier innerModel = target.withPrefix("block/").withSuffix("_inner");
        Identifier outerModel = target.withPrefix("block/").withSuffix("_outer");

        SLOPE.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        SLOPE_INNER.create(
                innerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        SLOPE_OUTER.create(
                outerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        generators.blockStateOutput.accept(
                BlockModelGenerators.createStairs(
                        blockSet.slope(),
                        BlockModelGenerators.plainVariant(innerModel),
                        BlockModelGenerators.plainVariant(model),
                        BlockModelGenerators.plainVariant(outerModel)
                )
        );
        generateItemModel(generators, blockSet.slope());

    }

    private static void generateShallowSlopeLower(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.shallowSlopeLower());

        Identifier model = target.withPrefix("block/");
        Identifier innerModel = target.withPrefix("block/").withSuffix("_inner");
        Identifier outerModel = target.withPrefix("block/").withSuffix("_outer");

        SHALLOW_SLOPE_LOWER.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        SHALLOW_SLOPE_LOWER_INNER.create(
                innerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        SHALLOW_SLOPE_LOWER_OUTER.create(
                outerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        generators.blockStateOutput.accept(
                BlockModelGenerators.createStairs(
                        blockSet.shallowSlopeLower(),
                        BlockModelGenerators.plainVariant(innerModel),
                        BlockModelGenerators.plainVariant(model),
                        BlockModelGenerators.plainVariant(outerModel)
                )
        );
        generateItemModel(generators, blockSet.shallowSlopeLower());

    }

    private static void generateShallowSlopeUpper(
            BlockModelGenerators generators,
            StoneWorkSet blockSet
    ) {
        Identifier target = BuiltInRegistries.BLOCK.getKey(blockSet.shallowSlopeUpper());

        Identifier model = target.withPrefix("block/");
        Identifier innerModel = target.withPrefix("block/").withSuffix("_inner");
        Identifier outerModel = target.withPrefix("block/").withSuffix("_outer");

        SHALLOW_SLOPE_UPPER.create(
                model,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        SHALLOW_SLOPE_UPPER_INNER.create(
                innerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        SHALLOW_SLOPE_UPPER_OUTER.create(
                outerModel,
                blockSet.textureMapping(),
                generators.modelOutput
        );

        generators.blockStateOutput.accept(
                BlockModelGenerators.createStairs(
                        blockSet.shallowSlopeUpper(),
                        BlockModelGenerators.plainVariant(innerModel),
                        BlockModelGenerators.plainVariant(model),
                        BlockModelGenerators.plainVariant(outerModel)
                )
        );
        generateItemModel(generators, blockSet.shallowSlopeUpper());

    }

    private static void generateItemModel(
            BlockModelGenerators generators,
            Block block
    ) {
        Identifier model = BuiltInRegistries.BLOCK
                .getKey(block)
                .withPrefix("block/");

        generators.registerSimpleItemModel(block, model);
    }
}

