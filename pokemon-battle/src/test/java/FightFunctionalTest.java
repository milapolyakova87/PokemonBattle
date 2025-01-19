import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FightFunctionalTest {

    @Test
    void testFullBattleCycle() {
        List<Spell> spells = Arrays.asList(
                new Spell("Огненный шар", 20, "огонь", 2),
                new Spell("Удар молнией", 18, "электричество", 2)
        );
        Pokemon pokemon1 = new Pokemon("Pikachu", 10, "Electric", 100, 10, spells);
        Pokemon pokemon2 = new Pokemon("Charmander", 10, "Fire", 100, 10, spells);
        BattleArena battleArena = new BattleArena(pokemon1, pokemon2);

        // Cимуляция победы
        while (pokemon1.isAlive() && pokemon2.isAlive()) {
            battleArena.performTurn(pokemon1, pokemon2);
            if (pokemon2.isAlive()) {
                battleArena.performTurn(pokemon2, pokemon1);
            }
        }

        assertTrue(pokemon1.isAlive() || pokemon2.isAlive());
    }
}
