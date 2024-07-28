import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

class DateGenerator {
    String[] generateDate(int end) {
        String list[] = new String[end];
        for (int i = 1; i <= end; i++) {
            list[i - 1] = Integer.toString(i);
        }
        return list;
    }
}

class InputField extends JTextField {
    public InputField(String title) {
        TitledBorder titledBorder = BorderFactory.createTitledBorder(title);
        Color red = new Color(255, 107, 107);
        Color blue = new Color(77, 150, 255);

        Font bodyFont = new Font("Verdana", Font.PLAIN, 18);

        titledBorder.setTitleFont(bodyFont);
        titledBorder.setTitleColor(red);
        titledBorder.setBorder(BorderFactory.createLineBorder(blue));
        this.setFont(bodyFont);
        this.setBorder(titledBorder);
    }
}

class Btn extends JButton {
    Btn(String text) {
        super(text);
        this.setBackground(new Color(77, 150, 255));
        this.setSize(250, 50);
        this.setFont(new Font("Verdana", Font.PLAIN, 20));
        this.setForeground(Color.WHITE);
        this.setFocusPainted(false);
    }
}

class Label extends JLabel {
    Label(String text) {
        super(text);
        this.setForeground(new Color(255, 107, 107));
        this.setSize(250, 50);
        this.setFont(new Font("Verdana", Font.PLAIN, 20));
    }
}

class ComboBox extends JComboBox<String> {
    ComboBox(String list[]) {
        super(list);
        this.setForeground(new Color(255, 107, 107));
        this.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.setBackground(Color.white);
        this.setSize(40, 30);
    }
}

class TextArea extends JTextArea {
    TextArea(String text) {
        super(text);
        this.setFont(new Font("Verdana", Font.PLAIN, 15));
        this.setForeground(new Color(255, 107, 107));
    }
}

class MenuPanel extends JPanel {
    JLabel mainHeading, sectionTitleCreate, sectionTitleOperation, displayTitle;
    Btn addDebitCard, addCreditCard, withdrawFromDebitCard, setCreditLimit, cancelCreditCard, displayDebitCard,
            displayCreditCard;
    JSeparator line, line1, line2;
    ArrayList<BankCard> bankCards;

