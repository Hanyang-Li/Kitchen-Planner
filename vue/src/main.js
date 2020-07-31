import Vue from 'vue'
//import './plugins/axios'
import App from './App.vue'
import router from './router'
import store from './store'
import './plugins/element.js'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import VueAxios from 'vue-axios';


import Vuex from 'vuex'
import axios from "axios";

Vue.use(Vuex) ;
Vue.use(VueAxios,axios);


Vue.config.productionTip = false;
Vue.use(ElementUI);


axios.interceptors.request.use(
    function (config) {
        // Do something before request is sent

        if (localStorage.getItem('Authorization')) {
            config.headers.Authorization = localStorage.getItem('Authorization');
        }

        return config;
    },
    function (error) {
        // Do something with request error
        return Promise.reject(error);
    }
);




new Vue({
  router,
  store: store,
  render: h => h(App)
}).$mount('#app')
