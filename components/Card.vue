<template>
  <div class="mx-3 mt-3 px-6 pt-6 border border-theme-secondary rounded-lg">
    <!-- Section 1 of card (Title) -->
    <div class="text-center relative">
      <p>{{ getTitle(item.slug) }}</p>
    </div>
    <!-- Section 2 of card (Question and Solution Links) -->
    <div class="flex justify-around m-5">
      <div>
        <a
          class="border border-theme-secondary rounded-lg p-1"
          target="_blank"
          rel="noopener noreferrer"
          :href="getQuestion"
        >
          Question
        </a>
      </div>
      <div>
        <a
          class="border border-theme-secondary rounded-lg p-1"
          target="_blank"
          rel="noopener noreferrer"
          :href="getSolution"
        >
          Solution
        </a>
      </div>
    </div>
    <!-- Section 3 of card (Details and Like/Share) -->
    <div class="flex justify-around items-center m-3">
      <!-- Chips -->
      <div class="flex flex-wrap flex-auto">
        <p
          class="border rounded-full m-1 px-2 py-1 text-xs"
          :class="
            theme === 'theme-light'
              ? 'border-theme-secondary'
              : 'border-mermaid'
          "
        >
          {{ item.examMode }}
        </p>
        <p
          class="border rounded-full m-1 px-2 py-1 text-xs"
          :class="
            theme === 'theme-light'
              ? 'border-theme-secondary'
              : 'border-mermaid'
          "
        >
          {{ item.examDate }}
        </p>
        <p
          class="border rounded-full m-1 px-2 py-1 text-xs"
          :class="
            theme === 'theme-light'
              ? 'border-theme-secondary'
              : 'border-mermaid'
          "
        >
          {{ item.questionNature }}
        </p>
      </div>
      <!-- Icons Like and Share/Copy -->
      <div class="leading-none flex">
        <!-- Like Button -->
        <button
          :title="isLiked ? 'Unlike' : 'Like'"
          class="pr-1"
          @click="handleLike(item.slug)"
        >
          <!-- Heart Filled -->
          <svg
            v-if="isLiked"
            xmlns="http://www.w3.org/2000/svg"
            xmlns:xlink="http://www.w3.org/1999/xlink"
            class="w-6 h-6"
            viewBox="0 0 16 16"
          >
            <defs>
              <linearGradient
                id="b"
                xlink:href="#a"
                x1="-137.5"
                y1="1045.239"
                x2="-125.5"
                y2="1045.239"
                gradientUnits="userSpaceOnUse"
                gradientTransform="translate(139.5 -.305)"
              />
              <linearGradient id="a">
                <stop offset="0" stop-color="#fc6a28" />
                <stop offset="1" stop-color="#f94045" />
              </linearGradient>
            </defs>
            <path
              d="M5.816 1039.506c-.977 0-1.953.373-2.702 1.121a3.801 3.801 0 00-.294 5.048c.962 1.19 3.603 3.55 4.696 4.512.266.234.7.233.965 0 1.075-.953 3.653-3.274 4.698-4.51a3.8 3.8 0 00-.292-5.047 3.806 3.806 0 00-4.888-.423 3.797 3.797 0 00-2.183-.699z"
              fill="url(#b)"
              fill-rule="evenodd"
              transform="translate(0 -1036.362)"
            />
          </svg>
          <!-- Heart Outline -->
          <svg
            v-else
            xmlns="http://www.w3.org/2000/svg"
            class="w-6 h-6 fill-current"
            :class="
              theme === 'theme-light' ? 'text-theme-secondary' : 'text-mermaid'
            "
            viewBox="0 0 16 16"
          >
            <path
              d="M4.996 2.004C3.98 1.95 2.961 2.29 2.211 3.04.71 4.544.867 7.068 2.473 8.676l.513.513 4.662 4.666a.5.5 0 00.706 0l4.66-4.666.513-.513c1.606-1.608 1.762-4.132.26-5.635-1.501-1.503-4.02-1.343-5.625.264L8 3.467l-.162-.162C7.035 2.5 6.013 2.058 4.996 2.004zm6.049.994V3c.76-.043 1.497.21 2.037.75 1.08 1.08 1.004 2.951-.26 4.217l-.517.517L8 12.793 3.695 8.484l-.515-.517C1.916 6.7 1.84 4.83 2.92 3.75c.54-.54 1.261-.788 2.023-.748.762.04 1.554.375 2.186 1.008l.52.517a.5.5 0 00.706 0l.516-.52c.632-.632 1.414-.967 2.174-1.009z"
            />
          </svg>
        </button>
        <!-- Share or Copy Card Link Button -->
        <button
          :title="webShareAPISupported ? 'Share this card' : 'Copy card link'"
          @click="handleCardShare"
        >
          <!-- Share Icon -->
          <svg
            v-if="webShareAPISupported"
            xmlns="http://www.w3.org/2000/svg"
            class="w-6 h-6 fill-current"
            :class="
              theme === 'theme-light' ? 'text-theme-secondary' : 'text-mermaid'
            "
            viewBox="0 0 100 100"
          >
            <path
              d="M75 64c-4.8 0-9.1 2.3-11.8 5.8L38.9 55.7c1.5-3.7 1.5-7.8 0-11.5l24.3-14.1c2.7 3.5 7 5.8 11.8 5.8 8.3 0 15-6.7 15-15s-6.7-15-15-15-15 6.7-15 15c0 2 .4 4 1.1 5.7L36.8 40.8C34 37.3 29.8 35 25 35c-8.3 0-15 6.7-15 15s6.7 15 15 15c4.8 0 9.1-2.3 11.8-5.8l24.3 14.1C60.4 75 60 77 60 79c0 8.3 6.7 15 15 15s15-6.7 15-15-6.7-15-15-15zm0-54c6.1 0 11 4.9 11 11s-4.9 11-11 11-11-4.9-11-11 4.9-11 11-11zM25 61c-6.1 0-11-4.9-11-11s4.9-11 11-11 11 4.9 11 11-4.9 11-11 11zm50 29c-6.1 0-11-4.9-11-11s4.9-11 11-11 11 4.9 11 11-4.9 11-11 11z"
            />
            <path
              fill="#00F"
              d="M1644-510v1684H-140V-510h1784m8-8H-148v1700h1800V-518z"
            />
          </svg>
          <!-- Copy Icon -->
          <svg
            v-else
            xmlns="http://www.w3.org/2000/svg"
            class="w-6 h-6 fill-current"
            :class="
              theme === 'theme-light' ? 'text-theme-secondary' : 'text-mermaid'
            "
            viewBox="0 0 16 16"
          >
            <path
              d="M6.999 1a2 2 0 00-2 2v8a2 2 0 002 2H12a2 2 0 002-2V5.5h-.002V4.414a1.5 1.5 0 00-.439-1.06l-1.914-1.915A1.5 1.5 0 0010.585 1H6.998zM12 12H6.999a1 1 0 01-1-1V3a1 1 0 011-1h3v1.5a1.5 1.5 0 001.5 1.5h1.5v1.061H13V11a1 1 0 01-1 1zm.791-8h-1.293a.5.5 0 01-.5-.5V2.207L12.791 4z"
            />
            <path
              d="M3 4a1 1 0 011-1v8a3 3 0 003 3h5a1 1 0 01-1 1H6.79A3.79 3.79 0 013 11.21V4z"
            />
          </svg>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import { mapMutations } from 'vuex';
