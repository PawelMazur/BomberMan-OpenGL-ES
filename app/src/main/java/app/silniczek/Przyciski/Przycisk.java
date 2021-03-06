package app.silniczek.Przyciski;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 24.10.14.
 */
public class Przycisk {

    private FloatBuffer buferWierzcholka;
    private FloatBuffer buferTekstury;
    private ByteBuffer buferIndeksow;

    private int[] tablica = new int[1];

    public Przycisk() {

        float[] tablicaWierzcholkow = {
                0.0f, 0.0f, 0.0f,
                0.0f, 0.1f, 0.0f,
                0.1f, 0.1f, 0.0f,
                0.1f, 0.0f, 0.0f,
        };

        float[] tablicaTekstur = {
                0.0f, 0.0f,
                0.0f, 1.0f,
                1.0f, 1.0f,
                1.0f, 0.0f,
        };

        byte[] tablicaIndeksow = {
                0, 1, 2,
                0, 2, 3,
        };

        ByteBuffer byteBufferW = ByteBuffer.allocateDirect(tablicaWierzcholkow.length * 4);
        byteBufferW.order(ByteOrder.nativeOrder());
        buferWierzcholka = byteBufferW.asFloatBuffer();
        buferWierzcholka.put(tablicaWierzcholkow).position(0);

        ByteBuffer byteBufferT = ByteBuffer.allocateDirect(tablicaTekstur.length * 4);
        byteBufferT.order(ByteOrder.nativeOrder());
        buferTekstury = byteBufferT.asFloatBuffer();
        buferTekstury.put(tablicaTekstur).position(0);

        buferIndeksow = ByteBuffer.allocateDirect(tablicaIndeksow.length);
        buferIndeksow.order(ByteOrder.nativeOrder());
        buferIndeksow.put(tablicaIndeksow).position(0);
    }

    public void rysujPrzycisk(GL10 gl10, int []tablica){

        gl10.glBindTexture(GL10.GL_TEXTURE_2D, tablica[0]);
        gl10.glVertexPointer(3, GL10.GL_FLOAT, 0, buferWierzcholka);
        gl10.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
        gl10.glTexCoordPointer(2, GL10.GL_FLOAT, 0, buferTekstury);
        gl10.glDrawElements(GL10.GL_TRIANGLES, 6, GL10.GL_UNSIGNED_BYTE, buferIndeksow);
    }

}
