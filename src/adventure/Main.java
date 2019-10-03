package adventure;

public class Main {


    public static void main(String[] args) {

        //Aktivitet objekt instansieres
        Activity a = new Activity();
        //Booking objekt instansieres
        Booking b = new Booking();

        //Hovedmenuen instatieres og køres
        Menu menu = new Menu();

        a.activityReadFromFile();
        b.bookingReadFromFile();

        while(menu.mainMenu()){
        }
    }
}