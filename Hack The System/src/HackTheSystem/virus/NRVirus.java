/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HackTheSystem.virus;

import HackTheSystem.securesystem.Firewall;
import java.util.ArrayList;
import java.util.List;

/**
 * NoRepeatVirus
 * @author Roolez
 */
public class NRVirus extends Virus{

    List <String> triedKeys = new ArrayList<>();

    public NRVirus(String keyPattern) {
        super(keyPattern);
    }
    
    @Override
    public void init()
    {
        numOfAttk = 1;
        triedKeys = new ArrayList<>();
    }
     
    @Override
    public String getNextKey(Firewall wall)
    {
      String key;
      do{
        key = "";
        for(int i = 0; i < keyPattern.length(); i++)
        {      
          if("*".equals(keyPattern.substring(i, i+1)))
              key += Integer.toString(rnd.nextInt(2));
          else
              key +=  keyPattern.substring(i, i+1);
        }
      }
      while(triedKeys.contains(key));
      
      numOfAttk ++;
      triedKeys.add(key);
      return key;
    }
}
