package river.riverside;

import river.riverside.core.providers.PackProviders;
import river.riverside.feature.stoneworks.Stoneworks;
import river.riverside.feature.stoneworks.StoneworksData;

public class FeatureList {

    public static void initializeFeatures() {
        //add feature registration calls here
        new Stoneworks();
    }

    public static void generateData(PackProviders providers) {
        //add feature data generation calls here
        new StoneworksData(providers);
    }
}
