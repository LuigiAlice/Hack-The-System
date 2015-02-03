/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.securesystem;

import HackTheSystem.bot.Bot;

/**
 *
 * @author Roolez
 */
public class Firewall {
    String secureKey; 
    SecureSystem secureSystem;
    Bot[] bots; 
    
    public Firewall(SecureSystem secureSystem, String key)
    {
        secureSystem = secureSystem;
	secureKey = key;
    }

    public String getSecureKey() {
        return secureKey;
    }

    
    public void hacked(String botKey)
    {
	System.out.println("hacked: "+botKey);
    }
}
