package com.example.managing.controller;

import com.example.managing.dto.ResultDto;
import com.example.managing.dto.TaskFormDto;
import com.example.managing.request.LoginInformationSearchRequest;
import com.example.managing.request.TaskFormSearchRequest;
import com.example.managing.service.LoginInformationSearchService;
import com.example.managing.service.TaskFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/taskForm")
public class TaskFormController {

    @Autowired
    TaskFormService taskFormService;

    /**我要添加新的任务**/

    @PostMapping("/addingNewTask")
    public ResultDto addingNewTask(@RequestBody TaskFormSearchRequest taskFormSearchRequest) {

        ResultDto result = taskFormService.addingNewTask(taskFormSearchRequest.getUser_id(),taskFormSearchRequest.getTaskName(),taskFormSearchRequest.getTaskDescription(),
                taskFormSearchRequest.getTaskDate(),
                taskFormSearchRequest.getTaskPriority(),
                taskFormSearchRequest.getTaskStatus());
        return result;

    }


    /**我要查询任务**/
    @PostMapping("/selectingSearchNewTask")
    public ResultDto searchingNewTask(@RequestBody TaskFormSearchRequest taskFormSearchRequest) {

        List<TaskFormDto>  result = (List<TaskFormDto>) taskFormService.searchingNewTask(taskFormSearchRequest. getUser_id());
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("任务返回成功");

        resultDto.setData(result);
        return resultDto;

    }
//
//    @PostMapping("/addingNewTask")
//    public ResultDto addingNewTask1(@RequestBody TaskFormSearchRequest taskFormSearchRequest) {
//        taskFormService
//        return null;
//
//    }

    ;
    /**只要今天的任务**/
    @PostMapping("/selectingSearchOnlyTodayTask")
    public ResultDto searchingOnlyTodayTask(@RequestBody TaskFormSearchRequest taskFormSearchRequest) {

        List<TaskFormDto>  result = (List<TaskFormDto>) taskFormService.searchingOnlyTodayTask(taskFormSearchRequest.getUser_id());
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("任务返回成功");

        resultDto.setData(result);
        return resultDto;

    }

    /**我要修改已经存在的任务**/

    @PostMapping("/changeNewTask")
    public ResultDto changeNewTask(@RequestBody TaskFormSearchRequest taskFormSearchRequest) {

        ResultDto result = taskFormService.changeNewTask(taskFormSearchRequest.getTaskName(),taskFormSearchRequest.getTaskDescription(),
                taskFormSearchRequest.getTaskDate(),
                taskFormSearchRequest.getTaskPriority(),
                taskFormSearchRequest.getTaskStatus(),
                taskFormSearchRequest.getId()
        );

        return result;

    }

    @PostMapping("/blurSearch")
    public ResultDto blurSearch(@RequestBody TaskFormSearchRequest taskFormSearchRequest) {

        List<TaskFormDto>  result = (List<TaskFormDto>) taskFormService.blurSearch(taskFormSearchRequest.getUser_id(),taskFormSearchRequest.getTaskName());
        ResultDto resultDto = new ResultDto();
        resultDto.setCode(200);
        resultDto.setMessage("任务返回成功");

        resultDto.setData(result);
        return resultDto;

    }
}
