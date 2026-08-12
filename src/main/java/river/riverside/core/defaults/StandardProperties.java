package river.riverside.core.defaults;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;

public final class StandardProperties {


    private StandardProperties() {
    }

    public static BlockBehaviour.Properties woodProperties(BlockBehaviour.Properties p, Block mapBlock) {
        return p.mapColor(mapBlock.defaultMapColor())
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava();
    }

    public static BlockBehaviour.Properties woodProperties(BlockBehaviour.Properties p, MapColor mapColor) {
        return p.mapColor(mapColor)
                .instrument(NoteBlockInstrument.BASS)
                .strength(2.0F, 3.0F)
                .sound(SoundType.WOOD)
                .ignitedByLava();
    }


}
