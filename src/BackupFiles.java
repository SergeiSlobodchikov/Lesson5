import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
public class BackupFiles {
    private static final String sourceFolder = "."; // путь к исходной директории
    private static final String backupFolder = "./backup"; // путь к папке для резервной копии

    public static void backupFiles(String source_Folder, String backup_Folder){
        try {
            File sourceDir = new File(source_Folder);
            File backupDir = new File(backup_Folder);
            // Создаем папку для резервной копии, если она не существует
            if (!backupDir.exists()) {
                backupDir.mkdir();
            }
            // Получаем список файлов в исходной директории
            File[] files = sourceDir.listFiles();
            if (files != null) {
                for (File file : files) {
                    if (file.isFile()) {
                        // Копируем файл в папку резервной копии
                        Files.copy(file.toPath(), new File(backupDir.getAbsolutePath() + "/" + file.getName()).toPath(), StandardCopyOption.REPLACE_EXISTING);
                    }
                }
            }
            System.out.println("Резервная копия файлов создана успешно!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       backupFiles(sourceFolder,backupFolder);
    }
}