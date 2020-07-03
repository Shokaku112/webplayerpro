<template>
  <div>
    <el-carousel :interval="4000" type="card" height="200px" @change="onchanged">
      
      <el-carousel-item v-for="item in item" :key="item.index">
       <img class="img" :src="item.src"  v-bind:style="{filter:item.style}" >
      </el-carousel-item>
   
    </el-carousel>
    <div class="contenttag">

    
    <div class="maintag">

    <div class="nav1">
      <h2 class="nav1 a1"><a href="#">热门推荐</a></h2>
      <div class="tab" >
        <a href="#" class="tabtag">日语</a>
        <span class="tagline">|</span>
        <a  href="#" class="tabtag">英语</a>
        <span class="tagline">|</span>
        <a  href="#" class="tabtag">法语</a>
        <span class="tagline">|</span>
        <a  href="#"  class="tabtag">俄语</a>
      </div>
    </div>
        <div class="clear"></div>
        <div class="line"></div>
        <!-- 清除nav1对下面itemtag的浮动影响 -->
        <div style="text-align:center">
        <div class="itemtag">

          <div class="itembox" v-for="item in listitem" :key="item.index">
            <a href="#"><img class="item-img" :src="item.imgurl"></a>
            <div class="itembonx-title">
              <span class="itemname">{{item.itemname}}</span>
              <br>
              <div class="by">
                  <span>by</span> <a class="itemhref" :href="item.href">{{item.itemhref}}</a>
              </div>
            </div>
          </div>
        </div>
        
      <div class="nav1">
      <h2 class="nav1 a1"><a href="#">新碟上架</a></h2>
      
      </div>
        <div class="clear"></div>
        <div class="line"></div>
        <!-- 清除nav1对下面itemtag的浮动影响 -->
        <div class="center">
        <div class="midpart">
          <a class="left" >《</a>
          <a class="right" @click="itemright">》</a>
      
         <ul class="itemul" v-bind:style="{transition:change3,left:change}" >
           <li class="itemli"></li>
           <li class="itemli"></li>
           <li class="itemli"></li>
           <li class="itemli"></li>
           <li class="itemli"></li>
         </ul>

          <ul class="itemul"  v-bind:style="{transition:change3,left:change2}">
           <li class="itemli"></li>
           <li class="itemli"></li>
           <li class="itemli"></li>
           <li class="itemli"></li>
           <li class="itemli"></li>
         </ul>
         
         
        </div>
        </div>
      
      
    </div>
    <!-- itemtag -->
     <div class="nav1">
      <h2 class="nav1 a1"><a href="#">榜单</a></h2>
       </div>
        <div class="clear"></div>
       <div class="line"></div>
        <div class="bottom">
         <dl class="dlk">
                <dt class="top">
                  <div class="cover"><img class="cover-img" src="../assets/image/item-img/title1.jpg">
                </div>
                <div class="coverinfo">
                  <a class="cover-title" href="">云音乐飙升</a>
                  <div class="btn">
                     <a class="play" href="">
                       <svg class="bi bi-play-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M11.596 8.697l-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393z"/>
</svg>
</a>
                  <a class="collect" href="">
                    <svg class="bi bi-collection-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <rect width="16" height="10" rx="1.5" transform="matrix(1 0 0 -1 0 14.5)"/>
  <path fill-rule="evenodd" d="M2 3a.5.5 0 0 0 .5.5h11a.5.5 0 0 0 0-1h-11A.5.5 0 0 0 2 3zm2-2a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 0-1h-7A.5.5 0 0 0 4 1z"/>
</svg>
</a>
                  </div>
                 
                </div>
                </dt>
                <dd class="dd">
                 
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox end"><a class="songtitle bt" href="#">查看更多>></a></div></li>
                  
                  </dd> 
            </dl>

          <!-- list2 -->
                   <dl class="dlk">
                <dt class="top">
                  <div class="cover"><img class="cover-img" src="../assets/image/item-img/title1.jpg">
                </div>
                <div class="coverinfo">
                  <a class="cover-title" href="">云音乐飙升</a>
                  <div class="btn">
                     <a class="play" href="">
                       <svg class="bi bi-play-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M11.596 8.697l-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393z"/>
