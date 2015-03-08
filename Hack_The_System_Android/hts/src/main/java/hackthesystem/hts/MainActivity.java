package hackthesystem.hts;

import java.util.Locale;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Handler;
import android.support.v13.app.FragmentPagerAdapter;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import HackTheSystem.*;
import HackTheSystem.securesystem.*;
import HackTheSystem.bot.*;
import HackTheSystem.exceptions.*;
import HackTheSystem.virus.*;


public class MainActivity extends Activity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v13.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);




    }

    //--------------own code -----------------------------------------------------------
    public void changeActivity(final View v)
    {
        Intent intent = new Intent(v.getContext(), MainActivity2.class);
        startActivityForResult(intent, 0);

    }

    public void buttonOnClick(final View v) {
        Hacker andi;


            andi = new Hacker();
            andi.addBotCoins(10000);        // Geld für Bot eroberung
            andi.addInnovation(20);   // 20 Entwicklungspunkte für Viren






        /**
         * Test of hack method, of class Hacker.
         * @throws java.lang.Exception
         */

            Bank sparkasse = new Bank();
            sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));
            sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));

            Botnetz BNet = new Botnetz("B***tnet/2015");
            BNet.setAttackInterval(100);

            Botfarm farm = new Botfarm(1000);

            for(int i=0; i < 3; i++)
            {
                Bot bot = farm.getNextBot(andi, 2000); // Andi ist geizig und zahlt nur 200 anstatt 1000 -> Risiko von 200:1000 für Erfolg!
                if (bot != null)    // Kauf geglückt
                {
                    System.out.println(bot + " gekauft.");
                    bot.setVirus(new NRVirus("*******"));
                    BNet.addBot(bot);
                }
            }

        final TextView text1 = (TextView)this.findViewById(R.id.display);

        final Activity me = this;

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
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

    

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            Locale l = Locale.getDefault();
            switch (position) {
                case 0:
                    return getString(R.string.title_section1).toUpperCase(l);
                case 1:
                    return getString(R.string.title_section2).toUpperCase(l);
                case 2:
                    return getString(R.string.title_section3).toUpperCase(l);
            }
            return null;
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            TextView textView = (TextView) rootView.findViewById(R.id.section_label);
            textView.setText(Integer.toString(getArguments().getInt(ARG_SECTION_NUMBER)));
            return rootView;
        }
    }

}
