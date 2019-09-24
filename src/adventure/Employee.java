package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Employee {

    String activityName;
    String employeeName;
    boolean bookedOrNot;
    List<String> activtyList = new ArrayList<String>();
    Scanner sc = new Scanner(System.in);

    public void addActivty(){
        System.out.println("You have chosen to add an activity\nType in the name of the new activity");
        activityName = sc.nextLine();
        System.out.println("You have created " + activityName);
        activtyList.add(activityName);


    }




}
