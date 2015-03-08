package hackthesystem.hts;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import HackTheSystem.Event2Args;
import HackTheSystem.bot.Bot;
import HackTheSystem.securesystem.Bank;
import HackTheSystem.securesystem.Firewall;
import HackTheSystem.virus.NRVirus;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Listeners.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link AttackTerminalFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class AttackTerminalFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private Listeners.OnFragmentInteractionListener mListener;

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment AttackTerminalFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static AttackTerminalFragment newInstance(String param1, String param2) {
        AttackTerminalFragment fragment = new AttackTerminalFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    public AttackTerminalFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_attack_terminal, container, false);
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (Listeners.OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public void startAttack(final View v) {
        MainActivity.BNet.setAttackInterval(100);


        Bank sparkasse = new Bank();
        sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));
        //sparkasse.addFirewall(new Firewall(sparkasse, "0101100"));

        if(MainActivity.BNet.getBots().size() < 1) {
            for (int i = 0; i < 3; i++) {
                Bot bot = MainActivity.farm.getNextBot(MainActivity.andi, 2000); // Andi ist geizig und zahlt nur 200 anstatt 1000 -> Risiko von 200:1000 für Erfolg!
                if (bot != null)    // Kauf geglückt
                {
                    System.out.println(bot + " gekauft.");
                    bot.setVirus(new NRVirus("*******"));
                    MainActivity.BNet.addBot(bot);
                }
            }

            final TextView text1 = (TextView) this.getActivity().findViewById(R.id.display);
            final Activity me = this.getActivity();

            text1.append("Bot ");
            // Auf Ereignis anmelden
            MainActivity.BNet.OnFirewallHacked(new Event2Args<Bot, String>() {
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
            Thread t = MainActivity.BNet.hack(wall);
            try {
                t.join(); // warten, bis Thread fertig ist
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }




}
