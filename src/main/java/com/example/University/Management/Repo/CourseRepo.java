package com.example.University.Management.Repo;

import com.example.University.Management.model.Courses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CourseRepo extends JpaRepository<Courses,Long> {
}
