import Vue from 'vue'
import Router from 'vue-router'
import topbar from '../src/views/topbar/topbar.vue'
import player from '../src/views/player.vue'
import Userinfomation from '../src/views/Userinfomation/myinfo'
Vue.use(Router)
export default new Router({
    routes:[
        {
            path: "/",
            redirect: "player"
          }, 
          //最初重定向的网页
          //路由重定向入口，用于配置多个vue组件模板
        {
            path:'/player',
            name:'player',
            component:player
        },
        {
            path:'/player/user',
            name:'user',
            component:Userinfomation
        },
        {
            path:'/topbar',
            name:'topbar',
            component:topbar
        },
       
    ]
})