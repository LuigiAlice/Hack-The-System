 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.virus;

import HackTheSystem.securesystem.Firewall;
import java.util.List;
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
    long numOfAttk;
    String keyPattern = "****************";

    
    Random rnd = new Random();  
    
    public void init()
    {
        numOfAttk = 1;
    }
    
    public String getNextKey(Firewall wall)
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
