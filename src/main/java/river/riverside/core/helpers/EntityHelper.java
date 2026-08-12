package river.riverside.core.helpers;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import net.minecraft.world.item.Item;
import river.riverside.Riverside;

import java.util.function.Supplier;

public final class EntityHelper {
    private EntityHelper() {
    }

    public static EntityType<Boat> registerBoat(String name, Supplier<Item> boatItem) {
        Identifier id = Riverside.id(name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);

        return Registry.register(BuiltInRegistries.ENTITY_TYPE,
                id,
                EntityType.Builder.<Boat>of((entityType, level)
                                -> new Boat(entityType, level, boatItem), MobCategory.MISC)
                        .sized(1.375f, 0.5625f).clientTrackingRange(10).build(key));
    }


    public static EntityType<ChestBoat> registerChestBoat(String name, Supplier<Item> chestBoatItem) {
        Identifier id = Riverside.id(name);
        ResourceKey<EntityType<?>> key = ResourceKey.create(Registries.ENTITY_TYPE, id);


        return Registry.register(
                BuiltInRegistries.ENTITY_TYPE,
                id,
                EntityType.Builder.<ChestBoat>of((entityType, level)
                                -> new ChestBoat(entityType, level, chestBoatItem), MobCategory.MISC)
                        .sized(1.375f, 0.5625f).clientTrackingRange(10).build(key));
    }
}
