package app.silniczek.bluetooth;

import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.UUID;

import app.silniczek.MainVars;

/**
 * Created by Pawel on 2015-05-29.
 */
public class MyClient implements Runnable {

    BluetoothSocket socketClient;
    UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9834FB");
    String ZNACZNIK = "MyClient : ";
    String wiadomosc = " ";
    TextView textView;
    Context context;
    public PozycjaWroga pozycjaWroga = new PozycjaWroga();

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            messageDisplay(msg.obj.toString());
            //textView.setText(msg.obj.toString());
            pozycjaWroga.pozycja(msg.obj.toString());
        }
    };

    public MyClient(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            try {

                BluetoothSocket tmp = null;
                try {
                    tmp = MainVars.device.createRfcommSocketToServiceRecord(MY_UUID);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socketClient = tmp;

                socketClient.connect();

                wyslanieWiadomosci(getWiadomosc());
                odbieranieWiadomosci();

                socketClient.close();
            } catch (IOException e) {
                Log.d(ZNACZNIK, "Nie ma polaczenia");
                break;
            }
        }
    }

    public void wyslanieWiadomosci(String wiadomosc){

        try {

            ObjectOutputStream oos = new ObjectOutputStream(socketClient.getOutputStream());
            oos.writeObject(wiadomosc);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void odbieranieWiadomosci(){
        try {
            Message message = Message.obtain();
            ObjectInputStream ois = new ObjectInputStream(socketClient.getInputStream());
            String s = (String) ois.readObject();
            message.obj = s;
            handler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void messageDisplay(String message){
        Toast.makeText(context, "" + "" + message, Toast.LENGTH_LONG).show();
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }
}
