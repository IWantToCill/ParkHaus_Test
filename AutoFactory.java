import java.awt.*;
import java.util.Random;

/**
 * Erzeugt auto objekte mit id, farbe und marke
 */
public class AutoFactory {
    private int id = 0;

    /**
     * Erzeugt ein neues Auto objekt mit id, farbe und marke.
     * dfsdfsd
     * @return Das Neu erzeugte Auto objekt
     */
    public Auto createAuto(){
        Random random = new Random();
        int markenIndex = random.nextInt(AutoMarken.values().length);
        AutoMarken autoMarke = AutoMarken.values()[markenIndex];

        // Test

        Auto auto = new Auto(id ,"Rot",autoMarke);
        this.id++;
        return auto;
    }
}
