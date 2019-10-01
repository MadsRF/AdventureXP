package adventure;

public class Main {


    public static void main(String[] args) {

        Activity a = new Activity();
        Booking b = new Booking();

        Activity activity1 = new Activity("Fodbold", 200, 20, "Spille_Fodboold", false);
        Activity activity2 = new Activity("Basketbold", 200, 20, "Spille_Basket", false);
        Activity activity3 = new Activity("Håndbold", 200, 20, "Spille_håndbold", false);
        Activity activity4 = new Activity("Esport", 200, 20, "Spille_pc", false);
        Activity activity5 = new Activity("Cricket", 200, 20, "spille_cricket", false);

        Booking booking1 = new Booking(1230, 1330, "01-10-2019", 4, "Fodbold");
        Booking booking2 = new Booking(1330, 1430, "01-10-2019", 32, "Håndbold");
        Booking booking3 = new Booking(1430, 1530, "01-10-2019", 11, "Esport");
        Booking booking4 = new Booking(1530, 1630, "01-10-2019", 34, "Cricket");
        Booking booking5 = new Booking(1630, 1730, "01-10-2019", 27, "Basketbold");


        a.getActivityList().add(activity1);
        a.getActivityList().add(activity2);
        a.getActivityList().add(activity3);
        a.getActivityList().add(activity4);
        a.getActivityList().add(activity5);

        b.getbookingList().add(booking1);
        b.getbookingList().add(booking2);
        b.getbookingList().add(booking3);
        b.getbookingList().add(booking4);
        b.getbookingList().add(booking5);

        Menu menu = new Menu();

        while(menu.mainMenu()){
        }
    }
}