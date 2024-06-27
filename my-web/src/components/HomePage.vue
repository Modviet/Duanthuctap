<!-- eslint-disable  -->
<template>
    <v-container>
        <v-app-bar :elevation="1">
            <v-row class="d-flex align-center just-center pr-6">
                <v-col cols="4">
                    <v-row>
                        <v-img src="https://fullstack.edu.vn/static/media/f8-icon.18cd71cfcfa33566a22b.png" contain max-height="35"
                        max-width="35" class="rounded-lg ml-5">
                        </v-img> 
                        <v-app-bar-title class="ml-3 d-flex align-center text-body-1"><b>Học lập trình</b></v-app-bar-title>
                    </v-row>
                    
                </v-col>
                <v-col cols="4">
                    <v-text-field 
                    v-model="search" 
                    prepend-inner-icon="mdi:mdi-magnify" 
                    density="compact" 
                    label="Tìm kiếm khóa học, bài viết,video,..."
                    variant="underlined" 
                    class="mt-4 mr-2"></v-text-field>
                </v-col>
                <v-col cols="4">
                  <v-row justify="end">
                    <v-btn rounded="lg"@click="goToLoginSignUp" >Đăng nhập</v-btn>
                    <v-btn rounded="lg" class="button-color" @click="goToLoginSignUp">Đăng ký</v-btn>
                  </v-row>
                </v-col>

            </v-row>
        </v-app-bar>

      <v-card>   
          <v-navigation-drawer :width="100" app floating
          permanent>
          <v-list density="compact" nav>
            <v-list-item>   
                  <v-container>
                  <v-row class="d-flex justify-center align-center">
                    <v-icon 
                    density="compact" 
                    rounded="xl" 
                    size="small" 
                    style="background-color: #1473e6; border-radius: 50%; width: 42px; height: 42px; display: flex; justify-content: center; align-items: center;"
                    icon="mdi:mdi-plus"
                    color="white"
                    class="icon-hover-effect"
                    >
                  </v-icon>
                  </v-row>
                  </v-container>
              </v-list-item>
              <v-list-item value="home">
                  <v-container>
                  <v-row class="d-flex justify-center align-center"><v-icon icon="mdi:mdi-home"></v-icon></v-row>
                  <v-row class="d-flex justify-center align-center">
                      <v-list-item-title>Trang Chủ</v-list-item-title></v-row>
                  </v-container>
              </v-list-item>
              <v-list-item value="roads">
                  <v-container>
                  <v-row class="d-flex justify-center align-center"><v-icon icon="mdi:mdi-road"></v-icon></v-row>
                  <v-row class="d-flex justify-center align-center">
                      <v-list-item-title>Lộ trình</v-list-item-title></v-row>
                  </v-container>      
              </v-list-item>
              <v-list-item value="Blogs">
                  <v-container>
                  <v-row class="d-flex justify-center align-center"><v-icon icon="mdi:mdi-newspaper"></v-icon></v-row>
                  <v-row class="d-flex justify-center align-center">
                      <v-list-item-title>Bài viết</v-list-item-title></v-row>
                  </v-container>
              </v-list-item>
             
              <v-list-item value="news" class="under-column">
                  <v-container>
                  <v-row class="d-flex justify-center align-center"><v-icon icon="mdi:mdi-bullhorn"></v-icon></v-row>
                  </v-container>
              </v-list-item>
          </v-list>
          </v-navigation-drawer>
      </v-card>
   
    </v-container>

    <v-container>
      <div>
            <v-carousel 
            cycle :interval="4000"
            show-arrows="hover"
            class="rounded-lg"
            hide-delimiters
            >
                <v-carousel-item
                v-for="(item,i) in img"
                :key="i"
                :src="item.src"
                cover
                ></v-carousel-item>
            </v-carousel>
      </div>

      <div>
        <v-container class="mt-3">
            <v-row class="d-flex align-center">
              <h2>Khóa học Pro</h2>
              <v-chip class="bg-blue mx-2 mb-3" text-color="white">Mới</v-chip>
            </v-row>
          </v-container>
          <v-container>
            <v-row>
              <v-col cols="3" v-for="course in courses1" :key="course.id">
                <v-card class="ma-1" :hover="course.id!==3&&course.id!==4">
                  <v-img
                    width="300px"
                    :src="course.image"
                    rounded="lg"
                    cover
                  ></v-img>
                  <v-card-item>
                    <v-card-title>{{ course.title }}</v-card-title>
                    <v-card-subtitle>
                      <span class="me-1">{{ course.subtitle }}</span>
                      <v-icon
                        color="error"
                        icon="mdi-fire-circle"
                        size="small"
                      ></v-icon>
                    </v-card-subtitle>
                  </v-card-item>
                  <v-card-text>
                    <v-row class="mx-0">
                      <v-rating
                        :model-value="course.rating"
                        color="amber"
                        density="compact"
                        size="small"
                        half-increments
                        readonly
                      ></v-rating>
                      <div class="text-grey ms-4">
                        {{ course.rating }} ({{ course.reviews }})
                      </div>
                    </v-row>
                    <div class="mt-4 text-subtitle-1">
                      <v-icon color="yellow" icon="mdi:mdi-crown"></v-icon>
                      <v-card-text>
                        <span v-if="course.oldPrice" class="old-price">{{ course.oldPrice }}</span>
                        <span class="new-price">{{ course.newPrice }}</span>
                      </v-card-text>
                    </div>
                  </v-card-text>
                  <v-card-actions>
                    <v-btn
                      :color="course.buttonColor"
                      :text="course.buttonText"
                      block
                      @click="reserve"
                      :disabled="course.isDisabled"
                    ></v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
          <!-- Khóa học miễn phí  -->
          <v-container class="mt-3">
            <v-row class="d-flex align-center">
              <h2>Khóa học miễn phí </h2>
            </v-row>
          </v-container>
          <v-container>
            <v-row>
              <v-col cols="3" v-for="course in courses2" :key="course.id">
                <v-card class="ma-1" hover>
                  <v-img
                    width="300px"
                    :src="course.image"
                    rounded="lg"
                    cover
                  ></v-img>
                  <v-card-item>
                    <v-card-title>{{ course.title }}</v-card-title>
                    <v-card-subtitle>
                      <span class="me-1">{{ course.subtitle }}</span>
                      <v-icon
                        color="error"
                        icon="mdi-fire-circle"
                        size="small"
                      ></v-icon>
                    </v-card-subtitle>
                  </v-card-item>
                  <v-card-text>
                    <v-row class="mx-0">
                      <v-rating
                        :model-value="course.rating"
                        color="amber"
                        density="compact"
                        size="small"
                        half-increments
                        readonly
                      ></v-rating>
                      <div class="text-grey ms-4">
                        {{ course.rating }} ({{ course.reviews }})
                      </div>
                    </v-row>
                  </v-card-text>
                  <v-card-actions>
                    <v-btn
                      :color="course.buttonColor"
                      :text="course.buttonText"
                      block
                      @click="reserve"
                      :disabled="course.isDisabled"
                    ></v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
          <!-- Bài viết nổi bật -->
          <v-container class="mt-3">
            <v-row class="d-flex align-center">
              <h2>Bài viết nổi bật</h2>
            </v-row>
          </v-container>
          <v-container>
            <v-row>
              <v-col cols="3" v-for="course in courses3" :key="course.id">
                <v-card class="ma-1" hover>
                  <v-img
                    width="300px"
                    :src="course.image"
                    rounded="lg"
                    cover
                  ></v-img>
                  <v-card-item>
                    <v-card-title>{{ course.title }}</v-card-title>
                    <v-card-subtitle>
                      <span class="me-1">{{ course.subtitle }}</span>
                      <v-icon
                        color="error"
                        icon="mdi-fire-circle"
                        size="small"
                      ></v-icon>
                    </v-card-subtitle>
                  </v-card-item>
                  <v-card-text>
                    <v-row class="mx-0">
                      <div class="text-grey ms-4">
                        <v-icon icon="mdi:mdi-eye"></v-icon> ({{ course.reviews }})
                      </div>
                    </v-row>
                  </v-card-text>
                  <v-card-actions>
                    <v-btn
                      :color="course.buttonColor"
                      :text="course.buttonText"
                      block
                      @click="reserve"
                      :disabled="course.isDisabled"
                    ></v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>

          <!-- Video nổi bật -->
          <v-container class="mt-3">
            <v-row class="d-flex align-center">
              <h2>Videos nổi bật</h2>
            </v-row>
          </v-container>
          <v-container>
            <v-row>
              <v-col cols="3" v-for="course in courses4" :key="course.id">
                <v-card class="ma-1" hover>
                  <v-img
                    width="300px"
                    :src="course.image"
                    rounded="lg"
                    cover
                  ></v-img>
                  <v-card-item>
                    <v-card-title>{{ course.title }}</v-card-title>
                    <v-card-subtitle>
                      <span class="me-1">{{ course.subtitle }}</span>
                      <v-icon
                        color="error"
                        icon="mdi-fire-circle"
                        size="small"
                      ></v-icon>
                    </v-card-subtitle>
                  </v-card-item>
                  <v-card-text>
                    <v-row class="mx-0">
                      <div class="text-grey ms-4">
                        <v-icon icon="mdi:mdi-eye"></v-icon> ({{ course.reviews }})
                      </div>
                    </v-row>
                  </v-card-text>
                  <v-card-actions>
                    <v-btn
                      :color="course.buttonColor"
                      :text="course.buttonText"
                      block
                      @click="reserve"
                      :disabled="course.isDisabled"
                    ></v-btn>
                  </v-card-actions>
                </v-card>
              </v-col>
            </v-row>
          </v-container>
      </div>
    </v-container>
    <!-- footer -->
    <v-footer class="background-footer">
    <v-row justify="center" no-gutters>
      <v-row justify="center" no-gutters >
        <v-btn
        v-for="link in links"
        :key="link"
        class="mx-2"
        color="white"
        rounded="xl"
        variant="text"
      >
        {{ link }}
      </v-btn>
      </v-row>
     
      <v-col cols="12">
        <v-row justify="center" no-gutters>
          <v-btn
          v-for="icon in icons"
          :key="icon"
          :icon="icon"
          class="mx-4"
          variant="text"
        ></v-btn>
        </v-row>
          
      </v-col>

      <v-col class="text-center mt-2" cols="12">
        {{ new Date().getFullYear() }} — <strong>F8</strong>
      </v-col>
    </v-row>
  </v-footer>
    
  </template>  
