package com.monash.accounts.TermDepositAccount;

/**
 * Created by caidong on 8/05/2017.
 */
public enum TypeOfTermDeposit {
    THREE_MONTHS(3), SIX_MONTHS(6), TWELEVE_MONTHS(12);

    private final int month;

    TypeOfTermDeposit(int m) {
        this.month = m;
    }
}
