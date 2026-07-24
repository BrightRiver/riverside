package scorned.riverside.data;

import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import scorned.riverside.Riverside;

import java.util.function.UnaryOperator;

public class ModDataComponents {
    public static final DataComponentType<Integer> PICKLE_AGE =
            register("age", builder -> builder
                    .persistent(Codec.INT) // <-- we'll fix this line
                    .networkSynchronized(ByteBufCodecs.VAR_INT)
                    .cacheEncoding());


    private static <T>DataComponentType<T> register(String name, UnaryOperator<DataComponentType.Builder<T>> builderOperator) {
        return Registry.register(BuiltInRegistries.DATA_COMPONENT_TYPE, Identifier.fromNamespaceAndPath(Riverside.MOD_ID, name),
                builderOperator.apply(DataComponentType.builder()).build());
    }

    public static void initialize() {
        Riverside.LOGGER.info("Registering Data Components for " + Riverside.MOD_ID);
    }
}
