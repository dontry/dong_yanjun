package com.example.caidong.bsp.accounts.CreditCardAccount;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.caidong.bsp.R;
import com.example.caidong.bsp.accounts.HomeLoanAccount.HomeLoanAccountActivity;
import com.example.caidong.bsp.accounts.SavingAccount.SavingAccountActivity;
import com.example.caidong.bsp.accounts.TermDepositAccount.TermDepositAccountActivity;

public class CreditCardAccountActivity extends AppCompatActivity implements View.OnClickListener{
    protected Button btnTermDeposit;
    protected Button btnSaving;
    protected Button btnCreditCard;
    protected Button btnHomeLoan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credit_card_account);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_saving_account:
                Intent intent = new Intent(this, SavingAccountActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_credit_card_account:
                Intent intent1 = new Intent(this, CreditCardAccountActivity.class);
                break;
            case R.id.btn_home_loan_account:
                Intent intent2 = new Intent(this, HomeLoanAccountActivity.class);
                break;
            case R.id.btn_term_deposit_account:
                Intent intent3 = new Intent(this, TermDepositAccountActivity.class);
                break;
        }
    }
}