</svg>
</a>
                  <a class="collect" href="">
                    <svg class="bi bi-collection-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <rect width="16" height="10" rx="1.5" transform="matrix(1 0 0 -1 0 14.5)"/>
  <path fill-rule="evenodd" d="M2 3a.5.5 0 0 0 .5.5h11a.5.5 0 0 0 0-1h-11A.5.5 0 0 0 2 3zm2-2a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 0-1h-7A.5.5 0 0 0 4 1z"/>
</svg>
</a>
                  </div>
                 
                </div>
                </dt>
                <dd class="dd">
                 
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox end"><a class="songtitle bt" href="#">查看更多>></a></div></li>
                  
                  </dd> 
            </dl>
            <!-- list3 -->
                     <dl class="dlk">
                <dt class="top">
                  <div class="cover"><img class="cover-img" src="../assets/image/item-img/title1.jpg">
                </div>
                <div class="coverinfo">
                  <a class="cover-title" href="">云音乐飙升</a>
                  <div class="btn">
                     <a class="play" href="">
                       <svg class="bi bi-play-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <path d="M11.596 8.697l-6.363 3.692c-.54.313-1.233-.066-1.233-.697V4.308c0-.63.692-1.01 1.233-.696l6.363 3.692a.802.802 0 0 1 0 1.393z"/>
</svg>
</a>
                  <a class="collect" href="">
                    <svg class="bi bi-collection-fill" width="22px" height="22px" viewBox="0 0 16 16" fill="currentColor" xmlns="http://www.w3.org/2000/svg">
  <rect width="16" height="10" rx="1.5" transform="matrix(1 0 0 -1 0 14.5)"/>
  <path fill-rule="evenodd" d="M2 3a.5.5 0 0 0 .5.5h11a.5.5 0 0 0 0-1h-11A.5.5 0 0 0 2 3zm2-2a.5.5 0 0 0 .5.5h7a.5.5 0 0 0 0-1h-7A.5.5 0 0 0 4 1z"/>
</svg>
</a>
                  </div>
                 
                </div>
                </dt>
                <dd class="dd">
                 
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong "><div class="bottombox"><span>1</span><a class="songtitle" href="#">那些日子</a></div></li>
                    <li class="bottom-itemsong unmark"><div class="bottombox end"><a class="songtitle bt" href="#">查看更多>></a></div></li>
                  
                  </dd> 
            </dl>
        </div>
    </div>
    </div>
    <!-- right side content -->
    <div class="rightside">
      <!-- usermode -->
      <div class="userinfo">
        <!-- 用户头像信息 -->
      <div class="headimg">
        <a href="" class="userimg">
          <img class="imgsize" src="../assets/image/user/user1.jpg" alt="">
        </a>
        <div class="usertext">
          <h4><a class="username" href="#">Takaku</a></h4>
          <div class="icon2"> 
         <a class="u-lv" href="">LV5</a>
          </div>
          <div class="clear"></div>
          <!-- 消除浮动影响 -->
        <div class="signarea">
          <!-- 用户签到区域 -->
          <a class="signin" href="">
            <span>签到</span>
          </a>
        </div>
        </div>
        
      </div>
      <ul class="userstatus">
        <li><a class="datastyle" href=""><strong class="strongfont">1</strong>
        <p><span>关注</span></p></a></li>
        
        <li class="line2"><a class="datastyle" href=""><strong class="strongfont">1</strong>
         <p><span>粉丝</span></p></a></li>
        <li><a class="datastyle" href=""><strong class="strongfont">1</strong>
         <p><span>动态</span></p></a></li>
      </ul>
      </div>
       <div class="line3">
         <span class="span1">入住歌手</span>
          <span class="span2">查看全部>></span>
         
       </div>
        <a class="singer" href="">
          <img class="singerimg" src="../assets/image/singer/1.jpg">
          <div class="singertext">
            <div class="singername">张惠妹aMEI</div>
             <div class="singertype">台湾歌手张惠妹</div>
          </div>
        </a>
        <a class="singer" href="">
          <img class="singerimg" src="../assets/image/singer/1.jpg">
          <div class="singertext">
            <div class="singername">张惠妹aMEI</div>
             <div class="singertype">台湾歌手张惠妹</div>
          </div>
        </a>
        <a class="singer" href="">
          <img class="singerimg" src="../assets/image/singer/1.jpg">
          <div class="singertext">
            <div class="singername">张惠妹aMEI</div>
             <div class="singertype">台湾歌手张惠妹</div>
          </div>
        </a>
         <a class="singer" href=""></a>
         <div class="line3">
         <span class="span1">热门主播</span>
         
         
       </div>
    </div>
  </div>

