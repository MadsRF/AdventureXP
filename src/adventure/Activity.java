package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Activity {

    String activityName;
    boolean bookedOrNot;
    List<String> activtyList = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public void addActivty(){
        System.out.println("You have chosen to add an activity\nType in the name of the new activity");
        activityName = sc.next();
        System.out.println("You have created " + activityName);
        activtyList.add(activityName);

    }

}
