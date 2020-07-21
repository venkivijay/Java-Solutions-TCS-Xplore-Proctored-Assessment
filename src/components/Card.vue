<template>
  <div class="card">
    <p class="title">{{generateName(data.slug)}}</p>
    <div class="links">
      <a :href="generateUrl(true,data.slug)">Question</a>
      <a
        v-for="index in data.solutionCount"
        :key="index"
        :href="generateUrl(false,data.slug,index,data.solutionCount)"
      >Solution{{index==1?'':index}}</a>
    </div>
    <p>Mode: {{data.examMode}}</p>
    <p>Date: {{date}}</p>
    <p>Difficulty: {{data.questionNature}}</p>
    <div class="icons">
      <button aria-label="like" @click="likeThis">
        <svg
          v-if="isliked"
          class="heart heart-filled"
          height="464pt"
          viewBox="0 -20 464 464"
          width="464pt"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="m340 0c-44.773438.00390625-86.066406 24.164062-108 63.199219-21.933594-39.035157-63.226562-63.19531275-108-63.199219-68.480469 0-124 63.519531-124 132 0 172 232 292 232 292s232-120 232-292c0-68.480469-55.519531-132-124-132zm0 0"
            fill="#ff6243"
          />
          <path
            d="m32 132c0-63.359375 47.550781-122.359375 108.894531-130.847656-5.597656-.769532-11.242187-1.15625025-16.894531-1.152344-68.480469 0-124 63.519531-124 132 0 172 232 292 232 292s6-3.113281 16-8.992188c-52.414062-30.824218-216-138.558593-216-283.007812zm0 0"
            fill="#ff5023"
          />
        </svg>
        <svg v-else viewBox="0 -28 512.001 512" xmlns="http://www.w3.org/2000/svg">
          <path
            d="M256 455.516c-7.29 0-14.316-2.641-19.793-7.438-20.684-18.086-40.625-35.082-58.219-50.074l-.09-.078c-51.582-43.957-96.125-81.918-127.117-119.313C16.137 236.81 0 197.172 0 153.871c0-42.07 14.426-80.883 40.617-109.293C67.121 15.832 103.488 0 143.031 0c29.555 0 56.621 9.344 80.446 27.77C235.5 37.07 246.398 48.453 256 61.73c9.605-13.277 20.5-24.66 32.527-33.96C312.352 9.344 339.418 0 368.973 0c39.539 0 75.91 15.832 102.414 44.578C497.578 72.988 512 111.801 512 153.871c0 43.3-16.133 82.938-50.777 124.738-30.993 37.399-75.532 75.356-127.106 119.309-17.625 15.016-37.597 32.039-58.328 50.168a30.046 30.046 0 01-19.789 7.43zM143.031 29.992c-31.066 0-59.605 12.399-80.367 34.914-21.07 22.856-32.676 54.45-32.676 88.965 0 36.418 13.535 68.988 43.883 105.606 29.332 35.394 72.961 72.574 123.477 115.625l.093.078c17.66 15.05 37.68 32.113 58.516 50.332 20.961-18.254 41.012-35.344 58.707-50.418 50.512-43.051 94.137-80.223 123.469-115.617 30.344-36.618 43.879-69.188 43.879-105.606 0-34.516-11.606-66.11-32.676-88.965-20.758-22.515-49.3-34.914-80.363-34.914-22.758 0-43.653 7.235-62.102 21.5-16.441 12.719-27.894 28.797-34.61 40.047-3.452 5.785-9.53 9.238-16.261 9.238s-12.809-3.453-16.262-9.238c-6.71-11.25-18.164-27.328-34.61-40.047-18.448-14.265-39.343-21.5-62.097-21.5zm0 0"
          />
        </svg>
      </button>
      <button aria-label="share" v-if="webShareAPISupported" @click="shareCard">
        <svg
          height="512pt"
          viewBox="-21 0 512 512"
          width="512pt"
          xmlns="http://www.w3.org/2000/svg"
        >
          <path
            d="m389.332031 160c-44.09375 0-80-35.882812-80-80s35.90625-80 80-80c44.097657 0 80 35.882812 80 80s-35.902343 80-80 80zm0-128c-26.453125 0-48 21.523438-48 48s21.546875 48 48 48 48-21.523438 48-48-21.546875-48-48-48zm0 0"
          />
          <path
            d="m389.332031 512c-44.09375 0-80-35.882812-80-80s35.90625-80 80-80c44.097657 0 80 35.882812 80 80s-35.902343 80-80 80zm0-128c-26.453125 0-48 21.523438-48 48s21.546875 48 48 48 48-21.523438 48-48-21.546875-48-48-48zm0 0"
          />
          <path
            d="m80 336c-44.097656 0-80-35.882812-80-80s35.902344-80 80-80 80 35.882812 80 80-35.902344 80-80 80zm0-128c-26.453125 0-48 21.523438-48 48s21.546875 48 48 48 48-21.523438 48-48-21.546875-48-48-48zm0 0"
          />
          <path
            d="m135.703125 240.425781c-5.570313 0-10.988281-2.902343-13.910156-8.0625-4.375-7.679687-1.707031-17.453125 5.972656-21.824219l197.953125-112.855468c7.65625-4.414063 17.449219-1.726563 21.800781 5.976562 4.375 7.679688 1.707031 17.449219-5.972656 21.824219l-197.953125 112.851563c-2.496094 1.40625-5.203125 2.089843-7.890625 2.089843zm0 0"
          />
          <path
            d="m333.632812 416.425781c-2.6875 0-5.398437-.683593-7.894531-2.109375l-197.953125-112.855468c-7.679687-4.371094-10.34375-14.144532-5.972656-21.824219 4.351562-7.699219 14.125-10.367188 21.804688-5.972657l197.949218 112.851563c7.679688 4.375 10.347656 14.144531 5.976563 21.824219-2.945313 5.183594-8.363281 8.085937-13.910157 8.085937zm0 0"
          />
        </svg>
      </button>
    </div>
  </div>
