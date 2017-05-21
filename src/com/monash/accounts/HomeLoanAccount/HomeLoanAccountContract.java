package com.monash.accounts.HomeLoanAccount;

import com.monash.accounts.SavingAccount.SavingAccount;
import com.sun.istack.internal.NotNull;

/**
 * Created by caidong on 10/05/2017.
 */
public interface HomeLoanAccountContract {
    interface UserActionListener {
        void depositMoney(@NotNull double amount);
        void repayMoney(@NotNull double amount);
        void openAccount(@NotNull long accountId);
        void showAccount();
        void saveAccount();
    }
}
