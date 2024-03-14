<template>
  <div class="container mt-3">
    <h1 class="display-1 text-center">사용자 수정</h1>
    <form>
      <div class="mb-3 mt-3">
        <label for="name" class="form-label">이름:</label>
        <input type="text" class="form-control" id="name" placeholder="이름을 입력하세요." name="name" v-model="user.name" />
      </div>
      <div class="mb-3 mt-3">
        <label for="email" class="form-label">이메일:</label>
        <input type="email" class="form-control" id="email" placeholder="이메일를 입력하세요." name="email" v-model="user.email"/>
      </div>
      <div class="mb-3">
        <label for="pwd" class="form-label">비밀번호:</label>
        <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd" v-model="user.pwd" />
      </div>
      <div class="d-flex">
        <div class="p-2 flex-fill">
          <div class="form-check">
            <input type="radio" class="form-check-input" id="radio1" name="gender" v-bind:value="true" checked
              v-model="user.gender" />
            <label class="form-check-label" for="radio1">남성</label>
          </div>
        </div>

        <div class="p-2 flex-fill">
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
        <button  class="btn btn-primary" @click="save">저장</button>
      </div>
      <div class="p-2 flex-fill d-grid">
        <button class="btn btn-primary" @click="cancel">취소</button>
      </div>
    </div>
  </div>
</template>

<script setup>
import { editUserRequest } from '@/apis';
import store from '@/store';
import { useRouter } from 'vue-router';
const router = useRouter();
const user = store.state.user;
const save = () => {
  editUserRequest(user).then(saveResponse);
}
const saveResponse = (responseBody) => {
  if(!responseBody){
    alert('네트워크 이상');
    return;
  }
  const {code} = responseBody;
  if(code !== '200'){
    alert('오류 코드: ' + code);
    return;
  }
  alert('수정 성공!');
  store.commit('setUser',responseBody.udto);
  cancel();
}
const cancel = () => {
  router.push({name: 'SelectView'});
}
</script>

<style scoped>

</style>