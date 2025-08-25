import java.io.*;
import java.nio.file.*;
import java.util.*;


class FileOperationException extends Exception {
    public FileOperationException(String message) {
        super(message);
    }

    public FileOperationException(String message, Throwable cause) {
        super(message, cause);
    }
}


public class Main {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager("data.txt");


        try {
            List<String> dataToWrite = Arrays.asList(
                    "Hello, World!",
                    "Тестовые данные",
                    "Ля-ля-ля пример",
                    "Бла-Бла-Бла"
            );

            fileManager.writeToFile(dataToWrite);

        } catch (FileOperationException e) {
            System.err.println("Ошибка при записи: " + e.getMessage());
            e.printStackTrace();
        }


        try {
            List<String> readData = fileManager.readFromFile();
            System.out.println("\nСодержимое файла:");
            readData.forEach(System.out::println);

        } catch (FileOperationException e) {
            System.err.println("Ошибка при чтении: " + e.getMessage());
            e.printStackTrace();
        }


        try {
            List<String> additionalData = Arrays.asList(
                    "Новая строка 1",
                    "Новая строка 2"
            );

            fileManager.appendToFile(additionalData);

        } catch (FileOperationException e) {
            System.err.println("Ошибка при добавлении: " + e.getMessage());
            e.printStackTrace();
        }


        try {
            List<String> finalData = fileManager.readFromFile();
            System.out.println("\nФинальное содержимое файла:");
            finalData.forEach(System.out::println);

        } catch (FileOperationException e) {
            System.err.println("Ошибка при финальном чтении: " + e.getMessage());
            e.printStackTrace();
        }


        try {
            FileManager nonExistent = new FileManager("none.txt");
            nonExistent.readFromFile();

        } catch (FileOperationException e) {
            System.err.println("\nОжидаемая ошибка для несуществующего файла:");
            System.err.println("Сообщение: " + e.getMessage());
        }
    }
}