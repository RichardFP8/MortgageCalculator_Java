public class Monthly {

    private final double houseValue;
    private final double loanAmount;
    private final double downPayment;
    private final int termYears;
    private final double interest;


    Monthly(double houseValue, double loanAmount, double downPayment, int termYears, double interest){
        double mortgageInsurance = 0.01 * houseValue;
        this.houseValue = houseValue;
        this.loanAmount = loanAmount;
        this.downPayment = downPayment;
        this.termYears = termYears;
        this.interest = interest;

    }
}
