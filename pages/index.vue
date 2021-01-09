<template>
  <main class="w-full max-w-screen-lg mx-auto">
    <section
      class="sticky top-0 z-10 flex flex-col justify-center pt-3 -mt-3 space-y-2 bg-theme-primary"
    >
      <!-- Search Bar -->
      <div class="relative">
        <input
          v-model="searchTerm"
          aria-label="Search"
          aria-controls="icons"
          type="search"
          :placeholder="`Search`"
          class="w-full py-6 pl-16 border rounded appearance-none bg-theme-primary border-theme-secondary focus:outline-none focus:border-mermaid"
        />
        <div
          class="absolute inset-y-0 left-0 flex items-center justify-center pl-6 pointer-events-none text-mermaid"
          style="margin-left: -2px; margin-top: 2px"
        >
          <svg
            class="w-4 h-4 stroke-current"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 15 15"
          >
            <path d="M14.5 14.5l-4-4m-4 2a6 6 0 110-12 6 6 0 010 12z" />
          </svg>
        </div>
        <div
          class="absolute inset-y-0 left-0 flex items-center justify-center pl-6 pointer-events-none"
        >
          <svg
            class="w-4 h-4 stroke-current"
            fill="none"
            xmlns="http://www.w3.org/2000/svg"
            viewBox="0 0 15 15"
          >
            <path d="M14.5 14.5l-4-4m-4 2a6 6 0 110-12 6 6 0 010 12z" />
          </svg>
        </div>
      </div>
      <!-- Filter and Sort Bar -->
      <div
        v-if="isHomePage"
        class="flex flex-wrap items-center justify-between px-5 py-4 rounded bg-theme-secondary text-theme-primary"
      >
        <div class="flex mr-auto space-x-3">
          <!-- Filter Options -->
          <button
            :class="
              filter === 'All' ? 'text-theme-ternary' : 'text-theme-disabled'
            "
            @click="filter = 'All'"
          >
            All
          </button>
          <button
            :class="
              filter === 'PA' ? 'text-theme-ternary' : 'text-theme-disabled'
            "
            @click="filter = 'PA'"
          >
            PA
          </button>
          <button
            :class="
              filter === 'OPA' ? 'text-theme-ternary' : 'text-theme-disabled'
            "
            @click="filter = 'OPA'"
          >
            OPA
          </button>
          <button
            :class="
              filter === 'Hackathon'
                ? 'text-theme-ternary'
                : 'text-theme-disabled'
            "
            @click="filter = 'Hackathon'"
          >
            Hackathon
          </button>
        </div>
        <!-- Sort Options -->
        <div class="flex ml-auto space-x-3">
          <!-- Name Sort -->
          <button
            class="flex justify-center items-center m-1 font-medium py-1 px-2 rounded-full"
            :class="
              nameSortOrder ? 'text-theme-ternary' : 'text-theme-disabled'
            "
            @click="toggleNameSort"
          >
            <div class="font-normal leading-none max-w-full flex-initial">
              Name
            </div>
            <div class="flex flex-auto pl-1">
              <svg
                v-if="nameSortOrder == 1"
                class="w-4 h-4 fill-current"
                :class="true ? 'text-theme-ternary' : 'text-theme-disabled'"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 48 48"
              >
                <path
                  d="M23.994 2L11.278 14.754l.061 7.693 9.95-9.959V42.44c0 1.972 1.21 3.56 2.714 3.56s2.713-1.59 2.714-3.56V12.39l10.005 10.07-.014-7.693C32.472 10.51 28.223 6.26 23.994 2z"
                  stroke="#000"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <svg
                v-else-if="nameSortOrder == 2"
                class="w-4 h-4 fill-current"
                :class="true ? 'text-theme-ternary' : 'text-theme-disabled'"
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 48 48"
              >
                <path
                  d="M23.994 46L11.278 33.246l.061-7.693 9.95
                9.959V5.56C21.29 3.588 22.5 2 24.003 2s2.713 1.59 2.714
                3.56v30.05l10.005-10.07-.014 7.693C32.472 37.49 28.223 41.74
                23.994 46z"
                  stroke="#000"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <svg
                v-else
                class="w-4 h-4 fill-current"
                :class="
                  nameSortOrder ? 'text-theme-ternary' : 'text-theme-disabled'
                "
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 48 48"
              >
                <g stroke="#000" stroke-linecap="round" stroke-linejoin="round">
                  <path
                    d="M16.261 44.09l-9.535-9.535.046-5.753 7.46 7.445V6.572c0-1.475.908-2.662 2.036-2.662 1.128 0 2.035 1.189 2.036 2.662V36.32l7.507-7.528-.01 5.753-9.541 9.542z"
                  />
                  <path
                    d="M31.739 3.91l9.535 9.535-.046 5.753-7.46-7.445v29.675c0 1.474-.908 2.662-2.036 2.662-1.128 0-2.035-1.189-2.036-2.662V11.68l-7.507 7.528.01-5.754 9.541-9.54z"
                  />
                </g>
              </svg>
            </div>
          </button>
          <!-- Date Sort -->
          <button
            class="flex justify-center items-center m-1 font-medium py-1 px-2 rounded-full"
            :class="
              dateSortOrder ? 'text-theme-ternary' : 'text-theme-disabled'
            "
            @click="toggleDateSort"
          >
            <div class="font-normal leading-none max-w-full flex-initial">
              Date
            </div>
            <div class="flex flex-auto pl-1">
              <svg
                v-if="dateSortOrder == 1"
                class="w-4 h-4 fill-current"
                :class="
                  dateSortOrder ? 'text-theme-ternary' : 'text-theme-disabled'
                "
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 48 48"
              >
                <path
                  d="M23.994 2L11.278 14.754l.061 7.693 9.95-9.959V42.44c0 1.972 1.21 3.56 2.714 3.56s2.713-1.59 2.714-3.56V12.39l10.005 10.07-.014-7.693C32.472 10.51 28.223 6.26 23.994 2z"
                  stroke="#000"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <svg
                v-else-if="dateSortOrder == 2"
                class="w-4 h-4 fill-current"
                :class="
                  dateSortOrder ? 'text-theme-ternary' : 'text-theme-disabled'
                "
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 48 48"
              >
                <path
                  d="M23.994 46L11.278 33.246l.061-7.693 9.95
                9.959V5.56C21.29 3.588 22.5 2 24.003 2s2.713 1.59 2.714
                3.56v30.05l10.005-10.07-.014 7.693C32.472 37.49 28.223 41.74
                23.994 46z"
                  stroke="#000"
                  stroke-linecap="round"
                  stroke-linejoin="round"
                />
              </svg>
              <svg
                v-else
                class="w-4 h-4 fill-current"
                :class="
                  dateSortOrder ? 'text-theme-ternary' : 'text-theme-disabled'
                "
                xmlns="http://www.w3.org/2000/svg"
                viewBox="0 0 48 48"
              >
                <g stroke="#000" stroke-linecap="round" stroke-linejoin="round">
                  <path
                    d="M16.261 44.09l-9.535-9.535.046-5.753 7.46 7.445V6.572c0-1.475.908-2.662 2.036-2.662 1.128 0 2.035 1.189 2.036 2.662V36.32l7.507-7.528-.01 5.753-9.541 9.542z"
                  />
                  <path
                    d="M31.739 3.91l9.535 9.535-.046 5.753-7.46-7.445v29.675c0 1.474-.908 2.662-2.036 2.662-1.128 0-2.035-1.189-2.036-2.662V11.68l-7.507 7.528.01-5.754 9.541-9.54z"
                  />
                </g>
              </svg>
            </div>
          </button>
        </div>
      </div>
    </section>
    <transition-group
      name="shuffle"
      tag="section"
      class="flex flex-wrap justify-center"
      aria-live="polite"
    >
      <Card
        v-for="item in manipulatedQA"
        :key="item.id"
        :item="item"
        class="flex-grow-0 flex-shrink"
        style="flex-basis: 300px"
      />
    </transition-group>
  </main>