    MenuPanel() {
        bankCards = new ArrayList<>();

        Color red = new Color(255, 107, 107);

        mainHeading = new Label("Access Your Bank Cards");
        mainHeading.setBounds(50, 0, 500, 60);
        mainHeading.setFont(new Font("Verdana", Font.BOLD, 30));

        sectionTitleCreate = new JLabel("Create");
        sectionTitleCreate.setFont(new Font("Verdana", Font.PLAIN, 20));
        sectionTitleCreate.setForeground(red);
        sectionTitleCreate.setBounds(50, 50, 300, 50);

        JSeparator line = new JSeparator();
        line.setForeground(new Color(152, 216, 170));
        line.setBounds(sectionTitleCreate.getX(), sectionTitleCreate.getY() + 60, 770, 1);

        addDebitCard = new Btn("Debit Card");
        addDebitCard.setLocation(line.getX(), line.getY() + 10);

        addDebitCard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DebitCardSection d = new DebitCardSection(bankCards);
                if (!d.isDisplayable()) {
                    d.setVisible(true);
                }
            }
        });

        addCreditCard = new Btn("Credit Card");
        addCreditCard.setLocation(addDebitCard.getX() + addDebitCard.getWidth() + 10, line.getY() + 10);

        addCreditCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CreditCardSection c = new CreditCardSection(bankCards);
                if (!c.isDisplayable()) {
                    c.setVisible(true);
                }
            }
        });

        sectionTitleOperation = new JLabel("Operation");
        sectionTitleOperation.setFont(new Font("Verdana", Font.PLAIN, 20));
        sectionTitleOperation.setForeground(red);
        sectionTitleOperation.setBounds(addDebitCard.getX(), addCreditCard.getY() + 60, 300, 50);

        line1 = new JSeparator();
        line1.setForeground(new Color(152, 216, 170));
        line1.setBounds(sectionTitleOperation.getX(), sectionTitleOperation.getY() + 60, 770, 1);

        withdrawFromDebitCard = new Btn("Withdraw");
        withdrawFromDebitCard.setLocation(line1.getX(), line1.getY() + 10);

        withdrawFromDebitCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                WithdrawAmountSection w = new WithdrawAmountSection(bankCards);
                if (!w.isDisplayable()) {
                    w.setVisible(true);
                }
            }

        });

        setCreditLimit = new Btn("Set Credit Limit");
        setCreditLimit.setLocation(withdrawFromDebitCard.getX() + withdrawFromDebitCard.getWidth() + 10,
                line1.getY() + 10);

        setCreditLimit.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                SetCreditSection s = new SetCreditSection(bankCards);
                if (!s.isDisplayable()) {
                    s.setVisible(true);
                }
            }

        });

        cancelCreditCard = new Btn("Cancel Credit Card");
        cancelCreditCard.setLocation(setCreditLimit.getX() + setCreditLimit.getWidth() + 10, line1.getY() + 10);

        cancelCreditCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                CancelCreditSection c = new CancelCreditSection(bankCards);
                if (!c.isDisplayable()) {
                    c.setVisible(true);
                }
            }

        });

        displayTitle = new Label("View Details On Bank Cards");
        displayTitle.setFont(new Font("Verdana", Font.PLAIN, 20));
        displayTitle.setForeground(red);
        displayTitle.setBounds(withdrawFromDebitCard.getX(),
                withdrawFromDebitCard.getY() + withdrawFromDebitCard.getHeight() + 10, 300, 50);

        line2 = new JSeparator();
        line2.setForeground(new Color(152, 216, 170));
        line2.setBounds(displayTitle.getX(), displayTitle.getY() + displayTitle.getHeight() + 10, 770, 1);

        displayDebitCard = new Btn("View Debit Card");
        displayDebitCard.setLocation(line2.getX(), line2.getY() + 10);

        displayDebitCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayDebit d = new DisplayDebit(bankCards);
                if (!d.isDisplayable()) {
                    d.setVisible(true);
                }
            }

        });

        displayCreditCard = new Btn("View Credit Card");
        displayCreditCard.setLocation(displayDebitCard.getX() + displayDebitCard.getWidth() + 10,
                displayDebitCard.getY());

        displayCreditCard.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                DisplayCredit d = new DisplayCredit(bankCards);
                if (!d.isDisplayable()) {
                    d.setVisible(true);
                }
            }
        });

        this.setBackground(Color.white);
        this.add(mainHeading);
        this.add(sectionTitleCreate);
        this.add(line);
        this.add(addDebitCard);
        this.add(addCreditCard);
        this.add(sectionTitleOperation);
        this.add(line1);
        this.add(withdrawFromDebitCard);
        this.add(setCreditLimit);
        this.add(cancelCreditCard);
        this.add(displayTitle);
        this.add(line2);
        this.add(displayDebitCard);
        this.add(displayCreditCard);
        this.setLayout(null);
    }
}

class ContentPanel extends JPanel {
    Label contentSectionTitle;
    JPanel mainPanel;

    ContentPanel(String title) {
        contentSectionTitle = new Label(title);
        contentSectionTitle.setForeground(Color.white);
        contentSectionTitle.setLocation(75, 50);

        mainPanel = new JPanel();
        mainPanel.setBounds(25, 106, 750, 400);
        mainPanel.setBackground(Color.white);
        mainPanel.setLayout(null);

        this.add(mainPanel);
        this.setBackground(new Color(77, 150, 255));
        this.add(contentSectionTitle);
        this.setLayout(null);
        this.setSize(820, 600);
    }
}

class DebitCardSection extends JFrame {
    InputField cardId, clientName, issuerBank, bankAccount, balanceAmount, pinNumber;
    Btn add, exit, clear;
    DebitCard debitCard;
    DebitCardSection mainPanel = this;

    DebitCardSection(ArrayList<BankCard> bankCards) {
        ContentPanel debitContent = new ContentPanel("Add Debit Card");
        // First Row
        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        // PIN NUmber
        pinNumber = new InputField("PIN Number");
        pinNumber.setBounds(cardId.getX() + cardId.getWidth() + 50, cardId.getY(), 300, 60);

        // Second Row
        // Issuer Bank field
        issuerBank = new InputField("Issuer Bank");
        issuerBank.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 20, 300, 60);

        // Client Name field
        clientName = new InputField("Client Name");
        clientName.setBounds(issuerBank.getX() + issuerBank.getWidth() + 50, issuerBank.getY(), 300, 60);

