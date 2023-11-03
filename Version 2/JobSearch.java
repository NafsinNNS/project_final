package jobSearchAndApplicationManagementSystem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JobSearch {
    public static void main(String[] args) {
        String filePath = "job_data.txt";
        Scanner scanner = new Scanner(System.in);
        Menu menu = new Menu();

        List<String> records = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                records.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        while (true) {
            displayMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 5) {
                menu.content();
            } else if (choice == 2) {
                displayCategoryMenu();
                int categoryChoice = scanner.nextInt();
                scanner.nextLine();

                String category = getCategoryByChoice(categoryChoice);

                if (category != null) {
                    searchAndDisplayResultsByCategory(records, category);
                } else {
                    System.out.println("Invalid category choice.");
                }
            } else {
                System.out.print("Enter your search term: ");
                String searchTerm = scanner.nextLine().trim();
                searchAndDisplayResults(records, choice, searchTerm);
            }
        }
    }

    public static void displayMenu() {
        System.out.println("\nSelect a search option:");
        System.out.println("1. Job Company");
        System.out.println("2. Background");
        System.out.println("3. Salary");
        System.out.println("4. Location");
        System.out.println("5. Back");
        System.out.print("Enter your choice: ");
    }

    public static void displayCategoryMenu() {
        System.out.println("\nSelect a job category:");
        String[] disciplines = {
            "1. Architecture",
            "2. Biochemistry and Microbiology",
            "3. Biotechnology",
            "4. Biochemistry and Biotechnology",
            "5. Business Administration",
            "6. Computer Science & Engineering (CSE)",
            "7. Development Studies",
            "8. Economics",
            "9. Electrical & Electronic Engineering (EEE)",
            "10. Electronics & Telecommunications Engineering (ETE)",
            "11. Environmental Science",
            "12. Law",
            "13. Media and Film",
            "14. Pharmacy",
            "15. Public Health",
            "16. Public Policy and Governance"
        };

        for (String discipline : disciplines) {
            System.out.println(discipline);
        }
        System.out.print("Enter your choice: ");
    }

    public static String getCategoryByChoice(int choice) {
        switch (choice) {
            case 1:
                return "Architecture";
            case 2:
                return "Biochemistry and Microbiology";
            case 3:
                return "Biotechnology";
            case 4:
                return "Biochemistry and Biotechnology";
            case 5:
                return "Business Administration";
            case 6:
                return "Computer Science & Engineering (CSE)";
            case 7:
                return "Development Studies";
            case 8:
                return "Economics";
            case 9:
                return "Electrical & Electronic Engineering (EEE)";
            case 10:
                return "Electronics & Telecommunications Engineering (ETE)";
            case 11:
                return "Environmental Science";
            case 12:
                return "Law";
            case 13:
                return "Media and Film";
            case 14:
                return "Pharmacy";
            case 15:
                return "Public Health";
            case 16:
                return "Public Policy and Governance";
            default:
                return null;
        }
    }

    public static void searchAndDisplayResults(List<String> records, int choice, String searchTerm) {
        boolean recordFound = false;

        for (String record : records) {
            String[] parts = record.split("_");
            if (parts.length == 11) {
                if ((choice == 1 && parts[0].equalsIgnoreCase(searchTerm)) ||
                    (choice == 2 && parts[2].equalsIgnoreCase(searchTerm)) ||
                    (choice == 3 && Double.parseDouble(parts[6]) >= Double.parseDouble(searchTerm)) ||
                    (choice == 4 && parts[7].toLowerCase().contains(searchTerm.toLowerCase()))) {
                    displayFormattedRecord(parts);
                    recordFound = true;
                }
            }
        }

        if (!recordFound) {
            System.out.println("No matching job records found.");
        }
    }

    public static void searchAndDisplayResultsByCategory(List<String> records, String category) {
        boolean recordFound = false;

        for (String record : records) {
            String[] parts = record.split("_");
            if (parts.length == 11 && parts[2].equalsIgnoreCase(category)) {
                displayFormattedRecord(parts);
                recordFound = true;
            }
        }

        if (!recordFound) {
            System.out.println("No matching job records found in the " + category + " category.");
        }
    }

    public static void displayFormattedRecord(String[] parts) {
        if (parts.length == 11) {
            System.out.println("Company: " + parts[0]);
            System.out.println("Position: " + parts[1]);
            System.out.println("Field: " + parts[2]);
            System.out.println("Education: " + parts[3]);
            System.out.println("Required CGPA: " + parts[4]);
            System.out.println("Address: " + parts[5]);
            System.out.println("Salary: " + parts[6]);
            System.out.println("Location: " + parts[7]);
            System.out.println("Job Type: " + parts[8]);
            System.out.println("Deadline: " + parts[9]);
            System.out.println("Email: " + parts[10]);
        }
        System.out.println(); // Add an empty line to separate records
    }


}
