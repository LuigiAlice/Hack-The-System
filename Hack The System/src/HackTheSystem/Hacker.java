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
    private double InnovationPoints = 0;
    
    
    public double getBotCoins() {
        return BotCoins;
    }

    public void addBotCoins(double BotCoins) {
        this.BotCoins += BotCoins;
    }

    public double getInnovationPoints() {
        return InnovationPoints;
    }

    public void addInnovationPoints(double InnovationPoints) {
        this.InnovationPoints += InnovationPoints;
    }
    
    
  
 
    
}