        // Third Row
        // Bank Account field
        bankAccount = new InputField("Bank Account");
        bankAccount.setBounds(issuerBank.getX(), clientName.getY() + clientName.getHeight() + 20, 300, 60);

        // Balance Amount field
        balanceAmount = new InputField("Balance Amount");
        balanceAmount.setBounds(bankAccount.getX() + bankAccount.getWidth() + 50, bankAccount.getY(), 300, 60);

        add = new Btn("Add");
        add.setBounds(bankAccount.getX(), bankAccount.getY() + bankAccount.getHeight() + 20, 200, 50);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userBankAccout = bankAccount.getText();
                String userIssuerBank = issuerBank.getText();
                String userName = clientName.getText();

                try {
                    int userBalance = Integer.parseInt(balanceAmount.getText()),
                            userCardId = Integer.parseInt(cardId.getText()),
                            userPin = Integer.parseInt(pinNumber.getText());

                    if (!balanceAmount.getText().equals("") && !cardId.getText().equals("")
                            && !userBankAccout.equals("")
                            && !userIssuerBank.equals("") && !userName.equals("") && !pinNumber.getText().equals("")) {
                        debitCard = new DebitCard(userBalance, userCardId, userBankAccout, userIssuerBank, userName,
                                userPin);

                        bankCards.add(debitCard);

                        JOptionPane.showMessageDialog(rootPane, "Debit Card Sucessfully Created!!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "All Fields Need To be filled!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Only Numbers are allowed for Balance Amount, Card Id and PIN Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(add.getX() + add.getWidth() + 23, add.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }

        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
                pinNumber.setText("");
                issuerBank.setText("");
                clientName.setText("");
                bankAccount.setText("");
                balanceAmount.setText("");
            }
        });

        JComponent debitContentMainPanel = (JComponent) debitContent.getComponent(0);

        debitContentMainPanel.add(cardId);
        debitContentMainPanel.add(pinNumber);
        debitContentMainPanel.add(issuerBank);
        debitContentMainPanel.add(clientName);
        debitContentMainPanel.add(bankAccount);
        debitContentMainPanel.add(balanceAmount);

        debitContentMainPanel.add(add);
        debitContentMainPanel.add(exit);
        debitContentMainPanel.add(clear);

        this.add(debitContent);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(debitContent.getWidth(), debitContent.getHeight());
    }
}

class CreditCardSection extends JFrame {
    InputField cardId, clientName, issuerBank, bankAccount, balanceAmount, cvcNumber, interestRate;
    Btn add, exit, clear;
    Label dayLabel, monthLabel, yearLabel, expirationDate;
    Font dateFont;
    CreditCard creditCard;
    CreditCardSection mainPanel = this;

    CreditCardSection(ArrayList<BankCard> bankCards) {
        ContentPanel creditContent = new ContentPanel("Add Credit Card");
        creditContent.setSize(creditContent.getWidth(), 700);

        DateGenerator dates = new DateGenerator();
        dateFont = new Font("Verdana", Font.PLAIN, 15);

        // First Row
        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        // PIN NUmber
        cvcNumber = new InputField("CVC Number");
        cvcNumber.setBounds(cardId.getX() + cardId.getWidth() + 50, cardId.getY(), 300, 60);

        // Second Row
        // Issuer Bank field
        issuerBank = new InputField("Issuer Bank");
        issuerBank.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 20, 300, 60);

        // Client Name field
        clientName = new InputField("Client Name");
        clientName.setBounds(issuerBank.getX() + issuerBank.getWidth() + 50, issuerBank.getY(), 300, 60);

        // Third Row
        // Bank Account field
        bankAccount = new InputField("Bank Account");
        bankAccount.setBounds(issuerBank.getX(), clientName.getY() + clientName.getHeight() + 20, 300, 60);

        // Balance Amount field
        balanceAmount = new InputField("Balance Amount");
        balanceAmount.setBounds(bankAccount.getX() + bankAccount.getWidth() + 50, bankAccount.getY(), 300, 60);

        // Fourth Row
        interestRate = new InputField("Interest Rate");
        interestRate.setBounds(bankAccount.getX(), balanceAmount.getY() + balanceAmount.getHeight() + 20, 300, 60);

        expirationDate = new Label("Expiration Date");
        expirationDate.setFont(dateFont);
        expirationDate.setBounds(interestRate.getX() + interestRate.getWidth() + 50, interestRate.getY(), 250, 30);
        expirationDate.setForeground(new Color(77, 150, 255));

