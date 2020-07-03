<template>
  <div id="app">
     <Topbar></Topbar>
      <router-view/>
      <!-- //router模式 -->
  </div>
</template>

<script>
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap/dist/js/bootstrap'
import 'bootstrap/dist/js/bootstrap.bundle'
import Topbar from '../src/views/topbar/topbar'
export default {
  components:{Topbar},
  name: 'App',
  
}
</script>

<style scoped>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
 
}
</style>
