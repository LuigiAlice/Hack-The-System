 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.virus;

import HackTheSystem.securesystem.Firewall;
import java.util.Random;

/**
 *
 * @author Roolez
 */
public class Virus {
    String name;
    int speed; //Attackiertgeschwindigkeit
    int raise; //Faktor um wie viel die einahmen im erfolgsfall
    int hidden; //Enddeckbarkeit
    int spread; //Ausbreitung
    int minProzessor; //vorraussetzung des bots
    
    long numOfAttk;
    protected String keyPattern = "*";
    Random rnd = new Random();  

    public Virus(String keyPattern) {
        this.keyPattern = keyPattern; 
    }
    
    public void init()
    {
        numOfAttk = 1;
    }
    
    
    public String attack(Firewall wall)
    {
        if (wall.getSecureKey().length() > this.keyPattern.length())
            throw new RuntimeException("Virus ist zu schwach für die Firewall");
        
        return getNextKey(wall); 
    }
    
    protected String getNextKey(Firewall wall)
    {
      String key = "";
      for(int i = 0; i < keyPattern.length(); i++)
      {      
        if("*".equals(keyPattern.substring(i, i+1)))
            key += Integer.toString(rnd.nextInt(2));
        else
            key +=  keyPattern.substring(i, i+1);
      }
      numOfAttk ++;
      return key;
    }
}
