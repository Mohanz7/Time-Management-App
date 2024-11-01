package com.example.managing.controller;

import com.example.managing.dto.SubjectGradeDto;
import com.example.managing.service.SubjectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subjectGrade")
public class SubjectGradeController {

    @Autowired
    SubjectGradeService subjectGradeService;

    @GetMapping("/querySubjectGrade")
    public SubjectGradeDto querySubjectGrade(@RequestParam("name") String name){
        SubjectGradeDto dto = subjectGradeService.querySubjectGrade(name);
        return dto;
    }

}
