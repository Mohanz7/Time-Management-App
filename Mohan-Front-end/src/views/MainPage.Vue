<template>
    <div class="theWholePage">

        <div class="theNewForm" >


         

<el-dialog title= "添加" :visible.sync="dialogFormVisible">

  
  <el-form :model="form">
    <el-form-item label="任务名" :label-width="formLabelWidth">
      <el-input v-model="form.name" autocomplete="off"></el-input>
    </el-form-item>
    <el-form-item label="任务描述" :label-width="formLabelWidth">
      <el-input v-model="form.descripition" autocomplete="off"></el-input>
    </el-form-item>
    <div class="theSecondLastLine flex">
        <div class="dateSelect flex">
            <span class="demonstration flex">日期</span>
            <el-date-picker
             v-model="form.date1"
             type="date"
             placeholder="选择日期"
             value-format="yyyy-MM-dd">
            </el-date-picker>
         </div>   
    <div class="prioritySelect flex">
        <span class="demonstration flex">优先级</span>
        <el-select v-model="form.priority" placeholder="请选择">
    <el-option
      v-for="item in options"
      :key="item.value"
      :label="item.label"
      :value="item.value">
    </el-option>
  </el-select>
    </div> 

    </div>
  
  </el-form>
   <div slot="footer" class="dialog-footer">
    <el-button @click="dialogFormVisible = false">取 消</el-button>
    <el-button type="primary" @click="saveData" >确 定</el-button>
  </div> 
</el-dialog>

            

        </div>
        <div class="theHeader flex">
        <!-- 中间两个盒子  有搜索框和添加标签-->
            <div class="theSearchBox flex">
                <div class="Searching">
                    <el-input v-model="searchContext" placeholder="请输入内容" @blur="searchData"></el-input>
                


                </div>
                <div class="addingNewTask">
                    <img src="@/assets/myDemo.png" alt="User Account Image"
                                @click="changeData(1)" />


                </div>

            </div>
            
            <div class="logOut" @mouseover="showLogout" @mouseleave="hideLogout" >
                <div class="userIcon" >
                    <el-avatar :size='50'> user </el-avatar>  
                </div>
            <!-- 用户头像，和登出 -->
                <div class="logout" v-show="showLogoutText" @click="reDirectToTheLogOutPage">
                    <el-button type="primary">退出</el-button>
                </div>
               
            </div>
            

        </div>
        <div class="theContext flex">
            <div class="leftOfPage">
                <div class="demoIcon">
                    <img src="@/assets/theIcon.png" alt="User Account Image">
                </div>
                <div class="todayTask" @click="showAllTask(1)" :class="activedTabs==1?'green':''">
                    今日任务
                </div>
                <div class="allTask"  @click="showAllTask(2)" :class="activedTabs==2?'green':''">
                    所有任务
                </div>

            </div>
            <div class="rightOfPage" >
                <div class="justTodayTask flex" v-if="whatWeShow.length" v-for="item in whatWeShow" :key="item.id"   :class="item.status?'item-done':''">
                    <div class="leftBox">
                        <el-checkbox v-model="item.status" size="large"> </el-checkbox>
                        {{ item.priority }}
                    </div>
                    <div class="rightContext" :class="{ 'white-background': item.status }" >
                        <div class="righttop flex">
                            <div class="taskName">
                                {{ item.name}}
                            </div>
                            <div class="taskDate">
                                {{item.date1 }}
                            </div>
                            <div class="revise" @click="changeData(2,item)" v-if="!item.status">
                                <i class="el-icon-edit"></i>
                            </div>
                        </div>
                        <div class="rightdown">
                            {{ item.descripition }}
                        </div>

                    </div>
                    
                        

                    

                </div>

            </div>

        </div>
    </div>


</template>

