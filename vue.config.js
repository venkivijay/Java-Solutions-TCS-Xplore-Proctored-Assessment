module.exports = {
  css: {
    loaderOptions: {
      sass: {
        prependData: `
            @import "@/assets/_variables.scss";
          `,
      },
    },
  },
  publicPath: "/Java-Solutions-TCS-Xplore-Proctored-Assessment/",
  // devServer: {
  //   https: true,
  // },
};
