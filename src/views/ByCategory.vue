<template>
    <div id="category" style="width: 100%;height: 90%">

        <el-row style="height: 50px;margin-bottom: 20px">
            <el-col :offset="2">
                <div class="head">
                    <span style="margin-right: 10px">
                        标签:
                    </span>
                <span>
                    <el-button size="large"  type="success" round>{{this.$route.query.categoryName}}</el-button>
                </span></div>
            </el-col>
        </el-row>


        <el-row :gutter="20" style="min-height: 200px;margin-bottom: 20px" v-for="i in length">
            <el-col :span="5" v-for="(item,index) in cate" :offset="index%4==0?'2':'0'" v-if="index >=i*4 & index < (i+1)*4">

                <div class="grid-content-inner">

                    <el-card :body-style="{ padding: '0px' }" class="card" @click.native="linkDownload('https://www.baidu.com')">
                        <el-image
                                class="smallimage"
                                :src="'http://localhost:8383/image/'+item.imgpath"
                                :alt = "item.menuname"
                                :fit="'cover'"
                        ></el-image>
                        <div style="padding: 14px">
                            <span style="margin-left: 5px;font-size: 20px">{{item.menuname}}</span>
                            <div class="bottom">
                                <el-button @click="tag(one)"
                                           size="mini" v-for="(one,index2) in item.taginfo" :type="button_type[index2]" round>
                                    {{one.name}}</el-button>
                                <span style="float: right;line-height: 20px">{{item.authorname}}</span>
                            </div>
                        </div>
                    </el-card>
                </div>
            </el-col>
        </el-row>

        <div style="text-align: center;margin-bottom: 20px">
            <el-pagination
                    style="height: 50px"
                    background
                    layout="prev, pager, next"
                    :page-size="totalPage"
                    :total="total"
                    @current-change="page">
            </el-pagination>
        </div>


    </div>
</template>

<script>
    export default {
        data(){
            return{
                totalPage:'1',
                total:'0',
                click_inner_button:0,
                cate:[],
                length:[],
                button_type:["success","danger","primary","warning","info",""],

            }
        },
        methods:{
            linkDownload(url){
                if(this.click_inner_button != 1){
                    window.open(url,'_blank');
                }
                else{
                    this.click_inner_button = 0;
                }

            },
            tag(one){
                let routeData = this.$router.resolve({
                    path: "/ByCategory/",
                    query: {
                        id: one.id,
                        categoryName: one.name
                    }
                });
                window.open(routeData.href, '_blank');
                this.click_inner_button = 1;

            },
            page(currentPage){
                const _this = this;

                this.axios.get("http://localhost:8282/menu/bycategory/"+ this.$route.query.id+"/"+(currentPage-1)+"/12").then(function (resp) {


                    _this.cate = resp.data.content;
                    _this.total = resp.data.totalelement;
                    _this.totalPage = resp.data.totalpage;
                    console.log(_this.totalPage);
                    var arr = [];
                    for(var i = 0;i<Math.round(_this.cate.length/4);i++){
                        arr.push(i);
                    }
                    _this.length = arr;


                }).catch(function (err) {
                    console.log(err);
                    _this.$router.push("/");
                })
            }


        },
        created() {
            const _this = this;

            this.axios.get("http://localhost:8282/menu/bycategory/"+ this.$route.query.id+"/0/12").then(function (resp) {


                _this.cate = resp.data.content;
                _this.total = resp.data.totalelement;
                _this.totalPage = resp.data.totalpage;
                console.log(_this.totalPage);
                var arr = [];
                for(var i = 0;i<Math.round(_this.cate.length/4);i++){
                    arr.push(i);
                }
                _this.length = arr;


            }).catch(function (err) {
                console.log(err);
                _this.$router.push("/");
            })
        }


    }
</script>

<style>

    .head{
        height: 50px;
        width: 100%;
        line-height: 30px;
        font-size: 20px;
        color: black;

    }
    .grid-content-inner{
        height: 100%;
        min-width: 100%;
        border-radius: 10px;
        background-color: #14de98;

    }
    .smallimage {
        width: 100%;
        height: 180px;
        cursor: pointer;
    }
    .card{
        width: 100%;
        height: 100%;
        cursor: pointer;
    }
</style>