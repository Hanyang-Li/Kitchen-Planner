<template>
    <el-form style="width: 60%" :model="ruleForm" :rules="rules" ref="ruleForm" label-width="100px" class="demo-ruleForm">
        <el-form-item label="图书名称" prop="name">
            <el-input v-model="ruleForm.name"></el-input>
        </el-form-item>

        <el-form-item label="作者" prop="author">
            <el-input v-model="ruleForm.author"></el-input>
        </el-form-item>

        <el-form-item label="出版社" prop="publish">
            <el-input v-model="ruleForm.publish"></el-input>
        </el-form-item>

        <el-form-item>
            <el-button type="primary" @click="submitForm('ruleForm')">修改</el-button>
            <el-button @click="resetForm('ruleForm')">重置</el-button>

        </el-form-item>
    </el-form>

</template>

<script>
    export default {
        data() {


            return {
                ruleForm: {
                    name: '',
                    author: '',
                    publish: ''

                },
                rules: {
                    name: [
                        { required: true, message: '请填写图书名称', trigger: 'blur' },

                    ],
                    author: [
                        { required: true, message: '请填写作者', trigger: 'change' },

                    ],
                    publish: [
                        {required: true, message: '请填写出版社', trigger:'blur'}
                    ]

                }
            };
        },
        methods: {

            submitForm(formName) {
                const _this = this;
                this.$refs[formName].validate((valid) => {
                    if (valid) {
                        axios.put("http://localhost:8181/book/update",this.ruleForm).then(function (resp) {
                            if (resp.data == 'success'){
                                _this.$notify({
                                    title:"成功",
                                    message:"修改成功啦！",
                                    type:"success"
                                });
                                _this.$router.push("/")
                            }
                            else {
                                _this.$notify({
                                    title:"失败",
                                    message:"修改失败！",
                                    type:"warning"
                                });
                                _this.$router.push("/")
                            }
                        })
                    } else {
                        console.log('error submit!!');
                        return false;
                    }
                });
            },
            resetForm(formName) {
                this.$refs[formName].resetFields();
            },

        },
        created(){
            const id = this.$route.query.id;
            const _this = this;
            axios.get("http://localhost:8181/book/findById/"+id).then(function (resp) {
                _this.ruleForm = resp.data;

            })
        }
    }
</script>