package adventure;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    //Variabler for Menu
    private String username = "admin";
    private String password = "password";
    private Scanner sc = new Scanner(System.in);
    private String answer;
    private String answer2;
    Activity activity = new Activity();
    Booking booking = new Booking();

    //Metode til hovedmenuen, som bliver kaldt når main() metoden bliver kørt i Main
    //Vi har lavet en seperat klasse til den for at gøre Main klassen mere overskuelig
    public boolean mainMenu() {

            Scanner scan = new Scanner(System.in);


            System.out.println("PRESS 1 - For EMPLOYEE page");
            System.out.println("PRESS 2 - For COSTUMER page");

            String choice = sc.next();

            // admin menu

            if (choice.equals("1")) {


                //very simple hardcoded "login" page
                System.out.println("USERNAME:");
                answer = sc.next();
                System.out.println("PASSWORD:");
                answer2 = sc.next();

                if (answer.equals(username) && (answer2.equals(password))) {

                    while (true) {

                        System.out.println("\n\nPRESS 0 - For exit");
                        System.out.println("_________________");
                        System.out.println("OPTIONS FOR ACTIVITIES");

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
                                booking.viewBookingsAsEmployee();
                                break;

                            default:
                                System.out.println("Enter a valid number from the menu");
                                return true;

                        }

                    }
                } else {
                    System.out.println("USERNAME OR PASSWORD INCORRECT\nTRY AGAIN");
                    mainMenu();
                }

            }
            // customer menu.
            else if (choice.equals("2")) {
                while (true) {
                    System.out.println("\n\nPRESS 0 - For exit");
                    System.out.println("_________________");
                    System.out.println("OPTIONS FOR ACTIVITIES");

                    System.out.println("PRESS 1 - View activities");

                    System.out.println("\nOPTIONS FOR BOOKINGS");

                    System.out.println("PRESS 2 - Create new booking");
                    System.out.println("PRESS 3 - Search for a booking");
                    System.out.println("PRESS 4 - Delete a booking");
                    System.out.println("PRESS 5 - View all bookings");
                    switch (sc.nextInt()) {
                        case 0:
                            System.out.println("Exiting program...");
                            return false;

                        case 1:
                            activity.readActivityList();
                            break;

                        case 2:
                            booking.createBooking();
                            break;

                        case 3:
                            booking.searchBooking();
                            break;

                        case 4:
                            booking.deleteBooking();
                            break;

                        case 5:
                            booking.viewBookingsAsCustomer();
                            break;

                        default:
                            System.out.println("Enter a valid number from the menu");
                            return true;


                    }
                }
            }
        return true;
    }
}