        String yearArray[] = dates.generateDate(10);

        for (int i = 0; i < yearArray.length; i++) {
            yearArray[i] = "202" + i;
        }

        dayLabel = new Label("day");
        dayLabel.setBounds(expirationDate.getX(), interestRate.getY() + interestRate.getHeight() - 30, 30, 30);
        dayLabel.setFont(dateFont);

        JComboBox<String> date = new ComboBox(dates.generateDate(31));
        date.setBounds(dayLabel.getX() + dayLabel.getWidth() + 5, dayLabel.getY(), 40, 30);
        date.setFont(dateFont);

        monthLabel = new Label("month");
        monthLabel.setBounds(date.getX() + date.getWidth() + 5, date.getY(), 50, 30);
        monthLabel.setFont(dateFont);

        JComboBox<String> month = new ComboBox(dates.generateDate(12));
        month.setBounds(monthLabel.getX() + monthLabel.getWidth() + 5, monthLabel.getY(), 40, 30);
        month.setFont(dateFont);

        yearLabel = new Label("year");
        yearLabel.setBounds(month.getX() + month.getWidth() + 5, month.getY(), 40, 30);
        yearLabel.setFont(dateFont);

        JComboBox<String> year = new ComboBox(yearArray);
        year.setBounds(yearLabel.getX() + yearLabel.getWidth() + 5, yearLabel.getY(), 72, 30);
        year.setFont(dateFont);

        add = new Btn("Add");
        add.setBounds(interestRate.getX(), interestRate.getY() + interestRate.getHeight() + 20, 200, 50);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userBankAccout = bankAccount.getText();
                String userIssuerBank = issuerBank.getText();
                String userName = clientName.getText();
                String userExpirationDate = date.getSelectedItem().toString() + "/" + month.getSelectedItem().toString()
                        + "/" + year.getSelectedItem().toString();

                try {
                    int userBalance = Integer.parseInt(balanceAmount.getText()),
                            userCardId = Integer.parseInt(cardId.getText()),
                            userCVC = Integer.parseInt(cvcNumber.getText());
                    double userInterestRate = Double.parseDouble(interestRate.getText());

                    if (!balanceAmount.getText().equals("") && !cardId.getText().equals("")
                            && !userBankAccout.equals("")
                            && !userIssuerBank.equals("") && !userName.equals("") && !cvcNumber.getText().equals("")
                            && !interestRate.getText().equals("") && !userExpirationDate.equals("")) {
                        creditCard = new CreditCard(userBalance, userCardId, userBankAccout, userIssuerBank, userName,
                                userCVC, userInterestRate, userExpirationDate);

                        bankCards.add(creditCard);

                        JOptionPane.showMessageDialog(rootPane, "Credit Card Sucessfully Created!!", "Sucess", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "All Fields Need To be filled!!", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception exception) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Only Numbers are allowed for Balance Amount, Card Id and CVC Number", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(add.getX() + add.getWidth() + 23, add.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }

        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
                cvcNumber.setText("");
                issuerBank.setText("");
                clientName.setText("");
                bankAccount.setText("");
                balanceAmount.setText("");
                interestRate.setText("");
                date.setSelectedItem("1");
                month.setSelectedItem("1");
                year.setSelectedItem("2020");
            }
        });

        JComponent creditContentMainPanel = (JComponent) creditContent.getComponent(0);
        creditContentMainPanel.setSize(creditContentMainPanel.getWidth(), 500);
        creditContentMainPanel.add(cardId);
        creditContentMainPanel.add(cvcNumber);
        creditContentMainPanel.add(issuerBank);
        creditContentMainPanel.add(clientName);
        creditContentMainPanel.add(bankAccount);
        creditContentMainPanel.add(balanceAmount);
        creditContentMainPanel.add(interestRate);

        creditContentMainPanel.add(expirationDate);

        creditContentMainPanel.add(dayLabel);
        creditContentMainPanel.add(date);

        creditContentMainPanel.add(monthLabel);
        creditContentMainPanel.add(month);

        creditContentMainPanel.add(yearLabel);
        creditContentMainPanel.add(year);

        creditContentMainPanel.add(add);
        creditContentMainPanel.add(exit);
        creditContentMainPanel.add(clear);

        this.add(creditContent);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(creditContent.getWidth(), creditContent.getHeight());
    }
}

