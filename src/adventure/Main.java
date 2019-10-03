package adventure;

public class Main {


    public static void main(String[] args) {

        //Aktivitet objekt instansieres
        Activity a = new Activity();
        //Booking objekt instansieres
        Booking b = new Booking();

        Instructor i = new Instructor();

        i.readInstructorFile();
        i.createInstructor();
        i.readInstructorFile();

        //Hovedmenuen instatieres og køres
        Menu menu = new Menu();

        a.activityReadFromFile();
        b.bookingReadFromFile();

        while(menu.mainMenu()){
        }
    }
}