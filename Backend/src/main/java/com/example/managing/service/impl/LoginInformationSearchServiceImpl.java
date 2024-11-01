package com.example.managing.service.impl;

import com.example.managing.controller.LoginInformationSearchController;
import com.example.managing.dto.LoginInformationSearchDto;
import com.example.managing.dto.ResultDto;
import com.example.managing.dto.TaskFormDto;
import com.example.managing.entity.LoginInformationSearchEntity;
import com.example.managing.entity.TaskFormEntity;
import com.example.managing.mapper.LoginInformationSearchMapper;
import com.example.managing.mapper.SearchGradeListMapper;
import com.example.managing.service.LoginInformationSearchService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service

public class LoginInformationSearchServiceImpl implements LoginInformationSearchService {
    @Autowired
    public LoginInformationSearchMapper loginInformationSearchMapper;

    @Override
    public ResultDto queryLoginInformation( String phone, String password) {
        ResultDto result= new ResultDto();
        //1 添加验证逻辑
        //如果用户没有输入手机号，则返回"请输入手机号"


        if (phone.isEmpty()) {
            result.setCode(666);
            result.setMessage("请输入手机号");
            result.setData(false);
            return result;
            // 这里你可以选择抛出异常或者返回特定的错误码，具体取决于你的需求
        }

        /***If 手机号有数字或者符号，则提示：请输入数字；**/

        if (isContainsEnglishWords(phone)) {
            result.setCode(666);
            result.setMessage("请输入数字");
            result.setData(false);
            return result;

        }
        /***If 手机号不为11位数字，则提示：请输入数字；**/
        if (!isElevenNumber(phone)){
            result.setCode(666);
            result.setMessage("请输入正确(长度)手机号");
            result.setData(false);
            return result;

        }
        if(!isValidPhoneNumber(phone)){
            result.setCode(666);
            result.setMessage("请输入正确手机号");
            result.setData(false);
            return result;


        }

        //首先想要检验它是不是已经存在，已经存在的手机号不可以再次录入

        /***如果用户没有输入手机号，则返回"请输入手机号"
         *
         */

        /***如果用户输入正确手机号，则返回"注册成功"。这里用到正则这个概念。手机号一定是1打头且为11位
         *
         */
        if (password.isEmpty()){
            result.setCode(666);
            result.setMessage("请输入密码");
            result.setData(false);
            return result;

        }

        if (!isValidPasswordNumber(password)){
            result.setCode(666);
            result.setMessage("请输入正确长度的密码");
            result.setData(false);
            return result;

        }

        //2、用手机号查询数据
        //3 校验密码是否准确

        LoginInformationSearchEntity loginInformationSearchEntity = loginInformationSearchMapper.selectLoginInformationSearchListRegAll(phone);

        if(loginInformationSearchEntity==null){
            result.setCode(666);
            result.setMessage("手机号不存在，请注册");
            result.setData(false);
            return result;
        }
        if(loginInformationSearchEntity.getPhone()!=null){
            if (password.equals(loginInformationSearchEntity.getPassword())){
                result.setCode(200);
                result.setMessage("登陆成功");
                LoginInformationSearchEntity entityReturn=loginInformationSearchMapper.selectLoginInformationSearchListRegAll(phone);
                LoginInformationSearchDto dto = new LoginInformationSearchDto();

                // Set properties based on your entity
                dto.setPhone(entityReturn.getPhone());
                dto.setPassword(entityReturn.getPassword());
                dto.setId(entityReturn.getId());
                result.setData(dto);
                return result;

            }
            else{
                result.setCode(666);
                result.setMessage("密码不正确");
                result.setData(false);
                return result;
            }
        }
        return null;
    }


    /**
     * 注册
     * @param phone
     * @param password
     * @return
     */

    @Override
    public ResultDto addingLoginInformation(String phone, String password) {
        /***我想让手机号正好11个数字
         *
         */

        //如果用户没有输入手机号，则返回"请输入手机号"
        ResultDto result= new ResultDto();

        if (phone.isEmpty()) {
            result.setCode(666);
            result.setMessage("请输入手机号");
            result.setData(false);
            return result;

            // 这里你可以选择抛出异常或者返回特定的错误码，具体取决于你的需求
        }

        /***If 手机号有数字或者符号，则提示：请输入数字；**/

        if (isContainsEnglishWords(phone)) {
            result.setCode(666);
            result.setMessage("请输入数字");
            result.setData(false);
            return result;

        }
        /***If 手机号不为11位数字，则提示：请输入数字；**/
        if (!isElevenNumber(phone)){
            result.setCode(666);
            result.setMessage("请输入正确(长度)手机号");
            result.setData(false);
            return result;

        }
        if(!isValidPhoneNumber(phone)){
            result.setCode(666);
            result.setMessage("请输入正确手机号");
            result.setData(false);
            return result;

        }

        //首先想要检验它是不是已经存在，已经存在的手机号不可以再次录入
        if(alreadyHavePhone(phone)){
            result.setCode(666);
            result.setMessage("用户名已经存在,请去登录");
            result.setData(false);
            return result;

        }
        /***如果用户没有输入手机号，则返回"请输入手机号"
         *
         */

        /***如果用户输入正确手机号，则返回"注册成功"。这里用到正则这个概念。手机号一定是1打头且为11位
         *
         */
        if (password.isEmpty()){
            result.setCode(666);
            result.setMessage("请输入密码");
            result.setData(false);
            return result;


        }

        if (!isValidPasswordNumber(password)){
            result.setCode(666);
            result.setMessage("请输入正确长度的密码");
            result.setData(false);
            return result;

        }


        // Perform the addition to the database
        loginInformationSearchMapper.addingNewUserList(phone, password);

        result.setCode(200);
        result.setMessage("注册成功");
        LoginInformationSearchEntity entityReturn=loginInformationSearchMapper.selectLoginInformationSearchListRegAll(phone);
        LoginInformationSearchDto dto = new LoginInformationSearchDto();

        // Set properties based on your entity
        dto.setPhone(entityReturn.getPhone());
        dto.setPassword(entityReturn.getPassword());
        dto.setId(entityReturn.getId());
        result.setData(dto);

        return result;


    }

    @Override
    public boolean queryCodeInformation(String phone, String code) {
        if (code.length() == 4) {
            loginInformationSearchMapper.insertCode(phone, code);
            LoginInformationSearchEntity loginInformationSearchEntity = loginInformationSearchMapper.alreadyHavePhone(phone);

            if (loginInformationSearchEntity!=null&& loginInformationSearchEntity.getCode()!=null){
                return true;
            }

        }
        return false;
    }

    public boolean isValidPhoneNumber(String phone) {

        String phoneRegex = "^((13[0-9])|(14[5,7])|(15[0-3,5-9])|(17[0,3,5-8])|(18[0-9])|166|198|199|(147))\\d{8}$";
        return phone.matches(phoneRegex);
    }

    private boolean isContainsEnglishWords(String phone) {
        return phone.matches(".*[a-zA-Z].*") || phone.matches(".*\\W.*");

    }
    private boolean alreadyHavePhone(String phone) {
        LoginInformationSearchEntity loginInformationSearchEntity = loginInformationSearchMapper.alreadyHavePhone(phone);
        if (loginInformationSearchEntity!=null&&loginInformationSearchEntity.getPhone()!=null){
            return true;
        }
        return false;
    }
    private boolean isElevenNumber(String phone) {
        return phone.length()==11;

    }

    private boolean isValidPasswordNumber(String password){
        if (50 < password.length()){
            return false;
        }
        return true;

    }
}
