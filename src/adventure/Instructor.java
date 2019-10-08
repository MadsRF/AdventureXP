package adventure;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Instructor {

    //Variabler for Instructor
    private String name;
    private String speciality;
    private Scanner scan = new Scanner(System.in);
    List<Instructor> instructorList = new ArrayList<>();

    //Konstruktører
    public Instructor(String name, String speciality) {
        this.name = name;
        this.speciality = speciality;
    }

    public Instructor() {
    }

    //Getters & setters
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

    //Metode til at oprette en ny instruktør
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

    //Metode til at hente alle instruktører fra filen
    public void readInstructorFile(){
        File f = new File("Instructor");
        try {
            Scanner s = new Scanner(f);
            instructorList.clear();
            while (s.hasNext()) {
                String name = s.next();
                String speciality = s.next();

                Instructor i = new Instructor(name, speciality);
                instructorList.add(i);
            }
            for (Instructor j: instructorList) {
                System.out.println(j.getName() + " " + j.getSpeciality());
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong reading the instructor file");
        }
    }

    //Metode til at skrive alle instruktørerne ind i filen
    public void saveInstructorFile() throws FileNotFoundException {
        PrintStream output = new PrintStream(("Instructor"));
        output.println("");

        PrintStream output1 = new PrintStream(new FileOutputStream("Instructor", true));
        for (Instructor i : instructorList) {
            output1.println(i.getName()+" "+i.getSpeciality());
        }
        System.out.println();
    }

    public void updateInstructor(){

    }

    public void deleteInstructor(){

    }

}


