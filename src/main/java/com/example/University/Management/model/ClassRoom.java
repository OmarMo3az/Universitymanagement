package com.example.University.Management.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ClassRoom")
public class ClassRoom { // class

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    @Column(name = "name")
    private String name ;

    @Column(name = "day")
    private Date day ;

    @Column(name = "time_start")
    private String time_start ;

    @Column(name = "time_end")
    private String time_end ;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="teacher_id", nullable=true,referencedColumnName = "id")
//    @JsonIgnore
//    private Teacher teacher;

   // @OneToMany(mappedBy="classRoom",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
   @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "classRoom_id")
   private Set<Courses> courses = new HashSet<>();

    public void addCourse(Courses courses) {
        this.courses.add(courses);
    }


    @ManyToMany(fetch = FetchType.EAGER )
    @JoinTable(name = "classRoom_students",
            joinColumns = @JoinColumn(name = "classRoom_Id",referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "student_id",referencedColumnName = "id"))
    private Set<Student> students=new HashSet<>();

    public void addStudent(Student students) {
        this.students.add(students);
    }

}
