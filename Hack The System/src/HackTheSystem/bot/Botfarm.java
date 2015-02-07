/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.bot;

import HackTheSystem.Hacker;
import HackTheSystem.exceptions.NotEnoughBotCoinsException;

/**
 * Eine Klasse, die Bots auf Anfrage generiert.
 * @author Luigi
 */
public class Botfarm {
    private final double botcoinsCosts;

    /**
     *
     * @param botcoinsCosts Durchschnittliche Kosten eines Bot Erfolgs
     */
    public Botfarm(double botcoinsCosts) {
        this.botcoinsCosts = botcoinsCosts;
    }
    
    /**
     * Umso mehr Geld übergeben wird umso höher die Wahrscheinlichkeit gute Bots angreifen und in Besitz nehmen zu können. 
     * @return 
     */
    public Bot getNextBot(Hacker hacker, double botcoins)
    {
        if (hacker.getBotCoins() < botcoins)
            throw new NotEnoughBotCoinsException("Du brauchst mindestens " + botcoins + " BotCoins");
        
        hacker.addBotCoins(-botcoins);  // zahlen
        double erfolgsfall = (botcoins / botcoinsCosts) + Math.random();
        if (erfolgsfall >= 1.0)
        {
            return new Bot();
        }
        
        return null;
    }
    
}
