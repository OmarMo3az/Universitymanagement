package com.example.University.Management.Service;

import com.example.University.Management.Dto.AssignmentDto;
import com.example.University.Management.model.Assignment;

public interface Assignment_Service {
    Assignment CreateAssignment(AssignmentDto requestDto,Long id);
}
