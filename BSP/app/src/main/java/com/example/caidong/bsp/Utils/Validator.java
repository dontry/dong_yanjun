package com.example.caidong.bsp.Utils;


import com.example.caidong.bsp.users.Customer;

/**
 * Created by caidong on 9/05/2017.
 */
public class Validator {
    //PIN validator
    public static boolean isPINvalid(Long pin) {
        return pin.toString().length() == Customer.PIN_LENGTH;
    }
}
