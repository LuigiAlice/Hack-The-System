package hackthesystem.hack.app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;


public class hack2 extends ActionBarActivity {

    TextView bcoin;
    TextView energy;
    TextView innovation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hack2);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        bcoin = (TextView)this.findViewById(R.id.tvBCoin);
        energy = (TextView)this.findViewById(R.id.tvEnergy);
        innovation = (TextView)this.findViewById(R.id.tvInnovation);


        bcoin.setText(Double.toString(hack.andi.getBotCoins()));
        energy.setText(Double.toString(hack.andi.getEnergy()));
        innovation.setText(Double.toString(hack.andi.getInnovation()));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.hack2, menu);
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

    public void changeActivity(final View v)
    {
        Intent intent = new Intent(this, hack.class);
        startActivity(intent);

    }
    public void changeToHack3(final View v)
    {
        Intent intent = new Intent(this, hack3.class);
        startActivity(intent);

    }

}
