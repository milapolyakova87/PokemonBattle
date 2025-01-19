import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

class BattleArenaIntegrationTest {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private BattleArena battleArena;

    @BeforeEach
    void setUp() {
        // Создаем заклинания
        Spell fireball = new Spell("Огненный шар", 20, "огонь", 2);
        Spell vineThunderstorm = new Spell("Удар молнией", 18, "электричество", 2);
        Spell electricTickle = new Spell("Электро щекотка", 15, "электричество", 1);
        Spell scratch = new Spell("Царапка", 50, "нормальный", 3);
        Spell dustInTheEyes = new Spell("Пыль в глаза", 40, "нормальный", 3);
        Spell spittle = new Spell("Плевок", 33, "нормальный", 1);
        Spell pokeball = new Spell("Покеболом по башке", 37, "нормальный", 1);

        // Создаем покемонов с их заклинаниями
        pokemon1 = new Pokemon("Pikachu", 10, "электричество", 100, 10, Arrays.asList(vineThunderstorm, electricTickle, scratch, spittle, pokeball));
        pokemon2 = new Pokemon("Charmander", 10, "огонь", 100, 10, Arrays.asList(fireball, scratch, spittle, pokeball, dustInTheEyes));
        battleArena = new BattleArena(pokemon1, pokemon2);
    }

    @Test
    void testStartBattle() {
        // Тест начала битвы без ошибок
        assertDoesNotThrow(() -> battleArena.startBattle());
    }
}