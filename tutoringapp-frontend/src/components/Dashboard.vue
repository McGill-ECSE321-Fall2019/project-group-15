<template>
    <span class="container">
         <b-navbar toggleable="lg" type="dark" variant="info">
             <b-navbar-brand href="#">My Dashboard</b-navbar-brand>
            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

                <b-collapse id="nav-collapse" is-nav>
                    <b-navbar-nav>
                        <b-nav-item href="#myProfile">My Profile</b-nav-item>
                        <b-nav-item href="./" >Logout</b-nav-item>
                       
                    </b-navbar-nav>
                </b-collapse>
            </b-navbar>
            <table  align="left">
                <tr>
                <td>
                <p class="loggedIn">Currently logged in as {{username}}</p>
                </td>
                </tr>
	        </table>
            
            <p> <br/> <br/> </p>

    <section class="tutors" id="tutors">
        <a href="./#/Tutor">
        <img src="./tutor-button.png" alt="Tutor Button">
        </a>
        <h3>Manage the tutors here</h3>
        <p></p>
    </section>
        
     <section class="rooms" id="rooms">
        <a href="./#/Room">
        <img src="./rooms-button.png" alt="Tutor Button">
        </a>
        <h3>Manage the rooms here</h3>
        <p></p>
    </section>
        
    <section class="courses" id="courses">
        <a href="./#/Course">
        <img src="./courses-button.png" alt="Tutor Button">
        </a>
        <h3>Manage the courses here</h3>
        <p></p>
    </section>

    <section class="evaluation" id="evaluation">
        <a href="./#/Evaluation">
        <img src="./evaluations-button.png" alt="Tutor Button">
        </a>
        <h3>Manage the tutor evaluations here</h3>
        <p></p>
    </section>

    </span>
</template>
<script>
</script>
<style>
body {
  font-family: Century Gothic;

}

h1, h2, h3 {
  font-weight: normal;
  font-family: Century Gothic;
}

ul {
  list-style-type: none;
  padding: 0;
}

li {
  display: inline-block;
  margin: 0 10px;
}

a {
  color: #42b983;
}

.tutors, .rooms, .courses, .evaluation {
    padding: 0%;
    text-align: left;
    margin-left: 2%;
}
.loggedIn {
    text-align: left;
}
</style>