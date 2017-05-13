/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystemprototype.widgets;

/**
 *
 * @author caidong
 */
public interface PinServiceApi {
     interface Callback<T> {
        public void onload(T pin);
    }
     interface Listener<T> {
         public void verifyPin(T pin);
     }
}
