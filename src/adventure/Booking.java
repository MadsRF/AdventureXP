package adventure;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Booking {

    //Variabler til bookinger
    private int startTime;
    private int endTime;
    private String date;
    private String instructor;
    private int bookingNumber;
    private int numberOfParticipant;
    private String activityName;

    //Arraylist, som opbevarer bookinger

    private static ArrayList<Booking> bookingList = new ArrayList<>();
    //Getters og setters
    public List<Booking> getbookingList() {
        return bookingList;
    }

    public void setbookingList(List<Activity> activityList) {
        this.bookingList = bookingList;
    }

    public int getBookingNumber() {
        return bookingNumber;
    }

    public void setBookingNumber(int bookingNumber) {
        this.bookingNumber = bookingNumber;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public static ArrayList<Booking> getBookingList() {
        return bookingList;
    }

    public static void setBookingList(ArrayList<Booking> bookingList) {
        Booking.bookingList = bookingList;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public int getNumberOfParticipant() {
        return numberOfParticipant;
    }

    public void setNumberOfParticipant(int numberOfParticipant) {
        this.numberOfParticipant = numberOfParticipant;
    }

    Random random = new Random();

    //Konstruktører til bookings

    public Booking() {
    }

    public Booking(int startTime, int endTime, String date, int numberOfParticipant, String activityName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.numberOfParticipant = numberOfParticipant;
        this.activityName = activityName;
        this.instructor = "Peter";
        this.bookingNumber = random.nextInt(99998)+1;
    }

    //Scanner oprettes til at læse bruger input

    Scanner scan = new Scanner(System.in);

    //Aktivitet instansieres
    Activity activity = new Activity();

    //Metode til at finde en booking
    public Booking searchBooking(){
        System.out.println("Enter booking ID");
        bookingNumber = scan.nextInt();
        for (Booking b : bookingList){
            if(bookingNumber == b.getBookingNumber()){
                System.out.println("Booking found");
                System.out.println();
                System.out.println("Activity name: " + b.getActivityName());
                System.out.println("Start time: " + b.getStartTime());
                System.out.println("End time: " + b.getEndTime());
                System.out.println("Date: " + b.getDate());
                System.out.println("Number of participants: " + b.getNumberOfParticipant());
                System.out.println("Instructor: " + b.getInstructor());
                System.out.println("Booking number: " + b.getBookingNumber());

                return b;
            }
            else {
                System.out.println("Nothing found");

            }
        }
        return null;
    }

    //Metode til at se alle bookinger fra bookingList
    public void viewBookings(){
        for (Booking b : bookingList){
            System.out.println("\nActivity name: " + b.getActivityName());
            System.out.println("Start time: " + b.getStartTime());
            System.out.println("End time: " + b.getEndTime());
            System.out.println("Date: " + b.getDate());
            System.out.println("Number of participants: " + b.getNumberOfParticipant());
            System.out.println("Instructor: " + b.getInstructor());
            System.out.println("Booking number: " + b.getBookingNumber() + "\n");

            }

    }

    //Metode som sletter en booking

    public void deleteBooking() {
        Booking b = searchBooking();
        System.out.println("Do you wish to delete booking ID: " + b.getBookingNumber() + "\nyes/no");
        String run = "run";
        String answer = scan.next();

        while (!run.equals("stop")){
            if (answer.equals("yes")){
                System.out.println("Booking of " + b.getActivityName() + " with the ID: " + b.getBookingNumber() + " has now been deleted.");
                bookingList.remove(b);
                run = "stop";
            }
            else if (answer.equals("no")){
                System.out.println(b.getBookingNumber() + " has not been deleted.");
            }
            else {
                System.out.println("Wrong input");
            }
        }
    }
    
    //Metode som opretter en booking

    public void createBooking(){
        activity.readActivityList();
        System.out.println("Choose activity");
        String activityName = scan.next();

        for (Activity a : activity.getActivityList()){
            if(activityName.toLowerCase().equals(a.getActivityName().toLowerCase())){
                System.out.println("Pick start time");
                startTime = scan.nextInt();
                System.out.println("Pick end time");
                endTime = scan.nextInt();
                System.out.println("Pick date");
                date = scan.next();
                System.out.println("How many participants?");
                numberOfParticipant = scan.nextInt();

                Booking b = new Booking(startTime, endTime, date, numberOfParticipant, a.getActivityName());
                System.out.println("Activity name: " + b.getActivityName());
                System.out.println("Start time: " + b.getStartTime());
                System.out.println("End time: " + b.getEndTime());
                System.out.println("Date: " + b.getDate());
                System.out.println("Number of participants: " + b.getNumberOfParticipant());
                System.out.println("Instructor: " + b.getInstructor());
                System.out.println("Booking number: " + b.getBookingNumber());

                System.out.println("Are you sure? yes or no");
                String answer = scan.next().toLowerCase();
                if (answer.equals("yes")){
                    bookingList.add(b);
                    a.setBookedOrNot(true);
                }

            }
            else {
                System.out.println("This activity doesn't exist.");
                break;
            }
        }
    }
}
