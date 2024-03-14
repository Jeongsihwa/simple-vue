<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 정보</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="name" class="form-label">이름:</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." :class="{ active: active.name }"
          name="name" v-model="result.name" />
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." :class="{ active: active.email }"
          name="email" v-model="result.email" />
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." :class="{ active: active.pwd }"
          name="pwd" v-model="result.pwd" />
      </div>
      <div class="d-flex">
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="gender" v-bind:value="true" checked
              v-model="result.gender" />
            <label class="form-check-label" for="radio1">남성</label>
          </div>
        </div>

        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="gender" v-bind:value="false" checked
              v-model="result.gender" />
            <label class="form-check-label" for="radio2">여성</label>
          </div>
        </div>
      </div>
    </form>
    <div class="d-flex">
      <div class="p-2 flex-fill d-grid">
        <button class="btn btn-primary" @click="save">생성</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <a href="/user" class="btn btn-primary">취소</a>
      </div>
    </div>
  </div>
</template>

<script setup>
import { createUserRequest } from '@/apis';
import { ref } from 'vue';
import { useRouter } from 'vue-router';

const router = useRouter();
const result = ref({ name: '', email: '', pwd: '', gender: true });
const active = ref({ name: false, email: false, pwd: false });
const save = () => {
  if (!result.value.name) {
    active.value.name = true;
    return;
  } else {
    active.value.name = false;
  }
  if (!result.value.email) {
    active.value.email = true;
    return;
  } else {
    active.value.email = false;
  }
  if (!result.value.pwd) {
    active.value.pwd = true;
    return;
  } else {
    active.value.pwd = false;
  }

  createUserRequest(result.value).then(createResponse);
}
const createResponse = (responseBody) => {
  if (!responseBody) {
    alert('네트워크 이상');
    return;
  }
  console.log(responseBody);
  const { code } = responseBody;
  if (code !== '200') {
    alert('에러 코드: ' + responseBody.status);
    return;
  }
  alert('성공');
  router.push({ name: 'ListView' });
}
</script>

<style scoped>
.active {
  background-color: blanchedalmond;
}
</style>