</template>

<script>
import pic1 from '../assets/image/1.jpg'
import pic2 from '../assets/image/2.jpg'
import pic3 from '../assets/image/3.jpg'
import pic4 from '../assets/image/3.jpg'

import 'jquery/dist/jquery.js'
import 'bootstrap/dist/js/bootstrap.js'
import 'bootstrap/dist/css/bootstrap.css'




export default {
 
    data(){
      return{
       itemswip:[
         {
           isactive:true,
           change:'161px'
         },
         {
           isactive:false,
           change:'0px'
         },
         ],
        change3:'',
        change2:'-675px !important',
        change:"161px",

        listitem:[
          {
            itemname:"【日式青春】放学后......",
            itemhref:"xxxxxx",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          },
           {
            itemname:"【日式青春】放学后......",
            itemhref:"xxxxxx",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            // require('../assets/images/member.png')
            
          },
           {
            itemname:"【日式青春】放学后......",
            itemhref:"xxxxxx",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          },
           {
            itemname:"【日式青春】放学后......",
            itemhref:"xxxxxx",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          },
           {
            itemname:"【日式青春】放学后......",
            itemhref:"xxxxxx",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          },
            {
            itemname:"【日式青春】放学后......",
            itemhref:"愛(あい)してる ただそれだけで",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          },
            {
            itemname:"【日式青春】放学后......",
            itemhref:"愛(あい)してる ただそれだけで",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          },
            {
            itemname:"【日式青春】放学后......",
            itemhref:"愛(あい)してる ただそれだけで",
            href:"www.baidu.com",
            imgurl:require('../assets/image/item-img/2.jpg')
            
          }
        ],
        index:0,
        item:[
         {index:'0',src:pic1,isactive:true,style:'blur(0px)'},
         {index:'1',src:pic2,isactive:true,style:'blur(15px)'},
         {index:'2',src:pic3,isactive:true,style:'blur(15px)'},
         {index:'3',src:pic4,isactive:true,style:'blur(15px)'}
          ],
        
      }
    },
    methods:{
      onchanged(index,oldindex){
           this.carouselIndex = index;
           this.index=index
           console.log("new"+index)
           console.log("old"+oldindex)
        
      },
      itemright(){
        this.change='-675px !important'
        this.change3='left 3s'

      }
      //onchanged事件是carouesl.js文件下watch下的监听变量activeIndex函数，里面有两个参数分为当前激活对象，和之前激活对象
    //  在子组件中需要向父组件传值处使用this.$emit("function",param);   //其中function为父组件定义函数，param为需要传递参数
    },
    //监听data下的变量的值发生改变后处理的事件（对该变量的处理）
    watch:{
      index(){
        for(let i=0;i<this.item.length;i++){
          this.item[i].style='blur(15px)'
        }
        this.item[this.index].style='blur(0px)'
        console.log("changed")
      },

     
    },
      
    

}
</script>


