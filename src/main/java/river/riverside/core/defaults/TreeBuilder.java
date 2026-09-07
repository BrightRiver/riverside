package river.riverside.core.defaults;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import river.riverside.core.helpers.BlocksHelper;

import java.util.Optional;
import java.util.OptionalInt;

public class TreeBuilder {
    private TreeGrower GROWER;
    private Block SAPLING;
    private ResourceKey<ConfiguredFeature<?, ?>> FEATURE;
    private TreeConfiguration.TreeConfigurationBuilder CONFIG_BUILDER;


    public Block getSapling() {
        return this.SAPLING;
    }

    public TreeBuilder(String name, Block trunk, Block leaf) {

        FEATURE = FeatureUtils.createKey(name);
        GROWER = new TreeGrower(name, Optional.of(FEATURE), Optional.empty(), Optional.empty());
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);
        BlockStateProvider belowTrunkProvider = TreeConfiguration.defaultPlaceBelowTreeTrunkProvider(biomes);

        CONFIG_BUILDER = new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(trunk),
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.simple(leaf),
                new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty()),
                belowTrunkProvider
        );

        FeatureUtils.register(context, FEATURE, Feature.TREE, CONFIG_BUILDER.ignoreVines().build());


        SAPLING =
                BlocksHelper.registerBlock("%s_sapling".formatted(name),
                        properties ->
                                new SaplingBlock(this.GROWER, StandardProperties.saplingProperties(properties)));


    }
}
