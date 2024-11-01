package com.example.managing.mapper;

import com.example.managing.entity.LoginInformationSearchEntity;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestParam;

public interface LoginInformationSearchMapper {
    /**
     * 我要查询手机号密码这个栏目，给手机号给密码可以调出整个
     * @param phone
     * @param password
     * @return
     */
    LoginInformationSearchEntity selectLoginInformationSearchListRegAll(@Param("phone") String phone);
    /**
     * 我要增加手机号密码，把给到的信息存入后台数据库
     * @param phone
     * @param password
     * @return
     */
    LoginInformationSearchEntity addingNewUserList(@Param("phone") String phone, @Param("password") String password);

    /***
     * 根据手机号查手机号是否已经存在
     * @param phone
     * @return
     */
    LoginInformationSearchEntity alreadyHavePhone(@Param("phone") String phone);

    LoginInformationSearchEntity insertCode(@Param("phone") String phone,@Param("code") String code);



}
