package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.wood_walls.WoodWalls;
import river.riverside.feature.wood_walls.WoodWallsData;
import river.riverside.feature.wooden_trims.WoodenTrims;
import river.riverside.feature.wooden_trims.WoodenTrimsData;

public class FeatureList {

    public static void initializeFeatures() {
        new WoodWalls();;
        new WoodenTrims();

    }

    public static void generateData(PackProviders providers) {
        //add feature data generation calls here
        new WoodWallsData(providers);
        new WoodenTrimsData(providers);
    }
}
