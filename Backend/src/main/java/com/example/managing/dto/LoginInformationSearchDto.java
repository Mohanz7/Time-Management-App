package com.example.managing.dto;

public class LoginInformationSearchDto {
    /**
     *我要搞一个手机号
     */
    private String Phone;

    /**
     *密码
     */
    private String Password;

    /**
     *验证码
     */

    private String code;

    private int id;



    public String getPhone() {
        return Phone;
    }

    public void setPhone(String phone) {
        Phone = phone;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
