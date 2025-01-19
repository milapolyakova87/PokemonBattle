import java.util.List;

public class Pokemon {
    private String name;
    /*
    не смогла реализовать прокачку уровней
    private int level;
     */
    /*
    не смогла реализовать стихии
    private String element;
     */
    private int health;
    private int baseDamage;
    private List<Spell> spells;
    private int lastUsedSpellIndex = -1; // Индекс последнего использованного заклинания

    public Pokemon(String name, int level, String element, int health, int baseDamage, List<Spell> spells) {
        this.name = name;
        /*
        this.level = level;
        this.element = element;
         */
        this.health = health;
        this.baseDamage = baseDamage;
        this.spells = spells;
    }

    // Атака обычным ударом
    public void attack(Pokemon opponent) {
        int damage = this.baseDamage;
        System.out.println(this.name + " атакует с яростью " + opponent.getName() + " и наносит врагу " + damage + " урона!");
        opponent.takeDamage(damage);
    }

    // Использование заклинания
    public void useSpell(Pokemon opponent, Spell spell) {
        if (spell.getCurrentCooldown() > 0) {
            System.out.println(spell.getName() + " на перезарядке! Осталось ходов: " + spell.getCurrentCooldown());
            return;
        }

        int damage = spell.getDamage();
        System.out.println(this.name + " использует спелл " + spell.getName() + " и наносит " + damage + " урона!");
        opponent.takeDamage(damage);
        spell.setCurrentCooldown(spell.getCooldown());
    }

    // Получение урона
    public void takeDamage(int damage) {
        this.health -= damage;
        if (this.health < 0) {
            this.health = 0;
        }
        System.out.println(this.name + " теперь имеет " + this.health + " здоровья.");
    }

    // Проверка, жив ли покемон
    public boolean isAlive() {
        return this.health > 0;
    }

    // Обновление перезарядки заклинаний
    public void updateSpellsCooldown() {
        for (Spell spell : spells) {
            if (spell.getCurrentCooldown() > 0) {
                spell.setCurrentCooldown(spell.getCurrentCooldown() - 1);
            }
        }
    }

    // Геттеры
    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public List<Spell> getSpells() {
        return spells;
    }

    // Получение следующего заклинания по очереди
    public Spell getNextSpell() {
        if (spells.isEmpty()) {
            return null;
        }
        lastUsedSpellIndex = (lastUsedSpellIndex + 1) % spells.size();
        return spells.get(lastUsedSpellIndex);
    }

    // Сброс цикла заклинаний
    public void resetSpellCycle() {
        lastUsedSpellIndex = -1;
    }
}