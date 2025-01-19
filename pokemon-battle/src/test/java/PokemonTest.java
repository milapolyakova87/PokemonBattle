import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class PokemonTest {
    private Pokemon pokemon;
    private List<Spell> spells;

    @BeforeEach
    void setUp() {
        spells = Arrays.asList(
                new Spell("Fireball", 20, "Fire", 2),
                new Spell("Water Blast", 15, "Water", 1)
        );
        pokemon = new Pokemon("Pikachu", 10, "Electric", 100, 10, spells);
    }

    @Test
    void testAttack() {
        Pokemon opponent = new Pokemon("Charmander", 10, "Fire", 100, 10, spells);
        pokemon.attack(opponent);
        assertEquals(90, opponent.getHealth());
    }

    @Test
    void testUseSpell() {
        Pokemon opponent = new Pokemon("Charmander", 10, "Fire", 100, 10, spells);
        pokemon.useSpell(opponent, spells.get(0));
        assertEquals(80, opponent.getHealth());
        assertEquals(2, spells.get(0).getCurrentCooldown());
    }

    @Test
    void testTakeDamage() {
        pokemon.takeDamage(20);
        assertEquals(80, pokemon.getHealth());
    }

    @Test
    void testIsAlive() {
        assertTrue(pokemon.isAlive());
        pokemon.takeDamage(100);
        assertFalse(pokemon.isAlive());
    }

    @Test
    void testUpdateSpellsCooldown() {
        pokemon.useSpell(new Pokemon("Charmander", 10, "Fire", 100, 10, spells), spells.get(0));
        pokemon.updateSpellsCooldown();
        assertEquals(1, spells.get(0).getCurrentCooldown());
    }
}
