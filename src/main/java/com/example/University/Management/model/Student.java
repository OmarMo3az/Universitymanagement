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
@Table(name = "Students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    @Column(name = "name")
    private String name ;


//    @OneToMany(mappedBy="student",fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @OneToMany(fetch = FetchType.EAGER ,cascade = CascadeType.ALL)
    @JoinColumn(name="student_id")
    private Set<Submissions> submissions = new HashSet<>();

    public void addSubmission(Submissions submission){
        this.submissions.add(submission);
    }

}
