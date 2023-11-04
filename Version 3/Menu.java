package jobSearchAndApplicationManagementSystem;

//Nafsin Nasama Salmee

import java.io.*;
import java.util.*;

import javax.print.attribute.standard.JobOriginatingUserName;
public class Menu implements MenuOption{
	JobSearch jobsearch = new JobSearch();
	SeeAvailableJobs seeAvailableJobs = new SeeAvailableJobs();
	JobPost jobpost = new JobPost();
	Scanner scanner = new Scanner(System.in);
	public void content(){
		SearchProfiles searchprofiles = new SearchProfiles();
		Profile profile = new Profile();
		ApplyCheck applycheck = new ApplyCheck();
        System.out.println("\n1. Profile");
        System.out.println("2. See Available Jobs");
        System.out.println("3. Search Jobs");
        System.out.println("4. Search a Profile");
        System.out.println("5. Post a Job");
        System.out.println("6. Logout\n");
        
        System.out.print("Please select an option: ");
        int choice = scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
        
        switch (choice) {
        case 1:
            // Profile
            profile.readUserProfile();
            break;
        case 2:
            // See Available Jobs
            SeeAvailableJobs.main(null);
            break;
        case 3:
            // Search Jobs
            jobsearch.loadJobData();
            break;
        case 4:
            // Search a Profile
        	searchprofiles.main(null);
            break;
        case 5:
            // Post a Job
            jobpost.JobPost();
            break;
        case 6:
            // Logout
            System.out.println("Logged out successfully.");
            System.exit(0);
            break;
        default:
            System.out.println("Invalid option. Please try again.");
    }
	}
}
