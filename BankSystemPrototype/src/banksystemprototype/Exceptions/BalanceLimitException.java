/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.Exceptions;

/**
 *
 * @author caidong
 */
public class BalanceLimitException extends Exception {
    private String type;
    public BalanceLimitException(TypeOfLimit limit) {
        type = limit.toString();
    }
    
    public String getMessage() {
        return "The amount exceeds the " + type + " Limit";
    }
}
