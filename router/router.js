import Vue from 'vue'
import Router from 'vue-router'
import Sampleplayer from '../src/views/sample.vue'
import player from '../src/views/player.vue'
Vue.use(Router)
export default new Router({
    routes:[
        {
            path:'/home',
            name:'home',
            component:Sampleplayer,
            redirect:'home',
            meta:{
                title:''
            }
            
        },
        {
            path:'/player',
            name:'player',
            component:player
        }
    ]
})