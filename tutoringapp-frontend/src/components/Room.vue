<template>

  <div class="room">
      
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
    <h1>Manage Rooms</h1>
    <!-- Search -->

    <!-- Table -->
    <table>
        <tr>
            <td> {{ rooms[0].name }} </td>
            <td> {{ rooms[0].type }} </td>
        </tr>
    </table> 

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
</style>

<script src="./javascript/roomRegistration.js">
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
