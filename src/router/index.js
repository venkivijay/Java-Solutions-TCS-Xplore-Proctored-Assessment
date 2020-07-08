import Vue from "vue";
import VueRouter from "vue-router";
import About from "../views/About.vue";
import Links from "../views/Links.vue";
import NotFound from "../views/NotFound.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    component: Links,
  },
  {
    path: "/index",
    component: Links,
  },
  {
    path: "/index.html",
    component: Links,
  },
  {
    path: "/?search=:id",
    component: Links,
  },
  {
    path: "/about",
    component: About,
  },
  {
    path: "*",
    component: NotFound,
  },
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes,
});

export default router;
