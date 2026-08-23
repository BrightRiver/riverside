package river.riverside.feature.wooden_trims;

import net.minecraft.world.level.block.Block;
import river.riverside.blocks.WoodTrim;
import river.riverside.core.defaults.StandardProperties;
import river.riverside.core.helpers.BlocksHelper;
import river.riverside.core.helpers.CreativeTabsHelper;

public class WoodenTrims {

    public static Block ACACIA_TRIM;
    public static Block BAMBOO_TRIM;
    public static Block BIRCH_TRIM;
    public static Block CHERRY_TRIM;
    public static Block CRIMSON_TRIM;
    public static Block DARK_OAK_TRIM;
    public static Block JUNGLE_TRIM;
    public static Block MANGROVE_TRIM;
    public static Block OAK_TRIM;
    public static Block PALE_OAK_TRIM;
    public static Block SPRUCE_TRIM;
    public static Block WARPED_TRIM;

    private void register_acaciaTrim() {
        ACACIA_TRIM = BlocksHelper.registerBlock("acacia_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, ACACIA_TRIM);
    }

    private void register_bambooTrim() {
        BAMBOO_TRIM = BlocksHelper.registerBlock("bamboo_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, BAMBOO_TRIM);
    }

    private void register_birchTrim() {
        BIRCH_TRIM = BlocksHelper.registerBlock("birch_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, BIRCH_TRIM);
    }

    private void register_cherryTrim() {
        CHERRY_TRIM = BlocksHelper.registerBlock("cherry_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, CHERRY_TRIM);
    }

    private void register_crimsonTrim() {
        CRIMSON_TRIM = BlocksHelper.registerBlock("crimson_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, CRIMSON_TRIM);
    }

    private void register_darkOakTrim() {
        DARK_OAK_TRIM = BlocksHelper.registerBlock("dark_oak_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, DARK_OAK_TRIM);
    }

    private void register_jungleTrim() {
        JUNGLE_TRIM = BlocksHelper.registerBlock("jungle_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, JUNGLE_TRIM);
    }

    private void register_mangroveTrim() {
        MANGROVE_TRIM = BlocksHelper.registerBlock("mangrove_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, MANGROVE_TRIM);
    }

    private void register_oakTrim() {
        OAK_TRIM = BlocksHelper.registerBlock("oak_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, OAK_TRIM);
    }

    private void register_paleOakTrim() {
        PALE_OAK_TRIM = BlocksHelper.registerBlock("pale_oak_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, PALE_OAK_TRIM);
    }

    private void register_spruceTrim() {
        SPRUCE_TRIM = BlocksHelper.registerBlock("spruce_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SPRUCE_TRIM);
    }

    private void register_warpedTrim() {
        WARPED_TRIM = BlocksHelper.registerBlock("warped_trim",
                properties -> new WoodTrim(StandardProperties.woodenTrimProperties(properties)));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, WARPED_TRIM);
    }

    public WoodenTrims() {
        register_oakTrim();
        register_acaciaTrim();
        register_bambooTrim();
        register_birchTrim();
        register_cherryTrim();
        register_crimsonTrim();
        register_darkOakTrim();
        register_jungleTrim();
        register_mangroveTrim();
        register_paleOakTrim();
        register_spruceTrim();
        register_warpedTrim();
    }
}
