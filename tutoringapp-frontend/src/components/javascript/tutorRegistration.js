import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

//Dtos
function TutorDto(firstName, lastName, id, hourlyRate, password) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.id = id;
    this.hourlyRate = hourlyRate;
    this.password = password;
    }

//data variables
export default {
    name: 'tutorRegistration',
    data () {
        return {
            tutors: [],
            newTutor: '',
            errorTutor: '',
            response: []
            }
        },
created: function () {
    // Initializing people from backend
      AXIOS.get(`/tutors`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.tutors = response.data
      })
      .catch(e => {
        this.errorTutor = e;
      });
  }
}