</template>

<script>
import Card from '@/components/Card';
import StaticData from '@/mixins/links.mixin';

export default {
  name: 'Index',
  components: { Card },
  mixins: [StaticData],
  data() {
    return {
      searchTerm: this.$route.query.card ? this.$route.query.card : '',
      nameSortOrder: 0,
      dateSortOrder: 0,
      filter: 'All',
      manipulatedQA: [],
    };
  },
  computed: {
    getFilteredQA() {
      const immutableQA = [...this.qa];
      if (this.filter === 'All') {
        return immutableQA;
      } else {
        return immutableQA.filter((item) => {
          return item.examMode === this.filter;
        });
      }
    },
    isHomePage() {
      return this.$route.fullPath === '/';
    },
  },
  watch: {
    filter: [
      {
        handler: 'filterQA',
        immediate: true,
      },
      'resetSortOrder',
    ],
    searchTerm: { handler: 'searchQA' },
    '$route.query.card': {
      handler: 'handleCardEndPoint',
      immediate: true,
    },
  },
  methods: {
    // Keeps the Name sort order among 0(no sort),1(ascend),2(desend)
    toggleNameSort() {
      this.dateSortOrder = 0;
      if (this.nameSortOrder === 0 || this.nameSortOrder === 1) {
        this.nameSortOrder = this.nameSortOrder + 1;
      } else if (this.nameSortOrder === 2) {
        this.nameSortOrder = 0;
      }
      this.sortQA('name', this.nameSortOrder);
    },
    // Keeps the Date sort order among 0(no sort),1(ascend),2(desend)
    toggleDateSort() {
      this.nameSortOrder = 0;
      if (this.dateSortOrder === 0 || this.dateSortOrder === 1) {
        this.dateSortOrder = this.dateSortOrder + 1;
      } else if (this.dateSortOrder === 2) {
        this.dateSortOrder = 0;
      }
      this.sortQA('date', this.dateSortOrder);
    },
    // FilterQA will set the manipulatedQA to the actual qa array if the filter is set to 'All'
    // Else it will set the manipulatedQA to an array that has the exact matched qa's only
    filterQA() {
      if (!this.$route.query.card) {
        const immutableQA = [...this.qa];
        if (this.filter === 'All') {
          this.manipulatedQA = immutableQA;
        } else {
          this.manipulatedQA = immutableQA.filter((item) => {
            return item.examMode === this.filter;
          });
        }
      }
    },
    // sortQA takes in sortBy(ie.,name or date) and order(ie., 0-none,1-ascending,2-descending)
    // sorts manipulatedQA based on the input parameters
    sortQA(
      sortBy = this.nameSortOrder ? 'name' : 'date',
      order = this.nameSortOrder ? this.nameSortOrder : this.dateSortOrder,
    ) {
      if (sortBy === 'name' && this.nameSortOrder !== 0) {
        this.manipulatedQA.sort((a, b) => {
          a = a.slug.toLowerCase().replace(/_/g, '');
          b = b.slug.toLowerCase().replace(/_/g, '');
          return order === 1
            ? a < b
              ? -1
              : a > b
              ? 1
              : 0
            : order === 2
            ? a < b
              ? 1
              : a > b
              ? -1
              : 0
            : '';
        });
      } else if (sortBy === 'date' && this.dateSortOrder !== 0) {
        this.manipulatedQA.sort((a, b) => {
          a = new Date(a.examDate).toISOString();
          b = new Date(b.examDate).toISOString();
          return order === 1
            ? a < b
              ? -1
              : a > b
              ? 1
              : 0
            : order === 2
            ? a < b
              ? 1
              : a > b
              ? -1
              : 0
            : '';
        });
      } else {
        this.filterQA();
      }
    },
    // clears all sort options
    resetSortOrder() {
      if (this.nameSortOrder !== 0 && this.dateSortOrder !== 0) {
        this.nameSortOrder = 0;
        this.dateSortOrder = 0;
      }
    },
    searchQA() {
      // at this stage user haven't touched the search bar
      if (this.searchTerm === this.$route.query.card) {
        this.$search(this.searchTerm, this.qa, {
          keys: ['slug'],
          threshold: 0.0,
        }).then((result) => {
          this.manipulatedQA = result;
        });
      } else {
        // at this stage user must have made change in search box
        // so force route to / and clear the card query to implement normal search
        if (this.$route.fullPath !== '/') {
          this.$router.push({
            path: '/',
          });
          this.$route.query.card = null;
        }
        if (this.searchTerm) {
          this.$search(this.searchTerm, this.getFilteredQA, {
            keys: ['slug', 'questionNature'],
          }).then((results) => {
            this.manipulatedQA = results;
          });
        } else {
          this.filterQA();
          this.sortQA();
        }
      }
    },
    handleCardEndPoint(value) {
      if (value) {
        this.searchQA();
      }
    },
  },
};
</script>

