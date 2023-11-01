package jobSearchAndApplicationManagementSystem;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class JobRecord{
    public static void main(String args[]){
        String filePath = "job_records.txt";

        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))){
            String[] jobRecords = {
                "Company A,Software Engineer,Computer Science,Bachelor's,3.0,Description 1,80000,Full-Time,123 Main St,companyA@example.com,123-456-7890,2023-12-31",
                "Company B,Data Analyst,Statistics,Bachelor's,3.5,Description 2,60000,Full-Time,456 Elm St,companyB@example.com,987-654-3210,2023-11-30",
                "Company C,Marketing Manager,Marketing,Master's,3.2,Description 3,90000,Full-Time,456 Elm St,companyC@example.com,567-890-1234,2023-12-15",
                "Company D,Software Engineer,Computer Science,Bachelor's,3.3,Description 4,87000,Full-Time,123 Main St,companyD@example.com,123-456-7890,2023-10-11",
                "Company E,Data Analyst,Statistics,Bachelor's,3.8,Description 5,65000,Full-Time,123 Main St,companyE@example.com,987-654-3210,2023-09-25",
                "Company F,Marketing Manager,Marketing,Master's,3.5,Description 6,93000,Full-Time,456 Elm St,companyF@example.com,567-890-1234,2023-06-15",
                "Company G,Data Analyst,Statistics,Bachelor's,3.6,Description 7,80000,Full-Time,456 Elm St,companyG@example.com,987-654-3210,2023-04-13",
                "Company H,Marketing Manager,Marketing,Master's,3.7,Description 8,98000,Full-Time,456 Elm St,companyH@example.com,567-890-1234,2023-03-22",
                "Company I,Software Engineer,Computer Science,Bachelor's,3.9,Description 9,100000,Full-Time,123 Main St,companyI@example.com,123-456-7890,2023-11-21",
                "Company J,Data Analyst,Statistics,Bachelor's,3.4,Description 10,70000,Full-Time,123 Main St,companyJ@example.com,987-654-3210,2023-12-28"
               
                
            };

            for(String record:jobRecords)
            {
                writer.write(record);
                writer.newLine();
            }
            System.out.println("Job records have been saved to " + filePath);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

