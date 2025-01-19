import java.util.Arrays;
import java.util.List;

public class AllSpellConfiguration {
    // Создаем заклинания
    public static Spell fireball = new Spell("Огненный шар", 20, "огонь", 2);
    public static Spell waterBlast = new Spell("Водный удар", 15, "вода", 1);
    public static Spell vineThunderstorm = new Spell("Удар молнией", 18, "электричество", 2);
    public static Spell electricTickle = new Spell("Электро щекотка", 15, "электричество", 1);
    public static Spell razorLeaf = new Spell("Острый лист", 12, "трава", 1);
    public static Spell scratch = new Spell("Царапка", 50, "трава", 3);
    public static Spell dustInTheEyes = new Spell("Пыль в глаза", 40, "электричество", 3);
    public static Spell spittle = new Spell("Плевок", 33, "огонь", 1);
    public static Spell pokeball = new Spell("Покеболом по башке", 37, "вода", 1);

    // Метод для загрузки всех заклинаний
    public List<Spell> loadAllSpells() {
        return Arrays.asList(fireball, waterBlast, vineThunderstorm, electricTickle, razorLeaf, scratch, dustInTheEyes, spittle, pokeball);
    }
}