class WithdrawAmountSection extends JFrame {
    InputField cardId, pinNumber, withdrawlAmount;
    Label withdrawlDate, dayLabel, monthLabel, yearLabel;
    Btn withdraw, exit, clear;
    DebitCard debitCard;
    WithdrawAmountSection mainPanel = this;
    ComboBox date, month, year;
    Font dateFont;

    WithdrawAmountSection(ArrayList<BankCard> bankCards) {
        ContentPanel withdrawAmountSection = new ContentPanel("Add Debit Card");
        DateGenerator dates = new DateGenerator();
        dateFont = new Font("Verdana", Font.PLAIN, 15);

        // First Row
        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        // PIN NUmber
        pinNumber = new InputField("PIN Number");
        pinNumber.setBounds(cardId.getX() + cardId.getWidth() + 50, cardId.getY(), 300, 60);

        // Second Row
        withdrawlAmount = new InputField("Withdrawl Amount");
        withdrawlAmount.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 50, 300, 60);

        withdrawlDate = new Label("Withdrawl Date");
        withdrawlDate.setFont(dateFont);
        withdrawlDate.setBounds(withdrawlAmount.getX() + withdrawlAmount.getWidth() + 50, withdrawlAmount.getY(), 250,
                30);
        withdrawlDate.setForeground(new Color(77, 150, 255));

        String yearArray[] = dates.generateDate(10);

        for (int i = 0; i < yearArray.length; i++) {
            yearArray[i] = "202" + i;
        }

        dayLabel = new Label("day");
        dayLabel.setBounds(withdrawlDate.getX(), withdrawlAmount.getY() + withdrawlAmount.getHeight() - 30, 30, 30);
        dayLabel.setFont(dateFont);

        JComboBox<String> date = new ComboBox(dates.generateDate(31));
        date.setBounds(dayLabel.getX() + dayLabel.getWidth() + 5, dayLabel.getY(), 40, 30);
        date.setFont(dateFont);

        monthLabel = new Label("month");
        monthLabel.setBounds(date.getX() + date.getWidth() + 5, date.getY(), 50, 30);
        monthLabel.setFont(dateFont);

        JComboBox<String> month = new ComboBox(dates.generateDate(12));
        month.setBounds(monthLabel.getX() + monthLabel.getWidth() + 5, monthLabel.getY(), 40, 30);
        month.setFont(dateFont);

        yearLabel = new Label("year");
        yearLabel.setBounds(month.getX() + month.getWidth() + 5, month.getY(), 40, 30);
        yearLabel.setFont(dateFont);

        JComboBox<String> year = new ComboBox(yearArray);
        year.setBounds(yearLabel.getX() + yearLabel.getWidth() + 5, yearLabel.getY(), 72, 30);
        year.setFont(dateFont);

        withdraw = new Btn("Withdraw");
        withdraw.setBounds(withdrawlAmount.getX(), withdrawlAmount.getY() + withdrawlAmount.getHeight() + 50, 200, 50);

        withdraw.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<BankCard> bankCardsIterator = bankCards.iterator();

                String userWithdrawlDate = date.getSelectedItem().toString() + "/" + month.getSelectedItem().toString()
                        + "/" + year.getSelectedItem().toString();

                String message = "Card Id : " + cardId.getText() + "\nPIN Number : " + pinNumber.getText()
                + "\nWithdrawl Date : " + userWithdrawlDate + "\nWithdrawl Amount : "
                + withdrawlAmount.getText();

