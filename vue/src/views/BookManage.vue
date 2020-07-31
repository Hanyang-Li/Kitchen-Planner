<template>
    <div>
        <el-table
                :data="tableData"
                border
                style="width: 100%">
            <el-table-column
                    fixed
                    prop="id"
                    label="编号"
                    style="width: 10%">
            </el-table-column>
            <el-table-column
                    prop="name"
                    label="书名"
                    style="width: 20%">
            </el-table-column>
            <el-table-column
                    prop="author"
                    label="作者"
                    style="width: 20%">
            </el-table-column>
            <el-table-column
                    prop="publish"
                    label="出版社"
                    style="width: 20%">
            </el-table-column>

            <el-table-column
                    fixed="right"
                    label="操作"
                    style="width: 30%">
                <template slot-scope="scope">
                    <el-button @click="edit(scope.row)" type="text" size="small">修改</el-button>
                    <el-button @click="deleteBook(scope.row)" type="text" size="small">删除</el-button>
                </template>
            </el-table-column>
        </el-table>

        <el-pagination
                background
                layout="prev, pager, next"
                page-size="6"
                @current-change="page"
                :total="total">
        </el-pagination>

    </div>

</template>

<script>
    export default {
        methods: {
            deleteBook(row){
                const _this = this
                axios.delete("http://localhost:8181/book/delete/"+row.id).then(function (reps) {
                    _this.$notify({
                        title:"成功",
                        message:"删除成功啦！",
                        type:"success"
                    });
                    window.location.reload();
                })
            },
            edit(row) {
                this.$router.push({
                    path: "/BookUpdate",
                    query:{
                        id:row.id
                    }
                });
            },
            page(currentPage) {
                const _this = this;
                axios.get("http://localhost:8181/book/findAll/" + currentPage + "/6").then(function (resp) {
                    _this.tableData = resp.data.content;
                    _this.total = resp.data.totalElements;
                })
            }
        },

        created() {
            const _this = this;
            axios.get("http://localhost:8181/book/findAll/1/6").then(function (resp) {
                _this.tableData = resp.data.content;
                _this.total = resp.data.totalElements;
            })
        },
        data() {
            return {
                total: null,
                tableData: null
            }
        }
    }
</script>