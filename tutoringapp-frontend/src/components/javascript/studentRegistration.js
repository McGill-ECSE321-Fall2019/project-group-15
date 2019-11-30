//Dtos
function StudentDto (id, password) {
    this.id = id;
    this.password = password;
    this.person = null;
}

//data variables
export default {
    name: 'studentRegistration',
    data() {
        return {
            students: [],
            newStudent: '',
            errorStudent: '',
            response: [],
            //Static Table
            fields: [],
            items: []

        };
    },

    created: function() {
        //Test data
        const s1 = new StudentDto('42069', 'abcd');
        const s2 = new StudentDto('69420', '1234');
        const s3 = new StudentDto('31','pass');
        //Sample initial content
        this.students = [s1, s2,s3];
    },

    methods: {
        createStudent: function (studentID, studentPassword) {
            // Create a new room and add it to the list of rooms
            var s = new StudentDto(studentID, studentPassword);
            this.students.push(s);
            // Reset the name and roomtype fields for new rooms
            this.newStudent = '';
        }
    }
}