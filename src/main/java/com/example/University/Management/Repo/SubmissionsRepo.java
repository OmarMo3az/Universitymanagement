package com.example.University.Management.Repo;

import com.example.University.Management.model.Student;
import com.example.University.Management.model.Submissions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubmissionsRepo extends JpaRepository<Submissions,Long> {

//    @Query(value = "SELECT e FROM Submissions e WHERE e.student_id = :id")
//    List <Submissions> findAllByStudentId(int id);



}
//e WHERE e.id = :id