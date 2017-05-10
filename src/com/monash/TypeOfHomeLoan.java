package com.monash;

/**
 * Created by caidong on 9/05/2017.
 */
public enum TypeOfHomeLoan {
    FIVE_YEARS(5), TEN_YEARS(10), TWENTY_YEARS(20), THIRTY_YEARS(30);

    private int months;
    TypeOfHomeLoan(int years) {
        months = 12 * years;
    }
}
