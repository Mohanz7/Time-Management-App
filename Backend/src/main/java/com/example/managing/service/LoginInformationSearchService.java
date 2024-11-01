package com.example.managing.service;

import com.example.managing.dto.LoginInformationSearchDto;
import com.example.managing.dto.ResultDto;
import com.example.managing.dto.SubjectGradeDto;
import com.example.managing.entity.LoginInformationSearchEntity;

public interface LoginInformationSearchService {
    ResultDto queryLoginInformation(String phone, String password);
    ResultDto addingLoginInformation(String phone, String password);

    boolean queryCodeInformation(String phone, String code);


}