export default {
  name: 'Card',
  props: {
    item: {
      type: Object,
      required: true,
    },
  },
  data() {
    return {
      rootURL:
        'https://github.com/venkivijay/Java-Solutions-TCS-Xplore-Proctored-Assessment/tree/master/',
    };
  },
  computed: {
    theme() {
      return this.$store.state.theme;
    },
    webShareAPISupported() {
      return navigator.share;
    },
    isLiked() {
      return this.$store.getters.isLiked(this.item.slug);
    },
    getQuestion() {
      return `${this.rootURL}${this.item.slug}/Question.md`;
    },
    getSolution() {
      return `${this.rootURL}${this.item.slug}/Solution.java`;
    },
  },
  methods: {
    ...mapMutations(['handleLike']),
    getTitle(slug) {
      return slug.replace(/_/g, ' ');
    },
    handleCardShare() {
      if (this.webShareAPISupported) {
        // share
        navigator.share({
          title: 'Xplore',
          text:
            'TCS Xplore Java Solution for\nProblem Name: ' +
            this.getTitle(this.item.slug) +
            '\nClick the link 👇 to view question and solutions\n',
          url: `https://xplore.venkivijay.com/?card=${this.item.slug}`,
        });
      } else {
        // copy
        const textarea = document.createElement('textarea');
        textarea.value = `https://xplore.venkivijay.com/?card=${this.item.slug}`;
        document.body.appendChild(textarea);
        const selection = document.getSelection();
        textarea.select();
        document.execCommand('copy');
        selection.removeAllRanges();
        document.body.removeChild(textarea);
        this.$toast.show('Card link copied to clipboard!', {
          position: 'bottom-right',
          duration: 2500,
          type: 'success',
        });
      }
    },
  },
};
</script>
