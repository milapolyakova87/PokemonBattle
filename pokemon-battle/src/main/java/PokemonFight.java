import ij.IJ;
import ij.ImagePlus;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PokemonFight {

    public static void main(String[] args) {
        // Создаем экземпляр AllSpellConfiguration для загрузки заклинаний
        AllSpellConfiguration allSpellConfiguration = new AllSpellConfiguration();
        var spells = allSpellConfiguration.loadAllSpells(); // Загружаем все заклинания

        // Создаем экземпляр PokemonSpells для получения списка покемонов
        PokemonSpells pokemonSpells = new PokemonSpells();
        List<Pokemon> pokemonList = Arrays.asList(
                pokemonSpells.charmander,
                pokemonSpells.psyduck,
                pokemonSpells.pikachu,
                pokemonSpells.bulbasaur
        );

        // Выбираем двух рандомных покемонов
        Random random = new Random();
        Pokemon pokemon1 = pokemonList.get(random.nextInt(pokemonList.size()));
        Pokemon pokemon2;
        do {
            pokemon2 = pokemonList.get(random.nextInt(pokemonList.size()));
        } while (pokemon2 == pokemon1); // Убедимся, что это два разных покемона

        // Начинаем битву
        BattleArena arena = new BattleArena(pokemon1, pokemon2);
        arena.startBattle();
    }

    /**
     * Отображает изображение победившего покемона.
     *
     * @param winner Победивший покемон
     */
    public static void displayWinner(Pokemon winner) {
        // Путь к изображению относительно src/main/resources
        String imagePath = winner.getName() + ".jpg"; // Например, "pickachu.jpg"

        // Загрузка изображения как ресурса
        InputStream inputStream = PokemonFight.class.getClassLoader().getResourceAsStream(imagePath);
        if (inputStream != null) {
            // Сохраняет изображение во временный файл (ImageJ требует файл, а не поток)
            String tempFilePath = "temp_" + imagePath;
            try {
                java.nio.file.Files.copy(inputStream, java.nio.file.Paths.get(tempFilePath), java.nio.file.StandardCopyOption.REPLACE_EXISTING);
            } catch (Exception e) {
                System.out.println("Ошибка при создании временного файла: " + e.getMessage());
                return;
            }

            // Открывает изображение с помощью ImageJ
            ImagePlus image = IJ.openImage(tempFilePath);
            if (image != null) {
                System.out.println("Победил " + winner.getName() + "!");
                image.show();
            } else {
                System.out.println("Не удалось загрузить изображение.");
            }
        }
    }
}