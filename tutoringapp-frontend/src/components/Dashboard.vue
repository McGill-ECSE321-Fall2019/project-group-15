<template>
    <span class="body">
         <b-navbar toggleable="lg" type="dark" variant="dark">
             <b-navbar-brand href="#">My Dashboard</b-navbar-brand>
            <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

                <b-collapse id="nav-collapse" is-nav>
                    <b-navbar-nav>
                        <b-nav-item href="#myProfile">My Profile</b-nav-item>
                        <b-nav-item href="./" >Logout</b-nav-item>
                       
                    </b-navbar-nav>
                </b-collapse>
            </b-navbar>
            
            
            
<br/>
<br/>

<div class="row">
    <div class="column">
        <a href="./#/Tutor">
            <div class="buttons">
                <button class="btn-hover color-1">Tutors</button>
            </div>
        </a>
     
    
        <a href="./#/Room">
            <div class="buttons">
                <button class="btn-hover color-1">Rooms</button>
            </div>
        </a>

        <a href="./#/Course">
            <div class="buttons">
                <button class="btn-hover color-1">Courses</button>
            </div>
        </a>

        <a href="./#/Evaluation">
            <div class="buttons">
                <button class="btn-hover color-1">Evaluations</button>
            </div>
        </a>
        <a href="./#/Student">
            <div class="buttons">
                <button class="btn-hover color-1">Students</button>
            </div>
        </a>
        <a href="./#/Subject">
            <div class="buttons">
                <button class="btn-hover color-1">Subjects</button>
            </div>
        </a>
        </div>
        <a href="./#/Session">
            <div class="buttons">
                <button class="btn-hover color-1">Sessions</button>
        </div>
        </a>
        </div>
     
    <div class="column">
        <p></p>
        <div>
  <b-card
    title="Welcome to your dashboard"
    
    img-alt="Image"
    img-top
    tag="article"
    style="max-width: 20rem;"
    class="mb-2"
  >
   
    <b-card-text>
      Here you can find out the different components you can accsess by navigating on the buttons on the left
    </b-card-text>

    
  </b-card>
</div>
    </div>
    </div>

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
.buttons {
    margin: 0%;
    text-align: center;
}

.btn-hover {
    width: 200px;
    font-size: 16px;
    font-weight: 600;
    color: #fff;
    cursor: pointer;
    margin: 20px;
    height: 55px;
    text-align:center;
    border: none;
    background-size: 300% 100%;

    border-radius: 50px;
    moz-transition: all .4s ease-in-out;
    -o-transition: all .4s ease-in-out;
    -webkit-transition: all .4s ease-in-out;
    transition: all .4s ease-in-out;
}

.btn-hover:hover {
    background-position: 100% 0;
    moz-transition: all .4s ease-in-out;
    -o-transition: all .4s ease-in-out;
    -webkit-transition: all .4s ease-in-out;
    transition: all .4s ease-in-out;
}

.btn-hover:focus {
    outline: none;
}

.btn-hover.color-1 {
    background-image: linear-gradient(to right, #29323c, #485563, #2b5876, #4e4376);
    box-shadow: 0 4px 15px 0 rgba(45, 54, 65, 0.75);
}
.column {
    float: left;
    width: 50%;
    font-family: Century Gothic;
}
.row::after {
    content: "";
    display: table;
    clear: both;
}

</style>