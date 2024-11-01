<template>
    <div class="theWholePage flex">
        <div class="leftOfpage">
        </div>
        
        <div class="rightOfpage">
            <div class="title">解放任务，高效管理</div>
            <div class="contentofLogin" v-if="displayLoginIn">
                
                <div class="phoneInsert flex">
                    <span class="shoujihao">手机号：</span>
                    <el-input placeholder="请输入手机号" v-model="inputOfPhone" clearable></el-input>
                    

                </div>
                <div class="passwordInsert flex">
                    <span class="mima">密码：</span>
                    <el-input placeholder="请输入密码" v-model="inputOfPasswrod" show-password></el-input>
                </div>
                <div class="dengLuButton">
                    <el-button type="primary" @click="decideWhetherLoginSuccessOrNot">登录</el-button>
                </div>
                <div class="noUserNameAndSwitchToCreateAccount" @click="cannotLogin">
                    没有账户？ 点击注册
                </div>
    
                
            </div>
            <div class="contentofCreatingAccount" v-if="!displayLoginIn">
                
                <div class="phoneInsert flex">
                    <span class="shoujihao">手机号：</span>
                    
                    <el-input
                        placeholder="请输入手机号" v-model="namephone" clearable>
                    </el-input>

                </div>
                <div class="codeInsert flex">
                    <span class="yanZhengMa">验证码：</span>
                    <el-input placeholder="请输入验证码" v-model="codeInsert" show-password >
                        
                    </el-input>
                    <el-button type="primary" @click="getCode">{{buttonText}}</el-button>
                </div>        

               
                <div class="passwordInsert flex">
                    <span class="mima">密码：</span>
                    <el-input placeholder="请输入密码" v-model="inputforPasswrod" show-password></el-input>
                </div>
                <div class="zhuCeButton">
                    <el-button type="primary" @click="decideWhetherCreateAccountSuccessOrNot">注册</el-button>
                </div>
                <div class="returnLoginButton">
                    <span class="yanZhengMa"  @click="decideWhetherBackToLogin">已有账号？返回登录</span>    
                </div>
            </div>

        </div>

    </div>
</template>


<script>
// import * as Api from "../api/index"
import * as Api from "@/api/index.js"
export default {

    data() {
        return {
            inputOfPhone: "",
            inputOfPasswrod: "",
            codephone:null,
            displayLoginIn: true,
            buttonText:'获取验证码',
            getCodeStatus: false,
            timer: null,
            count:0,
            namephone:'',
            codeInsert:'',
            inputforPasswrod:''
            
            
            

        };
    },
    mounted(){
        sessionStorage.clear(); 
       
    },
    methods: {
        cannotLogin(){
            this.displayLoginIn=false
        },
        getCode(){

            if(this.getCodeStatus) return;
            const TIME_COUNT = 6;
            if (!this.timer) {
                this.count = TIME_COUNT;
                this.getCodeStatus = true;
                this.timer = setInterval(() => {
                    if (this.count > 0 && this.count <= TIME_COUNT) {
                        this.count--;
                        this.buttonText = this.count + "s";
                    } else {
                        this.getCodeStatus = false
                        this.buttonText = "获取验证码";
                        clearInterval(this.timer);
                        this.timer = null;
                    }
                }, 1000)
            }
        
        },
        decideWhetherLoginSuccessOrNot(){
            //如果手机号为空，是不可以的
            if(!this.inputOfPhone){
                this.$message.error('请输入手机号')
                return ;
            }
            //如果手机号包含英文字母，是不可以的
            if (/[a-zA-Z]/.test(this.inputOfPhone)) {
                console.log("The phone contains English")
                this.$message.error('手机号栏目包含英文，请输入数字')
                return;
                
            }
            //如果手机号不是11位手机号的正确写法，是不可以的
            if (!/^\d{11}$/.test(this.inputOfPhone)) {
                console.log("The phone exceed the maximum")
                this.$message.error('请输入11位有效手机号')
                return ;
            }

            console.log("pass the phone check section");
            //如果密码为空，是不可以的
            if(!this.inputOfPasswrod){
                this.$message.error('请输入密码')
                return;
            }
          console.log("password is not empty");
            //如果密码长度大于50，是不可以的
            if(this.inputOfPasswrod.length>50){
                this.$message.error('请输入正确长度的密码')
                return;
            }
            console.log("Successfully log in");
            // this.$router.push('/MainPage');
            this.beginLogin()
            

        },

        beginLogin(){
            const params = {
                password: this.inputOfPasswrod,
                phone:this.inputOfPhone
            }
            Api.login(params).then(res=>{
                console.log("This is log in with the account", res)
                if(res.id){
                    sessionStorage.setItem('userId',res.id)
            
                    this.$router.push('/MainPage')
                    console.log("Again");
                }else{
                    this.$message.error('没有返回userId,请重新登录！')
                }
                    
            })
        },
        decideWhetherCreateAccountSuccessOrNot(){
            if(!this.namephone){
                this.$message.error('请输入手机号')
                return ;
            }
            if (/[a-zA-Z]/.test(this.namephone)) {
                
                this.$message.error('手机号栏目包含英文，请输入数字')
                return;
                
            }
            if (!/^\d{11}$/.test(this.namephone)) {
                
                this.$message.error('请输入11位有效手机号')
                return ;
            }
            if(!this.codeInsert){
                this.$message.error('请输入验证码')
                return;
            }
            if(!this.inputforPasswrod){
                this.$message.error('请输入密码')
                return;
            }
          
            
            if(this.inputforPasswrod.length>50){
                this.$message.error('请输入正确长度的密码')
                return;
            }
            console.log("Successfully create in");
            this.beginCreatingAnAccount()
            

            

        },
        decideWhetherBackToLogin(){
            // this.$router.push('/Login');
            this.displayLoginIn=true;

        },
        beginCreatingAnAccount(){
            const params = {
                phone:this.namephone,
                password: this.inputforPasswrod,
            }
            Api.createAnAccount(params).then(res=>{
                console.log("This is log in", res)
                this.$message.success('注册成功， 请登录');
                this.displayLoginIn = !this.displayLoginIn;
                this.inputOfPhone = this.namephone;
                this.inputOfPasswrod = this.inputforPasswrod;
            })

    },
}
};

