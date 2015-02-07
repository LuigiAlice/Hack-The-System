/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.bot;

import HackTheSystem.Event;
import HackTheSystem.Event1Args;
import HackTheSystem.Event2Args;
import HackTheSystem.exceptions.NoBotsException;
import HackTheSystem.securesystem.Firewall;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author AHellmann
 */
public class Botnetz  {
    boolean hacked;
    List<Bot> bots = new ArrayList<>();
    int attackInterval = 1000;
    int attacks = 0;
    private final String name;
    private Event2Args<Bot, String> evt;
    private Event2Args<Bot, String> evtAttack;
    private Event1Args<Botnetz> evtBotnet;

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
    
    public void OnBotAttack(Event2Args<Bot, String> evt)
    {
        if (this.evtAttack != null) throw new RuntimeException("Callback for Event OnBotAttack already defined!");
        this.evtAttack = evt;
    }
    
    public void OnBotnetAttack(Event1Args<Botnetz> evt)
    {
        if (this.evtBotnet != null) throw new RuntimeException("Callback for Event OnBotnetAttack already defined!");
        this.evtBotnet = evt;
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

    
    public int getAttacksCount() {
        return attacks;
    }
    
    
    
    
    /**
     * Angriff einer Firewall. Alle Bots im Netz greifen der Reihe nach an.
     * Dies gilt als quasi paralleler Angriff
     * @param wall 
     * @return  
     */     
    public Thread hack(final Firewall wall)
    {
        if (bots.isEmpty()) throw new NoBotsException("Botnetz " + this + " hat keine Bots!");
        
        final Event2Args<Bot, String> evt = this.evt;
        final Event2Args<Bot, String> evtAttack = this.evtAttack;
        final Event1Args<Botnetz> evtBotnetAttack = this.evtBotnet;
        final Botnetz me = this;
        Thread t = new Thread()
        {
            @Override
            public void run() {
                String secureKey = wall.getSecureKey();
                hacked = false;
                while(!hacked)
                {   
                    for(Bot bot : bots)
                    {                      
                        // Virus hackt Firewall...
                        String botKey = bot.getVirus().attack(wall);
                        
                        if(evtAttack != null) evtAttack.eventFired(bot, botKey);
                        
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
                        attacks++;
                    }
                    if(evtBotnetAttack != null) evtBotnetAttack.eventFired(me);
                    
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
