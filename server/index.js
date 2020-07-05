// node 后端服务器

const fs = require('fs')
const path = require('path')
const bodyParser = require('body-parser')
const express = require('express')
const UserApi=require('./UserApi')

// const {Sequelize}=require('sequelize');
// const sequelize = new Sequelize('clientlog', 'root', '123456', {
//     host: 'localhost',
//     dialect: "mysql"
//   });
 
//   async function makecall(){
//     try {
//        await sequelize.authenticate();
//        console.log('Connection has been established successfully.');
//      } catch (error) {
//        console.error('Unable to connect to the database:', error);
//      }

//   }
//   makecall()

// var session=require('express-session');

const app = express()
//采用设置所有均可访问的方法解决跨域问题
app.all("*", function (req, res, next) {
    //设置允许跨域的域名，*代表允许任意域名跨域
    res.header("Access-Control-Allow-Origin", "*");
    //允许的header类型
    res.header("Access-Control-Allow-Headers", "content-type");
    //跨域允许的请求方式
    res.header("Access-Control-Allow-Methods", "DELETE,PUT,POST,GET,OPTIONS");
    if (req.method.toLowerCase() == 'options')
        res.send(200); //让options尝试请求快速结束
    else
        next();
})


// var session=require('express-session');

// app.use(session({
//     name:'mysession',
//     secret:'sessiontest',
//     resave:true,
//     saveUninitialized:true,
//     cookie: {path: '/', httpOnly: true, maxAge: 30000},
// }));

// 后端api路由

app.use('/user', UserApi)
//第一个参数为路由路径，第二个为使用的路由对象

app.use(bodyParser.json())
app.use(bodyParser.urlencoded({ extended: false }))
// 后端api路由


// 监听端口
app.listen(3001)
console.log('success listen at port:3001......')
module.exports=app;