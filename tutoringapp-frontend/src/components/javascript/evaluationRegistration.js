import axios from 'axios'
var config = require('../../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = "https://tutoringapp-15.herokuapp.com/";

var AXIOS = axios.create ({
  baseURL: backendUrl,
  headers: {'Access-Control-Allow-Origin': frontendUrl }
})

//Dtos
function EvaluationDto(id, comment, rating) {
    
    this.comment = comment;
    this.rating = rating;
    this.isFlagged = false;
    this.student = null;
    this.tutor = null;
    this.id = id;
    this.type = null;

    this.visibleComment = (this.isFlagged ? '' : comment)

    
}
function EvaluationDto(id, comment, rating, studentID, managerID) {
  this.id = id;
  this.comment = comment;
  this.rating = rating;
  this.studentID = studentID;
  this.managerID = managerID;
  this.isFlagged = false;

  this.visibleComment = (this.isFlagged ? '' : comment)

}

function EvaluationDto(comment, rating, type, isFlagged, student, tutor, id) {
  this.comment = comment;
  this.rating = rating;
  this.type = type;
  this.isFlagged = isFlagged;
  this.student = student;
  this.tutor = tutor;
  this.id = id;

  this.visibleComment = (this.isFlagged ? '' : comment)
}


export default {
    name: 'evaluationRegistration',
    data () {
        return {
            evaluations: [],
            newEvaluation: '',
            errorEvaluation: '',
            response: [],
            //Static Table
            fields: [
                "evaluationID",
                "tutorID",
                "studentID",
                "rating",
                "isFlagged",
                "comment"
                
              ],
              items: [
                {
                  evaluationID: 1231,
                  rating: 4,
                  comment: "Best tutor ever!!!",
                  isFlagged: false,
                  tutorID: 160160160,
                  studentID: 696969
                },
                {
                  evaluationID: 2312,
                  rating: 1,
                  comment: "Worst tutor ever!!! ex tortor. Phasellus a urna dui. Donec consequat mollis justo id vestibulum. Proin dictum et lectus ac volutpat. Proin maximus sem ante, non pretium ex accumsan sit amet. Curabitur in turpis leo. Mauris libero leo, pellentesque quis tortor eget, rutrum consequat dolor. Aliquam quis finibus urna. Vivamus vitae vulputate mi.",
                  isFlagged: true,
                  tutorID: 601601601,
                  studentID: 969696
                }
              ]
        }
    },

    created: function () {

        AXIOS.get(`/allEvaluations/`)
        .then(response => {
          this.evaluations = response.data
        })
        .catch(e => {
          this.errorEvaluation = e;
        });



        // //Test data
        // const e1 = new EvaluationDto(123123, "Best Tutor Ever!!!", 5);
        // const e2 = new EvaluationDto(321321, "Worst Tutor Ever!!!", 1);
        // //Sample initial content
        // this.evaluations = [e1, e2];

  


    },

    methods: {
        createEvaluation: function (comment, rating, type, studentId, managerId) {
          AXIOS.post(`/createEvaluation/`+`?comment`+comment+`&rating=`+rating+`&type=`+type+'&stundentId='+studentId+`&managerId=`+ManagerId, {}, {})
          .then(response => {
            this.evaluations.push(response.data)
            this.newEvaluation = ''
            this.errorEvaluation = ''
          })
          .catch ( e => {
            var errorMsg = e.message
            console.log(errorMsg)
            this.errorEvaluation = errorMsg
          });
          //   // Create a new evaluation and add it to the list of evaluations
          // var e = new EvaluationDto(evaluationID, evaluationComment, evaluationRating);
          // this.evaluations.push(e);
          // // Reset the fields for new evaluations
          // this.newEvaluation = '';
        },
        deleteEvaluation: function (evaluationID) {
          AXIOS.post(`/deleteEvaluation/`+`?ID=`+evaluationID, {}, {})
          .then(response => {
            this.evaluations.push(response.data)
            this.newEvaluation=''
            this.errorEvaluation=''
          })
          .catch(e => {
            var errorMsg = e.message;
            console.log(errorMsg);
            this.errorEvaluation = errorMsg;
          })
        },
        flagEvaluation: function(evaluationID) {
          AXIOS.post(`/flagEvaluation/`+`?ID=`+evaluationID, {}, {})
          .then(response => {
            this.evaluations.push(response.data)
            this.newEvaluation=''
            this.errorEvaluation=''
          })
          .catch(e => {
            var errorMsg = e.message;
            console.log(errorMsg);
            this.errorTutor = errorMsg;
          })
        },
        getAllEvaluations: function () {
          AXIOS.get(`/allEvaluations/`)
          .then(response => {
            this.evaluations = response.data
          })
          .catch(e => {
            this.errorEvaluation = e;
          });

        }
    }

}