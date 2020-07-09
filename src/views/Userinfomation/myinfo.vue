<template>
  <div>
    <div class="mainbody col-lg-12 col-md-6">
        <div class="childbody">
            <div class="usertitle"><h1 class="titlefont">个人设置</h1></div>
            <div class="optionlist">
                <ul class="optionul">
                    <li v-for="item in usersettings" :key="item" class="optionli"><a class="lia" href="">{{item.name}}</a></li>
                     
                </ul>
            </div>
        </div>
    </div>
  </div>
</template>

<script>
export default {
   name:'user',
   data() {
       return {
           usersettings:[
               {
                   name:"个人信息",
                   url:"/user"

               },
               {
                    name:"修改密码",
                    url:"/user"

               },
               {
                    name:"音乐收藏记录",
                    url:"/user"

               }
           ]
       }
   },   
}
</script>

<style scoped>
.mainbody{
    width: 1366px;
    height: 700px;
    background: green;
  
}
.childbody{
    width: 980px;
    height: 580px;
    background: white;
    margin: 0 auto;
    text-align: left;
    padding: 50px 0 0 20px;
   
}
.titlefont{
    font-size:30px;
}
.usertitle{
    
}
.optionul{
    padding: 0;
    list-style: none;
}
.optionli{
    width: 137px;
    height: 40px;
    background: white;
    float: left;
    text-align: center;
    border: 1px solid gray;
   

}
.optionli:hover{
     border-top: 1px solid orange;
}
.optionli a{
    display: block;
    height: 100%;
    padding: 5%;
    text-decoration: none;
    color: black;
}

</style>