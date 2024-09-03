
package student;

import java.util.Scanner;
import java.util.ArrayList;

public class Student 
{
    int studentID;
    String studentName;
    int studentAge;
    String studentEmail;
    String studentCourse;
    public Scanner input=new Scanner(System.in);

    
    public static void main(String[] args) 
    {   Student dummy=new Student();
        
        dummy.Welcome();
    }

    public void SaveStudent(ArrayList<Student> students)
    {
        Student newStudent=new Student();
        String userInput;
        System.out.println("CAPTURE A NEW STUDENT");
        System.out.println("*************************");
        System.out.print("Enter the student id: ");
        userInput=input.next();
        while(invalidChar(userInput)==true)
        {
            System.out.println("Invalid student id!!!");
            System.out.print("Please re-enter the student id >> ");
            userInput=input.next();
        }
        newStudent.studentID=Integer.parseInt(userInput);
        
        System.out.print("Enter the student name: ");
        userInput=input.next();
        newStudent.studentName=userInput;
        
        System.out.print("Enter the student age: ");
        userInput=input.next();
        while(invalidChar(userInput)==true||validAge(Integer.parseInt(userInput))==false)
        {
            System.out.println("You have entered an incorrect student age!!!");
            System.out.print("Please re-enter the student age >>");
            userInput=input.next();
        }
        newStudent.studentAge=Integer.parseInt(userInput);
        

        System.out.print("Enter the student email: ");
        userInput=input.next();
        newStudent.studentEmail=userInput;
        
        
        System.out.print("Enter the student course: ");
        userInput=input.next();
        newStudent.studentCourse=userInput;
        
        students.add(newStudent);
        System.out.println("Student Successfully Captured!");
            
        
    }
    
    //overloaded method used in unit testing to demonstrate correct saving of Student object
    public Student SaveStudent(ArrayList<Student> students,Student student)
    {
        students.add(student);
        
        int index=students.indexOf(student);
        
        Student studentCopy=students.get(index);
        
        return studentCopy;
    }
     
     
    
    
    public boolean SearchStudent(ArrayList<Student> students)
    {
        boolean foundOrNot=false;
        int index=0;
        
        System.out.print("Enter the student id to search: ");
        int searchID=input.nextInt();
        System.out.println("-----------------------------------");
        
        
        // convert ArrayList to array using toArray method
        Student [] studentArray=new Student[students.size()];
        studentArray=students.toArray(studentArray);
        
        // search array
        for(int i=0;i<studentArray.length;i++)
        {
            if(searchID==studentArray[i].studentID)
            {
                foundOrNot=true;
                index=i;
            }
        }
        
        
        
    //print from array if found, else display error message        
    if(foundOrNot==true)
    {
        
        System.out.println("STUDENT ID: "+studentArray[index].studentID);
        System.out.println("STUDENT NAME: "+studentArray[index].studentName);
        System.out.println("STUDENT AGE: "+studentArray[index].studentAge);
        System.out.println("STUDENT EMAIL: "+studentArray[index].studentEmail);
        System.out.println("STUDENT COURSE: "+studentArray[index].studentCourse);
       
        
    }
    else
    {
        System.out.println("Student with Student ID: "+searchID+" was not found!");
        
    }
        System.out.println("-----------------------------------");
        
        
    return foundOrNot;
        
    }
    
     public boolean SearchStudent(ArrayList<Student> students,Student student)
    {
        boolean foundOrNot=false;
        int index=0;
        Student [] studentArray=new Student[students.size()];
        studentArray=students.toArray(studentArray);
        
        //search array
        for(int i=0;i<studentArray.length;i++)
        {
            if(student.studentID==studentArray[i].studentID)
            {
                foundOrNot=true;
                index=i;
            }
        }   
        
        return foundOrNot;
        
    }
     
    //overloaded method used by DeleteStudent to find student in students ArrayList
    public int SearchStudent(ArrayList<Student> students,int deletionStudentID)
    {
        int index=-1;
        
        
        // convert ArrayList to array using toArray method
        Student [] studentArray=new Student[students.size()];
        studentArray=students.toArray(studentArray);
        
        // search array
        for(int i=0;i<studentArray.length;i++)
        {
            if(deletionStudentID==studentArray[i].studentID)
            {
                index=i;
            }
    }
        
        return index;
    }
    
