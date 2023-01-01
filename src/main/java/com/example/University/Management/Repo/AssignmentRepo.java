package com.example.University.Management.Repo;

import com.example.University.Management.model.Assignment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AssignmentRepo extends JpaRepository<Assignment,Long> {
}