<style lang="postcss">
@keyframes "shake" {
  10%,
  90% {
    transform: translate3d(-1px, 0, 0);
  }
  20%,
  80% {
    transform: translate3d(2px, 0, 0);
  }
  30%,
  50%,
  70% {
    transform: translate3d(-4px, 0, 0);
  }
  40%,
  60% {
    transform: translate3d(4px, 0, 0);
  }
}
input[type='range'] {
  background: transparent;
  -webkit-appearance: none;
  margin: 10px 0;
  width: 100%;
  &::-webkit-slider-runnable-track {
    width: 100%;
    height: 1px;
    cursor: pointer;
    background: var(--primary);
  }
  &::-webkit-slider-thumb {
    height: 18px;
    width: 18px;
    border-radius: 9px;
    background: #01e2c7;
    cursor: pointer;
    -webkit-appearance: none;
    margin-top: -8.5px;
  }
  &::-moz-range-track {
    width: 100%;
    height: 1px;
    cursor: pointer;
    background: var(--primary);
    border-radius: 0;
  }
  &::-moz-range-thumb {
    height: 18px;
    width: 18px;
    border-radius: 9px;
    background: #01e2c7;
    cursor: pointer;
  }
  &::-ms-track {
    width: 100%;
    height: 1px;
    cursor: pointer;
    background: transparent;
    border-color: transparent;
    color: transparent;
  }
  &::-ms-fill-lower {
    background: var(--primary);
  }
  &::-ms-fill-upper {
    background: var(--primary);
  }
  &::-ms-thumb {
    margin-top: 1px;
    height: 18px;
    width: 18px;
    border-radius: 9px;
    background: #01e2c7;
    cursor: pointer;
  }
  &:focus {
    outline: none;
    &::-webkit-slider-runnable-track {
      background: var(--primary);
    }
    &::-ms-fill-lower {
      background: var(--primary);
    }
    &::-ms-fill-upper {
      background: var(--primary);
    }
  }
}
.shuffle-move {
  transition: transform 0.5s;
}
.shuffle {
  transition: all 0.5s;
}
.shuffle-leave-active {
  transition: all 0.5s;
}
.shuffle-enter {
  animation: shake 0.7s cubic-bezier(0.36, 0.07, 0.19, 0.97) both;
  transform: translate3d(0, 0, 0);
  backface-visibility: hidden;
  perspective: 1000px;
}
.shuffle-leave-to {
  animation: shake 0.7s cubic-bezier(0.36, 0.07, 0.19, 0.97) both;
  transform: translate3d(0, 0, 0);
  backface-visibility: hidden;
  perspective: 1000px;
}
</style>
