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
public class Botnetz  {
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
    
    /**
     * Angriff einer Firewall. Alle Bots im Netz greifen der Reihe nach an.
     * Dies gilt als quasi paralleler Angriff
     * @param wall
     * @throws InterruptedException 
     */     
    public Thread hack(Firewall wall)
    {
        Thread t = new Thread()
        {
            @Override
            public void run() {
                String secureKey = wall.getSecureKey();
                hacked = false;
                int j = 0;
                while(!hacked)
                {   
                    for(Bot bot : bots)
                    {
                        // Virus hackt Firewall...
                        botKey = bot.getVirus().attack(wall);
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
                    try {
                        Thread.sleep(getAttackInterval());
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }  
        };
        
        t.start();
	return t;
    }

}
