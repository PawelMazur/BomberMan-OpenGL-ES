package app.silniczek.geometria;

/**
 * Created by Pawel on 2015-05-04.
 */
public class RigidBodyControl  {

    private float czas;

    public RigidBodyControl(float czas){
        this.czas = czas;
    }

    public float getCzas() {
        return czas;
    }

    public void setCzas(float czas) {
        this.czas = czas;
    }
}
