package com.example.University.Management.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "Assignment")
public class Assignment {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="course_id", nullable=true,referencedColumnName = "id")
//    @JsonIgnore
//    private Courses course;


//    @OneToMany(mappedBy="assignment",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name = "assignment_id")
    private Set<Submissions> submissions = new HashSet<>();

    public void addSubmissions(Submissions submission) {
        this.submissions.add(submission);
    }

    @Column(name = "question")
    private String question;


    @Column(name = "state")
    private String state;


    @Column(name = "teacherName")
    private String teacherName;




}
