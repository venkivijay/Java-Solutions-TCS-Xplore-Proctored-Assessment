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
        v-for="obj in filteredData"
        :data="obj"
        :rootURL="rootURL"
        :likes="likes"
      />
    </div>
    <div v-else class="notfound">
      <p>OOPS!</p>
      <p>We can't find anything related to your search</p>
      <svg viewBox="0 0 512 512" xmlns="http://www.w3.org/2000/svg">
        <g>
          <path
            d="m437.02 74.98c-48.353-48.351-112.64-74.98-181.02-74.98s-132.667 26.629-181.02 74.98c-48.351 48.353-74.98 112.64-74.98 181.02s26.629 132.667 74.98 181.02c48.353 48.351 112.64 74.98 181.02 74.98s132.667-26.629 181.02-74.98c48.351-48.353 74.98-112.64 74.98-181.02s-26.629-132.667-74.98-181.02zm-21.214 340.826c-42.686 42.686-99.439 66.194-159.806 66.194s-117.12-23.508-159.806-66.194-66.194-99.439-66.194-159.806 23.508-117.12 66.194-159.806 99.439-66.194 159.806-66.194 117.12 23.508 159.806 66.194 66.194 99.439 66.194 159.806-23.508 117.12-66.194 159.806z"
          />
          <path
            d="m256 271.552c-65.876 0-119.471 53.595-119.471 119.471h30c0-49.334 40.137-89.471 89.471-89.471s89.471 40.137 89.471 89.471h30c0-65.877-53.595-119.471-119.471-119.471z"
          />
          <path
            d="m214.773 158.594h-30c0 14.009-11.397 25.406-25.406 25.406s-25.406-11.397-25.406-25.406h-30c0 30.551 24.855 55.406 55.406 55.406s55.406-24.855 55.406-55.406z"
          />
          <path
            d="m352.633 184c-14.009 0-25.406-11.397-25.406-25.406h-30c0 30.551 24.855 55.406 55.406 55.406s55.406-24.855 55.406-55.406h-30c0 14.009-11.397 25.406-25.406 25.406z"
          />
        </g>
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