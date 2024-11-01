<!-- <template>
    <div class="theWholePageLayOut">
        <div class="theHeader flex">
            <div class="theSearchBox flex">
                <div class="searching">
                    <el-input placeholder="请输入搜索内容" v-model="inputOfSearching" clearable></el-input>
                </div>
                <div class="addingNewContext flex">
                    <div class="icon">
                        <el-button type="text" @click="addTask(1)"><img src="@/assets/myDemo.png" alt="User Account Image"
                                @click="theNewAddedForm" /></el-button>
                    </div>
                    <el-dialog title="添加任务" :visible.sync="theFormDisplay">
                        <el-form :model="form">
                            <el-form-item label="任务名" :label-width="formLabelWidth">
                                <el-input v-model="form.taskName" autocomplete="off"></el-input>
                            </el-form-item>
                            <el-form-item label="任务描述" :label-width="formLabelWidth">
                                <el-input v-model="form.descripition" autocomplete="off"></el-input>
                            </el-form-item>
                            <div class="block flex">
                                <div class="dateWord">
                                    日期
                                </div>
                                
                                <div class="demonstration">
                                    <el-date-picker v-model="form.dateSelect" type="date" placeholder="选择日期"
                                        value-format="yyyy-mm-dd">
                                    </el-date-picker>
                                </div>
                                <div class="theSelection flex">
                                    <div class="dateWord">
                                        优先级
                                    </div>
                                    <el-select v-model="form.value" placeholder="请选择优先级">
                                        <el-option v-for="item in options" :key="item.value" :label="item.label"
                                            :value="item.value">
                                        </el-option>
                                    </el-select>
                                </div>
                            </div>
                        </el-form>
                        <div slot="footer" class="dialog-footer">
                            <el-button @click="cancel">取 消</el-button>
                            <el-button type="primary" @click="saveData">确 定</el-button>
                        </div>
                    </el-dialog>



                </div>

            </div>
            <div class="theImageOfTheUser" @mouseover="showLogout" @mouseleave="hideLogout">

                <el-avatar> user </el-avatar>
<!-- 
                <!-- <div class="logout" v-show="showLogoutText" @click="reDirectToTheLogOutPage">
                    <el-button type="primary">退出</el-button>
                </div> -->
                <!-- <div class="logout" v-show="showLogoutText" @click="reDirectToTheLogOutPage">退出</div>

            </div>

        </div>
        <div class="theContext flex">
            <div class="leftOfPage">
                <div class="demo">
                    <img src="@/assets/theIcon.png" alt="User Account Image" />
                </div>
                <div class="todaytask " @click="showtask(1)">
                    今日任务


                </div>
                <div class="allTask" @click="showtask(2)">
                    所有任务

                </div>


            </div>
            <div class="rightOfPage">
                <div class="allTask">

                    <div class="reShowList" v-if='taskList.length'>
                        <div class="item flex" v-for="item in taskList" :key="item.id" :class="item.status ? 'item-done' : ''">
                            <div class="left-checkbox">
                                <el-checkbox v-model="item.status" size="medium"> </el-checkbox>
                            </div>
                            <div class="right-taskcontent">
                                <div class="r-top flex">
                                    <div class="r-t-title">{{ item.title }}</div>
                                    <div class="r-t-date">{{ item.date }}</div>
                                    <div class="edit" @click="addTask(2, item)" v-if="!item.status"><i
                                            class="el-icon-edit"></i></div>
                                </div>
                                <div class="r-btm">
                                    <div class="r-t-msg">{{ item.message }}</div>
                                </div>
                            </div>
                        </div>
                        <!-- <div class="item" v-for="item in taskList" :key="item.id">
                            <div class="theBasic flex">
                                <div class="checkBox"><el-checkbox v-model="checked">
                                        <div class="theTaskTitle">{{ item.title }}</div>
                                    </el-checkbox></div>

                                <div class="thedate">{{ item.date }}</div>


                                
                                <div class="change" @click="theFormReDisplay = true"><i class="el-icon-edit"></i></div>

                            </div>
                            <div class="theMessage">{{ item.message }}</div>
                            <div class="formReshow">
                                <el-dialog title="添加任务" :visible.sync="theFormReDisplay">
                                    <el-form :model="form">
                                        <el-form-item label="任务名" :label-width="formLabelWidth">
                                            <el-input v-model="item.title" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <el-form-item label="任务描述" :label-width="formLabelWidth">
                                            <el-input v-model="item.message" autocomplete="off"></el-input>
                                        </el-form-item>
                                        <div class="block flex">
                                            <div class="dateWord">
                                                日期
                                            </div>
                                            <div class="demonstration">
                                                <el-date-picker v-model="item.date" type="date" placeholder="选择日期">
                                                </el-date-picker>
                                            </div>
                                            <div class="theSelection flex">
                                                <div class="dateWord">
                                                    优先级
                                                </div>
                                                <el-select v-model="item.status" placeholder="请选择优先级">
                                                    <el-option v-for="item in options" :key="item.value" :label="item.label"
                                                        :value="item.value">
                                                    </el-option>
                                                </el-select>
                                            </div>
                                        </div>
                                    </el-form>
                                    <div slot="footer" class="dialog-footer">
                                        <el-button @click="theFormDisplay = false">取 消</el-button>
                                        <el-button type="primary" @click="theFormDisplay = false">确 定</el-button>
                                    </div>
                                </el-dialog>


                            </div>
                        </div> -->
                    <!-- </div>

                    <div class="renwulist" v-else>
                        z暂无任务
                    </div>
                </div>

            </div>

        </div>
    </div>