<script>
import * as Api from "@/api/index.js"
    export default{
        
        data(){
            return {
                selectedItem: null,
                searchContext: " ",
                input: "",
                theFormDisplay:false,
                
                dialogFormVisible: false,
                showLogoutText: false,
                todayTaskDisplay:false,
                activedTabs:1,
                form: {
                    id:null,
                name: '',
                descripition: '',
                date1: '',
                priority: "",
                status: false,
                
                },
                formLabelWidth: '120px',
                today: this.dateFormat(new Date()),
                dateSelect:"",
                emergentOrNot:"",
                options: [{
                value: 'P1',
                label: 'P1'
                }, {
                value: 'P2',
                label: 'P2'
                }, {
                value: 'P3',
                label: 'P3'
                }, {
                value: 'P4',
                label: 'P4'
                }, ],
                value: '',
        // todayData: [
        //         {
        //             title: '吃红烧肉',
        //             message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
        //             date: '2023-10-10',
        //             status: false,
        //             id: 1,
        //             value: 'P2'
        //         },
        //         {
        //             title: '吃白斩鸡',
        //             message: '细节：空的时候告诉外婆 让外婆晚上做duang duang的红烧肉,多放糖',
        //             date: '2023-10-18',
        //             status: true,
        //             id: 2,
        //             value: 'P1'
        //         },
        //     ],
        aaa: [
            {
                "taskName": "我要吃红烧肉",
                "taskDescription": "一碗"
            },
            {
                "taskName": "a s啊实打实打底裙",
                "taskDescription": "a s d"
            },
            {
                "taskName": "和美玲老师玩",
                "taskDescription": "踢键子"
            }
        ],
        mockTodayTask:[
            {  id: 1,
                name: '吃红烧肉',
                descripition:'让外婆做红烧肉',
                date:'2023-10-11',
                priority: "P1",
                status: false
            },{id: 2,
                name: '吃白斩鸡',
                descripition:'让外婆做好吃的白斩鸡',
                date:'2023-10-13',
                priority: "P1",
                status: false},
        ],
       
        mockallTask:[
            {  id: 1,
                name: '吃红烧肉',
                descripition:'让外婆做红烧肉',
                date:'2023-10-11',
                priority: "P1",
                status: true
               
             
             

            },{id: 2,
                name: '吃白斩鸡',
                descripition:'让外婆做好吃的白斩鸡',
                date:'2023-10-13',
                priority: "P1",
                status: false},
                {  id: 3,
                name: '吃红烧肉',
                descripition:'让外婆做红烧肉',
                date:'2023-10-11',
                priority: "P1",
                status: true
               
             
             

            },
            {  id: 4,
                name: '吃红烧肉',
                descripition:'让外婆做红烧肉',
                date:'2023-10-11',
                priority: "P1",
                status: true
               
             
             

            },

            {  id: 5,
                name: '吃红烧肉',
                descripition:'让外婆做红烧肉',
                date:'2023-10-11',
                priority: "P1",
                status: true
               
             
             

            },
        ],

        whatWeShow: [ ]


            }


        },
        mounted(){
            this.whatWeShowList(1)
        },
        methods:{
            whatWeShowList(type){
                // const params = {
                //     searchKey: this.searchContext
                // }
                // const apiUrl = type==1 ? Api.whatWeShowListForTodayTask : Api.whatWeShowListForAllTask;
                // apiUrl(params).then(res=>{
                //     if(res&&res.length){
                //         res.map(i=>{
                //             i.taskDate = i.taskDate ? this.dateFormat(i.taskDate) : null;
                //             return i
                //         })
                //     }
                //     res.map(kk=>{
                //         kk.name = kk.taskName;
                //         kk.descripition = kk.taskDescription ;
                //         kk.date1=kk.taskDate;
                //         kk.priority=kk.taskPriority;
                //         kk.status=kk.taskStatus;
                //         return kk
                //     })
                //     this.whatWeShow=res;
                // })

                if (type==1){
                    
                    const params = {
                    // taskName: this.form.name,
                    // taskDescription: this.form.descripition,
                    // taskDate:this.form.date1,
                    // taskPriority:this.form.priority,
                    // taskStatus:this.form.status,
                    // id: this.form.id
                }
                    Api.whatWeShowListForTodayTask(params).then(res=>{
                        // console.log("1111",res) [{id:1,label:'123}]
                        console.log("6666",res) 
                        if(res&&res.length){
                            res.map(i=>{
                                i.taskDate = i.taskDate ? this.dateFormat(i.taskDate) : null;
                                return i
                            })
                        }
                        res.map(kk=>{
                            kk.name = kk.taskName;
                            kk.descripition = kk.taskDescription ;
                            kk.date1=kk.taskDate;
                            kk.priority=kk.taskPriority;
                            kk.status=kk.taskStatus;
                            return kk
                            
                        })
                        this.whatWeShow=res;
                    })
                

                }
                if(type==2){
                    const params = {
                        // taskName: this.form.name,
                        // taskDescription: this.form.descripition,
                        // taskDate:this.form.date1,
                        // taskPriority:this.form.priority,
                        // taskStatus:this.form.status,
                        // id: this.form.id
                    }
                        
                    

                    Api.whatWeShowListForAllTask(params).then(res=>{
                        // console.log("1111",res) [{id:1,label:'123}]
                        console.log("6666",res) 
                        console.log("6666",res) 
                            if(res&&res.length){
                                res.map(i=>{
                                    i.taskDate = i.taskDate ? this.dateFormat(i.taskDate) : null;
                                    return i
                                })
                            }
                        if(res&&res.length){
                                res.map(i=>{
                                    i.taskDate = i.taskDate ? this.dateFormat(i.taskDate) : null;
                                    return i
                                })
                            }
                        res.map(kk=>{
                            kk.id=kk.id;
                            kk.name = kk.taskName;
                            kk.descripition = kk.taskDescription ;
                            kk.date1=kk.taskDate;
                            kk.priority=kk.taskPriority;
                            kk.status=kk.taskStatus;
                            return kk
                        })
                        this.whatWeShow=res;
                
                    })
                }
                if(type==3){

                    const params = {
                        taskName: this.searchContext,
                    }    
                    Api.blurSearch(params).then(res=>{
                        res.map(kk=>{
                            kk.id=kk.id;
                            kk.name = kk.taskName;
                            kk.descripition = kk.taskDescription ;
                            kk.date1=kk.taskDate;
                            kk.priority=kk.taskPriority;
                            kk.status=kk.taskStatus;
                            return kk
                        })
                        this.whatWeShow=res;
                
                    })
                }
            
        },
        theNewAddedForm(){
            theFormDisplay=true;
9
            },
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
            showAllTask(num) {
                this.activedTabs = num;
                this.whatWeShowList(num)
            //     if (num == 1) {
            //     // 今日任务
            //         this.whatWeShowList(num)
            // } else {
            //     // 所有任务
            //     this.whatWeShow = this.mockallTask

            // }
        },
        // id: 2,
        //         name: '吃白斩鸡',
        //         description:'让外婆做好吃的白斩鸡',
        //         date:'2023-10-13',
        //         priority: "P1",
        //         status: false},
        changeData(type,item) {
                
                    if(type==2){
                    this.selectedItem = item; 
                    this.dialogFormVisible = true;
                    this.form.name = item.name;
                    this.form.descripition = item.descripition; // Make sure to use the correct property name
        // Set other form properties based on your item structure
                    this.form.date1 = item.date1;
                    this.form.priority = item.priority;
                    this.form.id = item.id
                }

                    else if (type == 1) {
                    this.form =  {
                       
                        name: '',
                        descripition: '',
                        date1: this.today,
                        priority: "",
                        status: false,
                    }
                    this.selectedItem = null; 
                    this.dialogFormVisible = true;}
        },
        searchData(){

  
           
            this.whatWeShowList(3);
        },
        dateFormat(time){
            let text = ''
            if(time){
                let date = new Date(time),
                y = date.getFullYear(),
                m = date.getMonth(),
                d =  date.getDate();
                m = m+1
                console.log(time,y,m,d,888)
                if(m < 10){
                    m = '0'+m
                }
                if(d < 10){
                    d = '0'+d
                }
                text = y + '-' + m + '-' + d
            }
            return text

        },
        saveData() {
            if (!this.form.name.trim()) {
      // Show an error message to the user using alert
            alert('任务名不可以为空');
         return;
    }

            
            // 更新
            if (this.selectedItem !== null) {
                
                const existingTaskIndex = this.whatWeShow.findIndex(task => task.id === this.selectedItem.id);
                // if (existingTaskIndex !== -1) {
                //     this.whatWeShow[existingTaskIndex].name = this.form.name;
                //     this.whatWeShow[existingTaskIndex].descripition = this.form.descripition;
                //     this.whatWeShow[existingTaskIndex].date = this.form.date1;
                //     this.whatWeShow[existingTaskIndex].priority = this.form.priority;
                //     this.whatWeShow[existingTaskIndex].status = this.form.status;
                //    
                // }
                const params = {
                    taskName: this.form.name,
                    taskDescription: this.form.descripition,
                    taskDate:this.form.date1,
                    taskPriority:this.form.priority,
                    taskStatus:this.form.status,
                    id: this.form.id
                }
                console.log("1112222222222221",params)
                Api.changeANewTask(params).then(res=>{
                    console.log("1111",res)
                    // this.whatWeShow=data;
                    this.dialogFormVisible = false;
                    if(res){
                        this.whatWeShowList(this.activedTabs)
                    }
                })

            } 
//             if (this.selectedItem && this.selectedItem.id) {
//     // Update existing task logic
//             const existingTaskIndex = this.whatWeShow.findIndex(task => task.id === this.selectedItem.id);
//             if (existingTaskIndex !== -1) {
//       // Update existing task properties
//       this.whatWeShow[existingTaskIndex].name = this.form.name;
//       this.whatWeShow[existingTaskIndex].descripition = this.form.descripition;
//       this.whatWeShow[existingTaskIndex].date = this.form.date1;
//       this.whatWeShow[existingTaskIndex].priority = this.form.priority;
//       this.dialogFormVisible = false;
//     }
//   } 
//   if (item.id) {
//     // Update existing task logic
//     const existingTaskIndex = this.whatWeShow.findIndex(task => task.id === item.id);
//     if (existingTaskIndex !== -1) {
//       // Update existing task properties
//       this.whatWeShow[existingTaskIndex].name = this.form.name;
//       this.whatWeShow[existingTaskIndex].descripition = this.form.descripition; // Corrected typo
//       this.whatWeShow[existingTaskIndex].date = this.form.date1;
//       this.whatWeShow[existingTaskIndex].priority = this.form.priority;
//     }
//   } else {
    // Add new task logic
    else if (this.selectedItem == null) {
        //新增
    // const newTask = {
    //     name: this.form.name,
    //     descripition: this.form.descripition, // Corrected typo
    //     date: this.form.date1,
    //     priority: this.form.priority,
    //     status: false,
    //     id: this.whatWeShow.length + 1,
    // };
    const params = {
               
                taskName: this.form.name,
                taskDescription:this.form.descripition,
                taskDate:this.form.date1,
                taskPriority: this.form.priority,
                taskStatus:this.form.status

            }

   

    Api.createANewTask(params).then(res=>{
        console.log("1111",res)
        // this.whatWeShow=data;

        if(res){
           
            this.whatWeShowList(this.activedTabs)

        }
            })


    this.dialogFormVisible = false;
    this.selectedItem = null;
}
}
}
}
    // if (this.selectedItem == null){
    // const newTask = {
    //   name: this.form.name,
    //   descripition: this.form.descripition, // Corrected typo
    //   date: this.form.date1,
    //   priority: this.form.priority,
    //   status: false,
    //   id: this.whatWeShow.length + 1,
    // };
   
    //  this.whatWeShow.push(newTask);
    // this.dialogFormVisible = false;
    // this.selectedItem = null; 
    //  }
    // },


        
  // Close the dialog

    //     saveData(item) {
    //   if (item.id) {
    //     // Assuming 'item' is defined elsewhere in your component or received as a parameter
    //     item.name = this.form.name;
    //     item.descripition = this.form.descripition; // Correcting the typo in 'descripition'
    //     item.date = this.form.date1;
    //     item.priority = this.form.priority;
    //   } else  {
    //     const newTask = {
    //       name: this.form.name,
    //       descripition: this.form.descripition, // Correcting the typo in 'descripition'
    //       date: this.form.date1,
    //       priority: this.form.priority,
    //       status: false,
    //       id: this.whatWeShow.length + 1,
    //     };
    //     this.whatWeShow.push(newTask);
    //   }


    //   this.dialogFormVisible = false; // Assuming you want to close the dialog after saving
    // },

      
