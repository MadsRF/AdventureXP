package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Instructor {

    private String name;
    private String speciality;
    private Scanner scan = new Scanner(System.in);
    List<Instructor> instructorList = new ArrayList<>();


    public Instructor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public Instructor() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public List<Instructor> getInstructorList() {
        return instructorList;
    }

    public void setInstructorList(List<Instructor> instructorList) {
        this.instructorList = instructorList;
    }

    public void createInstructor() {
        try {
            System.out.println("Name?");
            this.name = scan.next();
            System.out.println("Preferred activity");
            this.speciality = scan.next();
            instructorList.add(new Instructor(name, speciality));
            saveInstructorFile();
        }catch(Exception e){
            System.out.println("Something went wrong creating an Instructor");
        }
    }

    public void readInstructorFile(){
        File f = new File("C:\\Users\\madsr\\IdeaProjects\\AdventureXP\\src\\Instructor");
        try {
            Scanner s = new Scanner(f);
            instructorList.clear();
            while (s.hasNext()) {
                String name = s.nextLine();
                String speciality = s.nextLine();

                Instructor i = new Instructor(name, speciality);
                instructorList.add(i);

                for (Instructor j: instructorList){
                    System.out.println(j.getName()+" "+j.getSpeciality());
                }
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong reading the instructor file");
        }
    }

    public void saveInstructorFile() throws FileNotFoundException {
        PrintStream output = new PrintStream(new FileOutputStream("C:\\Users\\madsr\\IdeaProjects\\AdventureXP\\src\\Instructor", true));
        for (Instructor i : instructorList) {
            output.println(i.getName()+" "+i.getSpeciality());
        }
        System.out.println();
    }

    public void updateInstructor(){

    }

    public void deleteInstructor(){

    }

}


