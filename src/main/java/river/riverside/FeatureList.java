package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.olive_trees.OliveTrees;
import river.riverside.feature.olive_trees.OliveTreesData;

public class FeatureList {

    public static void initializeFeatures() {
        OliveTrees.initialize();
    }

    public static void generateData(PackProviders providers) {
        new OliveTreesData(providers);
    }
}
