
import java.util.Scanner;

public class StudentExpense {

    String studentName;
    double dailyBudget;
    double foodExpense;
    double travelExpense;
    double studyExpense;
    double otherExpense;

    public double calculateTotalExpense() {
        return foodExpense + travelExpense + studyExpense + otherExpense;
    }

    public double calculateRemainingAmount() {
        return dailyBudget - calculateTotalExpense();
    }

    public boolean isWithinBudget() {
        return calculateTotalExpense() <= dailyBudget;
    }

    public double calculateExceededAmount() {
        if (calculateTotalExpense() > dailyBudget) {
            return calculateTotalExpense() - dailyBudget;
        }

        return 0;
    }

    public String getBudgetStatus() {
        double total = calculateTotalExpense();

        if (total < dailyBudget) {
            return "Within Budget";
        } else if (total == dailyBudget) {
            return "Budget Fully Used";
        } else {
            return "Budget Exceeded";
        }
    }

    public void displayExpenseReport() {

        System.out.println("---------- DAILY EXPENSE REPORT ----------");

        System.out.println("Student Name      : " + studentName);
        System.out.println("Daily Budget      : " + dailyBudget);
        System.out.println("Food Expense      : " + foodExpense);
        System.out.println("Travel Expense    : " + travelExpense);
        System.out.println("Study Expense     : " + studyExpense);
        System.out.println("Other Expense     : " + otherExpense);

        System.out.println("Total Expense     : " + calculateTotalExpense());

        if (isWithinBudget()) {
            System.out.println("Remaining Amount  : " + calculateRemainingAmount());
        } else {
            System.out.println("Exceeded Amount   : " + calculateExceededAmount());
        }

        System.out.println("Budget Status     : " + getBudgetStatus());

        System.out.println("------------------------------------------");
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        StudentExpense expense = new StudentExpense();

        System.out.print("Enter student name: ");
        expense.studentName = scanner.nextLine();

        System.out.print("Enter daily budget: ");
        expense.dailyBudget = scanner.nextDouble();

        System.out.print("Enter food expense: ");
        expense.foodExpense = scanner.nextDouble();

        System.out.print("Enter travel expense: ");
        expense.travelExpense = scanner.nextDouble();

        System.out.print("Enter study expense: ");
        expense.studyExpense = scanner.nextDouble();

        System.out.print("Enter other expense: ");
        expense.otherExpense = scanner.nextDouble();

        expense.displayExpenseReport();

        scanner.close();
    }
}
