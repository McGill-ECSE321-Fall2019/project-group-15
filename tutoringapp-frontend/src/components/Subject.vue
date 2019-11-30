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
    <img src="./subject-menu.png" alt="Banner" class="image-tutor">
    <!-- Header -->

    <!-- Search -->
    <!-- Table -->
    <table>
        <tr>
            <td> {{ subjects[0].name }} </td>
            <td> {{ subjects[0].school }} </td>
            <td> {{ subjects[0].description }} </td>
        </tr>
    </table> 

    <!-- Input Table-->
    <table>
        <tr>
            <td>
                <input type="text" v-model="newSubjectName" placeholder="Enter Subject Name">
            </td>
            <td>
                <input type="text" v-model="newSchoolName" placeholder="Enter School Name">
            </td>
             <td>
                <input type="text" v-model="newDescription" placeholder="Enter Description">
            </td>
            <td>
                <button @click="createSubject(newSubjectName, newSchoolName, newDescription)">Create Subject</button>
            </td>
        </tr>
    </table>

        <!-- New Table -->
    <div>
      <b-table  striped hover :items="subjects">
      </b-table>
    </div>

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
.image-tutor {
  width: 50%;
}
.sign-up {
	width: 70%;
	text-align: left;
	margin-left: 50px;
}
</style>

<script src="./javascript/subject.js">
</script>