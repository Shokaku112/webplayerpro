const { Sequelize, DataTypes, Model } = require('sequelize');
const express = require('express');
const router = express.Router();
const mysql=require('mysql2')
const jwt=require('jsonwebtoken')
const fs=require('fs')
const path=require('path');
// const { JSON } = require('mysql2/lib/constants/types');
//连接数据库测试
const sequelize = new Sequelize('datalist', 'root', '123456', {
    host: 'localhost',
    dialect: "mysql"
  });
 
  
  
 
 
   router.get('/getuser',function (req,res,next) {
    const username=req.query.username
    const userpassword=req.query.userpwd
    const token=req.query.token;
         
    var Userinfo={
        statusCode:-1,
        Username:'',
        Userpassword:'',
        token:token
    }
    console.log(token)
    console.log(typeof token)
    let that=this;
    //如果token非空则进行token验证
    if(token!="null"&&username==null&&userpassword==null){
      console.log("enter token")
      //第一个参数为传入的token值，第二个为约定使用的密钥
      jwt.verify(token,'secret',(error,decoded)=>{
         //如果error则说明该密钥是伪造或者错误的
        if(error){
          console.log(error.message)
          return
        }
          //验证通过后，则输出密钥的内容信息
        console.log(decoded)
       JSON.stringify(decoded)
        res.send(decoded)
      })
    }else if(username!=null&&userpassword!=null&&token=="null"){
      console.log("enter make call")
      async function makecall(){
        try {
           await sequelize.authenticate();
           console.log('Connection has been established successfully.');
            //建立表
    
      const User = sequelize.define('User', {
        // 在这里定义模型属性
        Username: {
          type: DataTypes.STRING,
          allowNull: false
        },
        Userpassword: {
          type: DataTypes.STRING,
          allowNull: false
          // allowNull 默认为 true
        },
        Userimg:{
          type:DataTypes.STRING,
          allowNull:true
        }
      
       
      }, {
        // 这是其他模型参数
      });
      
      // `sequelize.define` 会返回模型
    //   console.log(User === sequelize.models.User); // true
    //   await User.sync()
       //创建用户
         
   
    // console.log("user1's auto-generated ID:", user1.id);
    
    // User.sync() - 如果表不存在,则创建该表(如果已经存在,则不执行任何操作)
    // User.sync({ force: true }) - 将创建表,如果表已经存在,则将其首先删除
    // User.sync({ alter: true }) - 这将检查数据库中表的当前状态(它具有哪些列,它们的数据类型等),然后在表中进行必要的更改以使其与模型
   
      
    await  User.findAll({
        where: {
          Username:username,
          Userpassword:userpassword,
        },
       
       
      }).then(function(result){
        //   console.log(result)
          if(result.length==0){
          
            res.send("statusCode:-1")

          }
          else{
            //正确之后添加用户信息与生成token
          
           
            // var token = jwt.sign({ username, iat: Math.floor(Date.now() / 1000) - 30 }, 'shhhhh');
            let userinomation={
              Username:result[0].dataValues.Username,
              Userimg:"user1.jpg",
              
            }
           
          var token=jwt.sign({
            exp: Math.floor(Date.now() / 1000) + (60 * 60),
            data: userinomation
          }, 'secret');
          Userinfo={
            statusCode:1,
            Username:result[0].dataValues.Username,
            Userpassword:result[0].dataValues.Userpassword,
            Userimg:"user1.jpg",
            token:token
        }
      
        
         
          JSON.stringify(Userinfo)
              res.send(Userinfo)
           
            
          }
         
          
      });
     
         } catch (error) {
           console.error('Unable to connect to the database:', error);
         }
        
        //  const user1 = await User.create({ Username: "shokaku112", Userpassword: "1234567" });
      }
      
      makecall()
    }else if(username==null&&userpassword==null&&token=="null"){
      res.send("你TM好像还没登陆！")
    }
    


     
   }),


module.exports = router;