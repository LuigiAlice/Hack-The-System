/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem;

/**
 *
 * @author Luigi
 * @param <T1>
 * @param <T2>
 * @param <T3>
 */
public interface Event3Args<T1, T2, T3> {
    
    public void eventFired(T1 sender, T2 arg2, T3 arg3);
    
}


