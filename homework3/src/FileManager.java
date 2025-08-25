import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private String filePath;

    public FileManager(String filePath) {
        this.filePath = filePath;
    }

    public void writeToFile(List<String> data) throws FileOperationException {
        try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(filePath))) {
            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Данные успешно записаны в файл: " + filePath);

        } catch (IOException e) {
            throw new FileOperationException("Ошибка записи в файл: " + filePath, e);
        }
    }

    public List<String> readFromFile() throws FileOperationException {
        List<String> lines = new ArrayList<>();

        try (BufferedReader reader = Files.newBufferedReader(Paths.get(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("Данные успешно прочитаны из файла: " + filePath);

        } catch (NoSuchFileException e) {
            throw new FileOperationException("Файл \"" + filePath + "\" не найден", e);
        } catch (IOException e) {
            throw new FileOperationException("Ошибка чтения файла: " + filePath, e);
        }

        return lines;
    }


    public void appendToFile(List<String> data) throws FileOperationException {
        try (BufferedWriter writer = Files.newBufferedWriter(
                Paths.get(filePath),
                StandardOpenOption.CREATE,
                StandardOpenOption.APPEND)) {

            for (String line : data) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("Данные успешно добавлены в файл: " + filePath);

        } catch (IOException e) {
            throw new FileOperationException("Ошибка добавления в файл: " + filePath, e);
        }
    }
}
