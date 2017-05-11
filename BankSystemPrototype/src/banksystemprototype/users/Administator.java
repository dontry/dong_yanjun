package banksystemprototype.users;

/**
 * Created by caidong on 9/05/2017.
 */
public class Administator extends User{
    public Administator(String username, String password) {
        super(username, password, TypeOfUser.ADMINISTRATOR);
    }
}
