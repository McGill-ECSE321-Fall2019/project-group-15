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
     <div id="table">
                    <table class="info-table" style="width: 100%; height: 100%;">
                        
                        <tr v-for="(room, i) in rooms" v-bind:key="`room-${i}`">
                            <td style="padding:10px">
                            </td>
                            <td style="padding:10px">{{ room.name }}</td>
                            <td style="padding:10px">{{ room.type }}</td>
                            
                        </tr>
                        <tr>
                            <th style="padding:10px">Room Name</th>
                            <th style="padding:10px">Room Type</th>
                        </tr>
                    </table>
					<h6 align="left" style="padding-top:1.6%">Add room</h6>
                </div>


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

<script src="./javascript/roomRegistration.js">
</script>
