<template>
  <div class="body">
    <!-- Navbar -->
    <div>
       <b-navbar toggleable="lg" type="dark" variant="dark">
         <b-navbar-brand href="#">
      <img src="./logo.png" alt="Logo">
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
    <h1>Moderate Evaluations</h1>
    <!-- Search  -->
    <b-container fluid>
      <!-- by Evaluation ID -->
      <b-row class="my-4">
        <b-col sm="2">
          <label for="input-4">by Evaluation ID:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-4" size="sm" placeholder="Enter Evaluation ID"></b-form-input>
        </b-col>
        <b-col>
          <b-button id="button-4" >Search</b-button>
        </b-col>
      </b-row>
      <!-- Search all Evaluations -->
      <b-row class="my-5">
        <b-col>
          <b-button id="button-5">All Evaluations</b-button>
        </b-col>
      </b-row>
    </b-container>

    <br />

    

<!-- Bootstrap Table -->
<b-table :items="evaluations" :fields="['id', 'rating','comment', 'student', 'tutor' , 'flagged', 'action']" >
  <!-- Student Column -->
  <template v-slot:cell(student)="data">
    {{ data.item.student.person.firstName}} {{ data.item.student.person.lastName }}
  </template>
  <!-- Tutor Column -->
   <template v-slot:cell(tutor)="data">
    {{ data.item.tutor.person.firstName}} {{ data.item.tutor.person.lastName }}
  </template>
  <!-- Action Column -->
  <template v-slot:cell(action)="data">
    <b-button v-model="data.item.flagged"
    @click="flagEvaluation(data.item.id)"
    >Flag
    </b-button>

    <b-button 
    variant="danger"
    @click="deleteEvaluation(data.item.id)"
    >Delete
    </b-button>
    </template>
    <!-- Flagged Column -->
  <template v-slot:cell(flagged)="data">
    {{ data.item.flagged ? "Flagged" : "Unflagged" }}
  </template>
  <!-- Comment Column -->
  <template v-slot:cell(comment)="data">
    {{ (data.item.flagged ? "" : data.item.comment) }}
  </template>
 
  
</b-table>


  </div>
</template>

<style scoped>
</style>

<!-- src="./javascript/evaluationRegistration.js" -->

<script src = "./javascript/evaluationRegistration.js">
</script>
