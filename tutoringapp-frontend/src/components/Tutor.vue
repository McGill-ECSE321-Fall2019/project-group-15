<template>
  <div class="tutor">
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
    <h1>Search Tutors</h1>

    <!-- Search  -->
    <b-container fluid>
      <!-- by ID -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input_1">by ID:</label>
        </b-col>
        <b-col sm="3">
          <b-form-input type="number" v-model="input_1" size="sm" placeholder="Enter ID"></b-form-input>
        </b-col>
        <b-col sm="2">
          <b-button 
          id="button-1"
          @click="getTutorByID(input_1)">Search by ID</b-button>
        </b-col>
      </b-row>
      <!-- by first name -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input_2">by first name:</label>
        </b-col>
        <b-col sm="3">
          <b-form-input v-model="input_2" size="sm" placeholder="Enter first name"></b-form-input>
        </b-col>
        <b-col sm="2">
          <b-button 
          id="button-2"
          @click="getTutorByFirstName(input_2)">Search by First Name</b-button>
        </b-col>
      </b-row>
      <!-- by last name -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input_3">by last name:</label>
        </b-col>
        <b-col sm="3">
          <b-form-input v-model="input_3" size="sm" placeholder="Enter last name"></b-form-input>
        </b-col>
        <b-col sm="2">
          <b-button 
          id="button-3"
          @click="getTutorByLastName(input_3)">Search by Last Name</b-button>
        </b-col>
      </b-row>
      <!-- Search all tutors -->
      <b-row>
        <b-col sm="2">
          <b-button 
          id="button-4"
          @click="getAllTutors()"
        >All Tutors</b-button>
        </b-col>
        <b-col sm="2">
          <b-button 
          id="button-5"
          @click="getAllUnverifiedTutors()">All Unverified Tutors</b-button>
        </b-col>
      </b-row>
    </b-container>

    <!-- Tutorial Input Table -->
    <table>
  <tr>
    <td>
        <input type="text" v-model="newTutorID" placeholder="Tutor ID">
    </td>
    <td>
        <input type="text" v-model="newTutorHourlyRate" placeholder="Tutor Hourly Rate">
    </td>
    <td>
        <input type="text" v-model="newTutorPassword" placeholder="Tutor Password">
    </td>
    <td>
       <Label>Verified?:</Label>
      <input type="checkbox" v-model="newTutorisVerified">
    </td>
    <td>
        <button @click="createTutor(newTutorID, newTutorHourlyRate, newTutorisVerified, newTutorPassword)">Create Tutor</button>
    </td>
  </tr>
</table>

    <br />
    
    <!-- Bootstrap Table -->
    <div>
    <b-table :items="tutors" :fields="['id','name','hourlyRate','isVerified', 'status', 'delete']">
      
      <!-- Name Column -->
      <template v-slot:cell(name)="data">
        {{ data.item.person }}
      </template>

      <!-- Status Column -->
      <template v-slot:cell(status)="data">
          <b-form-checkbox
            v-model="data.item.status"
            checked="data.item.isVerified"
            @change="toggleIsVerified(data.item)"
            value="Approved"
            unchecked-value="Unapproved"
          >
            <strong>{{ data.item.status }}</strong>
          </b-form-checkbox>
        </template>

      <!-- Delete Column -->
      <template v-slot:cell(delete)="data">
          <b-button 
          @click="removeTutor(data.item)"
          variant="danger">
          Delete</b-button>
        </template>
      
    </b-table>
    </div>

  </div>
</template>

<style>
</style>

<script src="./javascript/tutorRegistration.js">
</script>