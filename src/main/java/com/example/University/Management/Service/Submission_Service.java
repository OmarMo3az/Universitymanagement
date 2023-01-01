package com.example.University.Management.Service;

import com.example.University.Management.Dto.SubmissionsDto;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Submissions;

public interface Submission_Service {
    Submissions CreateStudentSubmission(SubmissionsDto requestDto, Long studentId, Long assignmentId);

}
