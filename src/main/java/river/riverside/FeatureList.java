package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.floral_covers.FloralCovers;
import river.riverside.feature.floral_covers.FloralCoversData;
import river.riverside.feature.wooden_trims.WoodenTrims;
import river.riverside.feature.wooden_trims.WoodenTrimsData;

public class FeatureList {

    public static void initializeFeatures() {
        //add feature registration calls here
        new FloralCovers();
        new WoodenTrims();
    }

    public static void generateData(PackProviders providers) {
        //add feature data generation calls here
        new FloralCoversData(providers);
        new WoodenTrimsData(providers);
    }
}
