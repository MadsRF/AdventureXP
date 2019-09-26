package adventure;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Booking {

    private int startTime;
    private int endTime;
    private String date;
    private String instructor;
    private int bookingNumber;
    private int numberOfParticipant;
    private String activityName;

    private static ArrayList<Booking> bookingList = new ArrayList<>();

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

    Scanner scan = new Scanner(System.in);
    Activity activity = new Activity();
    public void searchBooking(){


    }

    ////////////

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

                Booking b = new Booking(startTime, endTime, date, numberOfParticipant, activityName);
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
        }

    }
}
