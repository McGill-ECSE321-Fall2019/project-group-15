//Dtos
function EvaluationDto(id, comment, rating) {
    this.id = id;
    this.comment = comment;
    this.rating = rating;
}
function EvaluationDto(id, comment, rating, studentID, managerID) {
  this.id = id;
  this.comment = comment;
  this.rating = rating;
  this.studentID = studentID;
  this.managerID = managerID;
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
                  comment: "Worst tutor ever!!! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pulvinar ante nec risus maximus, ut eleifend justo suscipit. Phasellus eros nunc, semper ac nisi et, dignissim ultricies mi. Etiam ut odio id tellus blandit lacinia eu ac dolor. Sed sagittis libero eget lectus viverra, non pharetra risus accumsan. Integer vitae ex tortor. Phasellus a urna dui. Donec consequat mollis justo id vestibulum. Proin dictum et lectus ac volutpat. Proin maximus sem ante, non pretium ex accumsan sit amet. Curabitur in turpis leo. Mauris libero leo, pellentesque quis tortor eget, rutrum consequat dolor. Aliquam quis finibus urna. Vivamus vitae vulputate mi.",
                  isFlagged: true,
                  tutorID: 601601601,
                  studentID: 969696
                }
              ]
        }
    },

    created: function () {
        // //Test data
        // const e1 = new EvaluationDto(123123, "Best Tutor Ever!!!", 5);
        // const e2 = new EvaluationDto(321321, "Worst Tutor Ever!!!", 1);
        // //Sample initial content
        // this.evaluations = [e1, e2];

        AXIOS.get(`/allEvaluations/`)
        .then(response => {
          // JSON responses are automatically parsed.
          this.evaluations = response.data;
        })
        .catch(e => {
          this.errorTutor = e;
        });
  

    },

    methods: {
        createEvaluation: function () {
            // Create a new evaluation and add it to the list of evaluations
          var e = new EvaluationDto(evaluationID, evaluationComment, evaluationRating);
          this.evaluations.push(e);
          // Reset the fields for new evaluations
          this.newEvaluation = '';
        }
    }

}