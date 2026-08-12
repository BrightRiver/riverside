package river.riverside.core.providers;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.core.HolderLookup;
import org.jspecify.annotations.NonNull;
import river.riverside.core.helpers.CreativeTabsHelper;
import river.riverside.core.instructions.LanguageInstruction;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class LanguageProvider extends FabricLanguageProvider {

    private final List<LanguageInstruction> instructions = new ArrayList<>();

    public LanguageProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, "en_us", registriesFuture);
    }

    public boolean add(LanguageInstruction instruction) {
        instructions.add(instruction);
        return true;
    }

    @Override
    public void generateTranslations(HolderLookup.@NonNull Provider registries, TranslationBuilder translationBuilder) {
        translationBuilder.add(CreativeTabsHelper.RIVERSIDE_TAB, "Riverside");

        for (LanguageInstruction instruction : instructions) {
            translationBuilder.add(instruction.target().asItem(), instruction.englishName());
        }
    }
}
