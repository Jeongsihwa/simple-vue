<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 목록</h1>
    <div class="btn-group">
      <router-link to="/user/save" class="btn btn-primary">사용자 추가</router-link>
    </div>
    <table class="table table-hover mt-3">
      <thead class="table-dark">
        <tr>
          <th>이름</th>
          <th>이메일</th>
          <th>가입날짜</th>
        </tr>
      </thead>
      <tbody>
        <tr class="cursor-pointer" v-for="row in result" :key="row.id" v-on:click="href(row)">
          <td>{{ row.name }}</td>
          <td>{{ row.email }}</td>
          <td>{{ row.dateTime }}</td>
        </tr>
      </tbody>
    </table>
  </div>
</template>

<script setup>
import { getUserListRequest } from '@/apis';
import { onMounted, ref } from 'vue';

const result = ref([]);

const getFindAllResponse = (responseBody) => {
  if (!responseBody || responseBody.code !== '200') {
    alert('오류');
    return;
  }
  console.log(responseBody);
  result.value = responseBody.userDtos;
}

onMounted(() => {
  getUserListRequest().then(getFindAllResponse);

})
</script>

<style scoped>
.cursor-pointer {
  cursor: pointer;
}
</style>