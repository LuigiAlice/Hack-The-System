/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem;

import HackTheSystem.bot.Bot;
import HackTheSystem.bot.Botnetz;
import HackTheSystem.securesystem.Bank;
import HackTheSystem.securesystem.Firewall;
import HackTheSystem.virus.Virus;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Roolez
 */
public class Hacker {
    
    public void hack() throws InterruptedException
    {

            
 
            Bank sparkasse = new Bank();
            sparkasse.addFirewall(new Firewall(sparkasse, "01011001"));           
            
            
            Virus vir = new Virus();    // TODO: Virus gehört zu genau einem Bot
            
            Botnetz BNet = new Botnetz("B***tnet/2015");     
            BNet.setAttackInterval(500);
            for(int i=0; i < 4; i++) BNet.addBot(new Bot(vir));  // der gleiche Virus 4x geshared      

            for (Firewall wall : sparkasse.getFirewalls())
            {
                BNet.Hack(wall);
            }
                    
    }
    
}
