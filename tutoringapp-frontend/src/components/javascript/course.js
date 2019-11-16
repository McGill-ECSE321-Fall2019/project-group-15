import axios from 'axios'
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://tutoringapp-15.herokuapp.com'

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
      errorNewCourse: '',
      courseName: '',
      courseDescription: '',
	  errorMsg: '',
	  newCourse: '',
	  newDescription: ''
    }
  },
  created: function () {
  	this.fetchData()
},



methods: {
  createCourse: function (courseName, courseDescription) {

    AXIOS.post(`/createCourse?courseName=` + courseName + `&courseDescription=` + courseDescription, {}, {})
          .then(response => {
            // JSON responses are automatically parsed.
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorNewCourse = e.response.data.message
          });
        }
		
  },

  viewAllCourses: function(){
        // get the tutor information
        AXIOS.get(`/allCourses/`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.courses = response.data
        })
        .catch((err) => {
	  	console.log(err)
      	this.errorNewCourse = err.response.data.message
    	});
  },
  fetchData() {
        AXIOS.get(backendUrl + '/allCourses/')
        .then((resp) => {
          this.courses = resp.data
          console.log(resp)
        })
        .catch((err) => {
          console.log(err)
          this.errorCourseOffering = err.response.data.message
        })
    }


}
