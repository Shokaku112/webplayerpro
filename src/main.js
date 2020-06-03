import Vue from 'vue'
import App from './App.vue'
import router from '../router/router'
import elmentui from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'bootstrap'
import jq from 'jquery'

Vue.config.productionTip = false
Vue.use(elmentui)
Vue.use(jq)

router.beforeEach((to,from,next)=>{
  if(to.meta.title){
    document.title=to.meta.title;
  }
  next()
})
new Vue({

  router,
  render: h => h(App),
}).$mount('#app')
