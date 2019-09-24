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

    public boolean deleteActivity(String activityName){
        for (Activity activity : activityList){
            if(activity.getActivityName().equals(activityName)){
                activityList.remove(activity);
                System.out.println("The activity: " + activity.getActivityName() + " was deleted");
                return true;
            }
        }
        System.out.println("Couldn't find an activity with the name: " + activityName);
        return false;
    }

    public boolean editActivity(String activityName){
        Scanner scan = new Scanner(System.in);
        for (Activity activity: activityList){
            if(activity.getActivityName().equals(activityName)){
                System.out.println("Press 1 - Edit name: " + activity.getActivityName());
                System.out.println("Press 2 - Edit price: " + activity.getPrice());
                System.out.println("Press 3 - Edit minimum age: " + activity.getRequiredAge());
                System.out.println("Press 4 - Edit description" + activity.getDescription());
                switch (scan.nextInt()){
                    case 1:
                        System.out.println("Type the new name");
                        activity.setActivityName(scan.nextLine());
                        break;
                    case 2:
                        System.out.println("Type the new price");
                        activity.setPrice(scan.nextInt());
                        break;
                    case 3:
                        System.out.println("Type the new minimum age");
                        activity.setRequiredAge(scan.nextInt());
                        break;
                    case 4:
                        System.out.println("Type the new description");
                        activity.setDescription(scan.nextLine());
                        break;
                }
                System.out.println("The change is completed");
                return true;
            }
        }
        System.out.println("Couldn't find an activity with the name: " + activityName);
        return false;
    }


}
