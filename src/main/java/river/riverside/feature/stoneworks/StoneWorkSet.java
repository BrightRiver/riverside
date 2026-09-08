package river.riverside.feature.stoneworks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import river.riverside.core.defaults.StandardProperties;
import river.riverside.core.helpers.BlocksHelper;
import river.riverside.core.helpers.CreativeTabsHelper;
import river.riverside.feature.stoneworks.blocks.*;

public class StoneWorkSet {

    private Block PILLAR;
    private Block PILLAR_BASE;
    private Block PILLAR_TOP;
    private Block CORNICE;
    private Block SILL;
    private Block COPING;
    private Block SUPPORT;
    private Block SLOPE;
    private Block SHALLOW_SLOPE_LOWER;
    private Block SHALLOW_SLOPE_UPPER;

    private void pillar(Block base, String blockName) {
        PILLAR = BlocksHelper.registerBlock("%s_pillar".formatted(blockName),
                properties -> new Pillar(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, PILLAR);
    }


    public Block pillar() {
        return PILLAR;
    }

    private void pillarBase(Block base, String blockName) {
        PILLAR_BASE = BlocksHelper.registerBlock("%s_pillar_base".formatted(blockName),
                properties -> new Block(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, PILLAR_BASE);
    }


    public Block pillarBase() {
        return PILLAR_BASE;
    }

    private void pillarTop(Block base, String blockName) {
        PILLAR_TOP = BlocksHelper.registerBlock("%s_pillar_top".formatted(blockName),
                properties -> new Block(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, PILLAR_TOP);
    }


    public Block pillarTop() {
        return PILLAR_TOP;
    }

    private void cornice(Block base, String blockName) {
        CORNICE = BlocksHelper.registerBlock("%s_cornice".formatted(blockName),
                properties -> new Cornice(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, CORNICE);
    }


    public Block cornice() {
        return CORNICE;
    }

    private void sill(Block base, String blockName) {
        SILL = BlocksHelper.registerBlock("%s_sill".formatted(blockName),
                properties -> new Sill(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SILL);
    }


    public Block sill() {
        return SILL;
    }


    private void coping(Block base, String blockName) {
        COPING = BlocksHelper.registerBlock("%s_coping".formatted(blockName),
                properties -> new Coping(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, COPING);
    }


    public Block coping() {
        return COPING;
    }

    private void support(Block base, String blockName) {
        SUPPORT = BlocksHelper.registerBlock("%s_support".formatted(blockName),
                properties -> new Support(StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SUPPORT);
    }


    public Block support() {
        return SUPPORT;
    }

    private void slope(Block base, String blockName) {
        SLOPE = BlocksHelper.registerBlock("%s_slope".formatted(blockName),
                properties -> new StairBlock(base.defaultBlockState(), StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SLOPE);
    }



    public Block slope() {
        return SLOPE;
    }

    private void shallowSlopeLower(Block base, String blockName) {
        SHALLOW_SLOPE_LOWER = BlocksHelper.registerBlock("%s_shallow_slope_lower".formatted(blockName),
                properties -> new StairBlock(base.defaultBlockState(), StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SHALLOW_SLOPE_LOWER);
    }


    public Block shallowSlopeLower() {
        return SHALLOW_SLOPE_LOWER;
    }

    private void shallowSlopeUpper(Block base, String blockName) {
        SHALLOW_SLOPE_UPPER = BlocksHelper.registerBlock("%s_shallow_slope_upper".formatted(blockName),
                properties -> new StairBlock(base.defaultBlockState(), StandardProperties.stoneProperties(properties, base.defaultMapColor()).noOcclusion()));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SHALLOW_SLOPE_UPPER);
    }

    public Block shallowSlopeUpper() {
        return SHALLOW_SLOPE_UPPER;
    }

    public StoneWorkSet(Block base, String blockName) {
        pillar(base, blockName);
        pillarBase(base, blockName);
        pillarTop(base, blockName);
        cornice(base, blockName);
        sill(base, blockName);
        coping(base, blockName);
        support(base, blockName);
        slope(base, blockName);
        shallowSlopeLower(base, blockName);
        shallowSlopeUpper(base, blockName);

    }
}
