<!-- eslint-disable  -->
<template>
    <v-container>
        <v-row align="center" justify="center" >
            <v-col cols="12" sm="10">
              <v-card class="elevation-6 mt-10"  >
               <v-window v-model="step">
                  <v-window-item :value="1">
                    <v-row>
                      <v-col cols="12" md="6">
                        <v-card-text class="mt-12">
                          <h2
                            class="text-center"
                          >Đăng nhập</h2>
                          <v-row align="center" justify="center">
                            <v-col cols="12" sm="8">
                             
                            <v-text-field
                              label="Email"
                              outlined
                              dense
                              color="orange"
                              autocomplete="false"
                             class="mt-16"
                            />
                            <v-text-field
                              label="Password"
                              outlined
                              dense
                              color="orange"
                            autocomplete="false"
                             type="password"
                            
                            />
                              <v-row>
                                <v-col cols="12" sm="8">
                                  <v-checkbox
                                  label="Ghi nhớ"
                                  class="mt-n1"
                                  color="orange"
                                > </v-checkbox>
                                </v-col>
                                <v-col cols="12" sm="4">
                                  <p class="caption text-orange">Quên mật khẩu</p>
                                </v-col>
                              </v-row>
                            <v-btn color="orange" dark block tile @click="goToHome">Đăng nhập</v-btn>
                       
                           <h5
                            class="text-center  text-grey mt-4 mb-3"
                          >Hoặc đăng nhập bằng</h5>
                           <div class="d-flex  justify-space-between align-center mx-10 mb-16">
                          <v-btn depressed outlined color="transparent">
                            <v-icon color="red" icon="mdi: mdi-google"></v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="transparent">
                            <v-icon color="blue" icon="mdi: mdi-facebook"></v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="transparent">
                            <v-icon color="light-blue lighten-3" icon="mdi: mdi-twitter"></v-icon>
                          </v-btn>
                           </div>
                            </v-col>
                          </v-row>  
                        </v-card-text>
                      </v-col>
                      <v-col cols="12" md="6" class="pa-4 bg-orange rounded-bl-lg p-4">
                      <div style="  text-align: center; padding: 180px 0;">
                        <v-card-text class="text-white" >
                          <h3 class="text-center ">Chưa có tài khoản ?</h3>
                        </v-card-text>
                        <div class="text-center">
                          <v-btn tile outlined dark @click="step++">Đăng ký</v-btn>
                        </div>
                        </div>
                      </v-col>
                    </v-row>
                  </v-window-item>
                  <v-window-item :value="2">
                    <v-row >
                      <v-col cols="12" md="6" class="pa-4 bg-orange rounded-br-lg p-4">
                       <div style="  text-align: center; padding: 180px 0;">
                        <v-card-text class="text-white" >
                          <h3 class="text-center ">Đã đăng ký</h3>
                        </v-card-text>
                        <div class="text-center">
                          <v-btn tile outlined dark @click="step--">Đăng nhập</v-btn>
                        </div>
                        </div>
                      </v-col>
  
                      <v-col cols="12" md="6">
                        <v-card-text class="mt-12">
                          <h2
                            class="text-center"
                          >Đăng ký</h2>
                          <v-row align="center" justify="center">
                            <v-col cols="12" sm="8">
                             <v-row>
                             <v-col cols="12" sm="6">
                              <v-text-field
                              :rules="[rules.required,rules.counter]"
                              label="First Name"
                              outlined
                              dense
                              color="orange"
                              autocomplete="false"
                              maxlength="10"
                              counter
                             class="mt-4"
                            />
                             </v-col>
                             <v-col cols="12" sm="6">
                              <v-text-field
                              :rules="[rules.required,rules.counter]"
                              label="Last Name"
                              outlined
                              dense
                              color="orange"
                              autocomplete="false"
                              maxlength="10"
                              counter
                             class="mt-4"
                            />
                             </v-col>
                             </v-row>
                            <v-text-field
                            :rules="[rules.required,rules.email]"
                              label="Email"
                              outlined
                              dense
                              color="orange"
                              autocomplete="false"
                            />
                            <v-text-field
                              :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"  
                              :rules="[rules.required,rules.min]"
                              :type="show1 ? 'text' : 'password'"
                              hint="At least 8 characters"
                              label="Password"
                              outlined
                              dense
                              color="orange"
                              autocomplete="false"
                              type="password"
                              name="input-10-1"
                              counter 
                              @click:append="show1 = !show1"
                            />
                              <v-row>
                                <v-col cols="12" sm="7">
                                  <v-checkbox
                                    label="Đồng ý với các điều khoản"
                                    class="mt-n1"
                                    color="orange"
                                  > </v-checkbox>
                                </v-col>
                                <v-col cols="12" sm="5">
                                  <span class="caption text-orange ml-n4">Điều khoản và điều kiện</span>
                                </v-col>
                              </v-row>
                            <v-btn color="orange" dark block tile @click="goToHome">Đăng ký</v-btn>
                       
                           <h5
                            class="text-center  text-grey mt-4 mb-3"
                          >Hoặc đăng ký bằng</h5>
                           <div class="d-flex  justify-space-between align-center mx-10 mb-11">
                            <v-btn depressed outlined color="transparent">
                            <v-icon color="red" icon="mdi: mdi-google"></v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="transparent">
                            <v-icon color="blue" icon="mdi: mdi-facebook"></v-icon>
                          </v-btn>
                          <v-btn depressed outlined color="transparent">
                            <v-icon color="light-blue lighten-3" icon="mdi: mdi-twitter"></v-icon>
                          </v-btn>
                           </div>
                            </v-col>
                          </v-row>  
                        </v-card-text>
                      </v-col>
                    </v-row>
                  </v-window-item>
                </v-window>
              </v-card>
            </v-col>
        </v-row>
    </v-container>
  </template>  
<script>/* eslint-disable */
  
    export default {
     data: () => ({
      step: 1,
      show1: false,
      show2: true,
      email:'',
      rules: {
        required: value => !!value || 'Không được để trống',
        min: v => v.length >= 8 || 'Mật khẩu cần ít nhất 8 ký tự'
      },
          counter: value => value.length <= 10 || 'Chỉ được 10 ký tự',
          email: value => {
            const pattern = /^(([^<>()[\]\\.,;:\s@"]+(\.[^<>()[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/
            return pattern.test(value) || 'Mật khẩu không hợp lệ.'
          },
    }),
    props: {
      source: String
    },
    methods:{
      goToHome() {
      this.$router.push({ name: 'home' });
    }
    }
  
      
    }
  </script>
  <style scoped>
  .v-application .rounded-bl-lg {
      border-bottom-left-radius: 300px !important;
  }
  .v-application .rounded-br-lg {
      border-bottom-right-radius: 300px !important;
  }
  </style>