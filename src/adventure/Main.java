package adventure;

public class Main {


    public static void main(String[] args) {

        //Aktiviteterne oprettes

        Activity a = new Activity();

        Activity activity1 = new Activity("Fodbold", 200, 20, "Spille_Fodboold", false);
        Activity activity2 = new Activity("Basketbold", 200, 20, "Spille_Basket", false);
        Activity activity3 = new Activity("Håndbold", 200, 20, "Spille_håndbold", false);
        Activity activity4 = new Activity("Esport", 200, 20, "Spille_pc", false);
        Activity activity5 = new Activity("Cricket", 200, 20, "spille_cricket", false);

        //Aktiviteterne tilføjes til Arraylisten activityList
        a.getActivityList().add(activity1);
        a.getActivityList().add(activity2);
        a.getActivityList().add(activity3);
        a.getActivityList().add(activity4);
        a.getActivityList().add(activity5);

        //Hovedmenuen instatieres og køres

        Menu menu = new Menu();

        while(menu.mainMenu()){
        }
    }
}