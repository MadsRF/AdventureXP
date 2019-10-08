package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.nio.charset.MalformedInputException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Activity {

    //Variabler for aktiviteter

    private String activityName;
    private double price;
    private int requiredAge;
    private String description;


    //Arraylisten activityList og input scannere oprettes

    private  static List<Activity> activityList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Scanner sc1 = new Scanner(System.in);

    //Konstruktører til aktivitetsinstanser
    public Activity() {
    }

    public Activity(String activityName, double price, int requiredAge, String description) {
        this.activityName = activityName;
        this.price = price;
        this.requiredAge = requiredAge;
        this.description = description;
    }

    //Getters og setters

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getRequiredAge() {
        return requiredAge;
    }

    public void setRequiredAge(int requiredAge) {
        this.requiredAge = requiredAge;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    //Metode som opretter en ny aktivitet. Den tjekker først, om aktiviteten findes allerede.

    public void addActivity(){
        try {
            System.out.println("You have chosen to add an activity");
            boolean nameCheck = true;
            while(nameCheck == true){
                System.out.println("Type in the name of the new activity");
                activityName = sc.next();
                nameCheck = false;
                for (Activity a : getActivityList()) {
                    if (activityName.equals(a.getActivityName())) {
                        System.out.println("This activity already exists.");
                        nameCheck = true;
                    }
                }
            }

            System.out.println("You have created " + activityName + "\n");
            System.out.println("Choose a price:");
            price = sc.nextDouble();
            System.out.println("Choose a required age: ");
            requiredAge = sc.nextInt();
            System.out.println("Write a short description");
            description = sc1.nextLine();

            activityList.add(new Activity(activityName, price, requiredAge, description));

            activityWriteToFile();
        }
        catch (FileNotFoundException e){
            System.out.println("Failed to save activities to file - file not found");
        }
        catch (InputMismatchException e){
            System.out.println("Wrong input, didn't save, try again");

        }

    }

    //Metode som viser aktiviteter, som ikke er booket

    public void readActivityList(){

        System.out.println("Loading activity list");
        for (Activity s: activityList){
            System.out.println("Activity name: " + s.getActivityName() + "\nPrice : " + s.getPrice() + "\nRequired age: " + s.getRequiredAge() + "\nDescription: " + s.getDescription() + "\n");
        }
    }

    //Metode som sletter aktiviteter
    public boolean deleteActivity(){
        System.out.println("Type the activity name");
        String activityName = sc.next();
        for (Activity activity : activityList){
            if(activity.getActivityName().toLowerCase().equals(activityName.toLowerCase())){
                activityList.remove(activity);

                try {
                    activityWriteToFile();
                }
                catch (Exception e){
                    System.out.println("Failed to save activities to file");
                }

                System.out.println("The activity: " + activity.getActivityName() + " was deleted");
                return true;
            }
        }
        System.out.println("Couldn't find an activity with the name: " + activityName);
        return false;
    }

    //Metode som redigerer aktiviteter
    public boolean editActivity(){
        System.out.println("Type the activity name");
        String activityName = sc.next();
        for (Activity activity: activityList){
            if(activity.getActivityName().toLowerCase().equals(activityName.toLowerCase())){
                System.out.println("Press 1 - Edit name: " + activity.getActivityName());
                System.out.println("Press 2 - Edit price: " + activity.getPrice());
                System.out.println("Press 3 - Edit minimum age: " + activity.getRequiredAge());
                System.out.println("Press 4 - Edit description " + activity.getDescription());
                System.out.println("Press 5 - Exit back to menu");
                switch (sc.nextInt()){
                    case 1:
                        System.out.println("Type the new name");
                        activity.setActivityName(sc.next());
                        break;
                    case 2:
                        System.out.println("Type the new price");
                        activity.setPrice(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("Type the new minimum age");
                        activity.setRequiredAge(sc.nextInt());
                        break;
                    case 4:
                        System.out.println("Type the new description");
                        activity.setDescription(sc1.nextLine());
                        break;
                    case 5:
                        return true;
                    default:
                        System.out.println("Wrong input");
                        return true;

                }

                try {
                    activityWriteToFile();
                }
                catch (Exception e){
                    System.out.println("Failed to save activities to file");
                }

                System.out.println("The change is completed");
                return true;
            }
        }
        System.out.println("Couldn't find an activity with the name: " + activityName);
        return false;
    }

    //Metode for at booke en aktivitet -- Bliver ikke brugt -- Den rigtige ligger i Booking.java
    /*public void bookActivity(){

        description = null;

        readActivityList();

        System.out.println("Which activity do you wish to book?");

        String answer = sc.next();

        for (Activity a: activityList){
            if (a.getActivityName().equals(answer)){
                System.out.println("You have chosen to book " + a.getActivityName());
            }

        }
        readActivityList();
    }*/

    //Metode som oversætter data om aktiviteter til String, som kan læses fra filen
    @Override
    public String toString(){
        return getActivityName() + ";" + getPrice() + ";" + getRequiredAge() + ";" + getDescription();
    }

    //Metode som skriver aktiviteter ind i aktivitetsfilen
    public void activityWriteToFile()throws FileNotFoundException {

        PrintStream pss = new PrintStream("Activities");
        PrintStream ps = new PrintStream(new FileOutputStream("Activities", true));
        pss.print("");
        for (Activity a : getActivityList()){
            ps.println(a.toString());
        }
    }

    //Metode som henter aktiviteterne fra filen og sætter dem ind i activityList
    public void activityReadFromFile(){
        File f = new File("Activities");
        try {
            Scanner s = new Scanner(f);
            activityList.clear();
            while (s.hasNextLine()) {
                String line = s.nextLine();
                String[] info = line.split(";");
                Activity a = new Activity(info[0], Double.parseDouble(info[1]), Integer.parseInt(info[2]), info[3]);
                activityList.add(a);
            }
        }
        catch (Exception e){
            //who cares
        }
    }

}
