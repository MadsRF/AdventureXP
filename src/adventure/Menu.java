package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //Metode til hovedmenuen, som bliver kaldt når main() metoden bliver kørt i Main
    //Vi har lavet en seperat klasse til den for at gøre Main klassen mere overskuelig

    public boolean mainMenu() {
        Activity activity = new Activity();
        Booking booking = new Booking();
        Scanner scan = new Scanner(System.in);

        System.out.println("\n\nPRESS 0 - For exit");
        System.out.println("_________________");
        System.out.println("\nOPTIONS FOR ACTIVITIES");

        System.out.println("PRESS 1 - View activities");
        System.out.println("PRESS 2 - Create new activity");
        System.out.println("PRESS 3 - Edit activity");
        System.out.println("PRESS 4 - Delete activity");

        System.out.println("\nOPTIONS FOR BOOKINGS");

        System.out.println("PRESS 5 - Create new booking");
        System.out.println("PRESS 6 - Search for a booking");
        System.out.println("PRESS 7 - Delete a booking");
        System.out.println("PRESS 8 - View all bookings");

        switch (scan.nextInt()) {
            case 0:
                System.out.println("Exiting program...");
                return false;
            case 1:
                activity.readActivityList();
                break;

            case 2:
                activity.addActivity();
                break;

            case 3:
                activity.editActivity();
                break;
            case 4:
                activity.deleteActivity();
                break;
            case 5:
                booking.createBooking();
                break;
            case 6:
                booking.searchBooking();
                break;
            case 7:
                booking.deleteBooking();
                break;
            case 8:
                booking.viewBookings();
                break;



            default:
                System.out.println("Enter a valid number from the menu");
                return true;

        }return true;
    }
}
