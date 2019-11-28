<template>
  <div class="body">
    <!-- Navbar -->
    <div>
      <b-navbar toggleable="lg" type="dark" variant="dark">
        <b-navbar-brand href="#">
          <img src="./logo.png" alt="Logo" />
        </b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="./#/Dashboard">Dashboard</b-nav-item>
            <b-nav-item href="./#/Tutor">Tutors</b-nav-item>
            <b-nav-item href="./#/Room">Rooms</b-nav-item>
            <b-nav-item href="./#/Course">Courses</b-nav-item>
            <b-nav-item href="./#/Evaluation">Evaluations</b-nav-item>
            <b-nav-item href="./#/Student">Students</b-nav-item>
            <b-nav-item href="./#/Subject">Subjects</b-nav-item>
            <b-nav-item href="./#/Session">Sessions</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <!-- Header -->
    <h1>Manage Rooms</h1>
    <!-- Search -->

    <!-- Table -->
 <!--    <div id="table">
      <table class="info-table" style="width: 100%; height: 100%;">
        <tr v-for="(room, i) in rooms" v-bind:key="`room-${i}`">
          <td style="padding:10px"></td>
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
 -->
    <!-- Input Table-->
    <table>
      <tr>
        <td>
          <input type="text" v-model="newRoomName" placeholder="Enter Room Name" />
        </td>
        <select id="selectMenue">
          <option value="newRoomType">smallRoom</option>
          <option value="['Large','l']">largeRoom</option>
        </select>
        <td>
          <button @click="createRoom(newRoomName, newRoomType)">Create Room</button>
        </td>
      <b-button
    @click="update()"> <center>
      Update Rooms </center>
    </b-button> 
    
      </tr>
    </table>

    <!-- New Table -->
    <div>
      <b-table :items="rooms" :fields="['roomName','roomType','delete']">

        <template v-slot:cell(delete)="data">
        <b-button @click="deleteRoom(data.item.roomName)" variant="danger">Delete</b-button>
      </template>
      </b-table>
    </div>

    <br />
  </div>
</template>

<style>
body {
  font-family: Century Gothic;
}

h1,
h2,
h3 {
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

.dropbtn {
  background-color: #3498db;
  color: white;
  padding: 3px;
  font-size: 16px;
  border: none;
  cursor: pointer;
}

/* Dropdown button on hover & focus */
.dropbtn:hover,
.dropbtn:focus {
  background-color: #2980b9;
}

/* The container <div> - needed to position the dropdown content */
.dropdown {
  position: relative;
  display: inline-block;
}

/* Dropdown Content (Hidden by Default) */
.dropdown-content {
  display: none;
  position: absolute;
  background-color: #f1f1f1;
  min-width: 160px;
  box-shadow: 0px 8px 16px 0px rgba(0, 0, 0, 0.2);
  z-index: 1;
}

/* Links inside the dropdown */
.dropdown-content a {
  color: black;
  padding: 12px 16px;
  text-decoration: none;
  display: block;
}

/* Change color of dropdown links on hover */
.dropdown-content a:hover {
  background-color: #ddd;
}

/* Show the dropdown menu (use JS to add this class to the .dropdown-content container when the user clicks on the dropdown button) */
.show {
  display: block;
}
</style>

<!-- src="./javascript/roomRegistration.js" -->
<script src="./javascript/roomRegistration.js">
</script>
