import java.io.*;
import java.util.Scanner;

public class StudentAttendanceAnalyzer {
    private static final String FILE_NAME = "attendance.txt";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("======================================");
        System.out.println("   STUDENT ATTENDANCE FILE ANALYZER");
        System.out.println("======================================");

        int n = readPositiveInt(sc, "Enter number of students: ");

        try {
            storeRecords(sc, n);
            System.out.println("\nStudent records saved successfully to " + FILE_NAME + ".");
            displayBelow75();
        } catch (IOException e) {
            System.out.println("File error: " + e.getMessage());
        } finally {
            sc.close();
        }
    }

    private static void storeRecords(Scanner sc, int n) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (int i = 1; i <= n; i++) {
                System.out.println("\nStudent " + i);
                String name = readName(sc, "Name: ");
                int roll = readPositiveInt(sc, "Roll Number: ");
                int total = readPositiveInt(sc, "Total Classes: ");

                int attended;
                while (true) {
                    attended = readNonNegativeInt(sc, "Classes Attended: ");
                    if (attended <= total) break;
                    System.out.println("Invalid input: Classes Attended cannot be greater than Total Classes.");
                }

                double percentage = ((double) attended / total) * 100;
                writer.write(name + "|" + roll + "|" + total + "|" + attended + "|" +
                        String.format("%.2f", percentage));
                writer.newLine();
            }
        }
    }

    private static void displayBelow75() throws IOException {
        System.out.println("\n======================================");
        System.out.println("Students with attendance below 75%");
        System.out.println("======================================");

        boolean found = false;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] p = line.split("\\|");
                if (p.length != 5) continue;

                double percentage = Double.parseDouble(p[4]);
                if (percentage < 75.0) {
                    found = true;
                    System.out.println("Roll Number: " + p[1] + ", Name: " + p[0]
                            + ", Attendance: " + p[4] + "%");
                    System.out.println("Total Classes: " + p[2] +
                            ", Classes Attended: " + p[3]);
                    System.out.println("--------------------------------------");
                }
            }
        }

        if (!found) System.out.println("No student has attendance below 75%.");
    }

    private static int readPositiveInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value > 0) return value;
                System.out.println("Please enter a value greater than 0.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static int readNonNegativeInt(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value >= 0) return value;
                System.out.println("Please enter 0 or a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a whole number.");
            }
        }
    }

    private static String readName(Scanner sc, String message) {
        while (true) {
            System.out.print(message);
            String name = sc.nextLine().trim();
            if (!name.isEmpty() && !name.contains("|")) return name;
            System.out.println("Invalid name. Please enter a non-empty name.");
        }
    }
}
