package com.dailycodebuffer.spring.data.jpa.tutorial.repository;

import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Guardian;
import com.dailycodebuffer.spring.data.jpa.tutorial.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudent()
    {
        Student student = Student.builder()
                .emailId("Mabat22@gmail.com")
                .firstName("Mabast")
                .lastName("Hashm")
//                .guardianName("Guardian")
//                .guardianEmail("Guardian222@yahoo.com")
//                .guardianMobile("09908908099")
                .build();

        studentRepository.save(student);
    }

    @Test
    public void saveStudentWithGuardian(){

        Guardian guardian = Guardian.builder()
                .email("nikhil200@yahoo.com")
                .name("Nikhil200")
                .mobile("09907897878")
                .build();

        Student student = Student.builder()
                .firstName("Shivam200")
                .emailId("shivam200@gmail.com")
                .lastName("Kumar200")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> studentList = studentRepository.findAll();
        System.out.printf("Student List : " + studentList);
    }

    @Test
    public void printStudentByFirstName(){
        List<Student> students = studentRepository.findByFirstName("Mabast");
        System.out.printf("find bi first name : " + students );
    }

    @Test
    public void findByFirstNameContaining(){
        List<Student> students = studentRepository.findByFirstNameContaining("sh");
        System.out.printf("find by first name : " + students );
    }

    @Test
    public void printStudentBasedOnGuardianName(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil200");
        System.out.printf("students by Guardian Name :  " + students);
    }

    @Test
    public void getStudentByEmailAddress() {
        Student student = studentRepository.getStudentByEmailAddress("shivam200@yahoo.com");
        System.out.println("by Email  : " +student);
    }

    @Test
    public void getStudentFirstNameByEmailAddress() {
        String firstName = studentRepository.getStudentFirstNameByEmailAddress("shivam200@yahoo.com");
        System.out.println("FIRST NAME by Email  : " +firstName);
    }

    @Test
    public void getStudentByFirstNameNative(){
        Student student = studentRepository.getStudentByEmailAddressNative("Mabast@gmail.com" );
        System.out.printf("By email NATIVE :  "+ student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedParam() {
        Student student = studentRepository.getStudentByEmailAddressNativeNamedParam("Mabast@gmail.com" );
        System.out.printf("By email NATIVE :  "+ student);
    }

    @Test
    public void getStudentByLastName(){
        Student student = studentRepository.getStudentByLastName("Kumar200");
        System.out.printf("By Last Name :  " + student);
    }

    @Test
    public void updateStudentNameByLastNameTest() {
        studentRepository.updateStudentNameByLastName("testEmailId@gmail.com", "Kumar200");
    }

}