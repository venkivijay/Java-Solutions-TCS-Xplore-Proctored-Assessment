module.exports = {
  theme: {
    extend: {
      boxShadow: {
        mermaid: '0px 2px 0px #12F3D8',
      },
      colors: {
        mermaid: '#12F3D8',
        theme: {
          primary: 'var(--primary)',
          secondary: 'var(--secondary)',
          ternary: 'var(--ternary)',
          disabled: 'var(--disabled)',
        },
      },
      transitionProperty: {
        'transform-shadow': 'transform, box-shadow',
      },
    },
  },
  variants: {},
  plugins: [],
  purge: {
    // Learn more on https://tailwindcss.com/docs/controlling-file-size/#removing-unused-css
    enabled: process.env.NODE_ENV === 'production',
    content: [
      'components/**/*.vue',
      'layouts/**/*.vue',
      'pages/**/*.vue',
      'plugins/**/*.js',
      'nuxt.config.js',
    ],
  },
};
