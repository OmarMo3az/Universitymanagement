package com.example.University.Management.Service;

import com.example.University.Management.Dto.ClassRoomDto;
import com.example.University.Management.model.ClassRoom;

public interface ClassRoom_Service {

    ClassRoom CreateClassRoom(ClassRoomDto requestDto, Long teacherId , Long courseId);
}
