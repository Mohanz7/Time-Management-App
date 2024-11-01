package com.example.managing.service.impl;

import com.example.managing.dto.SubjectGradeDto;
import com.example.managing.entity.SubjectGradeEntity;
import com.example.managing.mapper.SearchGradeListMapper;
import com.example.managing.service.SubjectGradeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubjectGradeServiceImpl implements SubjectGradeService {

    @Autowired
    public SearchGradeListMapper searchGradeListMapper;

    @Override
    public SubjectGradeDto querySubjectGrade(String name) {
        SubjectGradeEntity subjectGradeEntity = searchGradeListMapper.selectSearchGradeListRegAll(name);
        SubjectGradeDto dto = new SubjectGradeDto();
        //1
        dto.setSubject(subjectGradeEntity.getSubject());
        dto.setGrade(subjectGradeEntity.getGrade());
        //2
        /***
         BeanUtils.copyProperties(subjectGradeEntity,dto);***/
         return dto;

    }
}