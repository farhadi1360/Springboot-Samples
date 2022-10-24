package org.edu.farhadi.simplerelational.database.apis.impl;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.edu.farhadi.simplerelational.database.apis.LogicalDeletedRestController;
import org.edu.farhadi.simplerelational.database.models.StudentModel;
import org.edu.farhadi.simplerelational.database.services.LogicalDeletedService;
import org.edu.farhadi.simplerelational.database.services.StudentService;
import org.edu.farhadi.simplerelational.database.validation.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Tag(name = "Student Rest Service v1")
@RequestMapping(value = "/api/v1/student")
@Validated
public class StudentController extends BaseRestControllerImpl<StudentModel, Long> implements LogicalDeletedRestController<Long> {

    private StudentService studentService;
    public StudentController(StudentService service) {
        super(service, StudentModel.class);
        this.studentService = service;
    }

    @Override
    public LogicalDeletedService<Long> getService() {
        return studentService;
    }


    @PatchMapping(value = "/update")
    @ResponseBody
    public ResponseEntity<StudentModel> customUpdate(@Validated(Update.class) @RequestBody StudentModel model) {
        return ResponseEntity.ok(studentService.save(model));
    }

}
