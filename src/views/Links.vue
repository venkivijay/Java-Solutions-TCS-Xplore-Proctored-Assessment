<template>
  <section>
    <div class="search-wrapper">
      <label for="search">Search</label>
      <input
        type="text"
        id="search"
        v-bind:value="searchString"
        v-on:input="searchString=$event.target.value"
      />

      <br />
      <label for="select">Choose View</label>
      <select type="dropdown" v-model="selectedView" id="select">
        <option value="All" selected>Show All</option>
        <!-- <option value="Liked" selected>Show only liked</option> -->
        <option value="PA">Show only PA</option>
        <option value="OPA">Show only OPA</option>
        <option value="Hackathon">Show only Hackathon</option>
      </select>
    </div>
    <div v-if="filteredData.length" class="wrapper">
      <Card
        ref="cardData"
        @liked="addToLikesList"
        v-bind:key="obj.id"
        v-for="obj in filteredData.slice().reverse()"
        :data="obj"
        :rootURL="rootURL"
        :likes="likes"
      />
    </div>
    <div v-else class="notfound">
      <p>OOPS!</p>
      <p>We can't find anything related to your search</p>
      <svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
        <path
          d="M437.02 74.98C388.67 26.63 324.38 0 256 0S123.33 26.63 74.98 74.98C26.63 123.33 0 187.62 0 256s26.63 132.67 74.98 181.02C123.33 485.37 187.62 512 256 512s132.67-26.63 181.02-74.98C485.37 388.67 512 324.38 512 256s-26.63-132.67-74.98-181.02zm-21.21 340.83C373.12 458.49 316.37 482 256 482s-117.12-23.5-159.8-66.2S30 316.38 30 256 53.5 138.88 96.2 96.2 195.62 30 256 30s117.12 23.5 159.8 66.2S482 195.62 482 256s-23.5 117.12-66.2 159.8z"
        />
        <path
          d="M256 271.55c-65.88 0-119.47 53.6-119.47 119.47h30c0-49.33 40.14-89.47 89.47-89.47s89.47 40.14 89.47 89.47h30c0-65.87-53.6-119.47-119.47-119.47zM214.77 158.6h-30c0 14-11.4 25.4-25.4 25.4s-25.4-11.4-25.4-25.4h-30c0 30.54 24.85 55.4 55.4 55.4s55.4-24.86 55.4-55.4zM352.63 184c-14 0-25.4-11.4-25.4-25.4h-30c0 30.54 24.85 55.4 55.4 55.4s55.4-24.86 55.4-55.4h-30c0 14-11.39 25.4-25.4 25.4z"
        />
      </svg>
    </div>
  </section>
</template>

<script>
import store from "../store";
import Card from "../components/Card";
export default {
  name: "Links",
  components: { Card },
  data() {
    return {
      likes: [],
      selectedView: "All",
      searchString: this.$route.query.search ? this.$route.query.search : "",
      isSearchMode: false,
      data: store.data,
      rootURL: store.rootURL
    };
  },
  computed: {
    filteredData: function() {
      if (this.selectedView == "All") {
        return this.data.filter(item => {
          return item.slug
            .toLowerCase()
            .replace(/_/g, " ")
            .match(this.searchString.toLowerCase().replace(/_/g, " "));
        });
      } else {
        return this.data.filter(item => {
          return (
            item.examMode == this.selectedView &&
            item.slug
              .toLowerCase()
              .replace(/_/g, " ")
              .match(this.searchString.toLowerCase().replace(/_/g, " "))
          );
        });
      }
    }
  },
  mounted() {
    if (localStorage.getItem("likes")) {
      try {
        this.likes = JSON.parse(localStorage.likes);
      } catch (e) {
        //data corrupt
        localStorage.removeItem("likes");
      }
    }
  },
  methods: {
    addToLikesList: function(clickedItem) {
      if (this.likes.includes(clickedItem)) {
        let index = this.likes.indexOf(clickedItem);
        this.likes.splice(index, 1);
        localStorage.setItem("likes", JSON.stringify(this.likes));
      } else {
        this.likes.push(clickedItem);
        localStorage.setItem("likes", JSON.stringify(this.likes));
      }
    },
    clearSearch: function(newVal) {
      console.log(newVal);
      this.searchString = this.$route.query.search
        ? this.$route.query.search
        : "";
    }
  },
  watch: {
    "$route.query.search"() {
      this.clearSearch();
    }
  }
};
</script>

<style lang="scss" scoped>
section {
  padding-top: 80px;
  .search-wrapper {
    display: flex;
    align-items: center;
    flex-direction: column;
    input {
      width: 50%;
      padding: 10px;
      padding-left: 35px;
      font-size: 1rem;
      background: url("../assets/search.svg") no-repeat;
      background-position: 3px;
      background-size: 25px;
      background-color: #fff;
      border-radius: 15px;
      outline: none;
      border: none;
      &:focus {
        box-shadow: 0px 0px 8px 0px $tertiary;
        border: none;
      }
    }
    label {
      display: none;
    }
    select {
      text-align: center;
      text-align-last: center;
      padding: 3px;
      border-radius: 15px;
      outline: none;
      border: none;
      &:focus {
        box-shadow: 0px 0px 8px 0px $tertiary;
        border: none;
      }
    }
  }
  .wrapper {
    width: 90%;
    margin: 0 auto;
    display: flex;
    flex-wrap: wrap;
    justify-content: center;
  }
  .notfound {
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: space-around;
    p {
      padding: 10px 0;
      text-align: center;
      font-size: 1rem;
      color: $secondary-color;
      font-family: "Raleway", sans-serif;
    }
    svg {
      max-width: 200px;
      fill: $primary-color;
    }
  }
}
</style>