package app.silniczek.pociski;

/**
 * Created by Pawel on 08.02.15.
 */
public interface Bron {

    public abstract Pociski miotacz(float x, float y, int[] tekstura);
    public abstract Pociski mina(float x, float y, int[] tekstura);
    public abstract Pociski kula(float x, float y, int[] tekstura);
    public abstract Pociski granatnik(float x, float y, int[] tekstura);
    public abstract Pociski bomba(float x, float y, int[]... tekstura);
}
