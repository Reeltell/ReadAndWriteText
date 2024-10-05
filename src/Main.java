import java.io.*;
import java.nio.file.*;

class Main {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\PC\\Desktop\\Проекты\\Text.txt";
        String outputFilePath = "C:\\Users\\PC\\Desktop\\Проекты\\vivod.svs";  // Результат

        try {
            // Чтение файла .txt
            String content = new String(Files.readAllBytes(Paths.get(filePath)));

            // Подсчет количества символов
            int totalCharacters = content.length();

            // Подсчет количества символов без пробелов
            int charactersWithoutSpaces = content.replace(" ", "").length();

            // Подсчет количества символов без учета пробелов и знаков препинания
            int charactersWithoutSpacesAndPunctuation = content.replaceAll("[\\s\\p{Punct}]", "").length();

            // Подсчет количества слов
            String[] words = content.trim().split("\\s+");
            int wordCount = words.length;

            // Вывод в консоль
            System.out.println("Количество символов в тексте: " + totalCharacters);
            System.out.println("Количество символов в тексте без пробелов: " + charactersWithoutSpaces);
            System.out.println("Количество символов в тексте без пробелов и знаков препинания: " + charactersWithoutSpacesAndPunctuation);
            System.out.println("Количество слов: " + wordCount);

            // Запись результатов в .svc файл
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {
                writer.write("Результаты анализа текста:\n");
                writer.write("Количество символов в тексте: " + totalCharacters + "\n");
                writer.write("Количество символов в тексте без пробелов: " + charactersWithoutSpaces + "\n");
                writer.write("Количество символов в тексте без пробелов и знаков препинания: " + charactersWithoutSpacesAndPunctuation + "\n");
                writer.write("Количество слов: " + wordCount + "\n");
            }

            System.out.println("Результаты записаны в файл: " + outputFilePath);

        } catch (IOException e) {
            System.out.println("Ошибка при чтении или записи файла: " + e.getMessage());
        }
    }
}