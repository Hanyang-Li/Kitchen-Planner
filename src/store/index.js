import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

const store = new Vuex.Store({
  state: {
    Authorization: localStorage.getItem('Authorization') ? localStorage.getItem('Authorization') : ''
  },
  mutations: {
    changeLogin (state,user) {
      this.state.Authorization = user.Authorization;

      localStorage.setItem('Authorization', user.Authorization);

    }
  },
  actions: {
  },
  modules: {
  }
});

export default store;
