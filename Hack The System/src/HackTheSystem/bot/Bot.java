/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.bot;

import HackTheSystem.securesystem.Firewall;
import HackTheSystem.virus.Virus;

/**
 *
 * @author Roolez
 */
public class Bot {
    Virus virus;
    
    public Bot(Virus virus)
    {
        this.virus = virus;
    }
    
    
    public String getNextKey(Firewall wall)
    {
      return virus.getNextKey(wall);
    };

}