<script>/* eslint-disable */
    export default{
  data () {
    return {
        isDisabled: true,
        isHovering: false,
        courses1: [
        {
          id: 1,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/15/62f13d2424a47.png",
          title: "HTML CSS Pro",
          subtitle: "Được yêu thích",
          rating: 4.5,
          reviews: 10413,
          oldPrice: "2.500.000đ",
          newPrice: "1.299.000đ",
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 2,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/27/64e184ee5d7a2.png",
          title: "Ngôn ngữ tiền xử lý Sass",
          subtitle: "Được yêu thích",
          rating: 4,
          reviews: 8234,
          oldPrice: "2.500.000đ",
          newPrice: "1.299.000đ",
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 3,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/19/62f13cb607b4b.png",
          title: "JavaScript Pro",
          subtitle: "Được đề cử",
          rating: 0,
          reviews: 0,
          oldPrice: "",
          newPrice: "Coming soon",
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Coming Soon",
          isDisabled: true
        },
        {
          id: 4,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/20/648020fc16597.png",
          title: "NextJS Pro",
          subtitle: "Được đề cử",
          rating: 0,
          reviews: 0,
          oldPrice: "",
          newPrice: "Coming soon",
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Coming soon",
          isDisabled: true
        }
      ],
      courses2: [
        {
          id: 1,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/7.png",
          title: "Kiến thức nhập môn IT",
          subtitle: "Được yêu thích",
          rating: 5,
          reviews: 1413,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 2,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/21/63e1bcbaed1dd.png",
          title: "Lập trình C++ từ cơ bản đến nâng cao",
          subtitle: "Được yêu thích",
          rating: 4.5,
          reviews: 1234,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 3,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/2.png",
          title: "HTML CSS từ Zero đến Hero",
          subtitle: "Được đề cử",
          rating: 4,
          reviews: 14555,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 4,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/3.png",
          title: "Reponsive với Grid",
          subtitle: "Được đề cử",
          rating: 4,
          reviews: 13231,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 5,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/1.png",
          title: "Lập trình JavaScript cơ bản",
          subtitle: "Được đề cử",
          rating: 4.5,
          reviews: 16111,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 6,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/12.png",
          title: "Lập trình JavaScript nâng cao",
          subtitle: "Được đề cử",
          rating: 4,
          reviews: 15133,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 7,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/14/624faac11d109.png",
          title: "Làm việc với Terminal và Ubuntu",
          subtitle: "Được đề cử",
          rating: 4,
          reviews: 8241,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id:8,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/13/13.png",
          title: "Xây dựng website với ReactJS",
          subtitle: "Được đề cử",
          rating: 4,
          reviews: 10131,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 9,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/6.png",
          title: "Node & ExpressJS",
          subtitle: "Được đề cử",
          rating: 4,
          reviews: 11331,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        },
        {
          id: 10,
          image: "https://files.fullstack.edu.vn/f8-prod/courses/4/61a9e9e701506.png",
          title: 'App "Đừng chạm tay lên mặt"',
          subtitle: "Được đề cử",
          rating: 5,
          reviews: 9231,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem khóa học",
          isDisabled: false
        }
      ],
      courses3: [
        {
          id: 1,
          image: "https://files.fullstack.edu.vn/f8-prod/blog_posts/65/6139fe28a9844.png",
          title: "Tổng hợp các sản phẩm của học viên",
          subtitle: "Được yêu thích",
          reviews: 5413,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem bài viết",
          isDisabled: false
        },
        {
          id: 2,
          image: "https://files.fullstack.edu.vn/f8-prod/blog_posts/279/6153f692d366e.jpg",
          title: "[Phần 1] Tạo dự án ReactJS với Webpack và Babel",
          subtitle: "Được yêu thích",
          reviews: 2344,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem bài viết",
          isDisabled: false
        },
        {
          id: 3,
          image: "https://files.fullstack.edu.vn/f8-prod/blog_posts/273/614043e523ad9.png",
          title: "Tổng hợp tài liệu tự học tiếng anh cơ bản.",
          subtitle: "Được đề cử",
          reviews: 3432,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem bài viết",
          isDisabled: false
        },
        {
          id: 4,
          image: "https://i.ytimg.com/vi/sgq7BH6WxL8/maxresdefault.jpg",
          title: "300 bài code thiếu nhi",
          subtitle: "Được đề cử",
          reviews: 6411,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem bài viết",
          isDisabled: false
        }
      ],
      courses4: [
        {
          id: 1,
          image: "https://i.ytimg.com/vi/0SJE9dYdpps/maxresdefault.jpg",
          title: "JavaScript có thể làm được gì",
          subtitle: "Được yêu thích",
          reviews: 745413,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem videos",
          isDisabled: false
        },
        {
          id: 2,
          image: "https://i.ytimg.com/vi/x0fSBAgBrOQ/maxresdefault.jpg",
          title: "ReactJS là gì ? Tại sao nên học ReactJS ?",
          subtitle: "Được yêu thích",
          reviews: 2344,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem videos",
          isDisabled: false
        },
        {
          id: 3,
          image: "https://i.ytimg.com/vi/AzmdwZ6e_aM/maxresdefault.jpg",
          title: "Các thẻ HTML thông dụng",
          subtitle: "Được đề cử",
          reviews: 13215,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem videos",
          isDisabled: false
        },
        {
          id: 4,
          image: "https://i.ytimg.com/vi/oF7isq9IjZM/maxresdefault.jpg",
          title: "Tài liệu tự học NodeJS",
          subtitle: "Được đề cử",
          reviews: 13235,
          buttonColor: "deep-purple-lighten-2",
          buttonText: "Xem videos",
          isDisabled: false
        }
      ],
        items: [
            { title: 'Home', icon: 'mdi-view-dashboard' },
            { title: 'About', icon: 'mdi-forum' },
        ],
        img: [
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/squirrel.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/sky.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/bird.jpg',
          },
          {
            src: 'https://cdn.vuetifyjs.com/images/carousel/planet.jpg',
          },
        ],
        icons: [
        'mdi-facebook',
        'mdi-twitter',
        'mdi-google-plus',
        'mdi-linkedin',
        'mdi-instagram',
      ],
      links: [
        'Home',
        'About Us',
        'Team',
        'Services',
        'Blog',
        'Contact Us',
      ],
      search:''
    }
  },
  methods: {
    goToLoginSignUp() {
      this.$router.push({ name: 'Login' });
    }
  }
}
  </script>
  
  <style scoped>
  .new-price{
    font-size:larger;
    color:red;
  }
  .old-price {
  text-decoration: line-through; 
}
  .relative-card {
  position: relative;
}

  .upper-icon{
    position: absolute;
    top: 8px;
    left: 8px; 
    font-size: 24px; 
    color: yellow ; 
  }
.under-column{
  position:fixed;
  bottom:60px;
  left:22px;
}
.button-color{
    background: linear-gradient(to right bottom, #ff8f26, #ff5117);
    color: white;
}
.background-footer{
  background: linear-gradient(to right bottom, #ff8f26, #ff5117);
}
  </style>  