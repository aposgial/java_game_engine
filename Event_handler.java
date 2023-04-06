import java.io.File;

public class DynamicFilePath {

    public static String getAbsolutePath(String fileName, String relativePath) {
        // Get the current working directory
        String currentDirectory = System.getProperty("user.dir");

        // Create a File object with the current directory, relative path, and file name
        File file = new File(currentDirectory, relativePath + File.separator + fileName);

        // Get the absolute file path
        String absolutePath = file.getAbsolutePath();

        return absolutePath;
    }

    public static void main(String[] args) {
        // Specify the file name and relative path
        String fileName = "file.txt";
        String relativePath = "Documents";

        // Call the method to get the absolute file path
        String absolutePath = getAbsolutePath(fileName, relativePath);

        // Print the absolute file path
        System.out.println("Absolute path of the file: " + absolutePath);
    }
}
