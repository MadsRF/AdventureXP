package adventure;

public class Main {


    public static void main(String[] args) {

        //Aktivitet objekt instansieres
        Activity a = new Activity();
        //Booking objekt instansieres
        Booking b = new Booking();

        //Hovedmenuen instatieres og køres
        Menu menu = new Menu();

        //Aktiviteterne hentes fra filen
        a.activityReadFromFile();
        //Bookingerne hentes fra filen
        b.bookingReadFromFile();

        //Hovedmenuen vises på konsollen

        while(menu.mainMenu()){
        }
    }
}