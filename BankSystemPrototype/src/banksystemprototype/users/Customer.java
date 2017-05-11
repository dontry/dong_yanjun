package banksystemprototype.users;


/**
 * Created by caidong on 8/05/2017.
 */
public class Customer extends User {
    public static final int PIN_LENGTH = 6;
    private String mFirstName;
    private String mLastName;
    private String mAddress;
    private String mIdNumber;
    private String mEmail;
    private String mPhoneNumber;
    private long mPin;
    private TypeOfId mTypeOfId;

    /**
     *
     * @param username
     * @param password
     * @param mFirstName
     * @param mLastName
     * @param mAddress
     * @param mIdNumber
     * @param mEmail
     * @param mPhoneNumber
     * @param mPin
     * @param mTypeOfId
     */
    public Customer(String username, String password, String mFirstName, String mLastName, String mAddress, String mIdNumber, String mEmail, String mPhoneNumber, long mPin, TypeOfId mTypeOfId) {
        super(username, password, TypeOfUser.CUSTOMER);
        this.mFirstName = mFirstName;
        this.mLastName = mLastName;
        this.mAddress = mAddress;
        this.mIdNumber = mIdNumber;
        this.mEmail = mEmail;
        this.mPhoneNumber = mPhoneNumber;
        this.mPin = mPin;
        this.mTypeOfId = mTypeOfId;
    }

    /**
     *
     * @return firstname
     */
    public String getmFirstName() {
        return mFirstName;
    }

    /**
     *
     * @return lastname
     */
    public String getmLastName() {
        return mLastName;
    }

    /**
     *
     * @return fullname
     */
    public String getmFullName() {
        return mLastName + mFirstName;
    }

    /**
     *
     * @return address
     */
    public String getmAddress() {
        return mAddress;
    }

    /**
     *
     * @return id number
     */
    public String getmIdNumber() {
        return mIdNumber;
    }

    /**
     *
     * @return email
     */
    public String getmEmail() {
        return mEmail;
    }

    /**
     *
     * @return phone number
     */
    public String getmPhoneNumber() {
        return mPhoneNumber;
    }

    /**
     *
     * @return PIN
     */
    public long getmPin() {
        return mPin;
    }

    /**
     *
     * @return ID type
     */
    public TypeOfId getmTypeOfId() {
        return mTypeOfId;
    }


    public void setmFirstName(String mFirstName) {
        this.mFirstName = mFirstName;
    }

    public void setmLastName(String mLastName) {
        this.mLastName = mLastName;
    }

    public void setmAddress(String mAddress) {
        this.mAddress = mAddress;
    }

    public void setmIdNumber(String mIdNumber) {
        this.mIdNumber = mIdNumber;
    }

    public void setmEmail(String mEmail) {
        this.mEmail = mEmail;
    }

    public void setmPhoneNumber(String mPhoneNumber) {
        this.mPhoneNumber = mPhoneNumber;
    }

    public void setmPin(long mPin) {
        this.mPin = mPin;
    }

    public void setmTypeOfId(TypeOfId mTypeOfId) {
        this.mTypeOfId = mTypeOfId;
    }
}
