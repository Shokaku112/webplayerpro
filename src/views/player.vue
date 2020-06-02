<template>
  <div>
    <el-carousel :interval="4000" type="card" height="200px" @change="onchanged">
      
      <el-carousel-item v-for="item in item" :key="item.index"  >
       <img class="img" :src="item.src"  v-bind:style="{filter:item.style}" >
      </el-carousel-item>
   
    </el-carousel>

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

        <div class="itemtag">
          <div class="itembox" v-for-key="(value,key,index) in listitem">
            <a href="#"><img class="item-img" src="../assets/image/item-img/2.jpg"></a>
            <div class="itembonx-title">
              <span class="itemname">【日式青春】放学后......</span>
              <br>
              <div class="by">
                  <span>by</span> <a class="itemhref" :href="{index}">xxxx</a>
              </div>
            </div>
          </div>
        </div>
    </div>

  </div>

</template>

<script>
import pic1 from '../assets/image/1.jpg'
import pic2 from '../assets/image/2.jpg'
import pic3 from '../assets/image/3.jpg'
import pic4 from '../assets/image/3.jpg'
export default {
 
    data(){
      return{
        listitem:[
          {
            itemname:"【日式青春】放学后......",
            itemhref:"xxxxxx",
            href:"www.baidu.com",
            imgurl:"../assets/image/item-img/2.jpg"
            
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
.itemhref{
  margin-left: 5px;
}
.by{
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
  margin-top:30px ;
  width: 140px;
  height: 185px;
  background: white;
 
}
.itemtag{
  margin-top:10px ;
  width: 600px;
  height: 550px;
  background: white;
  flex-flow: row wrap;
  display: flex;
  justify-content: space-between;
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
      
      margin: 0 auto;
      padding: 30px;
      width: 55%;
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
</style>