
package com.example.managing.mapper;

import com.example.managing.entity.SubjectGradeEntity;
import org.apache.ibatis.annotations.Mapper;

//@Mapper
public interface SearchGradeListMapper {
    //查询：所有配置(先查所有配置)
    SubjectGradeEntity selectSearchGradeListRegAll(String name);

//    //查询：配置
//    List<Map<String, Object>> selectSearchGradeListConfig(Map<String, Object> paramMap);
//
//    //新增：配置
//    void addSearchGradeListConfig(List<Map<String, String>> paramList);
//
//    //修改：配置
//    void modifySearchGradeListConfig(Map<String, Object> paramMap);
//
//    //删除：表单数据
//    void deleteData(Map<String, Object> paramMap);

}