                try {
                    int userWithdrawAmount = Integer.parseInt(withdrawlAmount.getText());

                    int userPin = Integer.parseInt(pinNumber.getText());

                    if (!pinNumber.getText().equals("") && !withdrawlAmount.getText().equals("")
                        && !cardId.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, message, "Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please Fill All The Fields!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (!bankCardsIterator.hasNext()) {
                    JOptionPane.showMessageDialog(rootPane,
                            "No cards have been added\nFirst Add The Card And Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                }

                while (bankCardsIterator.hasNext()) {
                    BankCard card = bankCardsIterator.next();
                    if (card instanceof DebitCard) {
                        DebitCard tempCard = (DebitCard) card;
                        if (Integer.parseInt(cardId.getText()) == card.getCardId()) {
                            if (tempCard.withdraw(userWithdrawAmount, userWithdrawlDate, userPin)) {
                                JOptionPane.showMessageDialog(rootPane,
                                        "Successfully Withdrawn!!\nYour remaining balance is "
                                                + tempCard.getBalanceAmount(), "Success", JOptionPane.INFORMATION_MESSAGE);
                            } else {
                                JOptionPane.showMessageDialog(rootPane,
                                        "Incorrect PIN Number\nCheck Again and Re-Enter", "Error", JOptionPane.ERROR_MESSAGE);
                            }
                        }
                    }
                }
                } catch (NumberFormatException exception) {
                    JOptionPane.showMessageDialog(rootPane,
                            "Only Numbers are allowed for Withdrawl Amount and PIN Number", "Error", JOptionPane.ERROR_MESSAGE);
                } 
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(withdraw.getX() + withdraw.getWidth() + 23, withdraw.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }
        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
                pinNumber.setText("");
                withdrawlAmount.setText("");
                date.setSelectedItem("1");
                month.setSelectedItem("1");
                year.setSelectedItem("2020");
            }
        });

        JComponent withdrawAmountSectionMainPanel = (JComponent) withdrawAmountSection.getComponent(0);

        withdrawAmountSectionMainPanel.add(cardId);
        withdrawAmountSectionMainPanel.add(pinNumber);
        withdrawAmountSectionMainPanel.add(withdrawlAmount);
        withdrawAmountSectionMainPanel.add(withdrawlDate);

        withdrawAmountSectionMainPanel.add(dayLabel);
        withdrawAmountSectionMainPanel.add(date);
        withdrawAmountSectionMainPanel.add(monthLabel);
        withdrawAmountSectionMainPanel.add(month);
        withdrawAmountSectionMainPanel.add(yearLabel);
        withdrawAmountSectionMainPanel.add(year);

        withdrawAmountSectionMainPanel.add(withdraw);
        withdrawAmountSectionMainPanel.add(exit);
        withdrawAmountSectionMainPanel.add(clear);

        this.add(withdrawAmountSection);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(withdrawAmountSection.getWidth(), withdrawAmountSection.getHeight());
    }
}

class SetCreditSection extends JFrame {
    InputField cardId, creditLimit, gracePeriod;
    Btn set, exit, clear;
    CreditCard creditCard;
    SetCreditSection mainPanel = this;
    Font dateFont;

    SetCreditSection(ArrayList<BankCard> bankCards) {
        ContentPanel setCreditSection = new ContentPanel("Set Credit Limit");
        dateFont = new Font("Verdana", Font.PLAIN, 15);

        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        gracePeriod = new InputField("New Grace Period (months)");
        gracePeriod.setFont(dateFont);
        gracePeriod.setBounds(cardId.getX() + cardId.getWidth() + 50, cardId.getY(), 300, 60);

        creditLimit = new InputField("New Credit Limit");
        creditLimit.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 20, 300, 60);

        set = new Btn("Set");
        set.setBounds(creditLimit.getX(), creditLimit.getY() + creditLimit.getHeight() + 20, 200, 50);

        set.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<BankCard> bankCardsIterator = bankCards.iterator();
                Double userCreditLimit = 0.0;
                int userGracePeriod = 0;
                Boolean isSetCredit = false;
                String tempMessage = "";

                String message = "Card Id : " + cardId.getText() + "\nNew Grace Period : " + gracePeriod.getText()
                        + " months";

