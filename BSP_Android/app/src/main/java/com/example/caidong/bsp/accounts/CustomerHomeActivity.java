package com.example.caidong.bsp.accounts;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.caidong.bsp.R;
import com.example.caidong.bsp.Utils.DataConverter;
import com.example.caidong.bsp.accounts.CreditCardAccount.CrediCardAccount;
import com.example.caidong.bsp.accounts.CreditCardAccount.CreditCardAccountActivity;
import com.example.caidong.bsp.accounts.HomeLoanAccount.HomeLoanAccount;
import com.example.caidong.bsp.accounts.HomeLoanAccount.HomeLoanAccountActivity;
import com.example.caidong.bsp.accounts.SavingAccount.SavingAccount;
import com.example.caidong.bsp.accounts.TermDepositAccount.TermDepositAccount;
import com.example.caidong.bsp.users.Customer;
import com.example.caidong.bsp.users.CustomerProfileActivity;

public class CustomerHomeActivity extends AppCompatActivity implements AccountContract.CustomerHomeView{
    public static final String ACCOUNT_ID = "account_id";
    private static final String CUSTOMER = "Customer";
    private Button btnSavingAccount;
    private Button btnTermDepositAccount;
    private Button btnCreditCardAccount;
    private Button btnHomeLoanAccount;
    private Button btnViewProfile;

    private AccountContract.CustomerActionListener mActionsListener;
    private Customer mCustomer;
    private String mUsername;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_home);
        btnSavingAccount = (Button) findViewById(R.id.btn_term_deposit_account);
        btnCreditCardAccount = (Button) findViewById(R.id.btn_credit_card_account);
        btnTermDepositAccount = (Button) findViewById(R.id.btn_term_deposit_account);
        btnHomeLoanAccount = (Button) findViewById(R.id.btn_home_loan_account);
        btnViewProfile = (Button) findViewById(R.id.btn_view_profile);


        Intent intent = getIntent();
        String jsonCustomer = intent.getStringExtra(CUSTOMER);
        mCustomer = (Customer) DataConverter.fromjsonToObject(jsonCustomer, Customer.class);
        mUsername = mCustomer.getmUsername();

        btnSavingAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SavingAccount account = (SavingAccount) mActionsListener.selectAccount(mUsername, TypeOfAccount.SAVING);
                mActionsListener.openSavingAccount(account);
            }
        });

        btnTermDepositAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TermDepositAccount account = (TermDepositAccount) mActionsListener.selectAccount(mUsername, TypeOfAccount.TERM_DEPOSIT);
                mActionsListener.openTermDepositAccount(account);
            }
        });

        btnCreditCardAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CrediCardAccount account = (CrediCardAccount) mActionsListener.selectAccount(mUsername, TypeOfAccount.CREDIT);
                mActionsListener.openCreditCardAccount(account);
            }
        });

        btnHomeLoanAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HomeLoanAccount account = (HomeLoanAccount) mActionsListener.selectAccount(mUsername, TypeOfAccount.LOAN);
                mActionsListener.openHomeLoanAccount(account);
            }
        });

        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActionsListener.viewCustomerProfile(mCustomer);
            }
        });

    }

    @Override
    public void onBackPressed() {
        mActionsListener.logout();
    }


    //View Methods
    @Override
    public void setProgressIndicator(boolean active) {
    }

    @Override
    public void showSavingAccount(long accountId) {
        Intent i = new Intent(this, SavingAccount.class);
        i.putExtra(ACCOUNT_ID, accountId);
        startActivity(i);
    }

    @Override
    public void showTermDepositAccount(long accountId) {
        Intent i = new Intent(this, TermDepositAccount.class);
        i.putExtra(ACCOUNT_ID, accountId);
        startActivity(i);
    }

    @Override
    public void showCreditCardAccount(long accountId) {
        Intent i = new Intent(this, CreditCardAccountActivity.class);
        i.putExtra(ACCOUNT_ID, accountId);
        startActivity(i);
    }

    @Override
    public void showHomeLoanAccount(long accountId) {
        Intent i = new Intent(this, HomeLoanAccountActivity.class);
        i.putExtra(ACCOUNT_ID, accountId);
        startActivity(i);
    }

    @Override
    public void showCustomerProfile(Customer profile) {
        Intent i = new Intent(this, CustomerProfileActivity.class);
        String jsonCustomer = DataConverter.fromObjectToJson(mCustomer, Customer.class);
        i.putExtra(CUSTOMER, jsonCustomer);
        startActivity(i);
    }

    @Override
    public void showLogout() {
        new AlertDialog.Builder(this)
                .setTitle("Logout")
                .setMessage("Do you want to leave?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        CustomerHomeActivity.this.onBackPressed();
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .show();
    }
}
