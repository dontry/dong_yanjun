package com.example.caidong.bsp.accounts.HomeLoanAccount;

import android.support.annotation.NonNull;


/**
 * Created by caidong on 10/05/2017.
 */
public interface HomeLoanAccountContract {
    interface UserActionListener {
        void depositMoney(@NonNull double amount);
        void repayMoney(@NonNull double amount);
        void openAccount(@NonNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
