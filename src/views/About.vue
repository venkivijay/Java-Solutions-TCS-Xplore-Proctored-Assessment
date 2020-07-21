<template>
  <section>
    <div class="wrapper">
      <div class="about">
        <h2>About</h2>
        <p>
          This website is primarily made to ease accessing the files in
          <br />
          <a
            href="https://github.com/venkivijay/Java-Solutions-TCS-Xplore-Proctored-Assessment"
          >Java-Solutions-TCS-Xplore-Proctored-Assessment</a>
          GitHub repo.
          <br />This repo contains solutions to Java Coding questions asked in the TCS Xplore.
        </p>
      </div>

      <div class="support">
        <h2>Support</h2>
        <p>If you found my work useful and got benefited from it, consider buying me a coffee.</p>
        <p class="color">
          <a href="https://paypal.me/venkivijay?locale.x=en_GB">PayPal</a>
        </p>
        <p class="color">UPI ID : venkivijay@upi</p>
        <p>
          <a
            href="https://user-images.githubusercontent.com/30868354/78326173-5385a380-7597-11ea-942a-af28e2343dd4.jpeg"
            target="_blank"
          >
            View UPI QR
            <svg
              fill="#64FFDA"
              style="height:15px;width:15px"
              viewBox="0 0 511.63 511.63"
              xmlns="http://www.w3.org/2000/svg"
            >
              <path
                d="M392.86 292.35h-18.274c-2.669 0-4.859.855-6.563 2.573-1.718 1.708-2.573 3.897-2.573 6.563v91.361c0 12.563-4.47 23.315-13.415 32.262-8.945 8.945-19.701 13.414-32.264 13.414H82.231c-12.562 0-23.317-4.469-32.264-13.414-8.945-8.946-13.417-19.698-13.417-32.262v-237.54c0-12.562 4.471-23.313 13.417-32.259 8.947-8.947 19.702-13.418 32.264-13.418h200.99c2.669 0 4.859-.859 6.57-2.57 1.711-1.713 2.566-3.9 2.566-6.567V82.218c0-2.662-.855-4.853-2.566-6.563-1.711-1.713-3.901-2.568-6.57-2.568H82.231c-22.648 0-42.016 8.042-58.102 24.125C8.049 113.294.007 132.662.007 155.31v237.54c0 22.647 8.042 42.018 24.123 58.095 16.086 16.084 35.454 24.13 58.102 24.13h237.54c22.647 0 42.017-8.046 58.101-24.13C393.958 434.868 402 415.498 402 392.85v-91.358c0-2.669-.856-4.859-2.574-6.57-1.713-1.718-3.903-2.573-6.565-2.573z"
              />
              <path
                d="M506.2 41.971c-3.617-3.617-7.905-5.424-12.85-5.424H347.17c-4.948 0-9.233 1.807-12.847 5.424-3.617 3.615-5.428 7.898-5.428 12.847s1.811 9.233 5.428 12.85l50.247 50.248-186.15 186.15c-1.906 1.903-2.856 4.093-2.856 6.563 0 2.479.953 4.668 2.856 6.571l32.548 32.544c1.903 1.903 4.093 2.852 6.567 2.852s4.665-.948 6.567-2.852l186.15-186.15 50.251 50.248c3.614 3.617 7.898 5.426 12.847 5.426s9.233-1.809 12.851-5.426c3.617-3.616 5.424-7.898 5.424-12.847V54.815c-.001-4.952-1.814-9.232-5.428-12.847z"
              />
            </svg>
          </a>
        </p>
        <p>
          <small>
            Add your name in the remarks/message field to get featured here.
            <br />Or mail me
            <a
              href="mailto:venkivijay@hotmail.com?subject=Supporter&body=Hey Venki, I am supporting you. I have attached the screenshot/reference ID of the payment."
            >venkivijay@hotmail.com</a>
          </small>
        </p>
      </div>
      <div class="contributors">
        <h2>Contributors</h2>
        <a
          :href="generateLink(contributor.name)"
          :key="contributor.name"
          v-for="contributor in contributors"
        >
          <img :src="contributor.avatar" :title="contributor.name" />
        </a>
      </div>
    </div>
  </section>
</template>

<script>
import store from "../store";
export default {
  data: function() {
    return {
      contributors: store.contributors
    };
  },
  methods: {
    generateLink: function(name) {
      return "https://github.com/" + name;
    }
  }
};
</script>

<style lang="scss" scoped>
section {
  width: 80%;
  padding-top: 80px;
  margin: 0 auto;
  height: 90vh;
  .wrapper {
    display: flex;
    flex-direction: column;
    justify-content: space-evenly;
    align-items: center;
    height: 100%;
    p {
      color: white;
      font-family: "Raleway", sans-serif;
      a {
        text-decoration: none;
        color: $primary-color;
      }
    }
    .about,
    .contributors,
    .support {
      text-align: center;
      h2 {
        padding-bottom: 5px;
        color: $primary-color;
        font-family: "Open Sans", sans-serif;
      }
      .color {
        color: $primary-color;
      }
    }
    .contributors {
      a {
        padding: 25px;

        img {
          border-radius: 50%;
          width: 50px;
        }
      }
    }
    .support p {
      padding: 5px 0;
    }
  }
}
</style>
