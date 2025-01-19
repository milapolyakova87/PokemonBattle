import java.util.Arrays;
import java.util.List;

public class PokemonSpells {
    // Создаем покемонов с их заклинаниями
    public Pokemon charmander = new Pokemon("charmander", 10, "огонь", 100, 10,
            Arrays.asList(AllSpellConfiguration.fireball, AllSpellConfiguration.scratch, AllSpellConfiguration.spittle, AllSpellConfiguration.pokeball, AllSpellConfiguration.dustInTheEyes));

    public Pokemon psyduck = new Pokemon("psyduck", 10, "вода", 100, 10,
            Arrays.asList(AllSpellConfiguration.waterBlast, AllSpellConfiguration.scratch, AllSpellConfiguration.spittle, AllSpellConfiguration.pokeball, AllSpellConfiguration.dustInTheEyes));

    public Pokemon pikachu = new Pokemon("pikachu", 10, "электричество", 100, 10,
            Arrays.asList(AllSpellConfiguration.vineThunderstorm, AllSpellConfiguration.electricTickle, AllSpellConfiguration.scratch, AllSpellConfiguration.spittle, AllSpellConfiguration.pokeball));

    public Pokemon bulbasaur = new Pokemon("bulbasaur", 10, "трава", 100, 10,
            Arrays.asList(AllSpellConfiguration.razorLeaf, AllSpellConfiguration.scratch, AllSpellConfiguration.spittle, AllSpellConfiguration.pokeball, AllSpellConfiguration.dustInTheEyes));
}