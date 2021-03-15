package lab6.account;

public class Account{
    private String accountName;
    private int accountNumber;

    Account(String accountName,int accountNumber){
        this.accountName = accountName;
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return this.accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }
