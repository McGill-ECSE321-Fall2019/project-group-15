// import axios from 'axios'
// var config = require('../../config')

// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

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
//       errorNewCourse: '',
//       courseName: '',
//       courseDescription: '',
//       errorMsg: ''
//     }
//   },
//   created: function () {
//   // Initializing people from backend
//     AXIOS.get(`/allCourses`)
//     .then(response => {
//       // JSON responses are automatically parsed.
//       this.courses = response.data
//     })
//     .catch(e => {
//       this.errorNewCourse = e;
//     });
// },


// methods: {
//   createCourse: function (courseName, courseDescription) {
//     if(newCourse == null || newCourse == ''){
//       this.errorMsg = "Please enter a Course Name"
//       return
//     }
//     AXIOS.post(`/createCourse` + "?courseName=" + courseName + "?courseDescription=" + courseDescription, {}, {})
//                 .then(response => {
//                     // JSON responses are automatically parsed.
//                     this.courseName = ''
//                     this.courseDescription = ''
//                     this.errorNewCourse = ''
                    
                        
//                 })
//                 .catch(e => {
//                     var errorMsg = e.message
//                     console.log(errorMsg)
//                     this.errorNewCourse = errorMsg
//                 })
//         }
		
//   }
// }
