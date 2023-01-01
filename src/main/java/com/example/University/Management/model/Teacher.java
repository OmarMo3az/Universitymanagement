package com.example.University.Management.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    @Column(name = "name")
    private String name ;


//    @OneToMany(mappedBy="teacher",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
//    private Set<ClassRoom> classRooms = new HashSet<>(); mappedBy="teacher",
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Set<ClassRoom> classRooms = new HashSet<>();

    public void addClassRoom(ClassRoom classRoom) {
        this.classRooms.add(classRoom);
    }

   // @OneToMany(mappedBy="teacher",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)mappedBy="teacher",
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "teacher_id")
    private Set<Courses> courses = new HashSet<>();

    public void addCourse(Courses course) {
        this.courses.add(course);
    }

}