                if (!creditLimit.getText().equals("") && !gracePeriod.getText().equals("")
                        && !cardId.getText().equals("")) {
                    JOptionPane.showMessageDialog(rootPane, message, "Details", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Please Fill All The Fields!!", "Error", JOptionPane.ERROR_MESSAGE);
                }

                if (!bankCardsIterator.hasNext()) {
                    JOptionPane.showMessageDialog(rootPane,
                            "No cards have been added\nFirst Add The Card And Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    while (bankCardsIterator.hasNext()) {
                        BankCard card = bankCardsIterator.next();
                        if (card instanceof CreditCard) {
                            CreditCard tempCard = (CreditCard) card;

                            if (!creditLimit.getText().equals("")) {
                                userCreditLimit = Double.parseDouble(creditLimit.getText());
                            }

                            if (!gracePeriod.getText().equals("")) {
                                userGracePeriod = Integer.parseInt(gracePeriod.getText());
                            }

                            if (Integer.parseInt(cardId.getText()) == tempCard.getCardId()) {
                                tempCard.setCreditLimit(userCreditLimit, userGracePeriod);
                                tempMessage = tempCard.display();
                                isSetCredit = true;
                            }
                        }
                    }
                    if (isSetCredit) {
                        JOptionPane.showMessageDialog(rootPane, tempMessage);
                    } else {
                        JOptionPane.showMessageDialog(rootPane,
                                "Your Card ID is incorrect!!\nPlease Re Check the details and try again", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(set.getX() + set.getWidth() + 23, set.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }
        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
                creditLimit.setText("");
                gracePeriod.setText("");
            }
        });

        JComponent setCreditMainPanel = (JComponent) setCreditSection.getComponent(0);

        setCreditMainPanel.add(cardId);
        setCreditMainPanel.add(gracePeriod);
        setCreditMainPanel.add(creditLimit);

        setCreditMainPanel.add(set);
        setCreditMainPanel.add(exit);
        setCreditMainPanel.add(clear);
        setCreditMainPanel.setSize(setCreditMainPanel.getWidth(), 325);

        setCreditSection.setSize(setCreditSection.getWidth(), 550);

        this.add(setCreditSection);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(setCreditSection.getWidth(), setCreditSection.getHeight());
    }
}

class CancelCreditSection extends JFrame {
    InputField cardId;
    Btn cancel, exit, clear;
    CreditCard creditCard;
    CancelCreditSection mainPanel = this;

    CancelCreditSection(ArrayList<BankCard> bankCards) {
        ContentPanel cancelCreditSection = new ContentPanel("Cancel Credit Card");

        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        cancel = new Btn("Cancel");
        cancel.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 20, 200, 50);

        cancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<BankCard> bankCardsIterator = bankCards.iterator();
                boolean isCardCorrect = false;
                String tempMessage = "";

                if (!bankCardsIterator.hasNext()) {
                    JOptionPane.showMessageDialog(rootPane,
                            "No cards have been added\nFirst Add The Card And Try Again", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    while (bankCardsIterator.hasNext()) {
                        BankCard card = bankCardsIterator.next();
                        if (card instanceof CreditCard) {
                            CreditCard tempCard = (CreditCard) card;

                            if (Integer.parseInt(cardId.getText()) == card.getCardId()) {
                                tempCard.cancelCreditCard();
                                isCardCorrect = true;
                                tempMessage = tempCard.display();
                                break;
                            }
                        }
                    }

                    if (isCardCorrect) {
                        JOptionPane.showMessageDialog(rootPane, tempMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "Incorrect Card Id \nRe-Check Your Details", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(cancel.getX() + cancel.getWidth() + 23, cancel.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }
        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
            }
        });

        JComponent setCreditMainPanel = (JComponent) cancelCreditSection.getComponent(0);
        setCreditMainPanel.setSize(setCreditMainPanel.getWidth(), 250);
        setCreditMainPanel.add(cardId);

        setCreditMainPanel.add(cancel);
        setCreditMainPanel.add(exit);
        setCreditMainPanel.add(clear);

        cancelCreditSection.setSize(cancelCreditSection.getWidth(), 500);

        this.add(cancelCreditSection);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(cancelCreditSection.getWidth(), cancelCreditSection.getHeight());
    }
}

class DisplayDebit extends JFrame {
    InputField cardId;
    Btn display, exit, clear;
    DebitCard debitCard;
    DisplayDebit mainPanel = this;

