/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem;

/**
 *
 * @author Luigi
 * @param <T>
 */
public interface Event<T> {
    
    public void eventFired(T sender, Object... args);
    
}
