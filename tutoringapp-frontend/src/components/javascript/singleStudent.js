import axios from "axios";
import { log } from "util";
var config = require("../../../config");

var frontendUrl = "http://" + config.dev.host + ":" + config.dev.port;
var backendUrl = "https://tutoringapp-15.herokuapp.com/";

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { "Access-Control-Allow-Origin": frontendUrl }
});

export default {
    data() {
        return {
            students: [], 
            fields: {
                id: {
                    label: "ID",
                    sortable: true
                },
                pass: {
                    label: "Password",
                    sortable: true
                }
            }
        };
    },
    created: function() {
        AXIOS.get(`/allStudents`).then(response =>{this.students = response.data;})
        .then(() => {
            for (var i = 0; i < this.students.length; i++) {
              var student = this.students[i];
            }    
                
            //this.$refs.table.refresh();
          })
          .catch(error => {
            alert(error);
          });    
      },
    
      methods: {
          createStudent: {
              
          }
      }
};
