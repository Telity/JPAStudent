package jpademo.jpastudent.controller;

import jpademo.jpastudent.model.Student;
import jpademo.jpastudent.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {

    @Autowired
    StudentRepository studentRepository;


    @GetMapping("/")
    public String start(){
        return "Wake up neo";
    }
    @GetMapping("/students")
    public List<Student> students(){
        System.out.println("Hello im under the water");
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        System.out.println(student);
        return studentRepository.save(student);
    }

    @GetMapping("/add")
    public Student addStud(){
        Student student = new Student();
        student.setName("jack2");
        return studentRepository.save(student);
    }

    @PutMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student updateStudent(@RequestBody Student student){
        Optional<Student> optional = studentRepository.findById(student.getId());
        if(optional.isPresent()){
            return studentRepository.save(student);
        }
        else {
            Student notstudent = new Student();
            notstudent.setName("Not Found");
            return notstudent;
        }

    }


    @PutMapping("/student/{id}")
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student){
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            studentRepository.save(student);
            return ResponseEntity.ok(student);
        }
        else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Optional<Student> optional = studentRepository.findById(id);
        if(optional.isPresent()){
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        }
        else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found");
        }
    }
}