</template>

<script>
export default {
  props: ["data", "rootURL", "likes"],
  methods: {
    generateUrl: function(isQuestionURL, slug, index, count) {
      if (isQuestionURL) {
        return this.rootURL + slug + "/Question.md";
      } else
        return (
          this.rootURL + slug + "/Solution" + (count > 1 ? index : "") + ".java"
        );
    },
    generateName: function(slug) {
      return slug.replace(/_/g, " ");
    },
    shareCard: function() {
      let slug = this.data.slug;
      let url = location.href + "?search=" + slug;
      navigator.share({
        title: "TCS Xplore Java Solutions",
        text:
          "TCS Xplore Java Solutions\nProblem Name: " +
          this.generateName(slug) +
          "\nClick the link 👇 to view question and solutions\n",
        url: url
      });
    },
    likeThis: function() {
      this.$emit("liked", this.data.slug);
    }
  },
  computed: {
    date: function() {
      return new Date(this.data.examDate).toDateString().substring(4, 10);
    },
    webShareAPISupported: function() {
      return navigator.share;
    },
    isliked: function() {
      if (this.likes.includes(this.data.slug)) return true;
      else return false;
    }
  }
};
</script>

<style lang="scss" scoped>
.card {
  padding: 10px;
  border-radius: 6px;
  flex: 0 0 300px;
  background-color: $card-bg;
  box-shadow: rgba(2, 12, 27, 1) 4px 4px 8px 3px;
  margin: 10px;
  display: flex;
  flex-direction: column;
  align-items: center;
  &:hover {
    transform: translateY(-5px);
    transition: all 0.25s ease-out;
    z-index: 1;
  }
  p {
    color: $tertiary;
    padding: 5px 0;
    font-family: "Open-sans", sans-serif;
    font-size: 0.85rem;
  }
  .title {
    color: $primary-color;
    font-family: "Open-sans", sans-serif;
    padding: 10px 0;
    font-weight: 600;
    font-size: 1rem;
  }
  .links {
    margin: 10px 0;
    a {
      text-decoration: none;
      color: $secondary-color;
      background-color: $bg-color;
      padding: 6px;
      margin: 5px;
      border-radius: 5px;
    }
  }
  button {
    background-color: transparent;
    border: 0;
    outline: none;
    padding: 5px 25px;
    cursor: pointer;
    svg {
      width: 25px;
      height: 25px;
      fill: $secondary-color;
    }
  }
}

@media screen and (max-width: 559px) {
  .card:hover {
    transform: none;
    transition: none;
  }
}
</style>