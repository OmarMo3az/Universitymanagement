package com.example.University.Management.Service.Imp;

import com.example.University.Management.Dto.SubmissionsDto;
import com.example.University.Management.Dto.UpdateStateByTeacherDto;
import com.example.University.Management.Repo.AssignmentRepo;
import com.example.University.Management.Repo.StudentRepo;
import com.example.University.Management.Repo.SubmissionsRepo;
import com.example.University.Management.Service.Submission_Service;
import com.example.University.Management.exceptions.ResourceNotFoundException;
import com.example.University.Management.model.Assignment;
import com.example.University.Management.model.Student;
import com.example.University.Management.model.Submissions;
import com.example.University.Management.model.TeacherAssignmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;
import java.util.List;

@Service
public class Submission_imp implements Submission_Service {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private SubmissionsRepo submissionsRepo;
    @Autowired
    private AssignmentRepo assignmentRepo;

    @Override
    public Submissions CreateStudentSubmission(SubmissionsDto requestDto, Long assignmentId, Long studentId) {

        Assignment getAssignment = assignmentRepo.findById(assignmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Assignment", "id", assignmentId));

        Student getStudent = studentRepo.findById(studentId)
                .orElseThrow(() -> new ResourceNotFoundException("Student", "id", studentId));

        Submissions submission = new Submissions();
        submission.setAnswer(requestDto.getAnswer());
        submission.setState("pending");

        getAssignment.addSubmissions(submission);
        getStudent.addSubmission(submission);

        submission = submissionsRepo.save(submission);

        //  List<Submissions> list = submissionsRepo.findAllByStudentId(1);

//        for (Submissions submission : requestDto.getSubmissions()) {
//            getAssignment.addSubmissions(submission);
//            getAssignment.setState("delivered");
//            submission.setAccepted(false);
//        }

        return submission;
    }


    public String updateStateByTeacher(UpdateStateByTeacherDto request
            , Long teacherId, Long submissionId) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        String sql = "update submissions set " +
                " state = "  + "'"+ request.getState() + "'" +
                " , score = " +  request.getScore() +
                ", comments = " + "'" + request.getComments() + "'" +
                "OUTPUT inserted.id, inserted.student_id, inserted.assignment_id, inserted.score, inserted.comments, inserted.answer, inserted.state " +
                " where submissions.id = " + submissionId;
        System.out.println(sql);
        JdbcTemplate jdbcTemplate = jdbcTemplate();
        List<TeacherAssignmentResponse> result = jdbcTemplate.query(sql, new BeanPropertyRowMapper(TeacherAssignmentResponse.class));

        return "Updated";
    }

    JdbcTemplate jdbcTemplate() throws IllegalAccessException, InvocationTargetException, InstantiationException {
// extract this 4 parameters using your own logic
        final String driverClassName = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        final String jdbcUrl = "jdbc:sqlserver://localhost:1433;DatabaseName=University_Management;encrypt=true;trustServerCertificate=true;";
        final String username = "omar";
        final String password = "1234";
// Build dataSource manually:
        final Class<?> driverClass = ClassUtils.resolveClassName(driverClassName, this.getClass().getClassLoader());
        final Driver driver = (Driver) ClassUtils.getConstructorIfAvailable(driverClass).newInstance();
        final DataSource dataSource = new SimpleDriverDataSource(driver, jdbcUrl, username, password);
// or using DataSourceBuilder:
//        final DataSource dataSource = DataSourceBuilder.create().driverClassName(driverClassName).url(jdbcUrl).username(username).password(password).build();
// and make the jdbcTemplate
        return new JdbcTemplate(dataSource);
    }
}
