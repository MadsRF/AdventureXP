package adventure;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {

    public boolean mainMenu() {
        Activity activity = new Activity();
        Scanner scan = new Scanner(System.in);

        System.out.println("Press 1 - For exit");
        System.out.println("Press 2 - View activities");
        System.out.println("Press 3 - Create new activity");
        System.out.println("Press 4 - Edit activity");
        System.out.println("Press 5 - Delete activity");

        switch (scan.nextInt()) {
            case 1:
                return false;
            case 2:
                activity.readActivityList();
                break;

            case 3:
                activity.addActivity();
                break;

            case 4:
                activity.editActivity();
                break;
            case 5:
                activity.deleteActivity();

            default:
                System.out.println("Enter a valid number from the menu");

        }return true;
    }
}
