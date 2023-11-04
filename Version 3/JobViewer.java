package jobSearchAndApplicationManagementSystem;

public interface JobViewer {
    void loadJobData(String filename);
    void run();
    void displayCurrentPage();
    void nextPage();
    void previousPage();
    void enterRecordNumber();
    void back();
}

