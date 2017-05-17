package banksystemprototype.Utils;

import banksystemprototype.users._Customer;



/**
 * Created by caidong on 9/05/2017.
 */
public class Validator {
    //PIN validator
    public static boolean isPINvalid(Long pin) {
        return pin.toString().length() == _Customer.PIN_LENGTH;
    }
}