</script>

<style lang="less" scoped>

.flex{
    display:flex;
    align-items:center;
}
.theWholePage{
    height:100vh;
    width:100vw;
    .theNewForm{
        .theSecondLastLine{
            margin-left: 50px;
            .demonstration{
                margin-right: 35px;
           }
        .dateSelect{
            margin-left: 10px;
        }
        .prioritySelect{
            margin-left:100px;
        }
    }
    }
    .theHeader{
        height:16%;
        width:100%;
        border-bottom: 1px solid #eee;
        .theSearchBox{
            margin-left: 650px;
            .Searching{
                width:200px;
            }
            .addingNewTask{
                margin-left: 40px;
                height:50px;
                width:50px;
                img{
                    height:100%;
                    width:100%;

                }

            }
     
          
        }
        .logOut{
            margin-left: 450px;
            position: relative;
            // background-color: red;
            .userIcon{
               
            }
            .logout{
                position:absolute;
                top: 55px;
                left: -12px;
            }
        }   
        
        

    }
    .theContext{
        height:84%;
        width:100%;
        >div {
            height: 100%;
        }
        .leftOfPage{
            
            flex:1;
            display:flex;
            flex-direction: column;
            align-items: center;
            border-right: 1px solid #eee;
            .demoIcon{
                height:50px;
                width:50px;
                
                margin-top:50px;
                img{
                    height:100%;
                    width:100%;
                }
            }
            .todayTask{
                margin-top:100px;
                margin-left: 0px;

            }
            .allTask{
                margin-top:100px;
                margin-left: 0px;

            }
        }
        .rightOfPage{
            flex:4;
            overflow: scroll;
            .justTodayTask{
                
                display: flex;
               
                margin-left: 50px;
                margin-top:50px;
                .leftBox{

                }
                .rightContext{
                    margin-left: 100px;
                    text-align: left;
                    
                    .taskName{
                        font-size: 30px;
                        font-weight: bold;
                        margin-bottom: 20px;
                    }
                    .taskDate{
                        margin-left: 40px;
                        color: blue;
                        margin-bottom: 20px;
                        font-size: 20px;
//                     
                    }
                    .revise{
                        font-size: 30px;
                        margin-left: 40px;
                        font-weight: bold;
                        margin-bottom: 20px;

                    }
                    .rightdown{
                        font-size: 18px;
                    }

                }
                .white-background {
                    // background-color: green;
                }
            
            
            }

            .item-done {
                color: red !important;
                .taskDate {
                    color: red !important;
                }
            }
                

            
        }
    }
    .green{
        color: green;
    }
    
}
</style>