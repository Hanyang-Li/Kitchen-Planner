<template>

    <div style="text-align: center">
        <img src="../assets/logo.png" width="200px" height="200px">
        <el-form  :model="ruleForm"  :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">


            <el-form-item  prop="username">
                <el-input
                        v-model="ruleForm.username"
                        placeholder = "用户名"
                        prefix-icon="el-icon-user-solid"
                        autocomplete="off"></el-input>
            </el-form-item>


            <el-form-item  prop="pass">
                <el-input
                        type="password"
                        v-model="ruleForm.pass"
                        placeholder="密码"
                        prefix-icon="el-icon-lock"
                        autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item>
                <el-button type="primary" @click="login('ruleForm')">登录</el-button>
                <el-button @click="signup()">注册</el-button>
            </el-form-item>
        </el-form>
    </div>


</template>
<style>
    .el-form{

        width: 70%;
        height: 300px;
        margin: auto;
        /*top:30%;*/
        /*left: 40%;*/

        text-align: center;
    }
    .el-form-item{

        margin: auto;
        width: 50%;
        text-align: center;
    }
</style>
<script>
    import {mapMutations} from "vuex";
    export default {
        data() {
            var validatePass = (rule, value, callback) => {

                if (value === '') {
                    callback(new Error('请输入用户名'));
                } else {
                }
                callback();
            };
            var validatePass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                }
                callback();
            };

            return {
                ruleForm: {
                    username: '',
                    pass: '',

                },
                rules: {
                    username: [
                        { validator: validatePass, trigger: 'blur' }
                    ],
                    pass: [
                        { validator: validatePass2, trigger: 'blur' }
                    ],

                }
            };
        },
        methods: {
            ...mapMutations(['changeLogin']),
            login(formName) {
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        const _this = this;
                        this.axios.post("http://localhost:8181/userinfo/signin",this.ruleForm).then(function (resp) {


                            if (resp.data.message　=== "error"){

                                _this.$notify({
                                    title:"错误",
                                    message:"用户名不存在或密码错误!",
                                    type:"error"
                                });
                                _this.$refs[formName].resetFields();

                                }
                                else{
                                _this.changeLogin({Authorization:resp.data.message});

                                _this.$router.push("/index");
                                _this.$notify({
                                    title:"成功",
                                    message:"欢迎回来!" + _this.ruleForm.username,
                                    type:"success"
                                });
                                }
                        }).catch(function (err) {
                            console.log(err);
                            _this.$notify({
                                title:"错误",
                                message:"网络错误!",
                                type:"error"
                            });
                            _this.$refs[formName].resetFields();

                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            signup() {
                // alert("click");
                this.$router.push("/sign")
            }
        }
    }
</script>