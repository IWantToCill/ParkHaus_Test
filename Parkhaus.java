import java.util.ArrayList;

/**
 * Funktions klasse von Parkhaus mit ausparken/ einparken
 * ist zur zeit vermicht mit der Daten klasse von parkhaus
 */
public class Parkhaus {
    public ArrayList<Auto> parkendeAutos;
    public int maxKapazitaet;

    public Parkhaus(int maxKapazitaet){
        this.maxKapazitaet = maxKapazitaet;
        this.parkendeAutos = new ArrayList<>();
    }

    /**
     *Parkt das übergebene Auto objekt in die Parkhausliste ein
     *
     * @param auto
     * @return true bei erfolgreichem einparken / false bei bereits vollem Parkhaus
     */
    public boolean einparken(Auto auto){
        if (parkendeAutos.size() < maxKapazitaet){ //überprüfung ob das parkhas voll ist
            parkendeAutos.add(auto);
            IO.println("Auto eingeparkt! Anzahl autos: " + parkendeAutos.size());
            return true;
        }
        else {
            IO.println("Parkhaus voll!");
            IO.println(String.format(parkendeAutos.toString()));
            return false;
        }
    }

    /**
     * Parkt das übergebene Auto objekt aus der Parkhausliste aus
     *
     * @param auto
     * @return gibt das ausgeparkte Auto objekt zurück
     */
    public Auto ausparken(Auto auto){
        //Auto wird aus dem parkhaus gelöscht
        if(parkendeAutos.remove(auto)){
            IO.println(String.format("Auto " + auto.getId() + " wurde ausgeparkt"));
            return auto;
        }
        else{
            IO.println(String.format("Auto " + auto.getId() + " ist nicht im Parkhaus"));
            return null;
        }
    }

    /**
     * Zeigt alle sich im Parkhaus befinlichen autos an
     */
    public void zeigeAlleAtos(){
        IO.println("Die Autos mit");
        for (Auto auto : parkendeAutos){
            IO.println("ID: " + auto.getId());
        }
        IO.println("sind in diesem parkhaus");
    }

    /**
     * Parkt das Auto aus der teoretichen "Parkliste" im Parkhaus mit der auto id
     * @param id
     */
    public void autoAusparkenNachID(int id){
        Auto zuEntfernen =null;

        for (Auto auto : parkendeAutos){
            if (auto.getId() == id){
                zuEntfernen = auto;
                break;
            }
        }
        if (zuEntfernen != null){
            parkendeAutos.remove(zuEntfernen);
            IO.println("Auto mit ID " + id + " wurde entfernt");
        }
        else {
            IO.println(String.format("Auto " + id + " ist nicht im Parkhaus"));
        }
    }


}
