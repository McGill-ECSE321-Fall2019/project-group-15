//Dtos
function EvaluationDto(id, comment, rating) {
    this.id = id;
    this.comment = comment;
    this.rating = rating;
}

export default {
    name: 'evaluationRegistration',
    data () {
        return {
            evaluations: [],
            newEvaluation: '',
            errorEvaluation: '',
            response: []
        }
    },

    created: function () {
        //Test data
        const e1 = new EvaluationDto(123123, "Best Tutor Ever!!!", 5);
        const e2 = new EvaluationDto(321321, "Worst Tutor Ever!!!", 1);
        //Sample initial content
        this.evaluations = [e1, e2];
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