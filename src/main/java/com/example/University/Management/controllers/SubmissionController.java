package com.example.University.Management.controllers;

import com.example.University.Management.Dto.SubmissionsDto;
import com.example.University.Management.Dto.UpdateStateByTeacherDto;
import com.example.University.Management.Service.Imp.Submission_imp;
import com.example.University.Management.model.Submissions;
import com.example.University.Management.model.TeacherAssignmentResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.sql.Driver;
import java.util.List;


@RestController
@RequestMapping("/api")
public class SubmissionController {

    @Autowired
    private Submission_imp submissionImp;

    @PostMapping("/addStudentSubmission/assignmentId/{assignmentId}/studentId/{studentId}")
    public ResponseEntity<?> addStudentSubmission(@RequestBody SubmissionsDto request,
                                                  @PathVariable Long assignmentId,
                                                  @PathVariable Long studentId){

    return new ResponseEntity<>(submissionImp.CreateStudentSubmission(request,assignmentId,studentId)
            ,HttpStatus.CREATED);
    }



    @GetMapping("/v1/studentId/{studentId}")// return submission fresh
    public List<Submissions> getStudentSubmissions(  @PathVariable Long studentId ) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String sql = "SELECT * from submissions where submissions.student_id =" + studentId + " AND state not in ('pending','finished')";

        JdbcTemplate  jdbcTemplate = jdbcTemplate();
        List<Submissions> result = jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper(Submissions.class));

        return result;
    }



    @GetMapping("/v1/teacher/{teacher_id}/assignments")// return submission fresh
    public List<TeacherAssignmentResponse> getTeachersAssignments(@PathVariable Long teacher_id ) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String sql = "select class_room.teacher_id, course_name, student_id, assignment_id, submissions.id as submission_id , submissions.state, answer  from class_room \n" +
                "join courses on courses.class_room_id = class_room.id\n" +
                "join assignment on courses.id = assignment.course_id\n" +
                "join submissions on submissions.assignment_id = assignment.id\n" +
                "where class_room.teacher_id = " + teacher_id;
        JdbcTemplate  jdbcTemplate = jdbcTemplate();
        List<TeacherAssignmentResponse> result = jdbcTemplate.query( sql, new BeanPropertyRowMapper(TeacherAssignmentResponse.class));

        return result;
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



    @PostMapping("v1/teacherId/{teacherId}/submissionId/{submissionId}")
    public ResponseEntity<?> updateStateByTeacher(@RequestBody UpdateStateByTeacherDto request,
                                                  @PathVariable Long teacherId,
                                                  @PathVariable Long submissionId) throws InvocationTargetException, IllegalAccessException, InstantiationException {

        return new ResponseEntity<>(submissionImp.updateStateByTeacher(request, teacherId, submissionId)
                , HttpStatus.CREATED);
    }

    @GetMapping("/v1/studentId/{student_id}/assignmentsId/{assignments_id}")// return submission fresh
    public List<Submissions> getStudentHistoryOfAssignment(@PathVariable Long student_id
                            ,@PathVariable Long assignments_id  ) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        String sql = "SELECT * from submissions where assignment_id = " + assignments_id + " and student_id = "+ student_id ;

        JdbcTemplate  jdbcTemplate = jdbcTemplate();
        List<Submissions> result = jdbcTemplate.query( sql, new BeanPropertyRowMapper(Submissions.class));

        return result;
    }


}
