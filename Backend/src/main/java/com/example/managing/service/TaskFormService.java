package com.example.managing.service;

import com.example.managing.dto.ResultDto;
import com.example.managing.dto.TaskFormDto;
import com.example.managing.entity.TaskFormEntity;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface TaskFormService {
   ResultDto addingNewTask(int user_id, String taskName, String taskDescription, Date taskDate, String taskPriority, Boolean taskStatus);
   List<TaskFormDto> searchingNewTask(int user_id);

   List<TaskFormDto> searchingOnlyTodayTask(int user_id);

   ResultDto changeNewTask(String taskName, String taskDescription, Date taskDate, String taskPriority, Boolean taskStatus, int id);

   List<TaskFormDto> blurSearch(int user_id,String taskName);

}
