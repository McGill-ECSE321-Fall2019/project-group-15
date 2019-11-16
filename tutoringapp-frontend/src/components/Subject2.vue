<template>

  <div class="subjects">
      
    <!-- Navbar -->
    <div>
      <b-navbar toggleable="lg" type="dark" variant="info">
        <b-navbar-brand href="#">Tutoring S15stem</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#">Home</b-nav-item>
            <b-nav-item href="#about">About</b-nav-item>
            <b-nav-item href="#contact">Contact</b-nav-item>
            <b-nav-item href="#tutor">Tutors</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <!-- Header -->
    <h1>Manage Subjects</h1>
    <!-- Search -->
    <!-- Table -->
    <table>
        <tr>
            <td> {{ subjects[0].name }} </td>
            <td> {{ subjects[0].school }} </td>
            <td> {{ subjects[0].description }} </td>
        </tr>
    </table> 

    <!-- Input Table-->
    <table>
        <tr>
            <td>
                <input type="text" v-model="newSubjectName" placeholder="Enter Subject Name">
            </td>
            <td>
                <input type="text" v-model="newSchoolName" placeholder="Enter School Name">
            </td>
             <td>
                <input type="text" v-model="newDescription" placeholder="Enter Description">
            </td>
            <td>
                <button @click="createSubject(newSubjectName, newSchoolName, newDescription)">Create Subject</button>
            </td>
        </tr>
    </table>

        <!-- New Table -->
    <div>
      <b-table  striped hover :items="subjects">
      </b-table>
    </div>

    <br />

  </div>
  
</template>

<style>
body {
  font-family: Century Gothic;

}

h1, h2, h3 {
  font-weight: normal;
  font-family: Century Gothic;
}

.room {
    width: 100%;
}
.sign-up {
	width: 70%;
	text-align: left;
	margin-left: 50px;
}
</style>

<script src="./javascript/Subject.js">
// export default {
//     name: 'roomRegistration',
//   data() {
//     return {
//         rooms: [],
//         newRoom: '',
//         errorRoom: '',
//         response: []
//     //   fields: [],
//     //   items: []
//     }
//   },

//   created: function () {
//       //Test data
//       const r1 = new RoomDto('TR5090', 'smallRoom');
//       const r2 = new RoomDto('MC10', 'smallRoom');
//       //Sample initial content
//       this.rooms = [r1, r2];
//   },

//   methods: {
//       createRoom: function (roomName, roomType) {
//           // Create a new room and add it to the list of rooms
//           var r = new RoomDto(roomName, roomType);
//           this.rooms.push(r);
//           // Reset the name and roomtype fields for new rooms
//           this.newRoom = '';
//       }
//   }
// };
</script>
