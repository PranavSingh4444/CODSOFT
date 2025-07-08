import java.util.Scanner;

public class GradeCalculator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ask how many subjects
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();

        int[] marks = new int[numSubjects];
        int totalMarks = 0;

        // Input marks for each subject
        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Enter marks for Subject " + (i + 1) + " (out of 100): ");
            marks[i] = scanner.nextInt();

            // Validate marks
            while (marks[i] < 0 || marks[i] > 100) {
                System.out.print("Invalid input! Please enter marks between 0 and 100: ");
                marks[i] = scanner.nextInt();
            }

            totalMarks += marks[i];
        }

        // Calculate average
        double averagePercentage = (double) totalMarks / numSubjects;

        // Grade calculation
        char grade;
        if (averagePercentage >= 90) {
            grade = 'A';
        } else if (averagePercentage >= 80) {
            grade = 'B';
        } else if (averagePercentage >= 70) {
            grade = 'C';
        } else if (averagePercentage >= 60) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // Display results
        System.out.println("\n STUDENT RESULT SUMMARY ");
        System.out.println("Total Marks     : " + totalMarks);
        System.out.printf("Average Percent : %.2f%%\n", averagePercentage);
        System.out.println("Grade           : " + grade);

        scanner.close();
    }
}