</template> -->

<!-- <script>
export default {
    data() {
        return {
            inputOfSearching: '',
            showLogoutText: false,
            theFormDisplay: false,
            theFormReDisplay: false,

            form: {
                taskName: '',
                descripition: '',
                dateSelect: '',
                value: ''
            },
            formLabelWidth: '100px',

            pickerOptions: {
                disabledDate(time) {
                    return time.getTime() > Date.now();
                },
                shortcuts: [{
                    text: '今天',
                    onClick(picker) {
                        picker.$emit('pick', new Date());
                    }
                }, {
                    text: '昨天',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24);
                        picker.$emit('pick', date);
                    }
                }, {
                    text: '一周前',
                    onClick(picker) {
                        const date = new Date();
                        date.setTime(date.getTime() - 3600 * 1000 * 24 * 7);
                        picker.$emit('pick', date);
                    }
                }]
            },
            dateSelect: '',
            options: [{
                value: 'P1',
                label: 'P1'
            }, {
                value: 'P2',
                label: 'P2'
            }, {
                value: 'P3',
                label: 'P3'
            }],
            value: '',
            todayData: [
                {
                    title: '吃红烧肉',
                    message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
                    date: '2023-10-10',
                    status: false,
                    id: 1,
                    value: 'P2'
                },
                {
                    title: '吃白斩鸡',
                    message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
                    date: '2023-10-18',
                    status: true,
                    id: 2,
                    value: 'P1'
                },
            ],
            allData: [
            {
                    title: '吃白斩鸡',
                    message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
                    date: '2023-10-18',
                    status: true,
                    id: 2,
                    value: 'P1'
                },
                {
                    title: '吃白斩鸡',
                    message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
                    date: '2023-10-18',
                    status: true,
                    id: 2,
                    value: 'P1'
                },
                {
                    title: '吃白斩鸡',
                    message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
                    date: '2023-10-18',
                    status: true,
                    id: 2,
                    value: 'P1'
                },
                
            ],
            taskList: []

        }
    },
    methods: {
        showLogout() {
            this.showLogoutText = true;
        },
        hideLogout() {
            this.showLogoutText = false;
        },
        reDirectToTheLogOutPage() {
            console.log("Redirecting to /Login");
            this.$router.push("/Login");
        },
        theNewAddedForm() {
            this.theFormDisplay = true;
        },
        showtask(type) {
            if (type == 1) {
                // 今日任务
                this.taskList = this.todayData
            } else {
                // 所有任务
                this.taskList = this.allData

            }
        },
        addTask(type, row) {
            this.theFormDisplay = true;
            if (type == 2) {
                const { title, message, id, date, value } = row
                this.form = {
                    taskName: title,
                    descripition: message,
                    dateSelect: date,
                    value,
                    id
                }
            }
            else{
            this.form = {
                taskName: "",
                descripition: "",
                dateSelect: "",
                value: ""
            }}
            

        },
        cancel() { -->
            <!-- // this.form = {
            //     taskName: "",
            //     descripition: "",
            //     dateSelect: "",
            //     value: ""
            // }
        //     this.theFormDisplay = false
        // },
        // saveData() {
            
            // if (this.form.id) {
            //     //编辑
            //     this.form[this.form.id] = {
            // taskName: this.form.title,
            // descripition: this.form.message,
            // dateSelect: this.form.date,
            // value: this.form.status,
            // id: item.id,
            // };
//             const editedTaskIndex = this.taskList.findIndex(task => task.id === this.form.id);
//         if (editedTaskIndex !== -1) {
//             this.taskList[editedTaskIndex] = {
//                 title: this.form.taskName,
//                 message: this.form.descripition,
//                 date: this.form.dateSelect,
//                 value: this.form.value,
//                 status: false, // Set the default status for edited tasks
//                 id: this.form.id,
//             };
           
//             }
//             else {
//                 const newTask = {
//                 title: this.form.taskName,
//                 message: this.form.descripition,
//                 date: this.form.dateSelect,
//                 value: this.form.value,
//                 status: false, // Set the default status for new tasks
//                 id: this.taskList.length + 1,
//             };
//             this.taskList.push(newTask);

//             }
//             this.theFormDisplay = false
//         }
//     }
// }
// </script>

// <style lang="less" scoped>
// .flex {
//     display: flex;
//     align-items: center;
// }

// .theWholePageLayOut {
//     height: 100vh;
//     width: 100vw;

//     .theHeader {
//         height: 15%;
//         width: 100%;
//         background-color: black;

//         .theSearchBox {
//             justify-content: center;
//             position: relative;

//             .searching {
//                 margin-left: 600px;
//                 margin-right: 50px;
//                 width: 300px;
//             }

//             .addingNewContext {
//                 width: 50px;
//                 height: 50px;

//                 .block {
//                     margin-left: 50px;

//                     .dateWord {
//                         margin-right: 20px;

//                     }

//                     .theSelection {
//                         margin-left: 120px;


//                     }
//                 } -->


<!-- //                 img {
//                     width: 100%;
//                     height: 100%
//                 }

//                 .theNewAddedForm {
//                     margin-left: 50px
//                 }

//             }

//         }

//         .theImageOfTheUser {
//             display: flex;
//             align-items: center;
//             margin-left: 300px;
//             position: relative;


//             .logout {
//                 display: none;
//                 position: absolute;
//                 top: 100%;


//             }

//             &:hover .logout {
//                 display: block;
//             }

//         }





//     }



//     .theContext {
//         height: 85%;
//         width: 100%;

//         >div {
//             height: 100%;
//         }

//         .leftOfPage {
//             flex: 0.5;

//             position: relative;

//             .demo {
//                 width: 50px;
//                 height: 50px;
//                 margin-top: 50px;
//                 margin-left: 140px;

//                 img {
//                     width: 100%;
//                     height: 100%
//                 }
//             }

//             .todaytask {
//                 margin-top: 50px;
//                 margin-left: 130px;
//             }

//             .allTask {
//                 margin-top: 25px;
//                 margin-left: 130px;
//             }

//         }

//         .rightOfPage {

//             flex: 3;
//             background-color: green;
//             margin-left: 200px;

//             .theTaskTitle {
//                 font-size: 30px;
//                 font-weight: bold;
//                 margin-left: 35px;
//                 margin-top: 40px;
//             }

//             .thedate {
//                 color: blue;
//                 margin-left: 35px;
//             }

//             .theMeassage {
//                 margin-left: 35px;
//                 margin-top: 40px;

//             }

//             .reShowList {
//                 .item {
//                     align-items: flex-start;
//                     margin: 12px;

//                     .left-checkbox {
//                         margin: 0 12px;
//                         position: relative;
//                         top: 12px;
//                     }

//                     .right-taskcontent {
//                         .r-t-title {
//                             font-size: 30px;
//                             font-weight: 500;
//                         }

//                         .r-t-date {
//                             margin-left: 24px;
//                             color: aqua;
//                         }

//                         .edit {
//                             margin-left: 12px;
//                             cursor: pointer;
//                         }
//                     }
//                 }

//                 .item-done {
//                     color: red;

//                     .r-t-date {
//                         color: red !important;
//                     }
//                 }
//             }

//             // .allTask{
//             //     // position: fixed;//以body为参照物
//             //     // position: relative; // 以自身为参照物 -->
<!-- //             //     left: 20px;
//             //     // top: 20px;
//             //     top: 100px;
//             //     // color: red;
//             //     position: absolute; //父级 祖级  有relative  他们便是参照物   没有body便是参照物
//             // }
//         }



//     }




// }</style>  -->

<template>
    <div class="theWholePage">
    <div class="theHeader">
        <!-- 中间两个盒子  有搜索框和添加标签-->
        <div class="theSearchBox">
            <div class="Searching">

            </div>
            <div class="addingNewTask">

            </div>

        </div>
        <div class="logOut">
            <!-- 用户头像，和登出 -->
        </div>
    </div>
    <div class="theContext">

    </div>
    </div>


</template>

<script>
</script>    

<style lang="less" scoped >

</style>    