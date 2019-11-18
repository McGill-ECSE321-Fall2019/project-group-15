<template>
  <div class="evaluation">
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
          <b-button id="button-4">Search</b-button>
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

    <!-- Table -->
    <div>
      <b-table small :fields="fields" :items="items" responsive="sm">
        <!-- Flagged Column -->
        <template v-slot:cell(isFlagged)="data">
          <b-form-checkbox
            v-model="data.item.isFlagged"
            checked="data.item.isFlagged"
            value="true"
            unchecked-value="false"
          >
            <strong>{{ data.item.isFlagged }}</strong>
          </b-form-checkbox>
        </template>
        <!-- Rating -->
        <template v-slot:cell(rating)="data">
            {{ data.item.rating }}/5
        </template>
      </b-table>
    </div>

<!-- Bootstrap Table -->
<b-table :items="evaluations" >
</b-table>


  </div>
</template>

<style scoped>
</style>

<!-- src="./javascript/evaluationRegistration.js" -->

<script src = "./javascript/evaluationRegistration.js">
</script>
