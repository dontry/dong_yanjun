package banksystemprototype;

import java.util.Date;

/**
 * Created by caidong on 9/05/2017.
 */
public class HomeLoanApplication {
    private long mAppId;
    private String mUsername;
    double mPrinciple;
    TypeOfHomeLoan mTypeOfHomeLoan;
    double interest; //TODO: interest of home loan;
    Date mStartingDate;

    public HomeLoanApplication(long mAppId, String mUsername, double mPrinciple, TypeOfHomeLoan mTypeOfHomeLoan, Date mStartingDate) {
        this.mAppId = mAppId;
        this.mUsername = mUsername;
        this.mPrinciple = mPrinciple;
        this.mTypeOfHomeLoan = mTypeOfHomeLoan;
        this.mStartingDate = mStartingDate;
    }

    public long getmAppId() {
        return mAppId;
    }

    public String getmUsername() {
        return mUsername;
    }

    public double getmPrinciple() {
        return mPrinciple;
    }

    public TypeOfHomeLoan getmTypeOfHomeLoan() {
        return mTypeOfHomeLoan;
    }

    public double getInterest() {
        return interest;
    }

    public Date getmStartingDate() {
        return mStartingDate;
    }
}
