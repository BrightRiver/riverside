package scorned.riverside.block;

import net.minecraft.data.BlockFamilies;
import net.minecraft.data.BlockFamily;
import scorned.riverside.Riverside;

public class ModBlockFamilies {

    public static final BlockFamily OLIVE_PLANKS = BlockFamilies.familyBuilder(ModBlocks.OLIVE_PLANKS)
            .log(ModBlocks.OLIVE_LOG)
            .strippedLog(ModBlocks.STRIPPED_OLIVE_LOG)

            .button(ModBlocks.OLIVE_BUTTON)
            .fence(ModBlocks.OLIVE_FENCE)
            .fenceGate(ModBlocks.OLIVE_FENCE_GATE)
            .hangingSign(ModBlocks.OLIVE_HANGING_SIGN, ModBlocks.OLIVE_WALL_HANGING_SIGN)
            .pressurePlate(ModBlocks.OLIVE_PRESSURE_PLATE)
            .sign(ModBlocks.OLIVE_SIGN, ModBlocks.OLIVE_WALL_SIGN)
            .slab(ModBlocks.OLIVE_SLAB)
            .stairs(ModBlocks.OLIVE_STAIR)
            .door(ModBlocks.OLIVE_DOOR)
            .trapdoor(ModBlocks.OLIVE_TRAPDOOR)
            .wall(ModBlocks.OLIVE_WALL)
            .recipeGroupPrefix("riverside")
            .recipeUnlockedBy("has_planks")
            .getFamily();


    public static void initialize() {
        Riverside.LOGGER.info("Registering Mod Blocks for " + Riverside.MOD_ID);
    }
}
