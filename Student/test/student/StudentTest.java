/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package student;

import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 27609
 */
public class StudentTest 
{
 
    @Test
    public void testSaveStudent() 
    {
        ArrayList<Student> students =new ArrayList<>();
        Student expResult = new Student();
       
        
        expResult.studentID=10111;
        expResult.studentAge=21;
        expResult.studentName="J.Bloggs";
        expResult.studentEmail="jbloggs@ymail.com";
        expResult.studentCourse="bcad";
        Student result=expResult.SaveStudent(students,expResult);
        
        assertEquals(expResult,result);
    }

    
    @Test
    public void TestSearchStudent() 
    {
        ArrayList<Student> students =new ArrayList<>();
        Student testStudent= new Student();
        Student instance=new Student();
        
        testStudent.studentID=10111;
        testStudent.studentAge=21;
        testStudent.studentName="J.Bloggs";
        testStudent.studentEmail="jbloggs@ymail.com";
        testStudent.studentCourse="disn";
        
        //adding testStudent object to student ArrayList
        students.add(testStudent);
        
        //expected result is true, SearchStudent returns true or false based on whether the testStudent object is found or not
        boolean expResult =true;
        boolean result = instance.SearchStudent(students,testStudent);
        assertEquals(expResult, result);
    }
    
    
    @Test
    public void TestSearchStudent_StudentNotFound() 
    {
        ArrayList<Student> students =new ArrayList<>();
        Student testStudent= new Student();
        Student testStudent2= new Student();
        Student instance=new Student();
        
        testStudent.studentID=10111;
        testStudent.studentAge=21;
        testStudent.studentName="J.Bloggs";
        testStudent.studentEmail="jbloggs@ymail.com";
        testStudent.studentCourse="disn";
        
        testStudent2.studentID=10112;
        testStudent2.studentAge=20;
        testStudent2.studentName="J.DOE";
        testStudent2.studentEmail="jdoe@ymail.com";
        testStudent2.studentCourse="disn";
        
        //adding testStudent2 instead of testStudent to the students array
        students.add(testStudent2);
        
        //expected result is false, SearchStudent returns true or false based on whether the testStudent object is found or not
        //testStudent object was not added so it wont be found
        boolean expResult =false;
        boolean result = instance.SearchStudent(students,testStudent);
        assertEquals(expResult, result);
    }
    
    @Test
    public void TestDeleteStudent() 
    {
        ArrayList<Student> students =new ArrayList<>();
        Student instance=new Student();
        Student testStudent= new Student();
        
        testStudent.studentID=10111;
        testStudent.studentAge=21;
        testStudent.studentName="J.Bloggs";
        testStudent.studentEmail="jbloggs@ymail.com";
        testStudent.studentCourse="disn";
        
        students.add(testStudent);
        
        String expResult="Student with Student ID: "+testStudent.studentID+" WAS deleted!";
        String result=instance.DeleteStudent(students,testStudent);
        
        assertEquals(expResult,result);
    }
    
    @Test
    public void TestDeleteStudent_StudentNotFound() 
    {
        ArrayList<Student> students =new ArrayList<>();
        Student instance=new Student();
        Student testStudent= new Student();
        Student testStudent2= new Student();
        
        testStudent.studentID=10111;
        testStudent.studentAge=21;
        testStudent.studentName="J.Bloggs";
        testStudent.studentEmail="jbloggs@ymail.com";
        testStudent.studentCourse="disn";
        
        testStudent2.studentID=10112;
        testStudent2.studentAge=20;
        testStudent2.studentName="J.DOE";
        testStudent2.studentEmail="jdoe@ymail.com";
        testStudent2.studentCourse="disn";
        
        students.add(testStudent);
        
        String expResult="Student with Student ID: "+testStudent2.studentID+" WAS NOT deleted!!!";
        String result=instance.DeleteStudent(students,testStudent2);
        
        assertEquals(expResult,result);
    }
    
    @Test
    public void TestStudentAge_StudentAgeValid()
    {
        
        Student testStudent= new Student();
        
        testStudent.studentAge=21;
        
        boolean expResult=true;
        boolean result=Student.validAge(testStudent.studentAge);
        
        assertEquals(expResult,result);
        
    }
    
    @Test
    public void TestStudentAge_StudentAgeInValid()
    {
        
        Student testStudent= new Student();
        
        testStudent.studentAge=10;
        
        boolean expResult=false;
        boolean result=Student.validAge(testStudent.studentAge);
        
        assertEquals(expResult,result);
        
    }
    
    @Test
    public void TestStudentAge_StudentAgeInvalidCharacter() {
        String string = "";
        boolean expResult = true;
        boolean result = Student.invalidChar(string);
        assertEquals(expResult, result);
        
        string="a";
        expResult = true;
        result = Student.invalidChar(string);
        assertEquals(expResult, result);
    }

}
