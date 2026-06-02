/**
 * Daten Klasse Die informaitionen über "auto" verwaltet
 */
public class Auto {
    private int id;
    private String farbe;
    private AutoMarken marke;
    private int geschwindigkeit;

    public Auto(int id, String farbe, AutoMarken marke) {

        this.id = id;
        this.farbe = farbe;
        this.marke = marke;
        IO.println("TEST");
    }

    /**
     * Zeigt die informationen über das Auto objekt
     *
     * @return Das zu den informationen gehörende auto objekt
     */
    public Auto zeigInfo(){
        IO.println(String.format("ID: %d, Farbe: %s, Marke: %s", id, farbe, marke));
        return this;
    }
/*
    public void setGeschwindigkeit(int geschwindigkeit){
        this.geschwindigkeit += geschwindigkeit;
        IO.println("Geschwindigkeit: " + this.geschwindigkeit);
    }
*/

    /**
     * Giebt die ID auto objektes zurück
     *
     * @return Die ID des auto ojektes
     */
    public int getId() {
        return id;
    }
}
