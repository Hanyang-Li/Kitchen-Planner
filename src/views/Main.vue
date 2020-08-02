<template>
    <div id="main" style="width:100%;height: 90%">
        <div style="height: 400px;width: 100%" class="dstyle">
            <el-row :gutter="10" style="height: 100%;">
                <el-col :span="8" :offset="2"><div class="grid-content-big">
                    <el-carousel trigger="click" height="400px">
                        <el-carousel-item v-for="item in carousels" :key="item.id">
                            <div>
                                <el-image
                                        class="largeimage"
                                        :src="'http://localhost:8383/image/'+item.imgpath"
                                        :fit="'cover'"
                                        :alt = "item.menuname"
                                        @click="linkDownload('http://www.baidu.com')"></el-image>
                            </div>


                        </el-carousel-item>
                    </el-carousel>
                </div></el-col>
                <el-col :span="12" ><div class="grid-content-big">

                    <el-row :gutter="10" style="height: 200px;">
                        <el-col :span="8" v-for="(item,index) in upshow" v-if="index < 3">

                            <div    @click="linkDownload('http://www.baidu.com')"
                                    class="backimg grid-content-inner" :style="{backgroundImage: 'url('+'http://localhost:8383/image/'+item.imgpath+')'}">
                                <span style="margin-left: 20px">{{item.menuname}}</span>

<!--                            <el-image-->
<!--                                    class="smallimage"-->
<!--                                    :src="'http://localhost:8383/image/'+item.imgpath"-->
<!--                                    :alt = "item.menuname"-->
<!--                                    :fit="'cover'"></el-image>-->
                        </div></el-col>
                    </el-row>
                    <el-row :gutter="10"  style="height: 200px;">
                        <el-col :span="8" v-for="(item,index) in upshow" v-if="index < 6& index >=3">

                            <div    @click="linkDownload('http://www.baidu.com')"
                                    class="backimg grid-content-inner" :style="{backgroundImage: 'url('+'http://localhost:8383/image/'+item.imgpath+')'}">
                                <span style="margin-left: 20px">{{item.menuname}}</span>
                            <!--                            <el-image-->
<!--                                    class="smallimage"-->
<!--                                    :src="'http://localhost:8383/image/'+item.imgpath"-->
<!--                                    :alt = "item.menuname"-->
<!--                                    :fit="'cover'"></el-image>-->
                        </div></el-col>
                    </el-row>
                </div>
                </el-col>

            </el-row>

            <div id="introduce" style="height: 10%;width: 100%" class="dstyle">
            <el-row style="min-height: 100%;width: 100%">
                <el-col :span="24" :offset="2" style="width: 100%;height: 100%"><div>
                    <svg id="tuiguang" viewBox="0 0 1024 1024" class="svg">
                        <path d="M324.5568 660.31616v56.832c0 30.19264 24.4736 54.67136 54.67136 54.67136 30.19264 0 54.67136-24.4736 54.67136-54.67136v-14.04928l-109.34272-42.78272z m186.4704 72.96512C503.0656 799.0016 447.09376 849.92 379.22816 849.92c-73.32864 0-132.77184-59.4432-132.77184-132.77184v-87.3984l-117.15584-45.83936v0.06656a39.05024 39.05024 0 1 1-78.10048 0V411.71968a39.05024 39.05024 0 0 1 78.10048 0v0.06656l499.85024-195.59424v-23.54176a39.05024 39.05024 0 1 1 78.1056 0v610.39616a39.05024 39.05024 0 1 1-78.1056 0v-23.54176l-118.1184-46.22336z" fill="#FFD778"></path>
                        <path d="M808.78592 458.73152h124.96384A39.05024 39.05024 0 0 1 972.8 497.78176v0.13312a39.05024 39.05024 0 0 1-39.05024 39.05024h-124.96384a39.05024 39.05024 0 0 1-39.05024-39.05024v-0.13312a39.05024 39.05024 0 0 1 39.05024-39.05024z m-3.31264 130.43712l108.25728 62.61248a39.05024 39.05024 0 0 1 14.2848 53.2992l-0.05632 0.1024a39.04512 39.04512 0 0 1-53.376 14.30016l-108.25728-62.6176a39.05024 39.05024 0 0 1-14.2848-53.2992l0.05632-0.09728a39.04512 39.04512 0 0 1 53.376-14.30016z m-39.14752-250.3424l108.25728-62.61248a39.04512 39.04512 0 0 1 53.376 14.30528l0.0512 0.09216a39.05024 39.05024 0 0 1-14.2848 53.30432L805.4784 406.528a39.04512 39.04512 0 0 1-53.376-14.30016l-0.0512-0.09728a39.05024 39.05024 0 0 1 14.27968-53.2992z" fill="#FB813A"></path>
                    </svg>
                </div></el-col>
            </el-row>
            </div>
            <div id="below" style="height: 500px;width: 100%" class="dstyle">
                <el-row :gutter="20" style="min-height: 200px;margin-bottom: 20px" >
                    <el-col :span="5" v-for="(item,index) in downshow" :offset="index%4==0?'2':'0'" v-if="index < 4"><div class="grid-content-inner">
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
                    </div></el-col>

                </el-row>
                <el-row :gutter="20" style="min-height: 200px;margin-bottom: 20px" >

                    <el-col :span="5" v-for="(item,index) in downshow" :offset="index%4==0?'2':'0'" v-if="index < 8 & index>=4"><div class="grid-content-inner">

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


                    </div></el-col>

                </el-row>
            </div>

        </div>


    </div>
</template>

<script>
    export default {
        methods:{

            linkDownload(url){

                if(this.$route.path.split("/")[1] != "ByCategory"){
                    window.open(url,'_blank');
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
            }
        },
        data(){
            return{
                button_type:["success","danger","primary","warning","info",""],
                upshow:[],
                downshow:[],
                carousels:[]
            }

        },
        created() {

          const _this = this;
          this.axios.get("http://localhost:8282/menu/index").then(function (resp) {
                console.log(resp);
                _this.carousels = resp.data.slice(0,4);

                _this.upshow= resp.data.slice(4,10);

                console.log(_this.upshow);
                _this.downshow = resp.data.slice(10,18);
          }).catch(function (err) {
                console.log(err);
                _this.$router.push("/")
          })
        }

    }

</script>

<style>
    .backimg{

        font-size: 30px;
        color: white;
        line-height: 330px;
        width: 100%;
        height: 190px;
        background-size: cover;
        overflow: hidden;
        cursor: pointer;
    }

    .bottom{
        content: "";
        display: table;
        margin-top: 13px;
        line-height: 12px;
        width: 100%;
    }
    .smallimage {
        width: 100%;
        height: 180px;
        cursor: pointer;
    }
    .largeimage {
        width: 100%;
        height: 400px;
        cursor: pointer;
    }
    .card{
        width: 100%;
        height: 100%;
        cursor: pointer;
    }
    .svg{
        width: 50px;
        height: 50px;
    }
    .el-row {
        display: flex;
    }
    .dstyle{
        margin-bottom: 20px;
    }
    .el-col{
        margin: 5px;
        border-radius: 4px;
    }

    .grid-content-big{
        height: 100%;
        min-width: 100%;
        border-radius: 10px;
        background-color: white;

    }

    .grid-content-inner{
        height: 100%;
        min-width: 100%;
        border-radius: 10px;
        background-color: white;

    }


</style>