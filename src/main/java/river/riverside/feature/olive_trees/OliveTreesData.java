package river.riverside.feature.olive_trees;
import river.riverside.core.defaults.WoodSetData;
import river.riverside.core.providers.PackProviders;

public class OliveTreesData {

    public OliveTreesData(PackProviders providers) {
        new WoodSetData(providers, OliveTrees.OLIVE_WOOD_SET, "Olive");
        new WoodSetData(providers, OliveTrees.BLACK_WALNUT_WOOD_SET, "Black Walnut");
        new WoodSetData(providers, OliveTrees.DEEP_PLUM_WOOD_SET, "Deep Plum");
    }
}
