import Vue from 'vue'
import VueRouter from 'vue-router'



import Sign from "../views/Sign";
import SignUp from "../views/SignUp";
import Calendar from "../views/Calendar";
import Favorite from "../views/Favorite";
import Shop from "../views/Shop";
import Fridge from "../views/Fridge";
import Menu from "../views/Menu";
import Main from "../views/Main";
import ByCategory from "../views/ByCategory";

import Index from "../views/Index";
import fa from "element-ui/src/locale/lang/fa";



Vue.use(VueRouter)

  const routes = [
    {
      path:'/',
      name:"登录页",
      component: Sign,
      show: false
    },

    {
      path:'/index',
      name: "首页",
      component: Index,
      show:true,
      redirect: '/MainMenu',
      children:[
        {
          path:'/MainMenu',
          name:"主站",
          component: Main
        },
        {
          path:'/ByCategory/**',
          name: "特别分类",
          component: ByCategory
        },

      ]
    },
    {
      path: '/calendar',
      name: "日历",
      show: false,
      component: Calendar
    },
    {
      path: '/favorite',
      name: "收藏夹",
      show: false,
      component: Favorite
    },
    {
      path: '/shop',
      name: "购物清单",
      show: false,
      component: Shop
    },
    {
      path: '/fridge',
      name: "实时冰箱",
      show: false,
      component: Fridge
    },
    {
      path: '/menu',
      name: "定制菜单",
      show: false,
      component: Menu
    },
    {
      path:'/sign',
      name: "注册",
      show: false,
      component: SignUp

    },




]

const router = new VueRouter({
  mode: 'history',
  base: process.env.BASE_URL,
  routes
})

router.beforeEach((to,from,next) =>{
  if(to.path === "/" || to.path === "/sign"){
    next();
  }
  else{
    let token = localStorage.getItem('Authorization');
    if( token === null || token === '' ){
      console.log(token);
      next("/");
    }
    else{
      next();
    }

  }

})

export default router
