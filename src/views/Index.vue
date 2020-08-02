<template>
    <el-container style="border: 1px solid #eee">

            <el-header>
                <span style="margin-left: 25px;">
                    <el-button type="text" style="font-size: 20px;color: black" @click="goindex()">
                        <i class="el-icon-s-home">主站</i> </el-button>
                </span>
                <span style="margin-left: 20px" v-for="item in category">
                    <el-button type="text" style="margin-left: 20px;color: black;font-size: 20px" @click="goto(item)">{{item.name}}</el-button>
                </span>

                <span style="float: right;">
                    <span style="margin-right: 20px;font-size: 20px;color: #ff6f00">欢迎!</span>
                    <el-dropdown @command="handleCommand">
                <span class="el-dropdown-link">
                    <el-button type="text" style="margin-right: 20px;font-size: 20px;color: #00ccff">{{username}}</el-button>
                </span>
                        <el-dropdown-menu  slot="dropdown" align="center">
                            <el-dropdown-item v-for="item in links" :key= "item.value + ''" :command="{value:item.value,name:item.name}">{{item.name}}</el-dropdown-item>

                        </el-dropdown-menu>
                    </el-dropdown>

                </span>



            </el-header>

            <el-main >
                <router-view></router-view>
            </el-main>




    </el-container>



</template>

<style type="text/css">
    .el-header {
        background-color: #ffffff;
        /*color: #333;*/
        line-height: 60px;
        width: 100%;

    }

    html,body,#app,.el-container{
        padding: 0px;
        margin: 0px;
        height: 100%;
    }
    .el-main{
        background-color: white;

    }
</style>

<script>
    export default {
        methods:{
            goindex(){
                this.$router.push("/index");
            },

            goto(item) {
                var splitted = this.$route.path.split("/")[1]
                if (splitted != "ByCategory") {
                    this.$router.push({
                        path: "/ByCategory/",
                        query: {
                            id: item.value,
                            categoryName: item.name
                        }
                    });
                } else {
                    let routeData = this.$router.resolve({
                        path: "/ByCategory/",
                        query: {
                            id: item.value,
                            categoryName: item.name
                        }
                    });
                    window.open(routeData.href, '_blank');
                }
            },
          handleCommand(command){
              switch(command.value){
                  case 0:
                      this.$router.push("/calendar");
                      break;
                  case 1:
                      this.$router.push("/favorite");
                      break;
                  case 2:
                      this.$router.push("/shop");
                      break;
                  case 3:
                      this.$router.push("/fridge");
                      break;
                  case 4:
                      this.$router.push("/menu");
                      break;
                  case 5:
                      localStorage.removeItem("Authorization");
                      this.$router.push("/");
                      break;
                  default:
                      break;

              }
            }
        },
        data() {

            return {
                screenwidth:document.body.clientWidth,
                username:'',
                userid:'',
                links:[
                    {name:"日历",value:0},
                    {name:"收藏夹",value:1},
                    {name:"购物清单",value:2},
                    {name:"实时冰箱",value:3},
                    {name:"定制菜单",value:4},
                    {name:"退出",value:5}
                ],
                category:[
                    {name:"家常菜",value:1},
                    {name:"海鲜",value:2},
                    {name:"素食",value:3},
                    {name:"汤羹",value:4},
                    {name:"主食",value:5},
                    {name:"母婴",value:6},
                    {name:"肉",value:7},
                    {name:"蛋",value:8},
                    {name:"奶",value:9},

                ]
            }
        },
        created() {
            const _this = this;
          this.axios.get("http://localhost:8181/userinfo/check").then(function (resp) {
                if(resp.data.message === "error"){
                    _this.$router.push("/");
                }
                else{
                    _this.userid = resp.data.message;
                    if(!resp.data.name){
                        _this.username = resp.data.message;
                    }
                    _this.username = resp.data.name;
                }
          }).catch(function (err) {
                console.log(err);
                _this.$router.push("/");
          });

        }
    };
</script>