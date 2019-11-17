<template>
  <div>
    <h1> Search People </h1>

    <b-table :items="people"></b-table>

    <table>
      <tr v-for="person in people" v-bind:key="person">
        <td>{{ person.firstName }}</td>
        <td>{{ person.lastName}}</td>
        <td>{{ person.userName }}</td>
      </tr>
      <!-- ... -->
    </table>
  </div>
</template>

<style>
</style>

<script src="./javascript/personregistration.js">
</script>
