/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.securesystem;

import java.util.List;

/**
 *
 * @author Roolez
 */
public class SecureSystem {
    String Bez;
    List<Firewall> wall;
    
    public SecureSystem(List<Firewall> wall)
    {
        this.wall = wall;
    }
    
    public void getRecources()
    {
    }

    public List<Firewall> getFirewall() {
        return wall;
    }
    
    
    
}
