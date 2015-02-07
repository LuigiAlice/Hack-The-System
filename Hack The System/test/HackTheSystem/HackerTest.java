/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem;

import HackTheSystem.bot.Bot;
import HackTheSystem.bot.Botfarm;
import HackTheSystem.bot.Botnetz;
import HackTheSystem.securesystem.Bank;
import HackTheSystem.securesystem.Firewall;
import HackTheSystem.virus.NRVirus;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luigi ist doof
 */
public class HackerTest {
    
    Hacker andi;
    
    public HackerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        
        andi = new Hacker();
        andi.addBotCoins(10000);        // Geld für Bot eroberung
        andi.addInnovation(20);   // 20 Entwicklungspunkte für Viren
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of hack method, of class Hacker.
     * @throws java.lang.Exception
     */
    @Test
    public void testSparkasseHack() throws Exception {


        Bank sparkasse = new Bank();
        sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));  
        sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));           
        
        Botnetz BNet = new Botnetz("B***tnet/2015");     
        BNet.setAttackInterval(100);
        
        Botfarm farm = new Botfarm(1000);
        
        for(int i=0; i < 3; i++)
        {
            Bot bot = farm.getNextBot(andi, 200); // Andi ist geizig und zahlt nur 200 anstatt 1000 -> Risiko von 200:1000 für Erfolg!
            if (bot != null)    // Kauf geglückt
            {
                System.out.println(bot + " gekauft.");
                bot.setVirus(new NRVirus("*******"));
                BNet.addBot(bot);
            }
        } 

        // Auf Ereignis anmelden
         BNet.OnFirewallHacked(new Event2Args<Bot, String>() {
                  @Override
                  public void eventFired(Bot bot, String key) {
                      System.out.println("Bot " + bot + " hacked firewall with key " + key);
                  }
              }
            );
        
         BNet.OnBotAttack(new Event2Args<Bot, String>() {
            @Override
            public void eventFired(Bot bot, String attackKey) {
                System.out.println("Bot: " + bot + " attackKey: " + attackKey);
            }
        });
         
        BNet.OnBotnetAttack(new Event1Args<Botnetz>() {
            @Override
            public void eventFired(Botnetz netz) {
                System.out.println("----------- " + netz.getAttacksCount());    
            }
        });
         
         
        for (Firewall wall : sparkasse.getFirewalls())
        {
            Thread t = BNet.hack(wall);
            t.join(); // warten, bis Thread fertig ist
        }
		           
    }
    
//    @Test
//    public void testVirusSchwach() throws Exception {
//        try
//        {
//        Bank sparkasse = new Bank(); 
//        sparkasse.addFirewall(new Firewall(sparkasse, "0101100110101010")); 
//        Botnetz BNet = new Botnetz("B***tnet/2015");   
//        Bot bot = new Bot(BNet, new NRVirus("****"));
//        BNet.addBot(bot);
//        BNet.hack(sparkasse.getFirewalls().get(0));
//        }
//        catch(Exception e)
//        {
//            assertTrue(e.getMessage().contains("Virus ist zu schwach"));
//        }
//    }
    
}
