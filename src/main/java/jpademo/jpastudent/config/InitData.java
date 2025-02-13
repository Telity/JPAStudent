package jpademo.jpastudent.config;

import jpademo.jpastudent.model.Student;
import jpademo.jpastudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {

    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Jack");
        s1.setBorndate(LocalDate.of(2002, 11, 12));
        s1.setBorntime(LocalTime.of(10, 11, 13));
        studentRepository.save(s1);

    }
}
