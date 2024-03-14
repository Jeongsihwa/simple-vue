import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import 'bootstrap'
import 'bootstrap/dist/css/bootstrap.min.css'
import stroe from '@/store'

createApp(App).use(router).use(stroe).mount('#app')
