package com.example.managing.service.impl;

import com.example.managing.dto.ResultDto;
import com.example.managing.dto.SubjectGradeDto;
import com.example.managing.dto.TaskFormDto;
import com.example.managing.entity.SubjectGradeEntity;
import com.example.managing.entity.TaskFormEntity;
import com.example.managing.entity.UserFormEntity;
import com.example.managing.mapper.LoginInformationSearchMapper;
import com.example.managing.mapper.TaskFormMapper;
import com.example.managing.mapper.UserTasksMapper;
import com.example.managing.service.SubjectGradeService;
import com.example.managing.service.TaskFormService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TaskFormImpl implements TaskFormService {
    @Autowired
    public TaskFormMapper taskFormMapper;
    @Autowired
    public UserTasksMapper userTasksMapper;
    @Override
    public ResultDto addingNewTask(int user_id,String taskName, String taskDescription, Date taskDate, String taskPriority, Boolean taskStatus)

    {
        TaskFormEntity taskFormEntity = new TaskFormEntity();
        taskFormEntity.setTaskName(taskName);
        taskFormEntity.setTaskDescription(taskDescription);
        taskFormEntity.setTaskDate(taskDate);
        taskFormEntity.setTaskPriority(taskPriority);
        taskFormEntity.setTaskStatus(taskStatus);

        taskFormMapper.addingNewTaskList(taskFormEntity);
        int taskForm_id = taskFormEntity.getId();

        UserFormEntity userFormEntity = new  UserFormEntity();
        userFormEntity.setTaskForm_id(taskForm_id);
        userFormEntity.setUser_id(user_id);
        userTasksMapper.addingUserIDAndTaskID(userFormEntity);
        ResultDto result = new ResultDto();
        result.setCode(200);
        result.setMessage("任务添加成功");
        result.setData(true);
        return result;


    }

    @Override
    public  List<TaskFormDto>  searchingNewTask(int user_id){
        List<TaskFormEntity> taskFormEntities = taskFormMapper.searchingNewTask(user_id);

        //1
        List<TaskFormDto> dtos = new ArrayList<>();
        for (TaskFormEntity entity : taskFormEntities) {
            TaskFormDto dto = new TaskFormDto();

            // Set properties based on your entity
            dto.setTaskName(entity.getTaskName());
            dto.setTaskDescription(entity.getTaskDescription());
            dto.setTaskDate(entity.getTaskDate());
            dto.setTaskPriority(entity.getTaskPriority());
            dto.setTaskStatus(entity.getTaskStatus());
            dto.setId(entity.getId());


            // If you want to use BeanUtils.copyProperties, uncomment and use it here
            // BeanUtils.copyProperties(entity, dto);

            dtos.add(dto);
        }

        // Return a list of TaskFormDto if needed
        return dtos;
    }

    @Override
    public  List<TaskFormDto>  searchingOnlyTodayTask(int user_id){
        List<TaskFormEntity> taskFormEntities = taskFormMapper.searchingOnlyTodayTask (user_id);

        //1
        List<TaskFormDto> dtos = new ArrayList<>();
        for (TaskFormEntity entity : taskFormEntities) {
            TaskFormDto dto = new TaskFormDto();

            // Set properties based on your entity
            dto.setTaskName(entity.getTaskName());
            dto.setTaskDescription(entity.getTaskDescription());
            dto.setTaskDate(entity.getTaskDate());
            dto.setTaskPriority(entity.getTaskPriority());
            dto.setTaskStatus(entity.getTaskStatus());

            dto.setId(entity.getId());
            // If you want to use BeanUtils.copyProperties, uncomment and use it here
            // BeanUtils.copyProperties(entity, dto);

            dtos.add(dto);
        }

        // Return a list of TaskFormDto if needed
        return dtos;
    }
    @Override
    public ResultDto changeNewTask(String taskName, String taskDescription, Date taskDate, String taskPriority, Boolean taskStatus, int id)

    {
        TaskFormEntity taskFormEntity = new TaskFormEntity();
        taskFormEntity.setTaskName(taskName);
        taskFormEntity.setTaskDescription(taskDescription);
        taskFormEntity.setTaskDate(taskDate);
        taskFormEntity.setTaskPriority(taskPriority);
        taskFormEntity.setTaskStatus(taskStatus);
        taskFormEntity.setId(id);

        taskFormMapper.changeNewTaskList(taskFormEntity);
        ResultDto result = new ResultDto();
        result.setCode(200);
        result.setMessage("任务添加成功");
        result.setData(true);
        return result;


    }
    @Override
    public List<TaskFormDto> blurSearch(int user_id,String taskName){
        List<TaskFormEntity> taskFormEntities = taskFormMapper.blurSearch(user_id, taskName);
        //1
        List<TaskFormDto> dtos = new ArrayList<>();
        for (TaskFormEntity entity : taskFormEntities) {
            TaskFormDto dto = new TaskFormDto();

            // Set properties based on your entity
            dto.setTaskName(entity.getTaskName());
            dto.setTaskDescription(entity.getTaskDescription());
            dto.setTaskDate(entity.getTaskDate());
            dto.setTaskPriority(entity.getTaskPriority());
            dto.setTaskStatus(entity.getTaskStatus());
            dto.setId(entity.getId());


            // If you want to use BeanUtils.copyProperties, uncomment and use it here
            // BeanUtils.copyProperties(entity, dto);

            dtos.add(dto);
        }

        // Return a list of TaskFormDto if needed
        return dtos;
    }


}
