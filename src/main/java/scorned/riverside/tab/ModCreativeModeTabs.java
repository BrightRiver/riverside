package scorned.riverside.tab;

import net.fabricmc.fabric.api.creativetab.v1.FabricCreativeModeTab;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import scorned.riverside.Riverside;
import scorned.riverside.block.ModBlocks;
import scorned.riverside.item.ModItems;

public class ModCreativeModeTabs {

    public static final CreativeModeTab RIVERSIDE_TAB = Registry.register(
            BuiltInRegistries.CREATIVE_MODE_TAB,
            Identifier.fromNamespaceAndPath(Riverside.MOD_ID, "riverside"),
            FabricCreativeModeTab.builder()
                    .icon(() -> new ItemStack(ModBlocks.OLIVE_PLANKS))
                    .title(Component.translatable("tab.riverside.creative_tab"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.OLIVE);
                        output.accept(ModBlocks.OLIVE_PLANKS);
                        output.accept(ModBlocks.OLIVE_WOOD);
                        output.accept(ModBlocks.OLIVE_LOG);
                        output.accept(ModBlocks.STRIPPED_OLIVE_WOOD);
                        output.accept(ModBlocks.STRIPPED_OLIVE_LOG);
                        output.accept(ModBlocks.OLIVE_FENCE);
                        output.accept(ModBlocks.OLIVE_FENCE_GATE);
                        output.accept(ModBlocks.OLIVE_WALL);
                        output.accept(ModBlocks.OLIVE_SLAB);
                        output.accept(ModBlocks.OLIVE_STAIR);
                        output.accept(ModBlocks.OLIVE_SHELF);
                        output.accept(ModBlocks.OLIVE_BUTTON);
                        output.accept(ModBlocks.OLIVE_PRESSURE_PLATE);
                        output.accept(ModBlocks.OLIVE_SIGN);
                        output.accept(ModItems.OLIVE_HANGING_SIGN);
                        output.accept(ModBlocks.OLIVE_DOOR);
                        output.accept(ModBlocks.OLIVE_TRAPDOOR);
                    })
                    .build());

    public static void initialize() {
        Riverside.LOGGER.info("registering creative mode tab for " + Riverside.MOD_ID);
    }
}
