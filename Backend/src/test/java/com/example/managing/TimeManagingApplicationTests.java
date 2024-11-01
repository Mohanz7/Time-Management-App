package com.example.managing;

import com.example.managing.dto.SubjectGradeDto;
import com.example.managing.service.SubjectGradeService;
import javax.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimeManagingApplicationTests {

    @Resource
    SubjectGradeService service;

    @Test
    void contextLoads() {

        SubjectGradeDto subjectGradeDto = service.querySubjectGrade("");
        System.out.println(subjectGradeDto);
    }

}
