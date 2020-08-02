<template>
    <div id="signup" style="height: 600px">

        <el-form style="height: 400px" :model="ruleForm" status-icon :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
            <el-form-item label="用户名" prop="username">
                <el-input v-model="ruleForm.username" auto-complete="off"></el-input>
            </el-form-item>
            <el-form-item label="密码" prop="pass">
                <el-input type="password" v-model="ruleForm.pass" autocomplete="off"></el-input>
            </el-form-item>
            <el-form-item label="确认密码" prop="checkpass">
                <el-input type="password" v-model="ruleForm.checkpass" autocomplete="off"></el-input>
            </el-form-item>

            <el-form-item label="电话" prop="phone">
                <el-input v-model="ruleForm.phone"></el-input>
            </el-form-item>
            <el-form-item label="电子邮箱" prop="email">
                <el-input v-model="ruleForm.email"></el-input>
            </el-form-item>
            <el-form-item>
                <el-button type="primary" @click="submitForm('ruleForm')">注册</el-button>
                <el-button @click="resetForm('ruleForm')">重置</el-button>
                <el-button @click="back()">返回</el-button>
            </el-form-item>

        </el-form>
    </div>


</template>

<script>
    export default {
        data() {
            var checkPhone = (rule, value, callback) => {
                if (value === '') {
                    return callback(new Error('电话号码不能为空'));
                }
                setTimeout(() => {
                    var phone = /^(((13[0-9]{1})|(15[0-9]{1})|(17[0-9]{1})|(18[0-9]{1}))+\d{8})$/;
                    if (!phone.test(value) ) {
                        callback(new Error('请输入正确电话号码'));
                    } else {
                        const _this = this;
                        this.axios.get("http://localhost:8181/userinfo/ExistPhone/"+this.ruleForm.phone).then(function (resp) {
                            // console.log(_this.ruleForm.username)

                            if (resp.data){
                                callback(new Error("号码已注册"));
                            }
                            else{
                                callback();
                            }
                        }).catch(function (err) {
                            console.log(err);
                            callback(new Error("网络错误"));

                        })
                    }
                }, 1000);
            };
            var validatepass = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请输入密码'));
                } else {
                    if (this.ruleForm.checkpass !== '') {
                        this.$refs.ruleForm.validateField('checkpass');
                    }
                    callback();
                }
            };
            var validatepass2 = (rule, value, callback) => {
                if (value === '') {
                    callback(new Error('请再次输入密码'));
                } else if (value !== this.ruleForm.pass) {
                    callback(new Error('两次输入密码不一致!'));
                } else {
                    callback();
                }
            };
            var validateName = (rule, value, callback) => {
                if (value === ''){
                    callback(new Error('请输入用户名'));
                }
                else {
                    var right = /^[0-9a-zA-Z]*$/;
                    if (!right.test(value)){
                        callback(new Error("用户名必须只包括数字和字母"))
                    }
                    else{
                        setTimeout(() =>{
                            const _this = this;
                            this.axios.get("http://localhost:8181/userinfo/ExistUsername/"+this.ruleForm.username).then(function (resp) {
                                // console.log(resp)

                                if (resp.data){
                                    callback(new Error("用户名已经存在"));
                                }
                                else{
                                    callback();
                                }
                            }).catch(function (err) {
                                console.log(err);
                                callback(new Error("网络错误"));

                            })
                        },1000)
                    }



                }
            };
            var validateEmail = (rule,value,callback) => {
                if (value === '') {
                    return callback(new Error('邮箱不能为空'));
                }
                setTimeout(() => {
                    var email =  /^([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+@([a-zA-Z0-9]+[_|\_|\.]?)*[a-zA-Z0-9]+\.[a-zA-Z]{2,3}$/;
                    if (!email.test(value) ) {
                        callback(new Error('请输入正确的邮箱'));
                    } else {
                        const _this = this;
                        this.axios.get("http://localhost:8181/userinfo/ExistEmail/"+this.ruleForm.email).then(function (resp) {
                            // console.log(_this.ruleForm.username)

                            if (resp.data){
                                callback(new Error("邮箱已注册"));
                            }
                            else{
                                callback();
                            }
                        }).catch(function (err) {
                            console.log(err);
                            callback(new Error("网络错误"));

                        })
                    }
                }, 1000);
            };
            return {
                options:[{
                  value: 'male',
                  label: '男'
                },
                    {
                        value: 'female',
                        label: '女'
                    }],
                ruleForm: {
                    username:'',
                    pass: '',
                    checkpass: '',
                    phone: '',
                    email: '',
                    sex: ''
                },

                rules: {
                    username: [
                        {validator:validateName, trigger:"blur"}
                    ],
                    pass: [
                        { validator: validatepass, trigger: 'blur' }
                    ],
                    checkpass: [
                        { validator: validatepass2, trigger: 'blur' }
                    ],
                    phone: [
                        { validator: checkPhone, trigger: 'blur' }
                    ],
                    email:[
                        { validator:validateEmail, trigger:'blur'}
                    ]
                }
            };
        },
        methods: {
            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        this.axios.post("http://localhost:8181/userinfo/signup",this.ruleForm).then(function (resp) {

                            if(resp.data.message === "success"){
                               _this.$notify({
                                   title:"成功",
                                   message:"注册成功啦！",
                                   type:"success"
                               });
                              _this.$router.push("/")
                           }
                            else {
                                _this.$notify({
                                    title:"失败",
                                    message:"注册失败！",
                                    type:"error"
                                });
                                this.$refs[formName].resetFields();
                            }
                        }).catch(function (err) {
                            console.log(err);
                            _this.$notify({
                                title:"失败",
                                message:"未知错误！",
                                type:"error"
                            });
                            this.$refs[formName].resetFields();

                        })
                    } else {
                        // console.log(valid);
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },
            back(){
                this.$router.push("/");
            }
        }
    }
</script>