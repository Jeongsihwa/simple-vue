<template>
  <div class="home">
    <a href="/user">사용자 목록</a>
    <br>
    <button @click="getDate">데이터호출</button>
  </div>
</template>

<script setup>
import axios from 'axios';

const uForm = { id: 1, name: '테스트', email: 'test@email.com', pwd: '1234', gender: true }
const params = {
  params: { id: 1 }
}
const getDate = () => {
  axios.put('http://localhost:8080/save', uForm)
    .then((response) => {
      console.log(response)
    })
    .catch((error) => {
      console.log(error)
    })
}
</script>
<style scoped>
a {
  color: black;
  text-decoration: none;
  font-weight: bold;
  font-size: 1.5rm;
}
</style>