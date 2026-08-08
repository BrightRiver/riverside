package river.riverside;

import river.riverside.core.providers.PackProviders;

public class FeatureList {

    public static void initializeFeatures() {
        WoodWalls.initialize();
    }

    public static void generateData(PackProviders providers) {
        new WoodWallsData(providers);
    }
}
