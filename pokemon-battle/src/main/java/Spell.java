// Создание заклинаний, перезарядка и прочее
public class Spell {
    private final String name;
    private final int damage;
    /*public enum Element {
        огонь,
        вода,
        электричество,
        трава
    }

     */


    private final int cooldown;
    private int currentCooldown;

    public Spell(String name, int damage, String element, int cooldown) {
        this.name = name;
        this.damage = damage;
        /*this.element = element;
     не справилась
         */
        this.cooldown = cooldown;
        this.currentCooldown = 0;
    }

    // Геттеры и сеттеры
    public String getName() {
        return name;
    }

    public int getDamage() {
        return damage;
    }

    public int getCooldown() {
        return cooldown;
    }

    public int getCurrentCooldown() {
        return currentCooldown;
    }

    public void setCurrentCooldown(int currentCooldown) {
        this.currentCooldown = currentCooldown;
    }
}
