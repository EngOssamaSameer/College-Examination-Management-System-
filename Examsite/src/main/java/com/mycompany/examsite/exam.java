/**
 *
 * @author Eng Ossama Samir
 */

package com.mycompany.examsite;

import java.io.*;
import java.util.List;

public class exam {
    String examfile = "D:\\exams.txt";//replace this path


    //-examID:int
    String examID;

    //-subject:string
    String subject;

    //-quedtion:list
    List<String> quedtion ;
    public exam(String examID,String subject){
        this.examID = examID;
        this.subject = subject;
    }

    // add quedtion
    public void createExame(String quedtion,String ans1,String ans2 , String rAns){
        insertInFile(this.examfile,this.examID,this.subject,quedtion,ans1,ans2,rAns);
    }
    private void insertInFile(String filePath ,String lineZero , String lineOne , String lineTwo,String lineThere , String lineFour,String lineFive ){
        try {
            FileWriter file = new FileWriter(filePath, true);
            BufferedWriter buffer = new BufferedWriter(file);
            String line0 = lineZero+"\n";
            String line1 = lineOne+"\n";
            String line2 = lineTwo+"\n";
            String line3 = lineThere+"\n";
            String line4 = lineFour+"\n";
            String line5 = lineFive+"\n";
            // write in file
            buffer.write(line0);
            buffer.write(line1);
            buffer.write(line2);
            buffer.write(line3);
            buffer.write(line4);
            buffer.write(line5);
            buffer.close();
        }catch(IOException e){
            System.out.println("Error writing to the file: " + e.getMessage());
        }finally{
        }
    }

}
