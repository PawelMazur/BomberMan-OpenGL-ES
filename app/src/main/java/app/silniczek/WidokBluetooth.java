package app.silniczek;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Set;

/**
 * Created by Pawel on 2015-06-07.
 */
public class WidokBluetooth extends ActionBarActivity {

    private WidokGL widokGL;
    private ArrayAdapter<String> arrayAdapter;
    private ArrayList<String> arrayList = new ArrayList<>();
    private ListView listView;
    private EditText editText;
    private boolean pairedDevices = false;
    private Button startGame;
    private Button exitGame;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);
        MainVars.adapter = BluetoothAdapter.getDefaultAdapter();

        listView = (ListView) findViewById(R.id.listView);
        editText = (EditText) findViewById(R.id.editText);
        startGame = (Button) findViewById(R.id.button_start);
        startGame.setFocusableInTouchMode(true);
        startServer();
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



    public void startServer() {

        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startGame.setFocusableInTouchMode(false);
                //if (MainVars.adapter.isEnabled() && pairedDevices == true) {

                Intent intent = new Intent(WidokBluetooth.this, OpenGL.class);
                startActivity(intent);
                //}
                //Toast.makeText(Silniczek.this, "adapter : " + MainVars.adapter.isEnabled(), Toast.LENGTH_LONG);

            }
        });

    }

    public void koniec(View view) {

        finish();
    }

    public void startBluetooth(View view) {
        if (!MainVars.adapter.isEnabled()){
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, 1);
        }
    }

    public void pairedDevices(View view) {
        if (MainVars.adapter.isEnabled()) {
            Set<BluetoothDevice> pairedDevices = MainVars.adapter.getBondedDevices();
            for (BluetoothDevice d : pairedDevices) {
                MainVars.device = d;
                arrayList.add(d.getName() + " \n " + d.getAddress());
            }
        }
        arrayAdapter = new ArrayAdapter<>(this, R.layout.abc_list_menu_item_radio, arrayList);
        listView.setAdapter(arrayAdapter);
        pairedDevices = true;
    }
}
