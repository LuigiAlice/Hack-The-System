package hackthesystem.hack.app;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import HackTheSystem.*;
import HackTheSystem.securesystem.*;
import HackTheSystem.bot.*;
import HackTheSystem.exceptions.*;
import HackTheSystem.virus.*;


public class hack extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hack, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //--------------own code -----------------------------------------------------------
    public static Hacker andi = new Hacker();
    public static Botnetz BNet = new Botnetz("B***tnet/2015");
    public static Botfarm farm = new Botfarm(1000);
    final Activity me = this;



    public void changeToHack2(final View v)
    {
        Intent intent = new Intent(this, hack2.class);
        //intent.putExtra("key", intentKey);
        startActivity(intent);


    }

    public void buttonOnClick(final View v) {

        andi.addBotCoins(10000);        // Geld für Bot eroberung
        andi.addInnovation(20);   // 20 Entwicklungspunkte für Viren






        /**
         * Test of hack method, of class Hacker.
         * @throws java.lang.Exception
         */

        Bank sparkasse = new Bank();
        sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));
        //sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));


        BNet.setAttackInterval(100);

        if(BNet.getBots().size() < 1) {
            for (int i = 0; i < 3; i++) {
                Bot bot = farm.getNextBot(andi, 2000); // Andi ist geizig und zahlt nur 200 anstatt 1000 -> Risiko von 200:1000 für Erfolg!
                if (bot != null)    // Kauf geglückt
                {
                    System.out.println(bot + " gekauft.");
                    bot.setVirus(new NRVirus("*******"));
                    BNet.addBot(bot);
                }
            }

            final TextView text1 = (TextView) this.findViewById(R.id.display);
            text1.append("Bot ");
            // Auf Ereignis anmelden
            BNet.OnFirewallHacked(new Event2Args<Bot, String>() {
                  @Override
                  public void eventFired(final Bot bot, final String key) {
                      //System.out.println("Bot " + bot + " hacked firewall with key " + key);
                      me.runOnUiThread(new Runnable() {
                          @Override
                          public void run() {
                              text1.append("Bot " + bot + " hacked firewall with key " + key);
                          }
                      });

                  }
              }
            );
        }

        for (Firewall wall : sparkasse.getFirewalls())
        {
            Thread t = BNet.hack(wall);
            try {
                t.join(); // warten, bis Thread fertig ist
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //-------------------------------end of own code------------------------------------


}
