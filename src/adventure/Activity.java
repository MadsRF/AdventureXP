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

    private  static List<Activity> activityList = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);
    private Scanner sc1 = new Scanner(System.in);


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
        description = sc1.nextLine();
        bookedOrNot = false;

        activityList.add(new Activity(activityName, price, requiredAge, description, bookedOrNot));

    }

    public void readActivityList(){

        System.out.println("Loading activity list");
        for (Activity s: activityList){

            if(s.bookedOrNot) {
                System.out.println("Activity name: " + s.getActivityName() + "\nPrice : " + s.getPrice() + "\nRequired age: " + s.getRequiredAge() + "\nDescription: " + s.getDescription() + "\nAvailable: Booked\n");
            }else{
                System.out.println("Activity name: " + s.getActivityName() + "\nPrice : " + s.getPrice() + "\nRequired age: " + s.getRequiredAge() + "\nDescription: " + s.getDescription() + "\nAvailable: Unbooked\n");
            }

        }
    }

    public boolean deleteActivity(){
        System.out.println("Type the activity name");
        String activityName = sc.nextLine();
        for (Activity activity : activityList){
            if(activity.getActivityName().toLowerCase().equals(activityName.toLowerCase())){
                activityList.remove(activity);
                System.out.println("The activity: " + activity.getActivityName() + " was deleted");
                return true;
            }
        }
        System.out.println("Couldn't find an activity with the name: " + activityName);
        return false;
    }

    public boolean editActivity(){
        System.out.println("Type the activity name");
        String activityName = sc.nextLine();
        for (Activity activity: activityList){
            if(activity.getActivityName().toLowerCase().equals(activityName.toLowerCase())){
                System.out.println("Press 1 - Edit name: " + activity.getActivityName());
                System.out.println("Press 2 - Edit price: " + activity.getPrice());
                System.out.println("Press 3 - Edit minimum age: " + activity.getRequiredAge());
                System.out.println("Press 4 - Edit description" + activity.getDescription());
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
                System.out.println("The change is completed");
                return true;
            }
        }
        System.out.println("Couldn't find an activity with the name: " + activityName);
        return false;
    }

    public void bookActivity(){

        description = null;

        readActivityList();

        System.out.println("Which activity do you wish to book?");

        String answer = sc.next();

        for (Activity a: activityList){
            if (a.getActivityName().equals(answer)){
                System.out.println("You have chosen to book " + a.getActivityName());
                a.setBookedOrNot(true);
            }

        }
        readActivityList();

    }


}
