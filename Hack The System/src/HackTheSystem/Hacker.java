/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem;

import HackTheSystem.bot.Bot;
import HackTheSystem.bot.Botnetz;
import HackTheSystem.securesystem.Firewall;
import HackTheSystem.securesystem.SecureSystem;
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
            List<Firewall> wall = new ArrayList<>();
            wall.add(new Firewall("01011001"));
            
            
            
            SecureSystem Sys = new SecureSystem(wall);
            Virus vir = new Virus();
            List<Bot> bots = new ArrayList<>();
            for(int i=0; i < 4; i++) bots.add(new Bot(vir));  // der gleiche Virus 4x geshared      

            Botnetz BNet = new Botnetz(bots);

            BNet.Hack(Sys.getFirewall().get(0));
                    
    }
    
}
