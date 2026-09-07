package river.riverside.feature.olive_trees;

import net.minecraft.world.level.material.MapColor;
import river.riverside.Riverside;
import river.riverside.core.defaults.WoodSet;

public class OliveTrees {


    public static WoodSet OLIVE_WOOD_SET = new WoodSet("olive", MapColor.TERRACOTTA_LIGHT_GREEN);
    public static WoodSet BLACK_WALNUT_WOOD_SET = new WoodSet("black_walnut", MapColor.TERRACOTTA_BLACK);
    public static WoodSet DEEP_PLUM_WOOD_SET = new WoodSet("deep_plum", MapColor.TERRACOTTA_PURPLE);

    public static void initialize() {
        Riverside.LOGGER.info(Riverside.MOD_ID + ": Initializing Olive Trees");
    }
}
