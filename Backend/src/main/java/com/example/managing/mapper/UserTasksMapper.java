package com.example.managing.mapper;

import com.example.managing.entity.TaskFormEntity;
import com.example.managing.entity.UserFormEntity;
import org.apache.ibatis.annotations.Param;

public interface UserTasksMapper {
    int addingUserIDAndTaskID(UserFormEntity userFormEntity);
}
