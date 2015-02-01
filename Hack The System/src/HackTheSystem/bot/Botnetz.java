/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.bot;

import HackTheSystem.securesystem.Firewall;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AHellmann
 */
public class Botnetz {
    boolean hacked;
    String botKey;
    List<Bot> bots = new ArrayList<>();
    int attackInterval = 1000;
    private final String name;

    public Botnetz(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Bot> getBots() {
        return bots;
    }

        
    public void addBot(Bot b)
    {
        this.bots.add(b);
    }
    
    
    public int getAttackInterval() {
        return attackInterval;
    }

    public void setAttackInterval(int attackInterval) {
        this.attackInterval = attackInterval;
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
            Thread.sleep(getAttackInterval());
        }
    }
}
