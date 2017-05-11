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
    private final String MSG = "The amount exceeds the balance Limit";
    public BalanceLimitException() {
        
    }
    
    public String getMessage() {
        return MSG;
    }
}
