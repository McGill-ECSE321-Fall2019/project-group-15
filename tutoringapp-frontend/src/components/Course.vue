<template>

  <div class="course">
      
    <!-- Navbar -->
    <div>
      <b-navbar toggleable="lg" type="dark" variant="info">
        <b-navbar-brand href="#">Tutoring S15stem</b-navbar-brand>


        <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

        <b-collapse id="nav-collapse" is-nav>
          <b-navbar-nav>
            <b-nav-item href="#">Home</b-nav-item>
            <b-nav-item href="#about">About</b-nav-item>
            <b-nav-item href="#contact">Contact</b-nav-item>
            <b-nav-item href="#tutor">Tutors</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <!-- Header -->
    <h1>Manage Courses</h1>
    <!-- Search -->

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="./#/Dashboard">Dashboard</b-nav-item>
            <b-nav-item href="./#/Tutor">Tutors</b-nav-item>
            <b-nav-item href="./#/Room">Rooms</b-nav-item>
            <b-nav-item href="./#/Course">Courses</b-nav-item>
            <b-nav-item href="./#/Evaluation">Evaluations</b-nav-item>
            <b-nav-item href="./#/Student">Students</b-nav-item>
      </b-navbar-nav>



    <!-- Table -->
     <div id="table">
                    <table class="info-table" style="width: 100%; height: 100%;">
                        
                        <tr v-for="(course, i) in courses" v-bind:key="`course-${i}`">
                            <td style="padding:10px">
                            </td>
                            <td style="padding:10px">{{ course.name }}</td>
                            <td style="padding:10px">{{ course.description }}</td>
                            
                        </tr>
                        <tr>
                            <th style="padding:10px">Course Name</th>
                            <th style="padding:10px">Course Description</th>
                        </tr>
                    </table>
					<h6 align="left" style="padding-top:1.6%">Add Course</h6>
                </div>


    <!-- Input Table-->
    <table>
        <tr>
            <td>
                <input type="text" v-model="newCourse" placeholder="Enter Course Name">
            </td>
            <td>
                <input type="text" v-model="newDescription" placeholder="Enter Description">
            </td>
            <td>
                <button @click="createCourse(newCourse, newDescription)">Create Course</button>
            </td>
        </tr>
    </table>
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
.sign-up {
	width: 70%;
	text-align: left;
	margin-left: 50px;
}
</style>

<script src="./javascript/course.js">
</script>
