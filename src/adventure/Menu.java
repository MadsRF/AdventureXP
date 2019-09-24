package adventure;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    public void mainMenu(){
        Activity activity = new Activity();
        Scanner scan = new Scanner(System.in);

        System.out.println("Press 1 - View activities");
        System.out.println("Press 2 - Create new activity");

        switch(scan.nextInt()){
            case 1:
                printList(activity.getActivityList());
                break;

            case 2:
                activity.addActivity();
                break;

            default:
                System.out.println("Enter a valid number from the menu");
        }
    }

    public void printList(ArrayList<Activity> list){
        for(Activity a : list){
            System.out.println("Activity name: " + a.getActivityName());
            System.out.println("Price: " + a.getPrice());
            System.out.println("Minimum age: " + a.getRequiredAge());
            System.out.println("Description: " + a.getDescription());
        }
    }
}
