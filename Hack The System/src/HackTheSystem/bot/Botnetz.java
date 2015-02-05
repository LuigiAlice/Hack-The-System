/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.bot;

import HackTheSystem.Event2Args;
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
    private Event2Args<Bot, String> evt;

    public Botnetz(String name) {
        this.name = name;
    }

    /**
     * Event wird ausgelöst, wenn Firewall gehackt wurde
     * @param evt
     */
    public void OnFirewallHacked(Event2Args<Bot, String> evt)
    {
        if (this.evt != null) throw new RuntimeException("Callback for Event OnFirewallHacked already defined!");
        this.evt = evt;
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
     * @return  
     */     
    public Thread hack(Firewall wall)
    {
        final Event2Args<Bot, String> evt = this.evt;
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
                            if (evt != null) evt.eventFired(bot, botKey);   // Ereignis auslösen
                            for (Bot botInit : bots)
                            {
                               botInit.getVirus().init();
                            }
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
