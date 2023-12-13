/**
 *
 * @author Eng Ossama Samir
 */

package com.mycompany.examsite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class student extends user {
    // scannser
    Scanner scanner = new Scanner(System.in);
    String examfile = "D:\\exams.txt";//replace this path
    //-registedSubject:List
    List<String> registedSubject = new ArrayList();

    //-examTaken:List
    Map<String, String> examTaken = new HashMap<>();

    public student(){
    }

    //+showDegree()
    public void showDegree(){
        for (Map.Entry<String, String> entry : examTaken.entrySet()) {
            System.out.println("Student: " + entry.getKey() + ", Exam: " + entry.getValue());
        }
    }

    //+accessExam()
    public void accessExam(String exam){
        String Grade = "";
        List<String>ex = selectLines(this.examfile,exam);
        System.out.println("Subject : "+ex.get(0));
        System.out.println("Question : "+ex.get(1));
        System.out.println("Choose 1: : "+ex.get(2));
        System.out.println("Choose 2 : "+ex.get(3));
        System.out.println("Please Write The Correct Answer");
        String rans = scanner.next();
        if(ex.get(4).equals(rans)){
            examTaken.put(exam,"20 from 20");
            System.out.println("Wow ! 20/20\n-------------------------------");
        }else{
            examTaken.put(exam,"0 from 20");
            System.out.println("Try Again\n-------------------------------");

        }

    }

    //+assignedSubject()
    public void assignedSubject(String subjectName) {
        registedSubject.add(subjectName);
    }

    //+seeAllAssignedSubject
    public void seeAllAssignedSubject(){
        for (String element : registedSubject) {
            System.out.println("Subject : "+element);
        }
        System.out.println("*************************************");
    }

    private List<String> selectLines(String fileName,String firstLine) {
        List<String> ex = new ArrayList<>();
        int linesToSelect = 5;
        boolean found = false;

        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null && linesToSelect > 0) {
                if (line.trim().equalsIgnoreCase(firstLine)) {
                    found = true;
                    ex.add(line);
                    linesToSelect--; // Reduce the lines to select

                    // Continue reading and printing next lines
                    while ((line = bufferedReader.readLine()) != null && linesToSelect > 0) {
                        ex.add(line);
                        linesToSelect--;
                    }
                    break;
                }
            }

            bufferedReader.close();

            if (!found) {
                System.out.println("The line  was not found.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return ex;
    }
}
