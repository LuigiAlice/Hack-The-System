/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem;

/**
 *
 * @author Roolez
 */
public class Hacker {
    
    private double BotCoins = 0;
    private double Innovation = 0;
    private double Energy = 0;
    
    public double getBotCoins() {
        return BotCoins;
    }
    public void addBotCoins(double BotCoins) {
        this.BotCoins += BotCoins;
        System.out.println("BotCoins: " + this.BotCoins);
    }
    public double getEnergy() {
        return Energy;
    }
    public void addEnergy(double Energy) {
        this.Energy += Energy;
    }
    

    public double getInnovation() {
        return Innovation;
    }

    public void addInnovation(double InnovationPoints) {
        this.Innovation += InnovationPoints;
    }
    
    
  
 
    
}
