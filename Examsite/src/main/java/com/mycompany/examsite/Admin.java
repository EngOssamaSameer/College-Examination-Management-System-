/**
 *
 * @author Eng Ossama Samir
 */

package com.mycompany.examsite;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.util.List;
import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;


public class Admin extends user {
    private String studentsFile = "D:\\students.txt";//replace this path
    private String lecturersFile = "D:\\lecturers.txt";//replace this path
    private String subjectsFile = "D:\\subjects.txt";//replace this path

    // Constructor
    public Admin(){
    }

    //+addStudent()
    public void addStudent(String studentId , String studentName , String studentpass){
        insertInFile(this.studentsFile,studentId,studentName,studentpass);
    }

    //+deleteStudent()
    public void deleteStudent(String studentId , String studentName){
        deleteFromFile(this.studentsFile,studentId);
        deleteFromFile(this.studentsFile,studentName);
    }

    //+updateStudent()
    public void updateStudent(String oldId,String newId,String oldNmae,String newNmae){
        updateInFile(this.studentsFile,oldId,newId);
        updateInFile(this.studentsFile,oldNmae,newNmae);
    }

    //+addSubject()
    public void addSubject(String SubjectId , String SubjectName){
        insertInFile(this.subjectsFile,SubjectId,SubjectName);
    }

    //+deleteStubject()
    public void deleteStubject(String StubjectId , String StubjectName){
        deleteFromFile(this.subjectsFile,StubjectId);
        deleteFromFile(this.subjectsFile,StubjectName);
    }

    //+updateSubject()
    public void updateSubject(String oldId,String newId,String oldNmae,String newNmae){
        updateInFile(this.subjectsFile,oldId,newId);
        updateInFile(this.subjectsFile,oldNmae,newNmae);
    }


    //+addLecturer()
    public void addLecturer(String LecturerId , String LecturerName, String Lecturerpass){
        insertInFile(this.lecturersFile,LecturerId,LecturerName,Lecturerpass);
    }

    //+deleteLecturer()
    public void deleteLecturer(String LecturerId , String LecturerName){
        deleteFromFile(this.lecturersFile,LecturerId);
        deleteFromFile(this.lecturersFile,LecturerName);
    }

    //+updateLecturer()
    public void updateLecturer(String oldId,String newId,String oldNmae,String newNmae){
        updateInFile(this.lecturersFile,oldId,newId);
        updateInFile(this.lecturersFile,oldNmae,newNmae);
    }

    private void insertInFile(String filePath ,String lineOne , String lineTwo, String lineThere ){
        try {
            FileWriter file = new FileWriter(filePath, true);
            BufferedWriter buffer = new BufferedWriter(file);
            String line1 = lineOne+"\n";
            String line2 = lineTwo+"\n";
            String line3 = lineThere+"\n";
            // write in file
            buffer.write(line1);
            buffer.write(line2);
            buffer.write(line3);
            buffer.close();
        }catch(IOException e){
            System.out.println("Error writing to the file: " + e.getMessage());
        }finally{
        }
    }
    private void insertInFile(String filePath ,String lineOne , String lineTwo){
        try {
            FileWriter file = new FileWriter(filePath, true);
            BufferedWriter buffer = new BufferedWriter(file);
            String line1 = lineOne+"\n";
            String line2 = lineTwo+"\n";
            // write in file
            buffer.write(line1);
            buffer.write(line2);
            buffer.close();
        }catch(IOException e){
            System.out.println("Error writing to the file: " + e.getMessage());
        }finally{
        }
    }
    private void deleteFromFile(String filePath ,String lineOne ){
        try {
            File inputFile = new File(filePath);
            File tempFile = new File("tempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                currentLine = currentLine.replace(lineOne, ""); // Removes the string from the line
                writer.write(currentLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (!inputFile.delete()) {
                System.out.println("Could not delete the original file.");
                return;
            }

            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename the temporary file.");
            }

            System.out.println("String '" + lineOne + "' removed from file successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file: " + e.getMessage());
        }
    }
    private void updateInFile(String fileName, String stringToReplace, String replacementString) {
        try {
            File inputFile = new File(fileName);
            File tempFile = new File("tempFile.txt");

            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

            String currentLine;

            while ((currentLine = reader.readLine()) != null) {
                String modifiedLine = currentLine.replaceAll(stringToReplace, replacementString);
                writer.write(modifiedLine + System.getProperty("line.separator"));
            }

            writer.close();
            reader.close();

            if (!inputFile.delete()) {
                System.out.println("Could not delete the original file.");
                return;
            }

            if (!tempFile.renameTo(inputFile)) {
                System.out.println("Could not rename the temporary file.");
            }

            System.out.println("String replaced successfully.");
        } catch (IOException e) {
            System.out.println("Error modifying the file: " + e.getMessage());
        }
    }



}
