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
    private final Botnetz botnetz;
    Virus virus;
    
    /**
     *
     * @param botnetz
     * @param virus
     */
    public Bot(Botnetz botnetz, Virus virus)
    {
        this.botnetz = botnetz;
        this.virus = virus;
    }
    
   
    

    public Botnetz getBotnetz() {
        return botnetz;
    }

    
    public Virus getVirus() {
        return virus;
    }
    
    

}
