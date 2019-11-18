<template>
  <div class="session">
    <!-- Navbar -->
    <div>
      <b-navbar toggleable="lg" type="dark" variant="info">
        <b-navbar-brand href="#">Tutoring S15stem</b-navbar-brand>

        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="./#/Dashboard">Dashboard</b-nav-item>
            <b-nav-item href="./#/Tutor">Tutors</b-nav-item>
            <b-nav-item href="./#/Room">Rooms</b-nav-item>
            <b-nav-item href="./#/Course">Courses</b-nav-item>
            <b-nav-item href="./#/Evaluation">Evaluations</b-nav-item>
            <b-nav-item href="./#/Student">Students</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>

    <!-- Tutorial Input Table -->
    <table>
      <tr>
        <td>
          <input type="text" v-model="newdate" placeholder="Date" />
        </td>
        <td>
          <input type="text" v-model="newStartTime" placeholder="Start time" />
        </td>
		<td>
          <input type="text" v-model="newEndTime" placeholder="End time" />
        </td>
		<td>
          <input type="text" v-model="newType" placeholder="Type" />
        </td>
		<td>
          <input type="text" v-model="newCourse" placeholder="Course" />
        </td>
        <td>
          <button @click="createSession(newdate,newStartTime,newEndTime,newType,newCourse,0)">Create Session</button>
        </td>
      </tr>
    </table>

    <br />

   
     <!-- Bootstrap Table -->
    <div>
    
      <b-table :items="sessions" :fields="['date']">
      



    </b-table>
    
    </div>
  </div>
</template>

<style>
</style>

<script src="./javascript/session.js">
</script>