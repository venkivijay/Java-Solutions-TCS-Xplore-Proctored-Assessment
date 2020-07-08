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
            d="m256 455.515625c-7.289062 0-14.316406-2.640625-19.792969-7.4375-20.683593-18.085937-40.625-35.082031-58.21875-50.074219l-.089843-.078125c-51.582032-43.957031-96.125-81.917969-127.117188-119.3125-34.644531-41.804687-50.78125-81.441406-50.78125-124.742187 0-42.070313 14.425781-80.882813 40.617188-109.292969 26.503906-28.746094 62.871093-44.578125 102.414062-44.578125 29.554688 0 56.621094 9.34375 80.445312 27.769531 12.023438 9.300781 22.921876 20.683594 32.523438 33.960938 9.605469-13.277344 20.5-24.660157 32.527344-33.960938 23.824218-18.425781 50.890625-27.769531 80.445312-27.769531 39.539063 0 75.910156 15.832031 102.414063 44.578125 26.191406 28.410156 40.613281 67.222656 40.613281 109.292969 0 43.300781-16.132812 82.9375-50.777344 124.738281-30.992187 37.398437-75.53125 75.355469-127.105468 119.308594-17.625 15.015625-37.597657 32.039062-58.328126 50.167969-5.472656 4.789062-12.503906 7.429687-19.789062 7.429687zm-112.96875-425.523437c-31.066406 0-59.605469 12.398437-80.367188 34.914062-21.070312 22.855469-32.675781 54.449219-32.675781 88.964844 0 36.417968 13.535157 68.988281 43.882813 105.605468 29.332031 35.394532 72.960937 72.574219 123.476562 115.625l.09375.078126c17.660156 15.050781 37.679688 32.113281 58.515625 50.332031 20.960938-18.253907 41.011719-35.34375 58.707031-50.417969 50.511719-43.050781 94.136719-80.222656 123.46875-115.617188 30.34375-36.617187 43.878907-69.1875 43.878907-105.605468 0-34.515625-11.605469-66.109375-32.675781-88.964844-20.757813-22.515625-49.300782-34.914062-80.363282-34.914062-22.757812 0-43.652344 7.234374-62.101562 21.5-16.441406 12.71875-27.894532 28.796874-34.609375 40.046874-3.453125 5.785157-9.53125 9.238282-16.261719 9.238282s-12.808594-3.453125-16.261719-9.238282c-6.710937-11.25-18.164062-27.328124-34.609375-40.046874-18.449218-14.265626-39.34375-21.5-62.097656-21.5zm0 0"
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