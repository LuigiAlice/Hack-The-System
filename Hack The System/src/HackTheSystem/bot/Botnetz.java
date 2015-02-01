/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.bot;

import HackTheSystem.securesystem.Firewall;
import java.util.List;

/**
 *
 * @author AHellmann
 */
public class Botnetz {
    List<Bot> bots;
    boolean hacked;
    String botKey;
    public Botnetz(List<Bot> bots)
    {
	this.bots = bots;
    }
    
            
    public void Hack(Firewall wall) throws InterruptedException
    {
	String secureKey = wall.getSecureKey();
	hacked = false;
	int j = 0;
        while(!hacked)
        {
	    
	    for(Bot bot : bots)
	    {
		botKey = bot.getNextKey(wall);
		if(botKey.equals(secureKey))
		{
		    hacked = true;
		    wall.hacked(botKey);
		    break;
		}
		System.out.println(botKey);
		j++;
	    }
	    System.out.println("----------- " + j);            
            Thread.sleep(1000);
        }
    };
}