<style scoped>
.contenttag{
  overflow: hidden;
  border:1px solid #d3d3d3 ;
  position: relative;
  right: -185px;
  width: 981px;
  height: auto;
  /* background: yellow; */
}
/* div{ 
white-space:nowrap; 
}  */
.dd{
  display: block;
}
.play{
  margin-right:10px ;
}
.collect{
  margin-left:10px ;
}
.cover-title{

}
.coverinfo{
  float: left;
  width: 116px;

}
.cover-img{
  height: 100%;
  width: 100%;
}
.cover{
  float: left;
  width: 80px;
  height: 80px;
  background: grey;
}
.top{
  padding: 0px;
  height: 100px;
  margin: 20px 0 0 20px;
}
.dlk{

  float: left;
  width:230px ;
  border: 1px solid #c3c3c3;
  background: #f4f4f4;
  height: auto;
  overflow: hidden;
}
.bottom{
  width: 800px;
  height: 480px;
  background: white;
  position: relative;
  right: 3px;
}
.left{
  float: left;
  position: relative;
  width: 17px;
  height: 17px;
  top: 100px;
  left: 0;
  
 
}
.right{
  float: right;
  position: relative;
  width: 17px;
  height: 17px;
  top: 100px;
  right:0;

}

.itemul{
  left: 0px !important;
  display: block;
  position: relative;
  list-style: none;
  text-align: left;
  width: 671px;
  height: 150px;
  padding-left:13px ;
 
  
  /* absoulute可以解决水平显示的问题 */
  transition: left 3s;
}
.itemul2{
  overflow: hidden;
  margin: 0 auto;
  list-style: none;
  text-align: left;
  width: 671px;
  height: 150px;
  position: absolute;
  padding-left:13px ;

}
.itemli{
  margin-top: 30px;
  width:118px ;
  height:150px ;
  margin-left: 11px;
  background: green;
  float: left;
  margin-bottom: 10px;
  position: relative;

}

