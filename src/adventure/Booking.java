package adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Booking {

    private int bookingNumber;

    private static ArrayList<Booking> bookingList = new ArrayList<>();

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public static ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public static void setBookingList(ArrayList<Booking> bookingList) {
        Booking.bookingList = bookingList;
    }

    Scanner scan = new Scanner(System.in);

    public void searchBooking(){
        System.out.println("Enter booking ID");
        bookingNumber = scan.nextInt();
        for (Booking b : bookingList){
            if(bookingNumber == b.bookingNumber){
                System.out.println("Booking found");
                System.out.println();
                System.out.println("Activity Name: " + b.getActivityName() + "Date: " + b.getDate() + "\nStart time: " + b.getStartTime() + "\nEnd time: " + b.getEndTime());
            }
        }
    }
    
    ////////////
}
