package com.example.University.Management.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Submissions")
public class Submissions {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id  ;

    @Column(name = "score")
    private int score;

    @Column(name = "comments")
    private String comments;
    @Column(name = "answer")
    private String  answer ;
    @Column(name = "state")
    private String state;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="assignment_id", nullable=true,referencedColumnName = "id")
//    @JsonIgnore
//    private Assignment assignment;


//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="student_id", nullable=true,referencedColumnName = "id")
//    @JsonIgnore
//    private Student student;


}
