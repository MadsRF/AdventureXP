package adventure;

public class Main {


    public static void main(String[] args) {

        //Aktivitet objekt instansieres
        Activity a = new Activity();
        //Booking objekt instansieres
        Booking b = new Booking();

        //Hovedmenuen instatieres og køres
        Menu menu = new Menu();


        Instructor i = new Instructor();
        i.readInstructorFile();
        i.createInstructor();
        i.readInstructorFile();
        i.updateInstructor();
        i.readInstructorFile();
        i.deleteInstructor();
        i.readInstructorFile();

        //Aktiviteterne hentes fra filen
        a.activityReadFromFile();
        //Bookingerne hentes fra filen
        b.bookingReadFromFile();

        //Hovedmenuen vises på konsollen

        //while(menu.mainMenu()){
        //}
    }
}