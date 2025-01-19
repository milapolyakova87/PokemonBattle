import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SpellTest {
    private Spell spell;

    @BeforeEach
    void setUp() {
        spell = new Spell("Fireball", 20, "Fire", 2);
    }

    @Test
    void testGetName() {
        assertEquals("Fireball", spell.getName());
    }

    @Test
    void testGetDamage() {
        assertEquals(20, spell.getDamage());
    }

    @Test
    void testGetCooldown() {
        assertEquals(2, spell.getCooldown());
    }

    @Test
    void testSetCurrentCooldown() {
        spell.setCurrentCooldown(1);
        assertEquals(1, spell.getCurrentCooldown());
    }
}
