import axios from 'axios'
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://tutoringapp-15.herokuapp.com/'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function SchoolDto(schoolName, schoolType){
	this.schoolName=schoolName;
	this.schoolType=schoolType;
		
}

export default {
  name: 'school',
  data () {
    return {
      schools: [],
      errorSchool: '',
      schoolName: '',
      schoolType: '',
		errorMsg: '',
	    newSchool: '',
		newType: '' ,
		errorSchool: ''
    }
  },
  created: function () {
  	  AXIOS.get('/allSchools/')
    .then(response => {
      this.schools = response.data;
    })
    .catch(e => {this.errorSchool = e});
},



methods: {
  createSchool: function (schoolName, schoolType) {

    AXIOS.post(`/addSchool/?schoolName=` + schoolName + `&schoolType=` + schoolType, {}, {})
          .then(response => {
			// JSON responses are automatically parsed.
			this.schools.push(response.data)
			this.errorSchool= ''
			this.newSchool= ''
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorSchool = e.response.data.message
          });
        }
		
  },

  getCourses: function(){
       AXIOS.get(`/allSchools/`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.schools = response.data;
      })
      .catch(e => {
        this.errorCourse = e;
      });
  },

  deleteCourse: function(schoolName) {
    AXIOS.post(`/deleteCourses`+`?schoolName=`+schoolName)
    .then(response => {
      //JSON responses are automatically parsed.
      this.schools.push(response.data);
      this.newSchool = '';
      this.errorSchool = '';
    })
    .catch(e => {
      var errorMsg = e.message;
      console.log(errorMsg);
      this.errorCourse = errorMsg;
    })
  }
  
}
