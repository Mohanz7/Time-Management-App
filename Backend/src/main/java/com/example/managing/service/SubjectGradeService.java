package com.example.managing.service;

import com.example.managing.dto.SubjectGradeDto;

public interface SubjectGradeService {
    /**
     * 根据姓名查询对应人的课程和成绩
     * @param name
     * @return
     */
    SubjectGradeDto querySubjectGrade(String name);
}