    DisplayDebit(ArrayList<BankCard> bankCards) {
        ContentPanel displayDebitSection = new ContentPanel("Cancel Credit Card");
        JComponent displayDebitMainPanel = (JComponent) displayDebitSection.getComponent(0);

        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        display = new Btn("Display");
        display.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 20, 200, 50);

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<BankCard> bankCardsIterator = bankCards.iterator();
                Boolean isDebitCard = false;
                while (bankCardsIterator.hasNext()) {
                    BankCard card = bankCardsIterator.next();
                    if (card instanceof DebitCard) {
                        DebitCard tempCard = (DebitCard) card;
                        isDebitCard = true;
                        if (Integer.parseInt(cardId.getText()) == card.getCardId()) {
                            JFrame display = new JFrame();
                            display.setBounds(100, 100, 800, 500);
                            display.setBackground(Color.WHITE);

                            TextArea displayArea = new TextArea(tempCard.display());
                            System.out.println(tempCard.hasWithdrawn());
                            displayArea.setBounds(100, 100, 250, 500);

                            display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            display.add(displayArea);

                            if (!display.isDisplayable()) {
                                display.setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane,
                                    "The Card ID doesn't exist!!\nPlease Check It Again..", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                if (!isDebitCard) {
                    JOptionPane.showMessageDialog(rootPane,
                            "No Debit Cards Have Been Saved.\nPlease Register One Debit Card Before Proceeding", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(display.getX() + display.getWidth() + 23, display.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }
        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
            }
        });

        displayDebitMainPanel.setSize(displayDebitMainPanel.getWidth(), 250);
        displayDebitMainPanel.add(cardId);
        displayDebitMainPanel.add(display);
        displayDebitMainPanel.add(exit);
        displayDebitMainPanel.add(clear);

        displayDebitSection.setSize(displayDebitSection.getWidth(), 500);

        this.add(displayDebitSection);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(displayDebitSection.getWidth(), displayDebitSection.getHeight());
    }
}

class DisplayCredit extends JFrame {
    InputField cardId;
    Btn display, exit, clear;
    DebitCard debitCard;
    DisplayCredit mainPanel = this;

    DisplayCredit(ArrayList<BankCard> bankCards) {
        ContentPanel displayCreditSection = new ContentPanel("Cancel Credit Card");
        JComponent displayCreditMainPanel = (JComponent) displayCreditSection.getComponent(0);

        // Card ID field
        cardId = new InputField("Card Id");
        cardId.setBounds(50, 50, 300, 60);

        display = new Btn("Display");
        display.setBounds(cardId.getX(), cardId.getY() + cardId.getHeight() + 20, 200, 50);

        display.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Iterator<BankCard> bankCardsIterator = bankCards.iterator();
                Boolean isCreditCard = false;
                while (bankCardsIterator.hasNext()) {
                    BankCard card = bankCardsIterator.next();
                    if (card instanceof CreditCard) {
                        CreditCard tempCard = (CreditCard) card;
                        isCreditCard = true;

                        if (Integer.parseInt(cardId.getText()) == card.getCardId()) {
                            JFrame display = new JFrame();
                            display.setBounds(100, 100, 800, 500);
                            display.setBackground(Color.WHITE);

                            TextArea displayArea = new TextArea(tempCard.display());
                            displayArea.setBounds(100, 100, 250, 500);

                            display.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                            display.add(displayArea);

                            if (!display.isDisplayable()) {
                                display.setVisible(true);
                            }
                        } else {
                            JOptionPane.showMessageDialog(rootPane,
                                    "The Card ID doesn't exist!!\nPlease Check It Again..", "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                }
                if (!isCreditCard) {
                    JOptionPane.showMessageDialog(rootPane,
                            "No Credit Cards Have Been Saved.\nPlease Register One Credit Card Before Proceeding", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        exit = new Btn("Exit");
        exit.setBounds(display.getX() + display.getWidth() + 23, display.getY(), 200, 50);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (mainPanel.isDisplayable()) {
                    mainPanel.setVisible(false);
                }
            }
        });

        clear = new Btn("Clear");
        clear.setBounds(exit.getX() + exit.getWidth() + 23, exit.getY(), 200, 50);

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardId.setText("");
            }
        });

        displayCreditMainPanel.setSize(displayCreditMainPanel.getWidth(), 250);
        displayCreditMainPanel.add(cardId);
        displayCreditMainPanel.add(display);
        displayCreditMainPanel.add(exit);
        displayCreditMainPanel.add(clear);

        displayCreditSection.setSize(displayCreditSection.getWidth(), 500);

        this.add(displayCreditSection);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(displayCreditSection.getWidth(), displayCreditSection.getHeight());
    }
}

public class BankGUI extends JFrame {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    double width = screenSize.getWidth();
    double height = screenSize.getHeight();

    public BankGUI() {
        MenuPanel menu = new MenuPanel();
        menu.setBounds(0, 0, 870, 550);

        this.setTitle("Bank GUI");
        this.add(menu);
        this.setLayout(null);
        this.setSize(menu.getWidth(), menu.getHeight());
        this.setLocation((int) width / 2 - 400, 100);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            public void run() {
                new BankGUI();
            }
        }).start();
    }
}