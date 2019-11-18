import axios from 'axios'
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://tutoringapp-15.herokuapp.com/'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function CourseDto(name, description){
	this.name=name
	this.description=description
}

export default {
  name: 'course',
  data () {
    return {
      courses: [],
      errorCourse: '',
      courseName: '',
      courseDescription: '',
		errorMsg: '',
	    newCourse: '',
	    newDescription: ''
    }
  },
  created: function () {
  	  AXIOS.get('/allCourses')
    .then(response => {
      this.courses = response.data;
    })
    .catch(e => {this.errorCourse = e});
},



methods: {
  createCourse: function (courseName, courseDescription) {

    AXIOS.post(`/createCourse/?courseName=` + courseName + `&description=` + courseDescription, {}, {})
          .then(response => {
			// JSON responses are automatically parsed.
			this.courses.push(response.data)
			this.errorCourse= ''
			this.newCourse= ''
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorNewCourse = e.response.data.message
          });
        }
		
  },

  getCourses: function(courseName){
       AXIOS.get(`/allTutors`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.tutors = response.data;
      })
      .catch(e => {
        this.errorTutor = e;
      });
  },
  
}
