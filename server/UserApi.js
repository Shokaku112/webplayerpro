const { Sequelize, DataTypes, Model } = require('sequelize');
const express = require('express');
const router = express.Router();
const mysql=require('mysql2')
//连接数据库测试
const sequelize = new Sequelize('datalist', 'root', '123456', {
    host: 'localhost',
    dialect: "mysql"
  });
 
  
  
 
 
   router.get('/getuser',function (req,res,next) {
    const username=req.query.username
    const userpassword=req.query.userpwd
   
    var Userinfo={
        statusCode:-1,
        Username:'',
        Userpassword:''
        
    }
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
      
       
      }, {
        // 这是其他模型参数
      });
      
      // `sequelize.define` 会返回模型
    //   console.log(User === sequelize.models.User); // true
    //   await User.sync()
       //创建用户
         
    // const user1 = await User.create({ Username: "Lbb", Userpassword: "12353123" });
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
            Userinfo={
                statusCode:1,
                Username:result[0].dataValues.Username,
                Userpassword:result[0].dataValues.Userpassword
            }
            console.log(result[0].dataValues.Username)
            JSON.stringify(Userinfo)
            res.send(Userinfo)
          }
          
      });
     
         } catch (error) {
           console.error('Unable to connect to the database:', error);
         }
        
        
      }
      makecall()

     
   }),


module.exports = router;