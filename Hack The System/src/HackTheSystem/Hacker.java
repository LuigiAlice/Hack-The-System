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
import HackTheSystem.virus.NRVirus;
import HackTheSystem.virus.RemVirus;
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
            sparkasse.addFirewall(new Firewall(sparkasse, "0101100110101010"));           
            
           
            
            Botnetz BNet = new Botnetz("B***tnet/2015");     
            BNet.setAttackInterval(1);
            for(int i=0; i < 1; i++) BNet.addBot(new Bot(new NRVirus()));  // der gleiche Virus 4x geshared      

            for (Firewall wall : sparkasse.getFirewalls())
            {
                BNet.Hack(wall);
            }
                    
    }
    
}
