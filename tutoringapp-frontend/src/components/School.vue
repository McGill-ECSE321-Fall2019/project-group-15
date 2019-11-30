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
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>

    <!-- Tutorial Input Table -->
    <table>
      <tr>
        <td>
          <input type="text" v-model="newSchool" placeholder="School Name" />
        </td>
        <td>
          <input type="text" v-model="newType" placeholder="School Type" />
        </td>
        <td>
          <button @click="addSchool(newSchool,newType)">Create School</button>
        </td>
      </tr>
    </table>

    <br />

    <!-- Bootstrap Table -->
     <!-- Bootstrap Table -->
    <div>
    
      <b-table :items="courses" :fields="['name', 'type', 'delete']">
      <template
        v-slot:cell(name)="data"
      >{{ data.item.courseName }}
      </template>
      <template v-slot:cell(description)="data">
        {{ data.item.description}}
        </template>
        <template v-slot:cell(delete)="data">
          <b-button 
          variant="danger"
          > Delete </b-button>
        </template>



    </b-table>
    
    </div>
  </div>
</template>

<style>
</style>

<script src="./javascript/school.js">
</script>