    public void DeleteStudent(ArrayList<Student> students)
    {   
        int deletionStudentID;
        int studentPosition;
        String choice;
        System.out.print("Enter the student id to delete: ");
        deletionStudentID=input.nextInt();
        
        
        studentPosition=this.SearchStudent(students,deletionStudentID);
        
        if(studentPosition!=-1)
        {
            System.out.println("Are you sure you want to delete student "+deletionStudentID+" from the system? Yes (y) to delete.");
            choice=input.next();
            
            if(choice.equals("y"))
            {
                students.remove(studentPosition);
                System.out.println("Student with Student ID: "+deletionStudentID+" WAS deleted!");
            }
            else
            {
                System.out.println("Student with Student ID: "+deletionStudentID+" WAS NOT deleted!!!");
            }
        }
    }
    
    //overloaded method used in unit testing to demonstrate functionality
    public String DeleteStudent(ArrayList<Student> students,Student student)
    {
        int studentPosition;
        String returnMessage=null;
        
        studentPosition=this.SearchStudent(students,student.studentID);
        
        if(studentPosition!=-1)
        {
                students.remove(studentPosition);
                returnMessage="Student with Student ID: "+student.studentID+" WAS deleted!";
        }
        else
        {
                returnMessage="Student with Student ID: "+student.studentID+" WAS NOT deleted!!!";
        }
        
        return returnMessage;
    }
    
    public void StudentReport(ArrayList<Student> students)
    {
        Student [] studentArray=new Student[students.size()];
        studentArray=students.toArray(studentArray);
        
        for(int i=0;i<studentArray.length;i++)
        {
            System.out.println("STUDENT "+(i+1));
            System.out.println("----------------------------------------------");
            System.out.println("STUDENT ID: "+studentArray[i].studentID);
            System.out.println("STUDENT AGE: "+studentArray[i].studentAge);
            System.out.println("STUDENT EMAIL: "+studentArray[i].studentEmail);
            System.out.println("STUDENT COURSE: "+studentArray[i].studentCourse);
            System.out.println("----------------------------------------------");
        }
    }
    
    public void ExitStudentApplication(ArrayList<Student> students)
    {
        System.out.println("Goodbye!");
    }   

    
    public static boolean invalidChar(String string)
    {
        int intValue;
        
        if(string == null || string.equals("")) 
        {
            return true;
        }
    
        try
        {
            intValue = Integer.parseInt(string);
            return false;
        } 
        catch (NumberFormatException e) 
        {
        }
    
        return true;
    }
    
    public static boolean validAge(int age)
    {
        boolean validity=false;
        
        if(age>=16)
        {
            validity=true;
        }
        
        return validity;
    }
    
    public void Welcome()
    {
        System.out.println("STUDENT MANAGEMENT APPLICATION");
        System.out.println("*************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit");
        
        String userSelection=input.next();

        if(userSelection.contentEquals("1"))
        {
            ArrayList<Student> students=new ArrayList<>();
            Menu(students);
            while(userSelection.contentEquals("1"))
            {
                System.out.println("Enter (1) to launch menu or any other key to exit");
                userSelection=input.next();
                if(userSelection.contentEquals("1"))
                {
                    Menu(students);
                }
            }
        }
        
    }
    
    public void Menu(ArrayList<Student> students)
    {
        int choice=0;

            System.out.println("Please select one of the following menu items:");
            System.out.println("(1) Capture a new student.");
            System.out.println("(2) Search for a student.");
            System.out.println("(3) Delete a student.");
            System.out.println("(4) Print student report.");
            System.out.println("(5) Exit Application.");
      
            String userSelection=input.next();
        
            while(invalidChar(userSelection)==true)
            {
                System.out.println("Invalid selection!!!");
            
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit Application.");
            
                userSelection=input.next();
            }
        
        
            choice=Integer.parseInt(userSelection);
        
            while(choice<0||choice>5)
            {
                System.out.println("Invalid selection!!!");
            
                System.out.println("Please select one of the following menu items:");
                System.out.println("(1) Capture a new student.");
                System.out.println("(2) Search for a student.");
                System.out.println("(3) Delete a student.");
                System.out.println("(4) Print student report.");
                System.out.println("(5) Exit Application.");
            
                userSelection=input.next();
                choice=Integer.parseInt(userSelection);
            
            }
            
            if(userSelection.equals("1"))
                    SaveStudent(students);
                else
                {
                    if(userSelection.equals("2"))
                        SearchStudent(students);
                    else
                    {
                        if(userSelection.equals("3"))
                            DeleteStudent(students);
                        else
                        {
                            if(userSelection.equals("4"))
                                StudentReport(students);
                        }
                    }
                } 
    }

    
}
