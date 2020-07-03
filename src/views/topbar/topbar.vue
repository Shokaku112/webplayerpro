<template>
  <div>
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
         <img class="circle user"  src="../../assets/image/navbar/2.jpg" alt="">
     </div>
     </div>
     
  </div>
</template>

<script>
export default {

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

}
</style>

