/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.virus;

import HackTheSystem.securesystem.Firewall;
import HackTheSystem.virus.Virus;
import java.util.List;

/**
 *RemenberVirus
 * @author Roolez
 */
public class RemVirus extends Virus{

    @Override
    public String getNextKey(Firewall wall)
    {
      String key = "";
      boolean done = false;
      for(int i = 0; i < keyPattern.length(); i++)
      {      
        if("*".equals(keyPattern.substring(i, i+1)))
        {
            key += Integer.toString(rnd.nextInt(2));
            if(numOfAttk % 50 == 0 && !done)
            {
                keyPattern = keyPattern.substring(0, i)+ wall.getSecureKey().substring(i, i + 1) + keyPattern.substring(i+1);
            }
        }
        else
            key +=  keyPattern.substring(i, i+1);
      }
      
      numOfAttk ++;
      return key;
    }
}
