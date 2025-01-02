import java.io.*;
import java.util.Scanner;

public class SimpleFileOperations {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath = "example.txt"; // File name or path

        System.out.println("Choose an operation:");
        System.out.println("1. Write to file");
        System.out.println("2. Read from file");
        System.out.println("3. Modify file");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        switch (choice) {
            case 1 -> writeToFile(filePath, scanner);
            case 2 -> readFromFile(filePath);
            case 3 -> modifyFile(filePath, scanner);
            default -> System.out.println("Invalid choice!");
        }
    }

    public static void writeToFile(String filePath, Scanner scanner) throws IOException {
        System.out.print("Enter text to write: ");
        String content = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);
            System.out.println("File written successfully.");
        }
    }

    public static void readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("File content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }

    public static void modifyFile(String filePath, Scanner scanner) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        System.out.println("Current content:\n" + content);
        System.out.print("Enter text to append: ");
        String newContent = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content + newContent);
            System.out.println("File modified successfully.");
        }
    }
}
