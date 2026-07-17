package scorned.riverside.client.entity;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.resources.Identifier;
import scorned.riverside.Riverside;

public class ModModelLayerLocations {

    public static final ModelLayerLocation OLIVE_BOAT =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "boat/olive_boat"), "main");
    public static final ModelLayerLocation OLIVE_CHEST_BOAT =
            new ModelLayerLocation(Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "chest_boat/olive_boat"), "main");

}
