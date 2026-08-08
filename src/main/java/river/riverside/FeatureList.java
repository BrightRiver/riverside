package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.wood_walls.WoodWalls;
import river.riverside.feature.wood_walls.WoodWallsData;

public class FeatureList {

    public static void initializeFeatures() {
        WoodWalls.initialize();
    }

    public static void generateData(PackProviders providers) {
        new WoodWallsData(providers);
    }
}
