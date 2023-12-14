/**
 *
 * @author Eng Ossama Samir
 */

package com.mycompany.examsite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class lecturer extends user{
    //-exams:list
    String examfile = "D:\\exams.txt";//replace this path
    public lecturer(){

    }
    //+addExam()
    public exam addExam(String examId,String subject){
        return new exam(examId,subject);
    }

    //+deleteExam()
    public void deleteExam(){
        // write code here
    }

    //+updateExam()
    public void updateExam(){
        // write code here
    }

    //+generateReports()
    public void generateReports(){
        System.out.println(readFileContent(this.examfile));
    }
    private String readFileContent(String fileName) {
        StringBuilder content = new StringBuilder();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                content.append(line).append("\n");
            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return content.toString();
    }


}
