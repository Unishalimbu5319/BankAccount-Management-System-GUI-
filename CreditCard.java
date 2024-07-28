public class CreditCard extends BankCard // child class
{
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;

    public CreditCard(int balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName,
            int cvcNumber, double interestRate, String expirationDate) {
        // parent class
        super(balanceAmount, cardID, bankAccount, issuerBank);
        super.setClientName(clientName);

        this.cvcNumber = cvcNumber;
        // this.creditLimit = creditLimit;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        // this.gracePeriod = gracePeriod;
        this.isGranted = false;
    }

    public int getCvcNumber() {
        return cvcNumber;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public int getGracePeriod() {
        return gracePeriod;
    }

    public boolean getIsGranted() {
        return this.isGranted;
    }

    public void cancelCreditCard() {
        this.gracePeriod = 0;
        this.cvcNumber = 0;
        this.creditLimit = 0;
        this.isGranted = false;
    }

    public void setCreditLimit(double creditLimit, int gracePeriod) {
        if (creditLimit <= (2.5 * getBalanceAmount())) {
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            this.isGranted = true;
        } else {
            System.out.println("Credit cannot be issued.");
        }
    }

    public String display() {
        String parentMessage = super.display();
        if (isGranted) {
            return parentMessage + "\nThe Credit Limit is :" + creditLimit + "\nThe Grace Period is :" + gracePeriod + "\nThe InterestRate is : " + interestRate + "\nThe Expiration Date is : " + expirationDate + "\nThe CVC number is : " + cvcNumber;

        } else {
            return parentMessage + "\nThe Credit has not been granted." + "\nThe InterestRate is : " + interestRate + "\nThe Expiratio Date is :" + expirationDate + "\nThe CVC number is : " + cvcNumber;
        }
    }
}