package app.silniczek.tekstury;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.khronos.opengles.GL10;

/**
 * Created by Pawel on 01.12.14.
 */
public class ZaladowanieTekstury {

    private int[] tekstura = new int[1];

    public ZaladowanieTekstury() {

    }

    public int[] zaladujTeksture(GL10 gl10, Context context, int zasob){
        InputStream inputStream = context.getResources().openRawResource(zasob);
        Bitmap bitmap = null;
        try {
            bitmap = BitmapFactory.decodeStream(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            inputStream.close();
            inputStream = null;
        } catch (IOException e) {
            e.printStackTrace();
        }
        gl10.glGenTextures(1, tekstura, 0);
        gl10.glBindTexture(GL10.GL_TEXTURE_2D, tekstura[0]);
        gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, GL10.GL_NEAREST);
        gl10.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, GL10.GL_NEAREST);
        GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
        bitmap.recycle();
        return tekstura;
    }
}
