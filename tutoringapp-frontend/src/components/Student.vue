<template>
  <div class="body">
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
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    <h1>Students</h1>

    <!-- Search Input -->
    <label>Search by ID:</label>
    <input type="number" v-model="searchStudentID">
    <b-button
    @click="getStudentByID(searchStudentID)">
      Search
    </b-button>
    <b-button
    @click="getAllStudents()">
      All Students
    </b-button>
     <b-button
    @click="getRemovedStudents()">
      Removed Students
    </b-button>

    <!-- Bootstrap Table -->
    <b-table :items="students" :fields="['id', 'name', 'userName','delete']">
      <template
        v-slot:cell(name)="data"
      >{{ data.item.person.firstName }} {{ data.item.person.lastName }}</template>
      <template v-slot:cell(userName)="data">{{ data.item.person.userName }}</template>

      <template v-slot:cell(delete)="data">
        <b-button @click="removeStudent(data.item.id)" variant="danger">Delete</b-button>
      </template>
    </b-table>

    <!-- Static Table -->
  </div>
</template>

<style>
</style>

<script src="./javascript/singleStudent.js">
</script>

