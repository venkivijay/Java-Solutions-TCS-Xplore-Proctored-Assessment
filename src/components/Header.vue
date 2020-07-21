<template>
  <header v-bind:class="{mobile:showNav}">
    <div class="logo">
      <p>TCS Xplore</p>
      <small>Solutions</small>
    </div>
    <button aria-label="menu" @click="handleNav" v-if="mobile">
      <svg v-if="!showNav" height="512" width="512" xmlns="http://www.w3.org/2000/svg">
        <path
          d="M437.02 74.98C388.667 26.629 324.38 0 256 0S123.333 26.629 74.98 74.98C26.629 123.333 0 187.62 0 256s26.629 132.667 74.98 181.02C123.333 485.371 187.62 512 256 512s132.667-26.629 181.02-74.98C485.371 388.667 512 324.38 512 256s-26.629-132.667-74.98-181.02zM256 482C131.383 482 30 380.617 30 256S131.383 30 256 30s226 101.383 226 226-101.383 226-226 226z"
        />
        <path
          d="M136 211c-24.813 0-45 20.187-45 45s20.187 45 45 45 45-20.187 45-45-20.187-45-45-45zm0 60c-8.271 0-15-6.729-15-15s6.729-15 15-15 15 6.729 15 15-6.729 15-15 15zM376 211c-24.813 0-45 20.187-45 45s20.187 45 45 45 45-20.187 45-45-20.187-45-45-45zm0 60c-8.271 0-15-6.729-15-15s6.729-15 15-15 15 6.729 15 15-6.729 15-15 15zM256 211c-24.813 0-45 20.187-45 45s20.187 45 45 45 45-20.187 45-45-20.187-45-45-45zm0 60c-8.271 0-15-6.729-15-15s6.729-15 15-15 15 6.729 15 15-6.729 15-15 15z"
        />
      </svg>
      <svg v-else xmlns="http://www.w3.org/2000/svg" viewBox="0 0 512 512">
        <path
          d="M436.812 75.188C388.327 26.702 324.113 0 256 0S123.673 26.702 75.188 75.188C26.702 123.673 0 187.887 0 256s26.702 132.327 75.188 180.812C123.673 485.298 187.887 512 256 512s132.327-26.702 180.812-75.188C485.298 388.327 512 324.113 512 256s-26.702-132.327-75.188-180.812zM256 482C131.383 482 30 380.617 30 256S131.383 30 256 30s226 101.383 226 226-101.383 226-226 226z"
        />
        <path
          d="M404.493 171.147l-63.64-63.639L256 192.36l-84.853-84.853-63.64 63.64L192.36 256l-84.853 84.853 63.64 63.64L256 319.64l84.853 84.853 63.64-63.64L319.64 256l84.853-84.853zm-42.427 169.706l-21.213 21.213L256 277.213l-84.853 84.853-21.213-21.213L234.787 256l-84.853-84.853 21.213-21.213L256 234.787l84.853-84.853 21.213 21.213L277.213 256l84.853 84.853z"
        />
      </svg>
    </button>
    <nav class="nav-lg" v-else>
      <!-- <router-link to="/">Home</router-link> -->
      <router-link to="/">Java Questions & Solutions</router-link>
      <router-link to="/about">About</router-link>
    </nav>
    <nav class="nav-sm" v-if="showNav">
      <!-- <router-link @click.native="handleNav" to="/">Home</router-link> -->
      <router-link @click.native="handleNav" to="/">Java Questions & Solutions</router-link>
      <router-link @click.native="handleNav" to="/about">About</router-link>
    </nav>
  </header>
</template>

<script>
export default {
  name: "Header",
  data: function() {
    return {
      mobile: false,
      showNav: false
    };
  },
  methods: {
    handleMobile: function() {
      this.mobile = window.innerWidth < 560;
    },
    handleNav: function() {
      this.showNav = !this.showNav;
    }
    // clearSearch: function() {
    //   this.$route.fullPath = "";
    // }
  },
  created() {
    this.handleMobile();
    window.addEventListener("resize", this.handleMobile);
  }
};
</script>

<style scoped lang="scss">
.mobile {
  height: 174px;
}
header {
  z-index: 2;
  height: 70px;
  background-color: $bg-color;
  display: flex;
  justify-content: space-around;
  align-items: center;
  box-shadow: $box-shadow;
  position: fixed;
  width: 100%;
  flex-wrap: wrap;
  .logo {
    font-size: 1rem;
    font-family: "Raleway", sans-serif;
    color: $primary-color;
    font-weight: 600;
  }
  button {
    background-color: transparent;
    border: 0;
    outline: none;
    padding: 5px 25px;
    cursor: pointer;

    svg {
      &:first-child {
        transform: rotate(90deg);
      }
      width: 30px;
      height: 30px;
      fill: $primary-color;
    }
  }
  .nav-sm {
    display: flex;
    flex-direction: column;
    flex: 0 0 100%;
    align-items: center;
    justify-content: center;
    a {
      padding: 10px 0;
      width: 100%;
      text-align: center;
      &:hover {
        background-color: $primary-color;
        color: $bg-color;
      }
    }
  }
}
.nav-lg,
.nav-sm {
  a {
    padding: 0 15px;
    text-decoration: none;
    color: $primary-color;
    font-family: "Raleway", sans-serif;
    font-weight: 600;
  }
}
.router-link-exact-active {
  background-color: $primary-color;
  color: $bg-color !important;
  border-radius: 10px;
}
</style>
