//import PersonDto from '@/components/javascript/personregistration.js'
import axios from 'axios'
import { log } from "util";
var config = require("../../../config")

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port;
var backendUrl = "https://tutoringapp-15.herokuapp.com/";

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})

//Dtos
function TutorDto(id, hourlyRate, password) {
  this.id = id;
  this.hourlyRate = hourlyRate;
  this.isVerified = false;
  this.password = password;
  this.person = null;

  this.status = (this.isVerified ? "Approved" : "Unapproved");
}
function TutorDto(id, hourlyRate, isVerifed, password){
  this.id = id;
  this.hourlyRate = hourlyRate;
  this.isVerified = isVerifed;
  this.password = password;
  this.person = null;

  this.status = (this.isVerified ? "Approved" : "Unapproved");
}
function TutorDto(id, hourlyRate, isVerifed, password, person){
  this.id = id;
  this.hourlyRate = hourlyRate;
  this.isVerified = isVerifed;
  this.password = password;
  this.person = person;

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
      // fields: [
      //   "ID",
      //   { key: "name", label: "Full Name" },
      //   "hourlyRate",
      //   "status",
      //   { key: "delete", label: "Delete" }
      // ],
      // items: [
      //   {
      //     isActive: true,
      //     ID: 160160160,
      //     name: { firstName: "John", lastName: "Doe" },
      //     hourlyRate: 20.0,
      //     isVerifed: true,
      //     status: (this.isVerified ? "Approved" : "Unapproved")
      //   },
      //   {
      //     isActive: true,
      //     ID: 601601601,
      //     name: { firstName: "Jane", lastName: "Doe" },
      //     hourlyRate: 20.5,
      //     isVerified: false,
      //     status: (this.isVerified ? "Approved" : "Unapproved")
      //   }
      // ]


    }
  },

  created: function () {
    // Initializing people from backend
      AXIOS.get(`/allTutors/`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.tutors = response.data;
      })
      .catch(e => {
        this.errorTutor = e;
      });

    // // Test data
    // //const p1 = new PersonDto('John','Doe','JDoe')
    // //const p2 = new PersonDto('Jane','Dough','JDough');

    // const t1 = new TutorDto(69696969, 20.20, true, 'abc');
    // const t2 = new TutorDto(420420420, 20.40, false, '123');

    // //Sample initial content
    // this.tutors = [t1, t2];
  },

  methods: {
    createTutor: function (hourlyRate, password, userName) {
      // // Create a new tutor and add it to the list of tutors
      // var t = new TutorDto(tutorID, tutorHourlyRate, tutorIsVerified, tutorPassword);
      // this.tutors.push(t);
      // // Reset the fields for new tutors
      // this.newTutor = '';

      AXIOS.post(`/createTutor/`+`?hourlyRate=`+hourlyRate+`&password=`+password+`&userName=`+userName, {}, {})
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

    findTutorIndex: function (tutor) {
      return this.tutors.indexOf(tutor);
    },

    removeTutor: function (tutorID) {
      // //Delete a tutor and remove it from the table
      // this.tutors.splice(this.findTutorIndex(tutor), 1);

      AXIOS.post(`/deleteTutor/`+`?tutorId=`+tutorID, {}, {})
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

    approveTutor: function (tutorID) {
      AXIOS.post('/approveTutor/'+tutorID, {}, {})
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

    toggleIsVerified: function (tutor) {
      //Find tutor with id in tutors
      var index = this.findTutorIndex(tutor);
      //Toggle the tutor's isVerified boolean
      this.tutors[index].isVerified = !this.tutors[index].isVerified;
    },

    getAllTutors: function () {
      // //This function gets all tutors
      // const t1 = new TutorDto(69696969, 20.20, true, 'abc');
      // const t2 = new TutorDto(420420420, 20.40, false, '123');
      // this.tutors = [t1, t2];

      AXIOS.get(`/allTutors`)
      .then(response => {
        // JSON responses are automatically parsed.
        this.tutors = response.data;
      })
      .catch(e => {
        this.errorTutor = e;
      });
    },

    getAllUnverifiedTutors: function () {
      //This function gets all unverified tutors
      this.getAllTutors();
      this.tutors = this.tutors.filter(tutor => (tutor.isVerified == false));
    },

    getTutorByID: function (id) {
      //This function gets a list of tutors from a given ID
      this.getAllTutors();
      this.tutors = this.tutors.filter(tutor => (tutor.id == id));
    },

    getTutorByFirstName: function (firstName) {
      //This function gets a list of tutors from a given first name
      this.getAllTutors();
      this.tutors = this.tutors.filter(tutor => tutor.person.firstName == firstName);
    },

    getTutorByLastName: function (lastName) {
      //This function gets a list of tutors from a given last name
      this.getAllTutors();
      this.tutors = this.tutors.filter(tutor => tutor.person.lastName == lastName);
    }

  }

}
