import java.io.*;
import java.util.Scanner;

public class FileOperationsScript {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String filePath = "example.txt"; // File to work with

        // Display options to user
        System.out.println("Select an operation:");
        System.out.println("1. Write to File");
        System.out.println("2. Read from File");
        System.out.println("3. Modify File");

        int choice = scanner.nextInt(); // Get user choice
        scanner.nextLine(); // Consume newline

        // Perform selected operation
        switch (choice) {
            case 1 -> writeToFile(filePath, scanner);  // Write content to file
            case 2 -> readFromFile(filePath);          // Read content from file
            case 3 -> modifyFile(filePath, scanner);  // Modify content in file
            default -> System.out.println("Invalid choice!");  // Handle invalid choice
        }
    }

    // Write text to a file
    public static void writeToFile(String filePath, Scanner scanner) throws IOException {
        System.out.print("Enter text to write: ");
        String content = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write(content);  // Write user input to file
            System.out.println("Content written to file.");
        }
    }

    // Read content from a file
    public static void readFromFile(String filePath) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("File content:");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);  // Print each line from the file
            }
        }
    }

    // Modify (append) content to a file
    public static void modifyFile(String filePath, Scanner scanner) throws IOException {
        System.out.print("Enter text to append: ");
        String newContent = scanner.nextLine();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(newContent);  // Append new content to file
            System.out.println("Content appended to file.");
        }
    }
}
