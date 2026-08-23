package river.riverside.feature.floral_covers;

import net.minecraft.world.level.block.Block;
import river.riverside.blocks.Cover;
import river.riverside.core.defaults.StandardProperties;
import river.riverside.core.helpers.BlocksHelper;
import river.riverside.core.helpers.CreativeTabsHelper;

public class FloralCovers {
    public static Block SUNFLOWER_COVER;

    private void register_sunflowerCover() {
        SUNFLOWER_COVER = BlocksHelper.registerBlock("sunflower_cover",
                properties -> new Cover(StandardProperties.FloralCoverProperties(properties), 4));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, SUNFLOWER_COVER);
    }

    public FloralCovers() {
        register_sunflowerCover();
    }
}
