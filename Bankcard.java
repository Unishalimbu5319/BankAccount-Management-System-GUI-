public class BankCard // parent class
{
    // five attributes of bankcard
    private String clientName;
    private String issuerBank;
    private String bankAccount;

    private int cardId;
    private int balanceAmount;

    // constructors that accepts only 4 parameters.
    public BankCard(int balanceAmount, int cardId, String bankAccount, String issuerBank) {
        // this.refers current object or constructor
        this.clientName = "";
        this.balanceAmount = balanceAmount;
        this.cardId = cardId;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;
    }

    //Accessor Methods For Each Attribute
    public int getCardId() {
        return this.cardId;
    }

    public String getClientName() {
        return this.clientName;
    }

    public String getIssuerBank() {
        return this.issuerBank;
    }

    public String getBankAccount() {
        return this.bankAccount;
    }

    public int getBalanceAmount() {
        return this.balanceAmount;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setBalanceAmount(int balanceAmount) {
        this.balanceAmount = balanceAmount;
    }

    public String display() {
        if (clientName == "") {
            return "ClientName is not assigned";

        } else {
            return "The CardId is " + cardId + "\nThe ClientName is " + clientName + "\nThe IssuerBank is " + issuerBank + "\nThe BankAccount is " + bankAccount + "\nThe BalanceAmount is " + balanceAmount;
        }
    }
}
