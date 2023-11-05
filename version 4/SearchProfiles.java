package jobSearchAndApplicationManagementSystem;

//Syed Ashfaq Shafin
//ID- 2312845042

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchProfiles{
	Menu menu = new Menu();
    private List<String> profileData = new ArrayList<>();

    public static void main(String[] args) {
        SearchProfiles profileSearch = new SearchProfiles();
        profileSearch.loadProfileData("users.txt");
        profileSearch.searchProfiles();
    }

    private void loadProfileData(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                profileData.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void searchProfiles() {
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Enter a keyword to search for a profile: ");
                String keyword = scanner.nextLine().trim().toLowerCase();

                List<Integer> matchingProfileIndices = new ArrayList<>();

                for (int i = 0; i < profileData.size(); i++) {
                    String profile = profileData.get(i).toLowerCase();
                    if (profile.contains(keyword)) {
                        matchingProfileIndices.add(i);
                    }
                }

                if (matchingProfileIndices.isEmpty()) {
                    System.out.println("No matching profiles found.");
                } else {
                    System.out.println("Matching Profiles:");
                    for (int i = 0; i < matchingProfileIndices.size(); i++) {
                        int profileIndex = matchingProfileIndices.get(i);
                        viewProfile(profileData.get(profileIndex));
                    }

                    System.out.println("Enter your choices : ");
                    System.out.println("1. Search Again");
                    System.out.println("2. Back");
                    int choice = scanner.nextInt();
                    if (choice == 1) {
                        searchProfiles();
                    } else if (choice == 2) {
                    	menu.content();
                        break;
                    } else {
                        System.out.println("Invalid choice. Please try again.");
                    }
                }
            }
        }
    }

    private void viewProfile(String profile) {
        // Split the profile into separate fields using underscore as the delimiter
        String[] profileFields = profile.split("_");

        // Define field labels
        String[] fieldLabels = {
            "Username", "Fullname", "Date of Birth", "Institute",
            "Degree", "CGPA", "Phone Number", "Email", "Address"
        };

        // Display profile information with labels
        System.out.println("Profile Information:\n");
        for (int i = 0; i < profileFields.length && i < fieldLabels.length; i++) {
            if (i != 1) { // Exclude the second field (password)
                System.out.println(fieldLabels[i] + ": " + profileFields[i]);
            }
        }
    }
}
