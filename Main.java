//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;

void main() {
    Scanner scanner = new Scanner(System.in); //neuer scanner wird erstellt? // \(o.o)/
    IO.println(String.format("Hello and a happy welcome!"));

    Parkhaus cityParkhaus = new Parkhaus(3); // parkheuser werden erstellt mus noch liste / stadt plan anlegen
    Parkhaus magicParkhaus = new Parkhaus(9999);

    ArrayList<Auto> alleAutos = new ArrayList<Auto> (); // gess wat Alle autos liste
    ArrayList<Auto> nichtGeparkteAutos = new ArrayList<>();
    AutoFactory autoFactory = new AutoFactory();//reposetori

    boolean debug=true;

    /**
 * ersetzen
 */
    for (int i = 1; i <= 5; i++) {
        autosErzeugen(magicParkhaus,autoFactory);
        Auto auto = new Auto(i,"rot",AutoMarken.values()[0]); //autos erstellen
        alleAutos.add(auto.zeigInfo());

        if (!cityParkhaus.einparken(auto)){  //erstellte autos in parkhaus stellen
            magicParkhaus.einparken(auto);
        }
    }



    for (int i = 0; i < alleAutos.size(); i++){
        cityParkhaus.ausparken(alleAutos.get(i));  //alle autos aus dem cityParkhaus ausparken

    }

    IO.println("---Parkhaus verwaltung---");     //was man so tun kann
    boolean running = true;                     //mit einer kleinen endlos schleife lol
    while (running) {
        IO.println("Was möchtest du tun?");
        IO.println("1 - Auto einparken");
        IO.println("2 - Auto ausparken");
        IO.println("3 - Auto um parken");
        IO.println("4 - Alle Atos anzeigen");
        IO.println("5 - Beenden");
        IO.print("Deine Wahl:");

        int wahl = scanner.nextInt();           //Die getroffene auswahl
        scanner.nextLine();

        switch (wahl) {                         //und hier kommen die dazugehörigen "geschehnisse"
            case 1:
                //Auto einparken
                IO.println("Welches Auto soll eingeparkt werden?");


                for (Auto auto : alleAutos) {
                    IO.print("ID:");
                    IO.println(auto.getId());
                }

                IO.print("Auto ID wahl:");

                int idEinparken = scanner.nextInt();
                scanner.nextLine();

                for (Auto auto : alleAutos) {
                    if (auto.getId() == idEinparken) {
                        IO.println("In welchem Parkhaus soll das Auto einparken?");
                        IO.println("1 - CityParkhaus");
                        IO.println("2 - MagicParkhaus");
                        int parkhaus = scanner.nextInt();
                        scanner.nextLine();

                        if (parkhaus == 1){
                            if (!cityParkhaus.parkendeAutos.contains(auto)){    //wenn das auto noch nicht im parkhaus ist
                                cityParkhaus.einparken(auto);
                            }
                        }

                        else if (parkhaus == 2){
                            if (!magicParkhaus.parkendeAutos.contains(auto)){   //wenn das auto noch nicht im parkhaus ist
                                magicParkhaus.einparken(auto);
                            }
                        }
                        else {
                            IO.println("Ungültige Parkhaus wahl!");
                        }
                    }
                }

                break;

            case 2:
                //Auto ausparken
                IO.println("Aus welchem parkhaus soll ausgeparkt werden?");

                if (!cityParkhaus.parkendeAutos.isEmpty()){
                    IO.println("1 - cityParkhaus");
                }

                if (!magicParkhaus.parkendeAutos.isEmpty()){
                    IO.println("2 - magicParkhaus");
                }

                int parkhausWal = scanner.nextInt();
                scanner.nextLine();

                if  (parkhausWal == 1) {
                    cityParkhaus.zeigeAlleAtos();
                    IO.println("Welche ID soll ausgeparkt werden?");
                    int idAusparken1 = scanner.nextInt();
                    scanner.nextLine();
                    for (Auto auto : cityParkhaus.parkendeAutos) {
                        if (auto.getId() == idAusparken1) {
                            nichtGeparkteAutos.add(auto);
                        }
                    }
                    cityParkhaus.autoAusparkenNachID(idAusparken1);

                }
                else if (parkhausWal == 2) {
                    magicParkhaus.zeigeAlleAtos();
                    IO.println("Welche ID soll ausgeparkt werden?");
                    int idAusparken2 = scanner.nextInt();
                    scanner.nextLine();
                    for (Auto auto : cityParkhaus.parkendeAutos) {
                        if (auto.getId() == idAusparken2) {
                            nichtGeparkteAutos.add(auto);
                        }
                    }
                    magicParkhaus.autoAusparkenNachID(idAusparken2);
                }
                else {
                    IO.println("Undefinierte eingabe");
                }
                break;

            case 3:
                //Auto umparken // ps hier gibt es noch probleme!
                for (Auto auto : alleAutos){
                    IO.print("ID: ");
                    IO.println(auto.getId());
                }

                IO.println("Welche ID soll umparken?");
                int idUmparken = scanner.nextInt();
                scanner.nextLine();

                for (Auto auto : alleAutos){
                    if (idUmparken == auto.getId()){                                    // alle autos nach dem korektem auto objekt durchsuchen
                        Auto gesuchtAuto = auto;
                        if (cityParkhaus.parkendeAutos.contains(gesuchtAuto)){          // ist das gesucht auto in city?
                            cityParkhaus.ausparken(auto);
                            magicParkhaus.einparken(auto);
                            IO.println("Auto wurde aus City Parkhaus umgeparkt");
                            break;
                        } else if (magicParkhaus.parkendeAutos.contains(gesuchtAuto)) { // oder ist das gesuchte auto in magic?
                            magicParkhaus.ausparken(auto);
                            cityParkhaus.einparken(auto);
                            IO.println("Auto wurde aus Magic Parkhaus umgeparkt");
                            break;
                        }
                        else {
                            IO.println("Auto mit der ID in keinem parkhaus gefunden");  // oder in keinem parkhaus
                            break;
                        }
                    }
                }


/*
                for (Auto auto : cityParkhaus.parkendeAutos){   //Auto im city suchen?(funktioniert nicht)
                    if (auto.getId() == idUmparken){            //umparken von city nach magic
                        cityParkhaus.ausparken(auto);
                        magicParkhaus.einparken(auto);
                        IO.println("Auto wurde aus City Parkhaus umgeparkt");
                    }
                }

                for (Auto auto : magicParkhaus.parkendeAutos){  // Auto in magic suchen?
                    if (auto.getId() == idUmparken){            //umparken von magic nach city
                        magicParkhaus.ausparken(auto);
                        cityParkhaus.einparken(auto);
                        IO.println("Auto wurde aus Magic Parkhaus umgeparkt");
                    }
                }
                break;
*/


            case 4:
                //Alle Autos anzeigen
                IO.println("Es existieren Autos mit ");
                for (Auto auto : alleAutos){
                    IO.println("ID: " + auto.getId());
                }

                if (debug) {
                    IO.println(" in alleAutos");
                }

                IO.println("Es existieren Autos mit ");
                for (Auto auto : cityParkhaus.parkendeAutos){
                    IO.println("ID: " + auto.getId());
                }

                if (debug) {
                    IO.println("in cityParkhaus");
                }

                IO.println("Es existieren Autos mit ");
                for (Auto auto : magicParkhaus.parkendeAutos){
                    IO.println("ID: " + auto.getId());
                }
                if (debug) {
                    IO.println("in magicParkhaus");
                }

                break;

            case 5:
                //Beenden
                IO.println("Auf Wiedersehen <3 ");
                running = false;
                break;

            default:
                IO.println("Ungültige eingabe");
        }
    }

}

/**
 * Die Metode autosErzeugen erzeugt ein auto objeckt in dem parkhaus magic
 *
 * @param magicParkhaus das parkhaus in dem das erzeugte auto geparkt wird
 * @param autoFactory autoFactory erzeugt das auto objekt
 */
Object autosErzeugen(Parkhaus magicParkhaus,AutoFactory autoFactory) {
    magicParkhaus.einparken(autoFactory.createAuto());
    return autoFactory;
}
