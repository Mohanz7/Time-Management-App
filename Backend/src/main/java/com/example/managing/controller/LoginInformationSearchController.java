package com.example.managing.controller;

import com.example.managing.dto.LoginInformationSearchDto;
import com.example.managing.dto.ResultDto;
import com.example.managing.dto.SubjectGradeDto;
import com.example.managing.entity.LoginInformationSearchEntity;
import com.example.managing.request.LoginInformationSearchRequest;
import com.example.managing.service.LoginInformationSearchService;
import com.example.managing.service.SubjectGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loginInformation")


public class LoginInformationSearchController {

    @Autowired
    LoginInformationSearchService loginInformationSearchService;


    /***我想要在这里试试getMapping的方法，但是具体不用到业务里
     *
     * @param loginInformationSearchRequest
     * @return
     */
//    @GetMapping("/queryLoginInformation")
//    public LoginInformationSearchDto queryLoginInformation(@RequestParam("phone") String phone, @RequestParam("password") String password) {

    //       LoginInformationSearchDto dto = loginInformationSearchService.queryLoginInformation(phone, password);
      //  return dto;
    //}

  //  ;


    /**
     * 我要注册，那么注册的信息就会添加到数据库
     * @param loginInformationSearchRequest
     * @return
     */
    @PostMapping("/addingLoginInfo")
    public ResultDto addingLoginInfo(@RequestBody LoginInformationSearchRequest loginInformationSearchRequest) {

        ResultDto feedback= loginInformationSearchService.addingLoginInformation(loginInformationSearchRequest.getPhone(), loginInformationSearchRequest.getPassword());
        return feedback;
    }

    ;


    @PostMapping("/queryLoginInfo")
    public ResultDto queryLoginInfo(@RequestBody LoginInformationSearchRequest loginInformationSearchRequest) {

        ResultDto result = loginInformationSearchService.queryLoginInformation(loginInformationSearchRequest.getPhone(),loginInformationSearchRequest.getPassword());
        return result;

    }

    ;

    @PostMapping("/queryCodeInfo")
    public boolean queryCodeInfo(@RequestBody LoginInformationSearchRequest loginInformationSearchRequest) {

        return loginInformationSearchService.queryCodeInformation(loginInformationSearchRequest.getPhone(), loginInformationSearchRequest.getCode());

    }

    ;


}
