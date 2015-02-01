/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.securesystem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roolez
 */
abstract class SecureSystem {
    String Bez;
    List<Firewall> firewalls = new ArrayList<>();
    boolean geknackt;
    
    
    public void getRecources()
    {
    }

    public void setGeknackt(boolean geknackt) {
        this.geknackt = geknackt;
    }

    
    
    public boolean isGeknackt() {
        return geknackt;
    }

    
    

    public List<Firewall> getFirewalls() {
        return firewalls;
    }
    
        public void addFirewall(Firewall wall)
    {
        this.firewalls.add(wall);     
    }
    
    
}
