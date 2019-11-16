<template>
<div id="id">
    <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">Tutoring S15stem</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">Home</b-nav-item>
        <b-nav-item href="#" disabled>About</b-nav-item>
      </b-navbar-nav>

     
    </b-collapse>
  </b-navbar>
    <div class="site-wrap">
        <div class="site-section" style="padding-top:10%">
            <div class="container" style="text-align:center; ">
                <h1 class="page-title">Create Course</h1>
                <input
                        class="text"
                        type="text"
                        style="margin: 15px; border-radius:2%;"
                        placeholder="Course Name"
                        v-model="newCourse"
                        />  
                        <h1 class="page-title">Add Course description</h1>
                        <input
                        class="text"
                        type="text"
                        style="margin: 15px; border-radius:2%;"
                        placeholder="Course Description"
                        v-model="courseDescription"
                        />
                <input @click="createCourse(newCourse, courseDescription)"
                        type="submit"
                        value="Create"
                        class="btn btn-primary py-2 px-4 text-white"
                        />
                <div class="container" align="center">
                    <span v-if="errorNewCourse" style="color:red">Error: {{errorNewCourse}} </span>
                    <br>
                </div>
                        <input @click="viewAllCourses()"
                        type="submit"
                        value="View Courses"
                        class="btn btn-primary py-2 px-4 text-white"
                        />
                    </div>
                    <hr style="border: 1px solid white; width:60%; opacity:0.4;" />
                    <br>
                     

                </div>
            </div>
        </div>
</template>

<script src="./javascript/course.js">
</script>
<style scoped>
h1, h2, h3 {
    font-family: Century Gothic;
}
</style>
