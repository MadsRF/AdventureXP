package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Activity {

    private String activityName;
    private int price;
    private int requiredAge;
    private String description;

    boolean bookedOrNot;


    List<Activity> activityList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);


    public Activity() {
    }

    public Activity(String activityName, int price, int requiredAge, String description) {
        this.activityName = activityName;
        this.price = price;
        this.requiredAge = requiredAge;
        this.description = description;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public boolean isBookedOrNot() {
        return bookedOrNot;
    }

    public void setBookedOrNot(boolean bookedOrNot) {
        this.bookedOrNot = bookedOrNot;
    }

    public List<Activity> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<Activity> activityList) {
        this.activityList = activityList;
    }

    public void addActivity(){

        System.out.println("You have chosen to add an activity\nType in the name of the new activity");
        activityName = sc.nextLine();
        System.out.println("You have created " + activityName + "\n");
        System.out.println("Choose a price:");
        price = sc.nextInt();
        System.out.println("Choose a required age: ");
        requiredAge = sc.nextInt();
        System.out.println("Write a short description");
        description = sc.next();
        activityList.add(new Activity(activityName, price, requiredAge, description));

    }

    public void readActivityList(){
        System.out.println("Loading activity list");
        for (Activity s: activityList){
            System.out.println("Activity name: " + s.getActivityName() + "\nPrice : " + s.getPrice() + "\nRequired age: " + s.getRequiredAge() + "\nDescription: " + s.getDescription());
        }

    }
}
