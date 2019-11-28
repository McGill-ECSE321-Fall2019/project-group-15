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

    <img src="./tutor-menu.png" alt="Banner" class="image-tutor">

    <!-- Header -->
    <div class="top">
     
    <h2>Search Tutors</h2>

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
          <b-button variant="outline-success"
          @click="getTutorByID(input_1)">Search by ID</b-button>
        </b-col>
      </b-row>
      
      <!-- by first name -->
      <!-- <b-row class="my-1">
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
      </b-row> -->
      <!-- by last name -->
      <!-- <b-row class="my-1">
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
      </b-row> -->
      <!-- Search all tutors -->
      
      <b-row class="rowtwo"> 
        <b-col sm="2">
          <b-button 
          id="button-4"
          @click="getAllTutors()"
        >All Tutors</b-button>
        </b-col>
        <b-col sm="2">
          <b-button 
          id="button-5"
          @click="getAllUnverifiedTutors()" >All Unverified Tutors</b-button>
        </b-col>
        <p>      </p>
        <b-col sm="2">
          <b-button 
          id="button-6"
          @click="getRemovedTutors()">All removed Tutors</b-button>
        </b-col>
        <b-col sm="2">
          <b-button 
          id="button-7"
          @click="update()">Refresh List</b-button>
        </b-col>
      </b-row>
    </b-container>
    <div>
  
</div>
    </div>

    <!-- Tutorial Input Table -->
    <!-- <table>
  <tr>
    <td>
        <input type="number" v-model="newTutorHourlyRate" placeholder="Tutor Hourly Rate">
    </td>
    <td>
        <input type="text" v-model="newTutorPassword" placeholder="Tutor Password">
    </td>
    <td>
        <input type="text" v-model="newTutorUserName" placeholder="Tutor Username">
    </td>
    <td>
        <button @click="createTutor(newTutorHourlyRate, newTutorPassword, newTutorUserName)">Create Tutor</button>
    </td>
  </tr>
</table> -->
<b-button block variant="primary" class="refresh" @click="update()">Refresh List</b-button>
    <br />
    
    <!-- Bootstrap Table -->
    <div>
    <b-table v-model="table_1" :items="tutors" :fields="['id','name','username','hourlyRate', 'status', 'delete']">
      
      <!-- Name Column -->
      <template v-slot:cell(name)="data">
        {{ data.item.person.firstName }} {{ data.item.person.lastName }}
      </template>

      <!-- Username Column -->
      <template v-slot:cell(username)="data">
        {{ data.item.person.userName }}

      </template>

      <!-- Hourly Rate Column -->
      <template v-slot:cell(hourlyRate)="data">
        ${{ data.item.hourlyRate }}/hour
      </template>

      <!-- Status Column -->
      <template v-slot:cell(status)="data">
          {{ data.item.isVerified ? "Approved" : "Unapproved" }}
        </template>

      <!-- Delete Column -->
      <template v-slot:cell(delete)="data">
         <b-button 
          @click="approveTutor(data.item.id)">
          Approve</b-button>
          <b-button 
          @click="removeTutor(data.item.id)"
          variant="danger">
          Delete</b-button>
          
        </template>
      
    </b-table>
    </div>

  </div>
</template>

<style>
.image-tutor {
  width: 50%;
}
.refresh {
  margin-left: 70%;
  margin-right: 3%;
  width: 20%;
}
.rowtwo {
  margin-top: 6%;
  border: 1px;
  border-color: black;
}
.top{
  margin-top: 6%;
  margin-left: 6%;
  display: flex;
}
</style>

<script src="./javascript/tutorRegistration.js">
</script>