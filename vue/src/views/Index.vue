<template>
    <el-container style="height: 500px; border: 1px solid #eee">
        <el-container>
            <el-header style="text-align: right; font-size: 12px">
                <el-dropdown >
                    <i class="el-icon-setting" style="margin-right: 15px"></i>
                    <el-dropdown-menu  slot="dropdown" >
<!--                        <el-dropdown-item v-for="(one,index2) in item.children" :index = "index + '_' + index2">{{one.name}}</el-dropdown-item>-->
                            <el-dropdown-item>nihao</el-dropdown-item>
                    </el-dropdown-menu>
                </el-dropdown>

                <span>{{username}}</span>
            </el-header>

            <el-main>
                <router-view></router-view>
            </el-main>
        </el-container>

    </el-container>



</template>

<style>
    .el-header {
        background-color: #B3C0D1;
        color: #333;
        line-height: 60px;
    }

    .el-aside {
        color: #333;
    }
</style>

<script>
    export default {
        data() {

            return {
                username:'',
            }
        },
        created() {
            const _this = this;
          this.axios.get("http://localhost:8181/userinfo/check").then(function (resp) {
                if(resp.data.message === "error"){
                    _this.$router.push("/");
                }
                else{
                    _this.username = resp.data.message;
                }
          }).catch(function (err) {
                console.log(err);
                _this.$router.push("/");
          });

        }
    };
</script>