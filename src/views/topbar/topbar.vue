<template>
  <div>
     <!-- v-on:success为子组件响应事件destroyed下的this.emit('success')，然后让父组件执行canceled方法 -->
      <login v-if="iflogin" v-bind:loginstatus="iflogin" v-on:existuser="userconfirm()"  v-on:destroyed="canceled()"></login>
      <!-- 导航条 -->
     <div class="topbar">
         <!-- 左侧图标部分 -->
        <h1 class="logo">
            <a class="logoa" href="#">
                <img class="circle"  src="../../assets/image/navbar/2.jpg" alt="">
                <span class="logoname">XXX音乐</span>
            </a>
        </h1>
        <!-- <div class="clear"></div> -->
        <!-- 列表部分 -->
        <ul class="navlist">
            <li class="list">
               <a class="lista markk" href="">发现音乐</a>
            </li>
            <li class="list">
                 <a class="lista" href="">我的音乐</a>
            </li>
            <li class="list">
                <a class="lista" href="">朋友</a>
            </li>
            <li class="list">
                <a class="lista" href="">商城</a>
            </li>
            <li class="list">
                <a class="lista" href="">音乐人</a>
            </li>
        </ul>
        <!-- 搜索框部分 -->
        
        <div class="searchpart">
           
            <img class="iconsearch" src="../../assets/image/navbar/search.svg">
            <input class="inputsearch" type="text">
        </div>
        <!-- 用户区域 -->
     <div class="userpart">
         <div class="clear"></div>
         <div class="nouser" :style="{ 'display': !userimg ? 'block' : 'none' }">   <a href="javascript:void(0)" @click="renderlogin()" >用户登录</a> </div>
         <img class="circle user"  :src="imgurl" :style="{ 'display': userimg ? 'block' : 'none' }" alt="">
         <div class="userlist">
             <ul class="tagul">
                 <li class="taglist" v-for="item in taglist"  v-bind:key="item" ><a @click="jumprouter(item.url)" href="javascript:void(0)">{{item.name}}</a></li>
                 <!-- 遇坑之一：a标签href不能为空值否则跳转路由的时候会出大问题（返回根路由草） -->
                
             </ul>
         </div>
     </div>
     </div>
       
  </div>
</template>

<script>
import login from '../login/login.vue'

 
export default {
    
   components:{
      login
   },
   data() {
       return {
           iflogin:false,
           userimg:false,
        //    "用户信息","个人收藏歌曲","登出"
           taglist:[
               {
                   name:"用户信息",
                   url:"/player/user"

               },
               {
                   name:"个人收藏歌曲",
                   url:"321321"

               },
               {
                   name:"登出",
                   url:"3213212"

               }
           ],
           imgurl:require("../../assets/image/user/user1.jpg")
        //    checkedlogin:false,
          

       }
   },
   methods: {
       jumprouter(path){
        //    const that=this
           console.log(path)
           this.$emit("isLeft")
           this.$router.push(path);


       },
        getUserinfo(){
           let data = JSON.parse(sessionStorage.getItem("Userinfo"));
          // Object.assign方法 赋值 （目标对象， 源对象）
          Object.assign(this, data);
          this.imgurl=require("../../assets/image/user/"+data.Userimg)
          
         
        },
       renderlogin(){
           this.iflogin=true;
       },
       canceled(){
           this.iflogin=false;
           console.log('success')
       },
       userconfirm(){
           this.bus.$emit("message",false);
           this.getUserinfo()
           this.userimg=true;
           this.iflogin=false;


       }
       
      
   },
   mounted() {
      // 在子组件B中，在created或mounted等生命周期函数上，监听那个事件和获取那个值。
      this.bus.$on('existuser', (val) => {
        console.log(val)
        this.userimg=true
      });
      
      
    },
   
    
   
    created() {
       this.getUserinfo()
    },

}
</script>

<style scoped>
.topbar{
    width: 100%;
    height: 70px;
    margin-bottom: 20px;
    background: #242424;
    position: relative;
   
}
.logo{
float: left;
padding-left: 40px;
padding-top: 5px;
}
.circle{
    width: 60px;
    height: 60px;
    border-radius: 40px;
    vertical-align:middle
}
.leftpart{
    width: 176px;
    height: 100%;
    display: block;
}
.logoname{
    font-size: 22px;
    color: #ffffff;
    letter-spacing: 7px;
    margin-left: 10px;
}
.logoa{
    display: block;
    text-decoration: none;
}
.navlist{
   float: left;
   list-style: none;
   /* margin: 0 0 0 5px; */
}
.list{
    width: 95px;
    height: 70px;
    
    float: left;
    text-align: center;
   
}
.clear{
    clear: both;
}
.lista{
    display: block;
    width: 100%;
    height: 100%;
    padding-top: 25px;
    text-decoration: none;
    color: white;
}
.lista:hover{
    background: black;
}
.markk{
    background: black;
}
.searchpart{
    margin-left: 20px;
    margin-top:20px ;
    width: 158px;
    height: 32px;
    background: white;
    float: left;
    border-radius: 15px;
    text-align: left;
    padding:4px 0 0 4px;
}
.iconsearch{
    
}
.inputsearch{
    position: relative;
    width: 120px;
    height: 16px;
    border: 0px;
    
}
input{
    border: 0px;
}
input:focus{
    outline: medium;
}
.userpart{
    float: left;
    
}
.user{
    margin-top: 16px;
    margin-left:120px ;
    width: 35px;
    height: 35px;
    display: none;
}
.nouser{
    margin-top: 26px;
    margin-left:80px ;
    width: 100px;
    height: 35px;
    color: white;
}
.userlist{
position: absolute;
width: 160px;
height: 245px;
margin-left: 50px;
background:#242424 ;


z-index: 10;
}
.tagul{
    list-style: none;
    padding: 0;
}
.taglist{
    
}
</style>

