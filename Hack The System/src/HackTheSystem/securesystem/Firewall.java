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
        this.secureSystem = secureSystem;
	this.secureKey = key;
    }

    public String getSecureKey() {
        return secureKey;
    }

}
