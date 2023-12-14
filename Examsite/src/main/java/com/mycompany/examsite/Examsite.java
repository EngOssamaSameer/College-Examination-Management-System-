/**
 *
 * @author Eng Ossama Samir
 */

package com.mycompany.examsite;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class Examsite {
    static String studentsFile = "D:\\students.txt";//replace this path
    static String lecturersFile = "D:\\lecturers.txt";//replace this path
    public static void main(String[] args) {

        String adminID = "2020";
        String adminpassword = "222";
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ID :");
        String id = scanner.nextLine();
        System.out.println("Enter Password :");
        String password = scanner.nextLine();
        List<String> role = gitRole(id);
        //log in
        int logout = 0 ;
        //Admin
        if(role.get(0).equals("Admin")&&password.equals(adminpassword)){
            System.out.println("Welcome in Admin Page");
            Admin admin = new Admin();
            int enter = 0;
            while (enter != -1) {
                System.out.println("To add Student enter 1");
                System.out.println("To delete Student enter 2");
                System.out.println("To update Student enter 3");
                System.out.println("To add Lecturer enter 4");
                System.out.println("To delete Lecturer enter 5");
                System.out.println("To update Lecturer enter 6");
                System.out.println("To add Subject enter 7");
                System.out.println("To delete Subject enter 8");
                System.out.println("To update Subject enter 9");
                System.out.println("To Exit enter -1");
                enter = scanner.nextInt();
                switch (enter){
                    case 1:
                        System.out.println("enter student ID");
                        String studentID = scanner.next();
                        System.out.println("enter student name");
                        String studentnName = scanner.next();
                        System.out.println("enter student password");
                        String studentnpass = scanner.next();
                        admin.addStudent(studentID,studentnName,studentnpass);
                        break;
                    case 2:
                        System.out.println("enter student ID");
                        String studentId = scanner.next();
                        System.out.println("enter student name");
                        String studentnname = scanner.next();
                        admin.deleteStudent(studentId,studentnname);
                        break;
                    case 3:
                        System.out.println("enter student old ID");
                        String oldstudentId = scanner.next();
                        System.out.println("enter student new ID");
                        String newstudentId = scanner.next();
                        System.out.println("enter old student name");
                        String oldstudentnname = scanner.next();
                        System.out.println("enter new student name");
                        String newstudentnname = scanner.next();
                        admin.updateStudent(oldstudentId,newstudentId,oldstudentnname,newstudentnname);
                        break;
                    case 4:
                        System.out.println("enter Lecturer ID");
                        String LecturertID = scanner.next();
                        System.out.println("enter Lecturer name");
                        String LecturerName = scanner.next();
                        System.out.println("enter Lecturer password");
                        String Lecturerpass = scanner.next();
                        admin.addLecturer(LecturertID,LecturerName,Lecturerpass);
                        break;
                    case 5:
                        System.out.println("enter Lecturer ID");
                        String LecturertId = scanner.next();
                        System.out.println("enter Lecturer name");
                        String Lecturervame = scanner.next();
                        admin.deleteLecturer(LecturertId,Lecturervame);
                        break;
                    case 6:
                        System.out.println("enter Lecturer old ID");
                        String oldLecturerId = scanner.next();
                        System.out.println("enter Lecturer new ID");
                        String newLecturerId = scanner.next();
                        System.out.println("enter old Lecturer name");
                        String oldLecturername = scanner.next();
                        System.out.println("enter new Lecturer name");
                        String newLecturernname = scanner.next();
                        admin.updateLecturer(oldLecturerId,newLecturerId,oldLecturername,newLecturernname);
                        break;
                    case 7:
                        System.out.println("enter Subject ID");
                        String SubjectID = scanner.next();
                        System.out.println("enter Subject name");
                        String SubjectName = scanner.next();
                        admin.addSubject(SubjectID,SubjectName);
                        break;
                    case 8:
                        System.out.println("enter Subject ID");
                        String SubjectId = scanner.next();
                        System.out.println("enter Subject name");
                        String Subjectrvame = scanner.next();
                        admin.deleteStubject(SubjectId,Subjectrvame);
                        break;
                    case 9:
                        System.out.println("enter Subject old ID");
                        String oldSubjectId = scanner.next();
                        System.out.println("enter Subject new ID");
                        String newLeSubjectId = scanner.next();
                        System.out.println("enter old Subject name");
                        String oldSubjectname = scanner.next();
                        System.out.println("enter new Subject name");
                        String newLSubjectname = scanner.next();
                        admin.updateSubject(oldSubjectId,newLeSubjectId,oldSubjectname,newLSubjectname);
                        break;
                    case -1:
                        return;
                }
            }
        // Lecturer
        } else if (role.get(0).equals("Lecturer")&&role.get(2).equals(password)) {
            System.out.println("Welcome in Lecturer Page");
            System.out.println("Welcome ! "+role.get(1));
            lecturer lecturer = new lecturer();
            int enter = 0;
            while (enter != -1) {
                System.out.println("To add add Exam enter 1");
                System.out.println("To delete Exam enter 2");
                System.out.println("To update Exam enter 3");
                System.out.println("To generateReports 4");
                System.out.println("To Exit enter -1");
                enter = scanner.nextInt();
                switch (enter){
                    case 1:
                        System.out.println("To Exit Subject name");
                        String subject = scanner.next();
                        System.out.println("To Exit Exam ID");
                        String examID = scanner.next();
                        exam exam = lecturer.addExam(subject,examID);
                        // insert questions
                        System.out.println("To Exit quedtion ");
                        String qu = scanner.next();
                        System.out.println("To Exit Ans1");
                        String a1 = scanner.next();
                        System.out.println("To Exit Ans2");
                        String a2 = scanner.next();
                        System.out.println("To Exit Right ans ");
                        String rans = scanner.next();
                        exam.createExame(qu,a1,a2,rans);
                        break;
                    case 2:
                        // Write code to delete Exam
                        break;
                    case 3:
                        // Write code to update Exam
                        break;
                    case 4:
                        lecturer.generateReports();
                        break;
                    case -1:
                        return;
                }
            }
        // Student
        } else if (role.get(0).equals("Student")&&role.get(2).equals(password)) {
            System.out.println("Welcome in Student Page");
            System.out.println("Welcome ! "+role.get(1));
            student student = new student();
            int enter = 0;
            while (enter != -1) {
                System.out.println("To show Degree enter 1");
                System.out.println("To access Exam enter 2");
                System.out.println("To assigned Subject enter 3");
                System.out.println("To see All Assigned Subject enter 4");
                System.out.println("To Exit enter -1");
                enter = scanner.nextInt();
                switch (enter){
                    case 1:
                        System.out.println("Subject Name");
                        String Subject = scanner.next();
                        student.showDegree();
                        break;
                    case 2:
                        System.out.println("Enter Exam Name:");
                        String eID = scanner.next();
                        student.accessExam(eID);
                        break;
                    case 3:
                        System.out.println("Enter Subject Name:");
                        String sName = scanner.next();
                        student.assignedSubject(sName);
                        break;
                    case 4:
                        student.seeAllAssignedSubject();
                        break;
                    case -1:
                        return;
                }
            }
        }else{
            System.out.println("User Not Found !!");
        }



    }
    public static List<String> gitRole(String id){
        List<String> role2 = new ArrayList<>();
        if(id.equals("2020")){
            role2.add("Admin");
            role2.add("Admin");
            role2.add("");
        } else if (id.substring(0, 4).equals("2021")) {
            if(readLines(lecturersFile,id) != null){
                role2.add("Lecturer");
                role2.add(readLines(lecturersFile,id).get(0));
                role2.add(readLines(lecturersFile,id).get(1));
            }else {
                role2.add("0");
                role2.add("0");
                role2.add("0");
            }
        } else if (id.substring(0, 4).equals("2022")) {
            if(readLines(studentsFile,id) != null){
                role2.add("Student");
                role2.add(readLines(studentsFile,id).get(0));
                role2.add(readLines(studentsFile,id).get(1));
            }else {
                role2.add("0");
                role2.add("0");
                role2.add("0");
            }
        }
        return role2;
    }

    public static List<String> readLines(String fileName,String id) {
        List<String> name = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            int linesRead = 0;
            int found = 0;

            while ((line = bufferedReader.readLine()) != null) {
                if (found == 2){
                    name.add(line);
                    return  name;
                }
                if(found == 1){
                    found ++;
                    name.add(line);
                }
                if(line.equals(id)){
                    found = 1;
                }
                linesRead++;

            }

            bufferedReader.close();
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
        return name;
    }



}
