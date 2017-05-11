package banksystemprototype.users;

/**
 * Created by caidong on 8/05/2017.
 */
abstract public class User {
    private String mUsername;
    private String mPassword;
    private TypeOfUser mTypeOfUser;


    public User(String username, String password, TypeOfUser typeOfUser) {
       mUsername = username;
       mPassword = password;
       mTypeOfUser = typeOfUser;
    }

    public String getmUsername() {
        return mUsername;
    }

    public String getmPassword() {
        return mPassword;
    }

    public TypeOfUser getmTypeOfUser() { return mTypeOfUser; }

}

