public class MortgageCalculator {
    public final double houseValue;
    public final double loanAmount;
    public final double downPayment;
    public final int termYears;
    public double interest;
    public final String frequency;

    public double insurance;
    public int numOfPayments;



    MortgageCalculator(double houseValue, double loanAmount, double downPayment, int termYears, double interest, String frequency){
        this.houseValue = houseValue;
        this.loanAmount = loanAmount;
        this.downPayment = downPayment;
        this.termYears = termYears;
        this.frequency = frequency;
        this.insurance = setInsurance(loanAmount);
        this.interest = (interest / 100) / 12; //turn the ARP into a decimal and then into a monthly rate
        this.numOfPayments = termYears * 12; //get number of months for monthly payments, later change this if it's biweekly

    };
    //breaking the steps into some methods, here I'm testing if the downpayment is less than 20% of the home price
    private boolean isLessThan20(double houseValue, double downPayment){
        return downPayment < 0.2 * houseValue;
    }

    //set the value of the insurance
    private double setInsurance(double loanAmount){
        if(isLessThan20(houseValue, downPayment) && frequency.equals("monthly"))
            return 0.01 * loanAmount;
        else if(isLessThan20(houseValue, downPayment) && frequency.equals("biweekly"))
            return 0.0005 * loanAmount;
        else
            return 0.0d;
    }

    public double calculatePayments(){
        double exponent = Math.pow(1.0 + interest, numOfPayments);
        double finalResult = (loanAmount * ((interest * exponent) / (exponent - 1))) + insurance;
        if(frequency.equals("biweekly"))
            finalResult /= 2;
        return finalResult;
    }

}
