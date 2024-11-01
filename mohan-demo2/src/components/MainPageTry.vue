<template>
    <div class="theWholePage">
        <div class="headerBox flex">
            <div class="search-box flex">
                <div class="search">
                    <el-input v-model="inputOfSearch" placeholder="请输入搜索内容"></el-input>
                </div>
                <div class="addNewText">
                    <img src="@/assets/littleDemo.png" alt="User Account Image" />
                </div>
            </div>
            <div class="theImageOftheAccount">
                <el-avatar> user </el-avatar>
                <div class="logout">退出</div>

            </div>

        </div>
        <!-- <div class="content"> -->
            <div class="menu">
111
            </div>
            <div class="maincontext">
                56789
            </div>
        <!-- </div> -->


    </div>
</template>


<script>
export default {
    data() {
        return {
            inputOfSearch: ''

        };

    },
    methods: {

    }

}
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

    .headerBox {
        width: 100%;
        height: 15%;
        background-color: black;
        justify-content: center;
        position: relative;



        .addNewText {
            width: 30px;
            height: 30px;

            img {
                width: 100%;
                height: 100%
            }

        }

        .theImageOftheAccount {
            position: absolute;
            right: 24px;
            top: 50px;

            .logout {
                background-color: aqua;
                display: none;
            }
        }

        .theImageOftheAccount:hover {
            .logout {
                display: block;
            }
        }


    }

    .menu {
        height: 100%;
        background-color: aquamarine;
        width: 17%
    }

}
</style>
