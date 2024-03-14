import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'

const routes = [
  {
    path: '/', // HomeView로 이동할 path
    name: 'home', // router name, 컴포넌트 이름과는 독립적
    component: HomeView // path로 이동될 Component
  },
  {
    path: '/user', // ListView로 이동할 path
    name: 'ListView', // router name
    component: () => import(/* webpackChunkName: "user" */ '../views/ListView.vue') // path로 이동될 Component
  },{
    path: '/user/findById', // /:id 필수 
    name: 'SelectView',
    component: () => import(/* webpackChunkName: "user" */ '../views/SelectView.vue')
  },
  {
    path: '/user/editById',
    name: 'UpdateView',
    component: () => import(/* webpackChunkName: "user" */ '../views/UpdateView.vue')
  },
  {
    path: '/user/save',
    name: 'CreateView',
    component: () => import(/* webpackChunkName: "user" */ '../views/CreateView.vue')
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})

export default router


