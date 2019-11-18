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
                    label: "id",
                    sortable: true
                },
                pass: {
                    label: "Password",
                    sortable: true
                },
                firstName: {
                    label: "First Name",
                    sortable: true
                },
            }
        };
    },
    created: function() {
        AXIOS.get(`/allStudents`).then(response =>{this.students = response.data;})
        .then(() => {
            for (var i = 0; i < this.students.length; i++) {
              var student = this.students[i];
        
            }    
          })
          .catch(error => {
            alert(error);
          });    
      },
    
      methods: {
          removeStudent : function(studentId) {
              AXIOS.post(`/deleteStudent`+ "/?studentId=" +studentId, {}, {})
              .then(response => {
                //JSON responses are automatically parsed.
                this.tutors.push(response.data);
                this.newTutor = '';
                this.errorTutor = '';
                
              })
              .catch(e => {
                var errorMsg = e.message;
                console.log(errorMsg);
                this.errorTutor = errorMsg;
              })
          },
          reloadPage(){
            window.location.reload()
          },

          getAllStudents: function(){
            AXIOS.get(`/allStudents/`).then(response =>{this.students = response.data;})
        .then(() => {
            for (var i = 0; i < this.students.length; i++) {
              var student = this.students[i];
        
            }    
          })
          .catch(error => {
            alert(error);
          });    
          },

          getRemovedStudents: function() {
            AXIOS.get(`/removedStudents/`)
            .then(response =>{
              this.students = response.data;
            })
            .catch( error => {
              alert(error)
            })
          },

          getStudentByID: function(studentId) {
            AXIOS.get(`/student/`+`?studentId=`+studentId)
            .then(response =>{
              this.students = [response.data];
            })
            .catch( error => {
              alert(error)
            })
          }



      }
};
