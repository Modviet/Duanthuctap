// Styles
import "@mdi/font/css/materialdesignicons.css";
import "@fortawesome/fontawesome-free/css/all.css";
import "vuetify/styles";
import colors from "vuetify/lib/util/colors";

// Vuetify
import { createVuetify } from "vuetify";

export default createVuetify({
  icons: {
    iconfont: "md" || "fa",
  },
  theme: {
    themes: {
      light: {
        background: colors.blue.accent2,
      },
      dark: {
        background: colors.blue,
      },
    },
  },
});
// https://vuetifyjs.com/en/introduction/why-vuetify/#feature-guides
