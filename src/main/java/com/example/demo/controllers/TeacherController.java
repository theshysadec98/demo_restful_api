package com.example.demo.controllers;

import com.example.demo.models.request.TeacherRequest;
import com.example.demo.models.response.RestResult;
import com.example.demo.models.response.TeacherResponse;
import com.example.demo.service.TeacherService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/teacher")
@RequiredArgsConstructor
public class TeacherController extends BaseController {

    private final TeacherService teacherService;

    @PostMapping()
    public ResponseEntity<RestResult<TeacherResponse>> createTeacher(@RequestBody TeacherRequest request){
        log.debug("REST request to create teacher.");
        return ResponseEntity.ok(RestResult.ok(teacherService.createTeacher(request)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<RestResult<TeacherResponse>> updateTeacher(@PathVariable Long id, @RequestBody TeacherRequest request){
        log.debug("REST request to update teacher.");
        return ResponseEntity.ok(RestResult.ok(teacherService.updateTeacherById(id, request)));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RestResult<Void>> deleteTeacher(@PathVariable Long id){
        log.debug("REST request to update teacher.");
        teacherService.removeTeacherById(id);
        return ResponseEntity.ok(RestResult.ok());
    }

    @GetMapping("/{id}")
    public ResponseEntity<RestResult<TeacherResponse>> getTeacherById(@PathVariable Long id){
        log.debug("REST request to get teacher by id.");
        return ResponseEntity.ok(RestResult.ok(teacherService.getTeacherById(id)));
    }

}
