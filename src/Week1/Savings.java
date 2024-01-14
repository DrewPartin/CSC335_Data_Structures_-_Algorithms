package Week1;

public class Savings {
    static int savingsGoal = 0;
    static int monthlySavings = 0;

    // Recursive Function to calculate the number of months required to reach a savings goal.
    static int calculateMonthsToGoal(int currentSavings) {
        // Base Case
        if (currentSavings >= savingsGoal) {
            return 0;
        }
        // Recursive Case
        else {
            return 1 + calculateMonthsToGoal(currentSavings + monthlySavings);
        }
    }

    //public static void main(String[] args) {
    //    Scanner scannerMain = new Scanner(System.in);
    //    System.out.println("Enter your current savings: ");
    //    int _currentSavings = scannerMain.nextInt();
    //    System.out.println("Enter your savings goal: ");
    //    savingsGoal = scannerMain.nextInt();
    //    System.out.println("Enter your monthly savings: ");
    //    monthlySavings = scannerMain.nextInt();
    //    System.out.println("It will take " + calculateMonthsToGoal(_currentSavings) + " months to reach your savings goal.");
    //}
}