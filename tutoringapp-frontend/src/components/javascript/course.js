// import axios from 'axios'
// var config = require('../../../config')

// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'https://tutoringapp-15.herokuapp.com'

// var AXIOS = axios.create({
//   baseURL: backendUrl,
//   headers: { 'Access-Control-Allow-Origin': frontendUrl }
// })


// function CourseDto(name, description){
// 	this.name=name
// 	this.description=description
// }

// export default {
//   name: 'course',
//   data () {
//     return {
//       courses: [],
//       errorCourse: '',
//       courseName: '',
//       courseDescription: '',
// 	    errorMsg: '',
// 	    newCourse: '',
// 	    newDescription: ''
//     }
//   },
//   created: function () {
//   	  AXIOS.get('/allCourses')
//     .then(response => {
//       this.courses = response.data;
//       this.courses.forEach(course => this.getCourses(course.name))
//     })
//     .catch(e => {this.errorCourse = e});
// },



// methods: {
//   createCourse: function (courseName, courseDescription) {

//     AXIOS.post(`/createCourse/?courseName=` + courseName + `&courseDescription=` + courseDescription, {}, {})
//           .then(response => {
//             // JSON responses are automatically parsed.
//           })
//           .catch(e => {
//             var errorMsg = e.message
//             console.log(errorMsg)
//             this.errorNewCourse = e.response.data.message
//           });
//         }
		
//   },

//   getCourses: function(courseName){
//         AXIOS.get('/allCourses')
//       .then(response => {
//         if (!response.data || response.data.length <= 0) return;

//         let indexPart = this.courses.map(x => x.name).indexOf(courseName);
//         this.courses[indexPart].courseName = [];
//         response.data.forEach(course => {
//           this.courses[indexPart].courseName.push(course);
//         });
//       })
//       .catch(e => {
//         e = e.response.data.message ? e.response.data.message : e;
//         console.log(e);
//       });
//   },
  
// }
