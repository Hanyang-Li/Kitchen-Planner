import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import About from '../views/About.vue'
import Book from '../views/Book.vue'
import BookManage from "../views/BookManage";
import AddBook from "../views/AddBook";
import BookUpdate from "../views/BookUpdate";
import PageFour from "../views/PageFour";
import Sign from "../views/Sign";
import SignUp from "../views/SignUp";

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
      name: "图书管理",
      component: Index,
      show:true,
      children:[
        {
          path:'/BookManage',
          name:"查询图书",
          component: BookManage
        },
        {
          path:'/AddBook',
          name: "添加图书",
          component: AddBook
        },

      ]
    },
    {
      path: '/BookUpdate',
      name: "修改信息",
      show: false,
      component: BookUpdate
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
      next("/");
    }
    else{
      next();
    }

  }

})

export default router
