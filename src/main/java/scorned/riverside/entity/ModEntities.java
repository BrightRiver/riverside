package scorned.riverside.entity;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.vehicle.boat.Boat;
import net.minecraft.world.entity.vehicle.boat.ChestBoat;
import scorned.riverside.Riverside;
import scorned.riverside.item.ModItems;


public class ModEntities {


    public static final ResourceKey<EntityType<?>> OLIVE_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_boat"));
    public static final ResourceKey<EntityType<?>> OLIVE_CHEST_BOAT_KEY = ResourceKey.create(Registries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_chest_boat"));



    public static final EntityType<Boat> OLIVE_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_boat"),
            EntityType.Builder.<Boat>of((entityType, level) -> new Boat(entityType, level, () -> ModItems.OLIVE_BOAT),
                            MobCategory.MISC).sized(1.375f, 0.5625f)
                    .clientTrackingRange(10).build(OLIVE_BOAT_KEY));

    public static final EntityType<ChestBoat> OLIVE_CHEST_BOAT = Registry.register(BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "olive_chest_boat"),
            EntityType.Builder.<ChestBoat>of((entityType, level) -> new ChestBoat(entityType, level, () -> ModItems.OLIVED_CHEST_BOAT),
                            MobCategory.MISC).sized(1.375f, 0.5625f)
                    .clientTrackingRange(10).build(OLIVE_CHEST_BOAT_KEY));


    public static void initialize() {
        Riverside.LOGGER.info("Registering Mod Entities for " + Riverside.MOD_ID);
    }

}
