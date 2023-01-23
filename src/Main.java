import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("What's the value of the house: ");
        Scanner houseInput = new Scanner(System.in);
        double houseValue = houseInput.nextDouble();

        System.out.println("What's the loan amount: ");
        Scanner loanInput = new Scanner(System.in);
        double loanAmount = loanInput.nextDouble();

        System.out.println("What's the down payment: ");
        Scanner downpInput = new Scanner(System.in);
        double downPayment = downpInput.nextDouble();

        System.out.println("Is the term 15 or 30 years? ");
        Scanner termInput = new Scanner(System.in);
        int termYears = termInput.nextInt();

        System.out.println("What's the annual interest rate: ");
        Scanner irInput = new Scanner(System.in);
        double interestRate = irInput.nextDouble();

        System.out.println("What's the frequency of payments: ");
        Scanner frequencyInput = new Scanner(System.in);
        String frequencyPay = frequencyInput.nextLine();



        if(frequencyPay.toLowerCase().equals("monthly") || frequencyPay.toLowerCase().equals("biweekly")) {
            MortgageCalculator user = new MortgageCalculator(houseValue, loanAmount, downPayment, termYears, interestRate, frequencyPay);
            double payment = user.calculatePayments();
            String output = String.format("You'll be paying $%.2f on a %s basis", payment, frequencyPay);
            System.out.print(output);
        }
        else
            System.out.println("The <frequency> input isn't valid");

    }




}