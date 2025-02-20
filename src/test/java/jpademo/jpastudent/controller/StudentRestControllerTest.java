package jpademo.jpastudent.controller;

import jpademo.jpastudent.model.Student;
import jpademo.jpastudent.repository.StudentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;



@DataJpaTest
@ActiveProfiles("test")
class StudentRestControllerTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    void testStudentOperations() {
        // Arrange
        Student student = new Student();
        student.setName("Test Student");

        // Act
        Student savedStudent = studentRepository.save(student);
        List<Student> students = studentRepository.findAll();

        // Assert
        assertNotNull(savedStudent.getId());
        assertEquals(1, students.size());
        assertEquals("Test Student", students.get(0).getName());
    }
}