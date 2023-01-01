package com.example.University.Management.Repo;

import com.example.University.Management.model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClassRoomRepo extends JpaRepository<ClassRoom,Long> {
}
