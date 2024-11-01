package com.example.managing.mapper;

import com.example.managing.dto.TaskFormDto;
import com.example.managing.entity.TaskFormEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Date;
import java.util.List;

public interface TaskFormMapper {

    int addingNewTaskList( TaskFormEntity taskFormEntity);
    List<TaskFormEntity> searchingNewTask(@Param("user_id") int user_id);

    List<TaskFormEntity> searchingOnlyTodayTask(@Param("user_id") int user_id);

    int changeNewTaskList(TaskFormEntity taskFormEntity);

    List<TaskFormEntity>  blurSearch(@Param("user_id") int user_id,@Param("taskName") String taskName);
}
