import axios from 'axios'
var config = require('../../config')

var frontendUrl = 'http://' + config.dev.host + ':' + config.dev.port
var backendUrl = 'http://' + config.dev.backendHost + ':' + config.dev.backendPort

var AXIOS = axios.create({
  baseURL: backendUrl,
  headers: { 'Access-Control-Allow-Origin': frontendUrl }
})



function SubjectDto(name, school, description) {
    this.name = name
    this.school = school
    this.description = description
}


export default {
    //name: 'subject'
    data () {
        return {
            subject: [],
            NewSubject: '',
            subjectName: '',
            errorSubject: '',
            errorNewSubject: '',
        }
    },
    created: function () {
        //AXIOS.get(`\getAllSubjects`)
        //.then(response => {
         //   this.subject = subject.data
        //})
        const  s1 = new SubjectDto('Math', 'McGill', 'First Class')
        this.subject = [s1]
    },

    methods: {
        createSubject : function (name, schoolName, description) {

        var p = new SubjectDto(name, schoolName, description)
        this.subject.push(p)
        this.NewSubject = ''
        }
    }
}