</script>

<style lang='less' scoped>
.flex {
    display: flex;
    align-items: center;
}
.theWholePage {
    width: 100vw;
    height: 100vh;
    min-width: 1440px;
    >div {
        flex: 1;
        height: 100%;
    }
 
    .leftOfpage {
        background: url(../assets/Login_icon.png) no-repeat;
        background-size: 100% 100%;
    }
    .rightOfpage{
        justify-content: center;
        padding-top: 200px;
        box-sizing: border-box;
        .title{
            font-size: 36px;
            font-weight: bolder;
            margin-bottom: 100px;

        }
        .contentofLogin{
        .loginTitle{
            font-size: 28px;
            font-weight: bolder;
            margin-bottom: 100px;
        }
        .phoneInsert{
            margin-left: 120px;
            width: 440px;
            margin-bottom: 50px;
           
            .shoujihao{
            font-size: 20px;
            width: 200px;

            }
      
        }
        .passwordInsert{
            margin-left: 120px;
            width: 440px;
            margin-bottom: 50px;
           
            .mima{
            font-size: 20px;
            width: 200px;

            }
      
        }
     
        .dengLuButton{
            margin-bottom: 30px;
        } 
        .noUserNameAndSwitchToCreateAccount{
            color:rgb(0, 55, 255);
        }
    }
        .contentofCreatingAccount{
        .creatingTitle{
            font-size: 28px;
            font-weight: bolder;
            margin-bottom: 100px;
        }
        .phoneInsert{
            margin-left: 120px;
            width: 440px;
            margin-bottom: 50px;
           
            .shoujihao{
            font-size: 20px;
            width: 200px;

            }
      
        }
        .returnLoginButton{
            .yanZhengMa{
                color:blue;
            }

        }
        .codeInsert{
            margin-left: 120px;
            width: 440px;
            margin-bottom: 50px;
           
            .yanZhengMa{
                font-size: 20px;
                width: 200px;
                
            }
            /deep/ .el-input{
                    width: 259px;
                    margin-right: 12px;
                }
            /deep/ .el-button{
                    width: 120px;
                }

        }
        .passwordInsert{
            margin-left: 120px;
            width: 440px;
            margin-bottom: 50px;
           
            .mima{
            font-size: 20px;
            width: 200px;

            }
      
        }
     
        .zhuCeButton{
            margin-bottom: 30px;
        } 
    }        

    }

}


</style>