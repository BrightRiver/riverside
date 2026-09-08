package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.stoneworks.Stoneworks;

public class FeatureList {

    public static void initializeFeatures() {
        //add feature registration calls here
        new Stoneworks();
    }

    public static void generateData(PackProviders providers) {
        //add feature data generation calls here
    }
}
