package BetygReg;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class CourseAdmin {

    private  String findFile = null;
    private  ArrayList<String> list;

    public void getCourse() throws FileNotFoundException{
        Scanner sc = new Scanner(System.in);
        CourseList cList = new CourseList();

        //Hämtar listan över kurser
        //findFile = "courseID.txt";
        //String content = new Scanner(new File(findFile)).useDelimiter("\\Z").next();
        //Filens innehåll --> array
        //list = new ArrayList<>(Arrays.asList(content.split("\n")));
        while(true) {
            //System.out.println(list);
            //System.out.println("Which course would you like to view?\nIf you would like to end the session write \"end\".");
            //Välj relevant
            //String cID = sc.nextLine();
            //cID = cID.toUpperCase();
            StudentList sList = new StudentList();
            //Grade grade = new Grade();
            if (cID.toUpperCase().equals("END")) {
                if (sList.getList() == null) {
                    System.exit(1);
                }
                sList.getStudent().getGrade().saveGrade(sList.getList());
                System.out.println(sList.getStudent().getGrade());
            }
            //Hämta studenter
            if (list.contains(cID)) {
                sList.getRelevant(cID);
            } else {
                System.out.println("ERROR 404! Course not found.");
            }
        }
        public
    }
}