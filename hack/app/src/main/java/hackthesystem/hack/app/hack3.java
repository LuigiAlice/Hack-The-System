package hackthesystem.hack.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.internal.view.menu.ListMenuItemView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import HackTheSystem.bot.Bot;
import HackTheSystem.virus.NRVirus;


public class hack3 extends ActionBarActivity {

    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack3);
        refreshList();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hack3, menu);
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

    public void changeToHack(final View v)
    {
        Intent intent = new Intent(this, hack.class);
        startActivity(intent);

    }

    public void addBot(View v)
    {
        EditText et = (EditText) findViewById(R.id.etSpend);
        double nummer = Double.parseDouble(et.getText().toString());

        Bot bot = hack.farm.getNextBot(hack.andi, nummer);
        if (bot != null)    // Kauf geglückt
        {
            System.out.println(bot + " gekauft.");
            bot.setVirus(new NRVirus("*******"));
            hack.BNet.addBot(bot);
            refreshList();
        }
    }

    public void refreshList()
    {
        ArrayList<String> value = new ArrayList<String>();
        for(int i = 0; i < hack.BNet.getBots().size(); i++)
        {
            value.add(hack.BNet.getBots().get(i).toString());
        }
        ArrayAdapter<String> items = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, android.R.id.text1, value);
        lv = (ListView) findViewById(R.id.listView);
        lv.setAdapter(items);

    }

}
