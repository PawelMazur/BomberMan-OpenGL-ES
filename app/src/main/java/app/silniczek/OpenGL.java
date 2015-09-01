package app.silniczek;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.WindowManager;

/**
 * Created by Pawel on 2015-05-10.
 */
public class OpenGL extends Activity{

    private WidokGL widokGL;
    private Silniczek silniczek = new Silniczek();
    private BluetoothAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        widokGL = new WidokGL(this);
        widokGL.display = ((WindowManager) getSystemService(WINDOW_SERVICE)).getDefaultDisplay();
        setContentView(widokGL);

    }


    /*private void init(){
        MyServer myServer = new MyServer(adapter, this);
        myServer.connectServer("wiadomosc od servera");

    }*/

}
