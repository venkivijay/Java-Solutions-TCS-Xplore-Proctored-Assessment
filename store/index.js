export const state = () => ({
  theme: 'theme-light',
  likes: [],
});

export const getters = {
  isLiked: (state) => (item) => {
    if (state.likes.includes(item)) {
      return true;
    } else return false;
  },
};

export const mutations = {
  // populate store values with localstorage
  initializeStore(state) {
    if (process.server) {
      return;
    }
    if (localStorage.getItem('state')) {
      try {
        // if localstorage is available and healthy
        this.replaceState(
          Object.assign(state, JSON.parse(localStorage.getItem('state'))),
        );
      } catch (e) {
        // if localstorage is unhealthy
        localStorage.removeItem('state');
        this.replaceState(
          Object.assign(state, { theme: 'theme-light', likes: [] }),
        );
      }
    }
  },
  toggleTheme(state) {
    state.theme === 'theme-light'
      ? (state.theme = 'theme-dark')
      : (state.theme = 'theme-light');
  },
  handleLike(state, item) {
    // unlike if already exists in likes array
    if (state.likes.includes(item)) {
      state.likes.splice(state.likes.indexOf(item), 1);
    }
    // like if it isn't in likes array
    else {
      state.likes.push(item);
    }
  },
};

// subscribe to store mutations and update localstorage
const subscribe = (store) => {
  store.subscribe((mutation, state) => {
    localStorage.setItem('state', JSON.stringify(state));
  });
};

export const plugins = [subscribe];
