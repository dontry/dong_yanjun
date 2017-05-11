package banksystemprototype.accounts.TermDepositAccount;

/**
 * Created by caidong on 8/05/2017.
 */
public enum TypeOfTermDeposit {
    THREE_MONTHS(3), SIX_MONTHS(6), TWELVE_MONTHS(12);

    private final int month;

    TypeOfTermDeposit(int m) {
        this.month = m;
    }
    
    int month(){
        return month;
    }
}
