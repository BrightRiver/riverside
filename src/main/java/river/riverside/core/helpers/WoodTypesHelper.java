package river.riverside.core.helpers;

import net.fabricmc.fabric.api.object.builder.v1.block.type.WoodTypeBuilder;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import river.riverside.Riverside;

public class WoodTypesHelper {

    public static WoodType register(String name, WoodType baseType, BlockSetType blockSetType) {
        return WoodTypeBuilder.copyOf(baseType)
                .register(Riverside.id(name), blockSetType);
    }
}
