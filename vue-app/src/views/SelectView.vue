<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 정보</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="name" class="form-label">이름:</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" readonly
          v-model="user.name" />
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" v-model="user.email"
          readonly />
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" v-model="user.pwd"
          readonly />
      </div>
      <div class="d-flex">
        <div class="p-2 flex-fill" v-if="user.gender">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="gender" v-bind:value="true" checked
              v-model="user.gender" />
            <label class="form-check-label" for="radio1">남성</label>
          </div>
        </div>

        <div class="p-2 flex-fill" v-else>
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio2" name="gender" v-bind:value="false" checked
              v-model="user.gender" />
            <label class="form-check-label" for="radio2">여성</label>
          </div>
        </div>
      </div>
    </form>
    <div class="d-flex">
      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="edit">수정</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="del">삭제</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <button type="button" class="btn btn-primary" @click="cancel">취소</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { deleteUserRequest } from '@/apis';
import store from '@/store';
import { useRoute, useRouter } from 'vue-router';
const route = useRoute();
const router = useRouter();
const user = store.state.user;
const edit = () => {
  router.push({name: 'UpdateView'});

}
const del = () => {
  deleteUserRequest(user.id).then(delResponse);
}
const delResponse = (responseBody) => {
  if (!responseBody) {
    alert('네트워크 이상');
    return;
  }
  console.log(responseBody);
  const {code} = responseBody;
  if(code !== '200'){
    alert('요청실패 코드: '+ code);
    return;
  }
  alert('삭제 성공');
  cancel();
}

  const cancel = () => {
    store.commit('setUser', {});
    router.push({ name: 'ListView' });
  }
</script>