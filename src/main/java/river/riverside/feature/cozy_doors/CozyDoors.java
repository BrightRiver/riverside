package river.riverside.feature.cozy_doors;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.phys.shapes.Shapes;
import river.riverside.core.defaults.StandardProperties;
import river.riverside.core.helpers.BlocksHelper;
import river.riverside.core.helpers.CreativeTabsHelper;

import static net.minecraft.world.level.block.Blocks.BAMBOO_PLANKS;
import static net.minecraft.world.level.block.Blocks.SPRUCE_PLANKS;

public class CozyDoors {

    public static Block DUNGEON_DOOR;
    public static Block FOLDING_DOOR;
    public static Block STAINED_GLASS_DOOR;

    public CozyDoors() {
        DUNGEON_DOOR = BlocksHelper.registerBlock("dungeon_door",
                properties -> new DoorBlock(BlockSetType.SPRUCE,
                        StandardProperties.woodProperties(properties, SPRUCE_PLANKS)
                                .isViewBlocking(Blocks::never)
                                .noOcclusion()
                ));

        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, DUNGEON_DOOR);

        STAINED_GLASS_DOOR = BlocksHelper.registerBlock("stained_glass_door",
                properties -> new CozyDoorBlock(BlockSetType.COPPER,
                        StandardProperties.woodProperties(properties, SPRUCE_PLANKS)
                                .isViewBlocking(Blocks::never)
                                .noOcclusion()
                ));
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, STAINED_GLASS_DOOR);

        FOLDING_DOOR = BlocksHelper.registerBlock("folding_door",
                properties -> new CozyDoorBlock(BlockSetType.BAMBOO,
                        StandardProperties.woodProperties(properties, BAMBOO_PLANKS)
                                .isViewBlocking(Blocks::never)
                                .noOcclusion()
                )
                        .shapeOpenLeft(Shapes.rotateHorizontal(
                                Block.box(0.0F, 0.0F, 7.0F, 3.3F, 16.0F, 16.0F))
                        )
                        .shapeOpenRight(Shapes.rotateHorizontal(
                                Block.box(11.6F, 0.0F, 7.0F, 16.0F, 16.0F, 16.0F)
                        ))
        );
        CreativeTabsHelper.accept(CreativeTabsHelper.RIVERSIDE_TAB, FOLDING_DOOR);
    }
}
