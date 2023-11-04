package jobSearchAndApplicationManagementSystem;

//Hasibul Islam Rony

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Profile extends SeeAvailableJobs{
	static String username;
	public void getUserName(String username) {
		this.username = username;
	}
	Menu menu = new Menu();
    public void readUserProfile() {
        String filePath = "users.txt"; // Specify the file name

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("_");

                // Check if the first part of the data (username) matches the provided username
                if (parts.length >= 10 && parts[0].equals(username)) {
                    String password = parts[1];
                    String fullName = parts[2];
                    String dob = parts[3];
                    String university = parts[4];
                    String department = parts[5];
                    String semester = parts[6];
                    String phoneNumber = parts[7];
                    String email = parts[8];
                    String city = parts[9];

                    // Display the extracted information
                    System.out.println("\nUsername: " + username);
                    System.out.println("Password: " + password);
                    System.out.println("Full Name: " + fullName);
                    System.out.println("Date of Birth: " + dob);
                    System.out.println("University: " + university);
                    System.out.println("Department: " + department);
                    System.out.println("Semester: " + semester);
                    System.out.println("Phone Number: " + phoneNumber);
                    System.out.println("Email: " + email);
                    System.out.println("City: " + city);
                    back();
                }
            }
            // If the loop completes without finding a matching profile:
            System.out.println("User profile not found for username: " + username);
        } catch (IOException e) {
            System.out.println("Error reading user data: " + e.getMessage());
            back();
        }
    }
    
    @Override
    public void back() {
    	Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose your option - "); 
        System.out.println("1. Back");
        System.out.print("Enter your choice : ");
        int back = scanner.nextInt();
        if(back == 1) {
        	menu.content();
        }
        else {
        	System.out.println("Invalid input try again");
        	back();
        }
    }
}
