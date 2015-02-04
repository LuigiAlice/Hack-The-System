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
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Luigi
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
        andi.addInnovationPoints(20);   // 20 Entwicklungspunkte für Viren
    }
    
    @After
    public void tearDown() {
    }


    /**
     * Test of hack method, of class Hacker.
     */
    @Test
    public void testSparkasseHack() throws Exception {


        Bank sparkasse = new Bank();
        sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));  
        sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));           
        
        Botnetz BNet = new Botnetz("B***tnet/2015");     
        BNet.setAttackInterval(100);
        
        for(int i=0; i < 1; i++)
        {
            Bot bot = new Bot(BNet, new NRVirus("*******"));
            BNet.addBot(bot);
        } 

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
