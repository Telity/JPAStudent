package jpademo.jpastudent.controller;

import jpademo.jpastudent.model.Student;
import jpademo.jpastudent.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRestControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        Student std = new Student();
        std.setName("Jack");
        studentRepository.save(std);
    }

    @Test
    void testOneStudent(){
        List<Student> student = studentRepository.findAll();
        assertEquals(1, student.size());
    }
}