.card{
  width: 118px;
  height: 150px;

}
.center{
  padding: 30px;
  text-align: center;
}
.midpart{
  position: relative;
  overflow: hidden;
  right: 38px;
  width: 700px;
  height: 200px;
  background: grey;
  float: left;
}
.itemhref{
  font-size: 12px;
}
a{
  text-decoration:none
}
.itemhref{
  margin-left: 5px;
}
.by{
  height: auto;
  text-align: left;
}
.itemname{
  font: bold;
  font-size: 12px;
}
.itembonx-title{
  width: 140px;
  height: 24px;
  text-align: left;
}
template{
  background: #f5f5f5;
}
.line{
  height: 2px;
  width: 100%;
  background:-webkit-gradient(left,rgba(255,255,255,0),	#00BFFF,rgba(255,255,255,0)) ;
  background:linear-gradient(to right,rgba(255,255,255,0),#0000CD,rgba(255,255,255,0))
}
.itembox{
  margin-left: 43px;
  margin-top:50px ;
  width: auto;
  height: 185px;
  background: white;
 
}
.itemtag{
  position: relative;
  right: 50px;
  margin-right:30px ;
  margin-top:10px ;
  width: 800px;
  height: 550px;
  background: white;
  display: flex;
  flex-flow: row wrap;
  /* justify-content: space-between; */
  align-content: flex-start
}
.img{
  width: 100%;height: 100%;
}
 
  .el-carousel__item h3 {
   
    font-size: 14px;
    opacity: 0.75;
    line-height: 200px;
    margin: 0;
  }
  
  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }
  
  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  .maintag{
      position: relative;
      right: 140px;
      overflow: hidden;
      margin: 0 auto;
      padding: 30px;
      width: 731px;
      height: 100%;
      background-color: white;
      border: 1px solid #d3d3d3;
  }
  .clear{
    clear: both;
  }
  .nav1{
    float: left;
  }
  .a1{
    margin: 10px;
  }
  .tab{
    display: inline-block;
    padding: 20px;
  }
  .tabtag{
    margin: 0px 5px 0px 5px;
    
  }
 .tagline{
  margin: 0px 10px 0px 10px;
 }
 .modaltopleft{
   width: 25%;
   height: 100%;
   filter: blur(10px);
   position: relative;
   left: 0;
   top: 0;
   z-index: 10;
   background: gold;
 }
 .modaltopright{
   width: 25%;
   height: 100%;
   /* background: grey; */
   float: right;
   position: absolute;
   top: 0;
   left: 75%;
 }
 .modal{
  -webkit-filter: blur(15px);
 }
 .item-img{
  width: 140px;
  height: 140px;
  border: 1px solid black;
}
.bottom-itemsong{
  width: 230px;
  height: 30px;
  text-align: left; 
  list-style: none;
  
 
  /* padding: 15px; */
}

.unmark{
  background: #e8e8e8;
}
.songtitle{
  font-size: 12px;
  line-height: 15px;
  margin-left: 10px;
}
.bottombox{
  margin: 1px 0 5px 32px;


}
.songnum{
  margin-right: 10px;
}
.end{
  text-align: right;
  padding-right: 32px;
  
}
.rightside{
  position: relative;
  left: 901px;
  bottom: 1526px;
  width:265px ;
  height:180px ;
  background: #f8f8f8;
}
.userinfo{
  padding-top:22px ;
  width: 252px;
  height: 180px;
  border: 1px solid #b2b2b2;
  /* background: ; */
}
.headimg{

width: 230px;
height: 87px;
margin: 0px 0px 0px 19px;
}
.userimg{
  float: left;
  width: 86px;
  height: 86px;
  padding: 2px;
 
  border: 1px solid gray;
}
.imgsize{
  display: block;
  width: 80px;
  height: 80px;
  background: purple;
  /* a标签放置img的时候需要将display设置成block模块 */
}
.usertext{
  width: 126px;
  height: 60px;
  
  float: left;
  margin-left:18px ;
  text-align: left;
}
.username{
  /* float: left; */
  color: black;
  font-size: 16px;
  vertical-align: middle;
}
.username:hover{
  text-decoration: underline;
}
.u-lv {
    width: 40px;
    height: 17px;
    border: 1px solid black;
    font-weight: bold;
    font-style: italic;
    border-radius:12px ;
    font-size: 12px;
    display:block;
    /* a标签是行内元素，所以需要设置成块级元素才能撑开宽高 */
    text-align: center;
}
.signarea{
  width: 100%;
  height: 31px;
 
}
.signin{
color: black;
display: block;
width: 75px;
height: 30px;
background: #eeeeee;
color: #c9c9c9;
border-radius: 5px;
text-align: center;
padding-top:2px ;
margin-top: 15px;
border: 1px solid #f8f8f8;
}
h4{
  margin-bottom: 2px;
}
.userstatus{
  list-style: none;
  margin: 22px 0 0 22px;
  text-align: left;
  position: relative;
  right: 47px;
}
.userstatus li{
  float: left;
  width: 45px;
  height: 40px;
  text-align: left;
  /* background: olivedrab; */
  margin: 0 5px 0 5px;
  display: block;
 

}
.line2{
   border-right: 1px solid grey;
    border-left: 1px solid gray;
    margin: 0 10px 0 0px !important;
    padding-left: 5px;
}
.datastyle{
  display: block;
  color: #666666;
  
}
.strongfont{
  font-size: 20px;
}
p span{
  font-size: 12px;
}
a p{
  position: relative;
  top: -5px;
}
.line3{
  width: 210px;
  height: 24px;
  background: white;
  margin: 22px 0 0 22px;
  border-bottom: 1px solid #b2b2b2;
  margin-bottom: 20px;
}
.span1{
float: left;
font-size: 12px;
font-weight: bold;
}
.span2{
  float: right;
  font-size: 12px;
}
.singer{
  display: block;
  width: 205px;
  height: 64px;
  background: #fafafa;
  margin: 0 auto;
  margin-bottom: 20px;
  list-style: none;
  border: 1px solid #e9e9e9;
  overflow: hidden;
}
.singer:hover{
  background: #bebebe;
  
}
.singerimg{
  width: 65px;
  height: 65px;
  background: purple;
  float: left;
}
.singertext{
  position: relative;
  width: 135px;
  height: 65px;
 
  float: right;
  padding-top: 10px;
  text-align: left;
  padding-left:5px ;
}
.singername{
  font-size: 15px;
  margin-bottom: 5px;
  font-weight: bold;
  color: black;
}
.singertype{
font-size: 12px;
color: gray;
}
</style>