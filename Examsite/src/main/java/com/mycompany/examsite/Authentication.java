package com.mycompany.examsite;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author Eng Ossama Samir
 */
public class Authentication {
    private String file_name = "";

    public Authentication(String file_name){
        this.file_name = file_name ;
    }

    // function to insert user
    public void insertUser(String userName , String userId , String userRole){
        try{
            FileWriter file = new FileWriter(this.file_name,true);
            BufferedWriter buffer = new BufferedWriter(file);
            String name = userName+"\n";
            String id = userId+"\n";
            String role = userRole+"\n";
            buffer.write(name);
            buffer.write(id);
            buffer.write(role);
            buffer.close();
        }catch(IOException e){
            System.out.println("Error writing to the file: " + e.getMessage());
        }finally{

        }
    }

    // function to select user
    public List<String> selectUser(){
        List<String> userInfo = new ArrayList<>();
        try {
            FileReader  file = new FileReader(this.file_name);
            BufferedReader  buffer = new BufferedReader(file);
            String line;
            int linesCount = 0;
            while ((line = buffer.readLine()) != null) {
                userInfo.add(line);
                linesCount++;
            }
            buffer.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return userInfo;
    }

}
