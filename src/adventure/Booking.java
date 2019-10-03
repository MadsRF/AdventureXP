package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
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

    public Booking() {
    }

    public Booking(int startTime, int endTime, String date, int numberOfParticipant, String activityName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.instructor = "Peter";
        this.numberOfParticipant = numberOfParticipant;
        this.activityName = activityName;
        this.bookingNumber = random.nextInt(99998)+1;
    }

    public Booking(int startTime, int endTime, String date, String instructor, int bookingNumber, int numberOfParticipant, String activityName) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.date = date;
        this.instructor = instructor;
        this.bookingNumber = bookingNumber;
        this.numberOfParticipant = numberOfParticipant;
        this.activityName = activityName;
    }

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
            else if (bookingNumber != b.getBookingNumber()){

            }
        }
        return null;
    }

    //Metode til at se alle bookinger fra bookingList
    public void viewBookingsAsEmployee(){
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
    public void viewBookingsAsCustomer(){
        for (Booking b : bookingList){
            System.out.println("\nActivity name: " + b.getActivityName());
            System.out.println("Start time: " + b.getStartTime());
            System.out.println("End time: " + b.getEndTime());
            System.out.println("Date: " + b.getDate());
            System.out.println("Number of participants: " + b.getNumberOfParticipant());
            System.out.println("Instructor: " + b.getInstructor());
        }

    }


    //Metode som sletter en booking

    public void deleteBooking() {
        try {
        Booking b = searchBooking();
        System.out.println("Do you wish to delete booking ID: " + b.getBookingNumber() + "\nyes/no");
        String run = "run";
        String answer = scan.next();

        while (!run.equals("stop")){
            if (answer.equals("yes")){
                System.out.println("Booking of " + b.getActivityName() + " with the ID: " + b.getBookingNumber() + " has now been deleted.");
                bookingList.remove(b);
                try{
                    bookingWriteToFile();
                }
                catch (Exception e){
                    System.out.println("Failed to write to file");
                }
                run = "stop";
            }
            else if (answer.equals("no")){
                System.out.println(b.getBookingNumber() + " has not been deleted.");
            }
            else {
                System.out.println("Wrong input");
            }
        } } catch (Exception e) {
            System.out.println("No booking ID found.");
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
                    try{
                        bookingWriteToFile();
                    }
                    catch (Exception e){
                        System.out.println("Failed to write to file");
                    }
                }
            }

        }
    }

    @Override
    public String toString(){
        return getStartTime() + ";" + getEndTime() + ";" + getDate() + ";" + getInstructor() + ";" + getBookingNumber() + ";" + getNumberOfParticipant() + ";" + getActivityName();
    }

    public void bookingWriteToFile()throws FileNotFoundException {

        PrintStream pss = new PrintStream("Bookings");
        PrintStream ps = new PrintStream(new FileOutputStream("Bookings", true));
        pss.print("");

        for (Booking b : getbookingList()){
            ps.println(b.toString());
        }
    }

    public void bookingReadFromFile(){
        File f = new File("Bookings");
        try {
            Scanner s = new Scanner(f);
            bookingList.clear();
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] info = line.split(";");
                Booking booking = new Booking(Integer.parseInt(info[0]), Integer.parseInt(info[1]), info[2], info[3], Integer.parseInt(info[4]), Integer.parseInt(info[5]), info[6]);
                bookingList.add(booking);
            }
        }
        catch (Exception e){
            //who cares
        }
    }
}
