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
                <h1 class="page-title">Add Subject</h1>
                <input
                        class="text"
                        type="text"
                        style="margin: 15px; border-radius:2%;"
                        placeholder="Subject Name"
                        v-model="createSubj"
                        />  
               
                <div class="container" align="center">
                    <span v-if="err" style="color:red">Error: {{er} </span>
                    <br>
                </div>
                        <h1 class="page-title">Add Subject description</h1>
                        <input
                        class="text"
                        type="text"
                        style="margin: 15px; border-radius:2%;"
                        placeholder="Subject Description"
                        v-model="courseDescription"
                        />
                        <div class="container" align="center">
                            <span v-if="errorCourseDescription" style="color:red">Error: {{errorCourseDescription}} </span>
                            <br>
                    	</div>
                    </div>
                    </div>
                        <h1 class="page-title">Add School Name</h1>
                        <input
                        class="text"
                        type="text"
                        style="margin: 15px; border-radius:2%;"
                        placeholder="School Name"
                        v-model="courseDescription"
                        />
                        <div class="container" align="center">
                            <span v-if="errorCourseDescription" style="color:red">Error: {{errorCourseDescription}} </span>
                            <br>
                    	</div>
                    </div>
                    <hr style="border: 1px solid white; width:60%; opacity:0.4;" />
                    <br>
                        <input @click="createSubject(Name,schoolName, description)"
                        type="submit"
                        value="Create"
                        class="btn btn-primary py-2 px-4 text-white"
                        />
                    
                </div>
        
</template>

<script>

</script>
<style scoped>
h1, h2, h3 {
    font-family: Century Gothic;
}
</style>
