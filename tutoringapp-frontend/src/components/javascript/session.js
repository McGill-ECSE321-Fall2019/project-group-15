import axios from 'axios'
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'https://tutoringapp-15.herokuapp.com/'

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})


function SessionDto(date, startTime, endTime, type, course) {
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;
		this.type = type;
		this.course = course;
		this.managerName= null
}

export default {
  name: 'session',
  data () {
    return {
      sessions: [],
      errorSession: '',
	    newSession: '',
	    response: []
    }
  },
  created: function () {
  	 
},


methods: {
  createSession: function (date, startTime, endTime, type, course, managerName) {

    AXIOS.post(`/createSession/?date=` + date + `&startTime=` + startTime + `&endTime=` + endTime + `&type=` + type + `&course=` + course + `&managerName=` + managerName, {}, {})
          .then(response => {
			// JSON responses are automatically parsed.
			this.sessions.push(response.data)
			this.errorSession= ''
			this.newSession= ''
          })
          .catch(e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorNewCourse = e.response.data.message
          });
        }
		
  }
}





