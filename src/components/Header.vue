<template>
  <header v-bind:class="{mobile:showNav}">
    <div class="logo">
      <p>TCS Xplore</p>
      <small>Solutions</small>
    </div>
    <button aria-label="menu" @click="handleNav" v-if="mobile">
      <svg
        v-if="!showNav"
        id="Capa_1"
        enable-background="new 0 0 512 512"
        height="512"
        viewBox="0 0 512 512"
        width="512"
        xmlns="http://www.w3.org/2000/svg"
      >
        <g>
          <path
            d="m437.02 74.98c-48.353-48.351-112.64-74.98-181.02-74.98s-132.667 26.629-181.02 74.98c-48.351 48.353-74.98 112.64-74.98 181.02s26.629 132.667 74.98 181.02c48.353 48.351 112.64 74.98 181.02 74.98s132.667-26.629 181.02-74.98c48.351-48.353 74.98-112.64 74.98-181.02s-26.629-132.667-74.98-181.02zm-181.02 407.02c-124.617 0-226-101.383-226-226s101.383-226 226-226 226 101.383 226 226-101.383 226-226 226z"
          />
          <path
            d="m136 211c-24.813 0-45 20.187-45 45s20.187 45 45 45 45-20.187 45-45-20.187-45-45-45zm0 60c-8.271 0-15-6.729-15-15s6.729-15 15-15 15 6.729 15 15-6.729 15-15 15z"
          />
          <path
            d="m376 211c-24.813 0-45 20.187-45 45s20.187 45 45 45 45-20.187 45-45-20.187-45-45-45zm0 60c-8.271 0-15-6.729-15-15s6.729-15 15-15 15 6.729 15 15-6.729 15-15 15z"
          />
          <path
            d="m256 211c-24.813 0-45 20.187-45 45s20.187 45 45 45 45-20.187 45-45-20.187-45-45-45zm0 60c-8.271 0-15-6.729-15-15s6.729-15 15-15 15 6.729 15 15-6.729 15-15 15z"
          />
        </g>
      </svg>
      <svg
        v-else
        version="1.1"
        id="Capa_1"
        xmlns="http://www.w3.org/2000/svg"
        xmlns:xlink="http://www.w3.org/1999/xlink"
        x="0px"
        y="0px"
        viewBox="0 0 512 512"
        style="enable-background:new 0 0 512 512;"
        xml:space="preserve"
      >
        <g>
          <g>
            <path
              d="M436.812,75.188C388.327,26.702,324.113,0,256,0S123.673,26.702,75.188,75.188C26.702,123.673,0,187.887,0,256
			s26.702,132.327,75.188,180.812C123.673,485.298,187.887,512,256,512s132.327-26.702,180.812-75.188
			C485.298,388.327,512,324.113,512,256S485.298,123.673,436.812,75.188z M256,482C131.383,482,30,380.617,30,256S131.383,30,256,30
			s226,101.383,226,226S380.617,482,256,482z"
            />
          </g>
        </g>
        <g>
          <g>
            <path
              d="M404.493,171.147l-63.64-63.639L256,192.36l-84.853-84.853l-63.64,63.64L192.36,256l-84.853,84.853l63.64,63.64
			L256,319.64l84.853,84.853l63.64-63.64L319.64,256L404.493,171.147z M362.066,340.853l-21.213,21.213L256,277.213l-84.853,84.853
			l-21.213-21.213L234.787,256l-84.853-84.853l21.213-21.213L256,234.787l84.853-84.853l21.213,21.213L277.213,256L362.066,340.853z
			"
            />
          </g>
        </g>
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
        <g />
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
