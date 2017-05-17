package banksystemprototype.accounts.CreditCardAccount;

import banksystemprototype.accounts._Account;
import banksystemprototype.accounts.TypeOfAccount;


/**
 * Created by caidong on 8/05/2017.
 */
public class CreditCardAccount extends _Account {
    private double mWithdrawDailyLimit;
    private double mLoanLimit;
    private double dailyWithdrawal;

    public CreditCardAccount(long accountId, String username, TypeOfAccount typeOfAccount, boolean locked, double balance, double withdrawDailyLimit, double loanLimit) {
        super(accountId, username, typeOfAccount, locked, balance);
        mWithdrawDailyLimit = withdrawDailyLimit;
        mLoanLimit = loanLimit;
        dailyWithdrawal = 0;
    }

    public double getDailyWithdrawal() {
        return dailyWithdrawal;
    }

    public double getmWithdrawDailyLimit() {
        return mWithdrawDailyLimit;
    }

    public double getmLoanLimit() {
        return mLoanLimit;
    }

    public void setWithdrawDailyLimit(double withdrawDailyLimit) {
        mWithdrawDailyLimit = withdrawDailyLimit;
    }

    public void setLoanLimit(double loanLimit) {
        mLoanLimit = loanLimit;
    }

    public void addMoney(double amount) {
        super.setBalance(super.getBalance() + amount);
    }

    public void deductMoney(double amount) {
        super.setBalance(super.getBalance() - amount);
    }
}
