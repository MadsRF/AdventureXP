package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public boolean mainMenu() {
        Activity activity = new Activity();
        Booking booking = new Booking();
        Scanner scan = new Scanner(System.in);

        System.out.println("Press 1 - For exit");
        System.out.println("_________________");
        System.out.println("\nOPTIONS FOR ACTIVITIES");

        System.out.println("Press 2 - View activities");
        System.out.println("Press 3 - Create new activity");
        System.out.println("Press 4 - Edit activity");
        System.out.println("Press 5 - Delete activity");

        System.out.println("\nOPTIONS FOR BOOKINGS");

        System.out.println("Press 6 - Create new booking");
        System.out.println("Press 7 - Search for a booking");
        System.out.println("Press 8 - Delete a booking");
        System.out.println("Press 9 - View all bookings");

        switch (scan.nextInt()) {
            case 1:
                return false;
            case 2:
                activity.readActivityList();
                break;

            case 3:
                activity.addActivity();
                break;

            case 4:
                activity.editActivity();
                break;
            case 5:
                activity.deleteActivity();
                break;
            case 6:
                booking.createBooking();
                break;
            case 7:
                booking.searchBooking();
                break;
            case 8:
                booking.deleteBooking();
                break;
            case 9:
                booking.viewBookings();
                break;



            default:
                System.out.println("Enter a valid number from the menu");
                return true;

        }return true;
    }
}
