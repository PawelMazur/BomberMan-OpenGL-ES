package app.silniczek.bluetooth;

import android.bluetooth.BluetoothServerSocket;
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
public class MyServer implements Runnable {

    Thread thread;
    BluetoothServerSocket serverSocket;
    BluetoothSocket socket;
    UUID MY_UUID = UUID.fromString("00001101-0000-1000-8000-00805F9834FB");
    String NAME = "Name";
    String wiadomosc = " ";
    String ZNACZNIK = "MyServer";
    TextView textView;
    Context context;
    public PozycjaWroga pozycjaWroga = new PozycjaWroga();

    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
           messageDisplay(msg.obj.toString());
           //textView.setText(msg.obj.toString());
           pozycjaWroga.pozycja(msg.obj.toString());
        }
    };

    public MyServer(Context context) {
        this.context = context;
    }

    @Override
    public void run() {
        while (true) {
            try {

                BluetoothServerSocket tmp = null;

                try {
                    tmp = MainVars.adapter.listenUsingRfcommWithServiceRecord(NAME, MY_UUID);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                serverSocket = tmp;


                socket = serverSocket.accept();

                wyslanieWiadomosci(getWiadomosc());
                odbieranieWiadomosci();
                serverSocket.close();

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
                Log.d(ZNACZNIK, "Server nie odpowiada");
            }
        }
    }


    public void odbieranieWiadomosci(){
        try {
            Message message = Message.obtain();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String s = (String) ois.readObject();
            message.obj = s;
            handler.sendMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void wyslanieWiadomosci(String wiadomosc){
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(wiadomosc);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void messageDisplay(String messaage){
        Toast.makeText(context, "" + messaage, Toast.LENGTH_LONG).show();
    }

    public String getWiadomosc() {
        return wiadomosc;
    }

    public void setWiadomosc(String wiadomosc) {
        this.wiadomosc = wiadomosc;
    }
}
