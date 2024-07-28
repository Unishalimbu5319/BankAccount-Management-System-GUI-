import javax.print.attribute.HashAttributeSet;

public class DebitCard extends BankCard {
    // attributes of debit card.
    private int pinNumber;
    private int withdrawalAmount;

    private String dateOfWithdrawal;

    private boolean hasWithdrawn;

    public DebitCard(int balanceAmount, int cardID, String bankAccount, String issuerBank, String clientName,
            int pinNumber) {
        super(balanceAmount, cardID, bankAccount, issuerBank);
        super.setClientName(clientName);
        this.pinNumber = pinNumber;
        this.hasWithdrawn = false;
    }

    // Accessor methods for each attribute
    public int getPinNumber() {
        return this.pinNumber;
    }

    public int getWithdrawalAmount() {
        return this.withdrawalAmount;
    }

    public String getDateOfWithdrawal() {
        return this.dateOfWithdrawal;
    }

    public boolean hasWithdrawn() {
        return this.hasWithdrawn;
    }

    // Mutator method for withdrawal amount
    public void setWithdrawalAmount(int withdrawalAmount) {
        this.withdrawalAmount = withdrawalAmount;
    }

    // method to withdraw money
    public boolean withdraw(int withdrawalAmount, String dateOfWithdrawl, int pinNumber) {
        if (getPinNumber() == pinNumber) {
            if (withdrawalAmount <= getBalanceAmount()) {
                this.dateOfWithdrawal = dateOfWithdrawl;
                this.withdrawalAmount = withdrawalAmount;
                setBalanceAmount(getBalanceAmount() - withdrawalAmount);
                hasWithdrawn = true;
                return hasWithdrawn;
            }
        } else {
            System.out.println("Given PIN Number is incorrect. Your withdrawal is unsuccessful.");
            hasWithdrawn = false;
            return hasWithdrawn;
        }
        hasWithdrawn = false;
        return hasWithdrawn;
    }

    public String display() {
        String parentMessage = super.display();
        if (hasWithdrawn()) {
            return parentMessage + "\nPIN Number : " + pinNumber + "\nWithdrawal Amount : " + withdrawalAmount
                    + "\nDate Of Withdrawal : " + dateOfWithdrawal;
        } else {
            return parentMessage + "\nNo transaction has been completed." + "\nBalance Amount : "
                    + super.getBalanceAmount();
        }

    }
}