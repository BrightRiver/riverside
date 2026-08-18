package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.cozy_doors.CozyDoors;
import river.riverside.feature.cozy_doors.CozyDoorsData;

public class FeatureList {

    public static void initializeFeatures() {
        //add feature registration calls here
        new CozyDoors();
    }

    public static void generateData(PackProviders providers) {
        //add feature data generation calls here
        new CozyDoorsData(providers);
    }
}
