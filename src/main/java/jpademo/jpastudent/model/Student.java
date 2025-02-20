package jpademo.jpastudent.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    @Column(columnDefinition = "DATE")
    private LocalDate borndate;

    @Column(columnDefinition = "TIME")
    private LocalTime borntime;

    public Student() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBorndate() {
        return borndate;
    }

    public void setBorndate(LocalDate borndate) {
        this.borndate = borndate;
    }

    public LocalTime getBorntime() {
        return borntime;
    }

    public void setBorntime(LocalTime borntime) {
        this.borntime = borntime;
    }
}
