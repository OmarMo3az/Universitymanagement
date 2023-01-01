package com.example.University.Management.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Courses")
public class Courses {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    @Column(name = "course_name")
    private String course_name ;


//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
//    @JoinColumn(name="classRoom_id", nullable=true,referencedColumnName = "id")
//    @JsonIgnore
//    private ClassRoom classRoom;
//
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="teacher_id", nullable=true,referencedColumnName = "id")
//    @JsonIgnore
//    private Teacher teacher;

//    @OneToMany(mappedBy="course",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name="course_id")
    private Set<Assignment> assignments = new HashSet<>();

    public void addAssignments(Assignment assignment) {
        this.assignments.add(assignment);
    }
}
