<template>
        

             <div class="modalmask">
                 <div class="loginmode">
                <div class="cancelmode"><a class="cancelbtn" href="javascript:void(0);" @click="destroyed()">X</a></div>
                        <div class="input-group">
<div class="column col-lg-12 poi">

<input type="text" class="form-control col-lg-6"  placeholder="请输入账号">
<input type="text" class="form-control col-lg-6"  placeholder="请输入密码">
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
import axios from 'axios'
export default {
    data() {
        return {
            notificationchange:this.loginstatus,
        }
    },
    props:['loginstatus'],
   methods: {
       destroyed(){
            // this.$emit('changestatus', false);
           this.notificationchange=false
           this.$emit('success');
           console.log('clicked')
       },
       logincheck(){
           let username="Lbb"
           let userpwd="12353123"
           let url="http://localhost:3001/user/getuser?username="+username
           +"&userpwd="+userpwd
           axios
           .get(url)
           .then(function(res){
               console.log(res.data)
           })
           .catch(function(e){
               console.log(e)
           })
       }
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

