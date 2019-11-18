<template>
  <div class="student">
    <h1>Students</h1>

    <!-- Search Input -->
    <label>Search by ID:</label>
    <input type="number" v-model="searchStudentID">
    <b-button
    @click="getStudentByID(searchStudentID)">
      Search
    </b-button>
    <b-button
    @click="getAllStudents()">
      All Students
    </b-button>
     <b-button
    @click="getRemovedStudents()">
      Removed Students
    </b-button>

    <!-- Bootstrap Table -->
    <b-table :items="students" :fields="['id', 'name', 'userName','delete']">
      <template
        v-slot:cell(name)="data"
      >{{ data.item.person.firstName }} {{ data.item.person.lastName }}</template>
      <template v-slot:cell(userName)="data">{{ data.item.person.userName }}</template>

      <template v-slot:cell(delete)="data">
        <b-button @click="removeStudent(data.item.id)" variant="danger">Delete</b-button>
      </template>
    </b-table>

    <!-- Static Table -->
  </div>
</template>

<style>
</style>

<script src="./javascript/singleStudent.js">
</script>

