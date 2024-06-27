import { createRouter, createWebHashHistory } from "vue-router";
import HomePage from "@/components/HomePage.vue";
import LoginSignUp from "@/components/LoginSignUp";
/* eslint-disable */
const routes = [
  {
    path: "/home",
    name: "home",
    component: HomePage,
  },
    
  {
    path: "/home/login",
    name: "Login",
    component: LoginSignUp,
  },
];

const router = createRouter({
  history: createWebHashHistory(),
  routes,
});

export default router;
