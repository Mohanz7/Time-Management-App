<template>
    <div class="login_container flex">
        
        <!-- <div class="image_layout">
            <img src="../assets/Login_icon.png" alt="">
        </div>
        <div class="loginWord">
            <div class="titleOfLogin">
                解放任务 高效管理
            </div>
            <div class="titleOfLogin2">
                登录
            </div>
            <div class="passwordLogin">
                
                <div class="phoneLogin flex">
                    <span class="inlineFlex">手机号:</span> 
                    <el-input
                        placeholder="请输入手机号"
                        v-model="inputOfPhone"
                        clearable>
                    </el-input> 
                </div>
                <div class="passwordInsert flex">
                    <span>密码:</span> 
                    <el-input placeholder="请输入密码" v-model="inputOfPasswrod" show-password></el-input>
                </div>
                <div class="loginButton">
                    <el-row>
                    <el-button type="primary">登录</el-button>
                    </el-row>
                </div>
            </div>
        </div> -->
        <div class="left">

        </div>
        <div class="right flex">
            <div class="center">
                <div class="title">b标题</div>
                <div class="zhuce login-box" v-if="!isLogin">
                    <div class="login">zhuce</div>
                </div>
                <div class="denglu login-box" v-else>
                    <div class="login">登录</div>
                    <div class="phoneLogin flex">
                        <span class="inlineFlex">手机号:</span>
                        <el-input placeholder="请输入手机号" v-model="inputOfPhone" clearable>
                        </el-input>
                    </div>
                    <el-input v-model="phone" placeholder="请输入s手机"></el-input>
                    <el-input v-model="psd" placeholder="请输入密码"></el-input>
                </div>
                <div class="qiehuan" @click="isLogin = !isLogin">切换</div>
            </div>
        </div>

    </div>
</template>

<script>
export default {
    data() {
        return {
            inputOfPhone: "",
            inputOfPasswrod: "",
            isLogin: true
        };
    },
    methods: {},
};
</script>

<style lang='less' scoped>
.flex {
    display: flex;
    align-items: center;
}

.login_container {
    width: 100vw;
    height: 100vh;
    min-width: 1440px;

    // background: url("../assets/");
    >div {
        flex: 1;
        height: 100%;
    }

    .left {
        background: url(../assets/Login_icon.png) no-repeat;
        background-size: 100% 100%;
    }

    .right {
        justify-content: center;

        .center {
            .title {
                font-size: 36px;
                font-weight: bolder;
                margin-bottom: 100px;

            }

            .login-box {
                width: 440px;
                height: 400px;
                .login {
                    font-size: 24px;
                    font-weight: bold;
                }
                .inlineFlex{
                    width: 100px;
                }
            }
        }
    }
}

// .login_container{
//     background-color: rgba(255, 255, 255, 1);
//     position: relative;
//     width: 100vw;
//     height: 100vh;
//     overflow: hidden;
// }
// .image_layout{

//   width: 192px;
//   height: 133px;


// }
// .passwordLogin{
//     width: 443px;
//   height: 599px;
//   margin-top: 113px;
//   border: 1px solid #eee;
// }
// .titleOfLogin2{
//     margin-top: 60px;
//     margin-left:800px;
//     font-size: 30px;
//     font-family: PingFangSC-Semibold;
// }

// .titleOfLogin{

//   width: 443px;
//   height: 70px;
//   overflow-wrap: break-word;
//   color: rgba(10, 23, 25, 1);
//   font-size: 50px;
//   letter-spacing: -0.875px;
//   font-family: PingFangSC-Semibold;
//   font-weight: 600;
//   text-align: left;
//   white-space: nowrap;
//   line-height: 70px;
//   margin-left:903px;


// }

// .phoneLogin{
//     margin-left: 903px;
//     margin-top:80px;
//     .flex {
//       align-items: baseline; /* Adjusted alignment */
//     }

// }

// .passwordInsert{
//     margin-left: 903px;
//     margin-top:80px;

// }
// .inlineFlex{
//     display: inline-flex;
//     align-items: center; 

// }

// .loginButton{
//     width: 44px;
//   height: 30px;
//   overflow-wrap: break-word;
//   color: rgba(255, 255, 255, 1);
//   font-size: 22px;
//   font-weight: NaN;
//   text-align: left;
//   white-space: nowrap;
//   line-height: 30px;
//   margin-left: 903px;
//     margin-top:80px;

// }</style>