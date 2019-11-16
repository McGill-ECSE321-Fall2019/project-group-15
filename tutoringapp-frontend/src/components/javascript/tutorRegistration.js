import PersonDto from '@/javascript/personregistration.js'
// import axios from 'axios'
// var config = require('../../config')

// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

// var AXIOS = axios.create({
//   baseURL: backendUrl,
//   headers: { 'Access-Control-Allow-Origin': frontendUrl }
// })

//Dtos
function TutorDto(id, hourlyRate, isVerified, password, person) {
    this.id = id;
    this.hourlyRate = hourlyRate;
    this.isVerified = isVerified;
    this.password = password;
    this.person = person;
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
    // // Initializing people from backend
    //   AXIOS.get(`/tutors`)
    //   .then(response => {
    //     // JSON responses are automatically parsed.
    //     this.tutors = response.data
    //   })
    //   .catch(e => {
    //     this.errorTutor = e;
    //   });

    // Test data
    const p1 = new PersonDto('John', 'Doe', 'JDoe');
    const p2 = new PersonDto('Jane', 'Doe', 'JDough');

    const t1 = new TutorDto(160160160, 20.00, true, 'abc', p1);
    const t2 = new TutorDto(601601601, 20.50, false, '123', p2);

    //Sample initial content
    this.tutors = [t1, t2];
  },

  methods: {
    createTutor: function (tutorID, tutorHourlyRate, tutorIsVerified, tutorPassword, tutorPerson) {
      // Create a new tutor and add it to the list of tutors
      var t = new TutorDto(tutorID, tutorHourlyRate, tutorIsVerified, tutorPassword, tutorPerson);
      this.people.push(t);
      // Reset the fields for new tutors
      this.newTutor = '';
    }
  }

}
