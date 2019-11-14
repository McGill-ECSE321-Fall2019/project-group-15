<template>
<div id="id">
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
                <input @click="createCourse(newCourse, courseDescription)"
                        type="submit"
                        value="Create"
                        class="btn btn-primary py-2 px-4 text-white"
                        />
                <div class="container" align="center">
                    <span v-if="errorNewCourse" style="color:red">Error: {{errorNewCourse}} </span>
                    <br>
                </div>
                        <h1 class="page-title">Add Course description</h1>
                        <input
                        class="text"
                        type="text"
                        style="margin: 15px; border-radius:2%;"
                        placeholder="Course Description"
                        v-model="courseDescription"
                        />
                        <div class="container" align="center">
                            <span v-if="errorCourseDescription" style="color:red">Error: {{errorCourseDescription}} </span>
                            <br>
                    	</div>
                    </div>
                    <hr style="border: 1px solid white; width:60%; opacity:0.4;" />
                    <br>
                     

                </div>
            </div>
        </div>
</template>

<script src="./javascript/course.js">
</script>
