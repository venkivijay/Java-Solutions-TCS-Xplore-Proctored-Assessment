<template>
  <main id="app">
    <Header />
    <router-view />
  </main>
</template>

<script>
import Header from "./components/Header";
export default {
  name: "Home",
  components: {
    Header
  }
};
</script>

<style lang="scss">
@import url("https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Raleway:wght@400;600;900&display=swap");
* {
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
body {
  background-color: $bg-color;
  overflow-x: hidden;
  overflow-y: overlay;
  &::-webkit-scrollbar {
    width: 5px;
  }
  &::-webkit-scrollbar-track {
    box-shadow: inset 0 0 6px rgba(0, 0, 0, 0.3);
    background-color: $card-bg;
  }

  &::-webkit-scrollbar-thumb {
    background-color: $primary-color;
    outline: 1px solid $secondary-color;
    border-radius: 5px;
  }
}
</style>
