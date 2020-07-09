<template>
        

             <div class="modalmask">
                 <div class="loginmode">
                <div class="cancelmode"><a class="cancelbtn" href="javascript:void(0);" @click="destroyed()">X</a></div>
                        <div class="input-group">
<div class="column col-lg-12 poi">

<input type="text" class="form-control col-lg-6" v-model="username"  placeholder="请输入账号">
<input type="text" class="form-control col-lg-6" v-model="userpwd"  placeholder="请输入密码">
<div class="row">
<div class="are1">
    <label  for="name">自动登录</label>
    <input id="name" type="checkbox">
</div>
<div class="are2">
    <a href="">忘记密码?</a>
</div>
</div>

<button @click="logincheck()" type="button" class="form-control btn btn-info lgbtn col-lg-6">登录</button>
</div>
  
 
 
</div>
                 </div>
                 

             </div>
  

        
     
</template>

<script>
// import Vue from 'vue'
import axios from 'axios'
export default {
    data() {
        return {
            userpwd:null,
            username:null,
            notificationchange:this.loginstatus,
        }
    },
    props:['loginstatus'],
    
   methods: {
       destroyed(){
            // this.$emit('changestatus', false);
           this.notificationchange=false
           this.$emit('destroyed');
           
           console.log('clicked')
       },
       setcookie(c_name,value,expireseconds){
            var exdate=new Date();
    exdate.setTime(exdate.getTime()+expireseconds * 1000);
    document.cookie=c_name+ "=" +escape(value)+
    ((expireseconds==null) ? "" : ";expires="+exdate.toGMTString())
       },
    getCookie(userName){
      if (document.cookie.length>0){
        let c_start=document.cookie.indexOf(userName+ "=");
        if (c_start!=-1){
          c_start=c_start + userName.length+1;
        let  c_end=document.cookie.indexOf(";",c_start);
          if (c_end==-1){ 
              c_end=document.cookie.length;
          }
          return unescape(document.cookie.substring(c_start,c_end));
        }
     }
    return null;
     
},
       ifloginstatus(){


       },

       logincheck(){
        //    console.log(this.username)
        //    console.log(this.userpwd)
           let that=this;
        //    let Event=new Vue();
        
           let username=this.username
           let userpwd=this.userpwd
           //进行cookies判断
            // eslint-disable-next-line
           var Token=this.getCookie("token");
           console.log(Token)
           if(username!=null&&userpwd!=null){
                           let url="http://localhost:3001/user/getuser?username="+username
           +"&userpwd="+userpwd
           +"&token="+Token
           axios
           .get(url)
           .then(function(res){

               console.log(res.data)
               if(res.data.statusCode==1){
                    
                //    that.$emit("existuser")
                 sessionStorage.setItem("Userinfo", JSON.stringify(res.data))
                    that.bus.$emit("existuser")
                    that.$emit("existuser")
                   that.bus.$emit("success")
                   that.$emit("success")
                   that.setcookie("token",res.data.token,300)
                   
                   

               }else if(res.data=="statusCode:-1"){

                   alert("用户名不对或者账号错误")
               }
           })
           .catch(function(e){
               console.log(e)
           })

           }else{
               alert("你的账号或者密码为输入不完整!")
           }

       }
   },
  mounted() {
    // this.setcookie('userName','Tom',5);
     var  userName = this.getCookie('userName');
     console.log(userName)
    
  },
   
}
</script>

<style  scoped>
.modalmask{
    width: 100vw;
    height: 100vh;
    /* background: greenyellow; */
    position: absolute;
    z-index: 100;
  
}
.loginmode{
    width: 530px;
    height: 330px;
    background: white;
    margin: 100px 0 0 400px;
}
/* .form-control{
    width: 200px!important;

} */
.poi{
    position: relative;
    margin: 30px 0 0 140px;
    text-align: center;
}   
.form-control{
    margin-top: 20px;
}
.lgbtn{
    /* position: relative; */
    margin: 10px 225px 0 0;
    width: 220px;
    height: 30px;
}
.are1{
    width: 96px;
    height: 32px;
    margin-top: 10px;
    padding-top: 4px;
    font-size: 14px;
}
.are2{
    width: 96px;
    height: 32px;
        margin-top: 10px;
    margin-left:105px ;
    font-size: 14px;
    padding-top: 4px;
}
.cancelmode{
    width: 30px;
    height: 30px;
    position: relative;
    /* background: black; */
    float: right;
}
.cancelbtn{
    color: gainsboro;
    text-decoration: none;
}   
</style>

