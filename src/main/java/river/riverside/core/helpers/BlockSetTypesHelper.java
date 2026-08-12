package river.riverside.core.helpers;

import net.fabricmc.fabric.api.object.builder.v1.block.type.BlockSetTypeBuilder;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import river.riverside.Riverside;

public class BlockSetTypesHelper {

    public static BlockSetType register(String name, BlockSetType baseType) {
        return BlockSetTypeBuilder.copyOf(baseType)
                .register(Riverside.id(name));
    }
}
