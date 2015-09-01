package app.silniczek;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;


public class Silniczek extends ActionBarActivity {

    private Button startGry;
    private Button koniecGry;
    private Button startServer;
    private ProgressBar progressBar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainVars.adapter = BluetoothAdapter.getDefaultAdapter();

        startGry = (Button) findViewById(R.id.button_start);
        koniecGry = (Button) findViewById(R.id.button_koniec);
        //startServer = (Button) findViewById(R.id.start_server);

        //startGry.setFocusableInTouchMode(true);
        //koniecGry.setFocusableInTouchMode(true);
        //startServer.setFocusableInTouchMode(true);

        start();
        koniec();
        //startServer();


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



    public void start() {

        startGry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGry.setFocusableInTouchMode(false);
                //if (MainVars.adapter.isEnabled() && pairedDevices == true) {

                Intent intent = new Intent(Silniczek.this, OpenGL.class);
                startActivity(intent);
                //}
                //Toast.makeText(Silniczek.this, "adapter : " + MainVars.adapter.isEnabled(), Toast.LENGTH_LONG);

            }
        });

    }

    public void koniec(){
        koniecGry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                koniecGry.setFocusableInTouchMode(false);
                finish();
            }
        });
    }

    public void startServer(){
        startServer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Silniczek.this, WidokBluetooth.class);
                startActivity(intent);
            }
        });
    }
}
