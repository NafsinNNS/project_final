package jobSearchAndApplicationManagementSystem;

import java.util.List;

public abstract class JobSearchOption {
    protected List<String> records;

    public abstract void loadJobData();
    
    public abstract void displayMenu();

    public abstract void displayCategoryMenu();

    public abstract String getCategoryByChoice(int choice);

    public abstract void searchAndDisplayResults(List<String> records, int choice, String searchTerm);

    public abstract void searchAndDisplayResultsByCategory(List<String> records, String category);

    public abstract void displayFormattedRecord(String[] parts);
}

