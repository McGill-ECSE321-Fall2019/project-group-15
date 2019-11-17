//import PersonDto from '@/components/javascript/personregistration.js'

// import axios from 'axios'
// var config = require('../../config')

// var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
// var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

// var AXIOS = axios.create({
//   baseURL: backendUrl,
//   headers: { 'Access-Control-Allow-Origin': frontendUrl }
// })

//Dtos
function TutorDto(id, hourlyRate, isVerified, password) {
  this.id = id;
  this.hourlyRate = hourlyRate;
  this.isVerified = isVerified;
  this.password = password;
  this.person = null;

  this.status = (this.isVerified ? "Approved" : "Unapproved");
}

//data variables
export default {
  name: 'tutorRegistration',
  data() {
    return {
      tutors: [],
      newTutor: '',
      errorTutor: '',
      response: [],
      //Static table
      fields: [
        "ID",
        { key: "name", label: "Full Name" },
        "hourlyRate",
        "status",
        { key: "delete", label: "Delete" }
      ],
      items: [
        {
          isActive: true,
          ID: 160160160,
          name: { firstName: "John", lastName: "Doe" },
          hourlyRate: 20.0,
          isVerifed: true,
          status: (this.isVerified ? "Approved" : "Unapproved")
        },
        {
          isActive: true,
          ID: 601601601,
          name: { firstName: "Jane", lastName: "Doe" },
          hourlyRate: 20.5,
          isVerified: false,
          status: (this.isVerified ? "Approved" : "Unapproved")
        }
      ]


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
    //const p1 = new PersonDto('John','Doe','JDoe')
    //const p2 = new PersonDto('Jane','Dough','JDough');

    const t1 = new TutorDto(69696969, 20.20, true, 'abc');
    const t2 = new TutorDto(420420420, 20.40, false, '123');

    //Sample initial content
    this.tutors = [t1, t2];
  },

  methods: {
    createTutor: function (tutorID, tutorHourlyRate, tutorIsVerified, tutorPassword) {
      // Create a new tutor and add it to the list of tutors
      var t = new TutorDto(tutorID, tutorHourlyRate, tutorIsVerified, tutorPassword);
      this.tutors.push(t);
      // Reset the fields for new tutors
      this.newTutor = '';
    },

    removeTutor: function (tutor) {
      //Find tutor with id in tutors
      var index = this.tutors.indexOf(tutor);
      //Delete a tutor and remove it from the table
      this.tutors.splice(index, 1);
    },

    toggleIsVerified: function (tutor) {
      //Find tutor with id in tutors
      var index = this.tutors.indexOf(tutor);
      //Toggle the tutor's isVerified boolean
      this.tutors[index].isVerified = !this.tutors[index].isVerified;
    }
  }

}
