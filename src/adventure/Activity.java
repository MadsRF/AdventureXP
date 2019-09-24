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

    List<String> activityList = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);


    public Activity() {
    }

    public Activity(String activityName, int price, int requiredAge, String description, boolean bookedOrNot) {
        this.activityName = activityName;
        this.price = price;
        this.requiredAge = requiredAge;
        this.description = description;
        this.bookedOrNot = bookedOrNot;
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

    public List<String> getActivityList() {
        return activityList;
    }

    public void setActivityList(List<String> activityList) {
        this.activityList = activityList;
    }

    public void addActivity(){
        System.out.println("You have chosen to add an activity\nType in the name of the new activity");
        activityName = sc.next();
        System.out.println("You have created " + activityName);
        activityList.add(activityName);

    }

    public void readActivityList(){
        System.out.println("Loading activity list");
        for (String s: activityList){
            System.out.println(s);
        }


    }

}
