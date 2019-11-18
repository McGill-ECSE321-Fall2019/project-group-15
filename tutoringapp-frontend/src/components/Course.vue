<template>
  <div class="course">
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
          <input type="text" v-model="newCourse" placeholder="Course Name" />
        </td>
        <td>
          <input type="text" v-model="newDescription" placeholder="Course Description" />
        </td>
        <td>
          <button @click="createCourse(newCourse,newDescription)">Create Course</button>
        </td>
      </tr>
    </table>

    <br />

    <!-- Bootstrap Table -->
    <div>
      <b-table :items="courses" :fields="['courseName', 'description']">
        <template v-slot:cell(name)="data">{{ data.item.name }}</template>
        <template v-slot:cell(description)="data">{{ data.item.description}}</template>
      </b-table>
    </div>
  </div>
</template>

<style>
</style>

<script src="./javascript/course.js">
</script>