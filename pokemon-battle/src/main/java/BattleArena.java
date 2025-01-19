import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BattleArena {
    private Pokemon pokemon1;
    private Pokemon pokemon2;
    private Scanner scanner;

    public BattleArena(Pokemon pokemon1, Pokemon pokemon2) {
        this.pokemon1 = pokemon1;
        this.pokemon2 = pokemon2;
        this.scanner = new Scanner(System.in);
    }

    // Проведение битвы
    public void startBattle() {
        System.out.println("Добро пожаловать на Бой Покемонов! " +
                "Битва начинается между " + pokemon1.getName() + " и " + pokemon2.getName() + "!");

        while (pokemon1.isAlive() && pokemon2.isAlive()) {
            // Ход первого покемона
            System.out.println("\nХод " + pokemon1.getName() + "!");
            performTurn(pokemon1, pokemon2);

            if (!pokemon2.isAlive()) break;

            // Ход второго покемона
            System.out.println("\nХод " + pokemon2.getName() + "!");
            performTurn(pokemon2, pokemon1);

            // Обновление перезарядки заклинаний
            pokemon1.updateSpellsCooldown();
            pokemon2.updateSpellsCooldown();

            // Проверка на "последний шанс" перед поражением
            checkLastChance(pokemon1, pokemon2);
            checkLastChance(pokemon2, pokemon1);
        }

        // Определение победителя
        Pokemon winner = pokemon1.isAlive() ? pokemon1 : pokemon2;
        System.out.println("Соперник поражён!");

        // Отображение изображения победителя
        PokemonFight.displayWinner(winner);
    }

    // Выполнение хода покемона
    protected void performTurn(Pokemon attacker, Pokemon defender) {
        System.out.println("Выберите действие:");
        System.out.println("1. Обычная атака");
        System.out.println("2. Использовать заклинание");

        int choice = scanner.nextInt();
        if (choice == 1) {
            attacker.attack(defender);
        } else if (choice == 2) {
            List<Spell> availableSpells = getAvailableSpells(attacker);
            if (availableSpells.isEmpty()) {
                System.out.println("У покемона нет доступных заклинаний!");
                attacker.attack(defender);
            } else {
                System.out.println("Выберите заклинание:");
                for (int i = 0; i < availableSpells.size(); i++) {
                    Spell spell = availableSpells.get(i);
                    System.out.println((i + 1) + ". " + spell.getName() + " (Урон: " + spell.getDamage() + ")");
                }
                int spellChoice = scanner.nextInt();
                if (spellChoice > 0 && spellChoice <= availableSpells.size()) {
                    Spell selectedSpell = availableSpells.get(spellChoice - 1);
                    attacker.useSpell(defender, selectedSpell);
                } else {
                    System.out.println("Неверный выбор, выполняется обычная атака.");
                    attacker.attack(defender);
                }
            }
        } else {
            System.out.println("Неверный выбор, выполняется обычная атака.");
            attacker.attack(defender);
        }
    }

    // Получение списка доступных заклинаний (не на перезарядке)
    private List<Spell> getAvailableSpells(Pokemon pokemon) {
        List<Spell> availableSpells = new ArrayList<>();
        for (Spell spell : pokemon.getSpells()) {
            if (spell.getCurrentCooldown() == 0) {
                availableSpells.add(spell);
            }
        }
        return availableSpells;
    }

    // Проверка на "последний шанс" перед поражением
    private void checkLastChance(Pokemon pokemon, Pokemon opponent) {
        if (pokemon.getHealth() <= 10 && pokemon.isAlive()) { // Если здоровье меньше или равно 10
            System.out.println(pokemon.getName() + " на грани поражения! Используйте последний шанс!");

            // Создаем заклинания "Плевок" и "Покеболом по башке"
            Spell spittle = new Spell("Плевок", 33, "огонь", 1);
            Spell pokeball = new Spell("Покеболом по башке", 37, "вода", 1);

            // Предлагаем выбор
            System.out.println("Выберите заклинание для последнего шанса:");
            System.out.println("1. " + spittle.getName() + " (Урон: " + spittle.getDamage() + ")");
            System.out.println("2. " + pokeball.getName() + " (Урон: " + pokeball.getDamage() + ")");

            int choice = scanner.nextInt();
            if (choice == 1) {
                pokemon.useSpell(opponent, spittle);
            } else if (choice == 2) {
                pokemon.useSpell(opponent, pokeball);
            } else {
                System.out.println("Неверный выбор, последний шанс упущен.");
            }
        }
    }
}