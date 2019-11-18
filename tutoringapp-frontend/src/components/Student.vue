<template>
  <div class="student">
    <h1>Students</h1>

    <input
      class="text"
      type="text"
      style="margin: 15px; border-radius:2%;"
      placeholder="Password"
      v-model="newPassword"
    />
    <input
      class="text"
      type="text"
      style="margin: 15px; border-radius:2%;"
      placeholder="Username"
      v-model="newUserName"
    />
    <input
      class="text"
      type="text"
      style="margin: 15px; border-radius:2%;"
      placeholder="Student ID"
      v-model="newStudentID"
    />
    <input @click="createSubject(Name,schoolName, description)"
                        type="submit"
                        value="Create"
                        class="btn btn-primary py-2 px-4 text-white"
                        />
    <!-- Bootstrap Table -->
    <b-table :items="students"></b-table>

    <!-- Static Table -->
  </div>
</template>

<style>
</style>

<script src="./javascript/singleStudent.js">
</script>

