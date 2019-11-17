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

    <!-- Input Table-->
    <table>
        <tr>
            <td>
                <input type="text" v-model="newRoomName" placeholder="Enter Room Name">
            </td>
            <td>
                <input type="text" v-model="newRoomType" placeholder="Enter Room Type">
            </td>
            <td>
                <button @click="createRoom(newRoomName, newRoomType)">Create Room</button>
            </td>
        </tr>
    </table>

        <!-- New Table -->
    <div>
      <b-table striped hover :items="rooms">
        

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

<!-- src="./javascript/roomRegistration.js" -->
<script src="./javascript/roomRegistration.js">

</script>
