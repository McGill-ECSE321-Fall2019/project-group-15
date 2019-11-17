<template>
  <div class="tutor">
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
    <h1>Search Tutors</h1>
    <!-- Search  -->
    <b-container fluid>
      <!-- by ID -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input-1">by ID:</label>
        </b-col>
        <b-col sm="3">
          <b-form-input id="input-1" size="sm" placeholder="Enter ID"></b-form-input>
        </b-col>
        <b-col sm="2">
          <b-button id="button-1">Search by ID</b-button>
        </b-col>
      </b-row>
      <!-- by first name -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input-2">by first name:</label>
        </b-col>
        <b-col sm="3">
          <b-form-input id="input-2" size="sm" placeholder="Enter first name"></b-form-input>
        </b-col>
        <b-col sm="2">
          <b-button id="button-2">Search by First Name</b-button>
        </b-col>
      </b-row>
      <!-- by last name -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input-3">by last name:</label>
        </b-col>
        <b-col sm="3">
          <b-form-input id="input-3" size="sm" placeholder="Enter last name"></b-form-input>
        </b-col>
        <b-col sm="2">
          <b-button id="button-3">Search by Last Name</b-button>
        </b-col>
      </b-row>
      <!-- Search all tutors -->
      <b-row>
        <b-col sm="2">
          <b-button id="button-4">All Tutors</b-button>
        </b-col>
        <b-col sm="2">
          <b-button id="button-5">All Unverified Tutors</b-button>
        </b-col>
      </b-row>
    </b-container>

    <br />

    <!-- Table -->
    <div>
      <b-table small :fields="fields" :items="items" responsive="sm">
        <!-- Name Column -->
        <template
          v-slot:cell(name)="data"
        >{{ data.item.name.firstName }} {{ data.item.name.lastName }}</template>

        <!-- Status Column -->
        <template v-slot:cell(status)="data">
          <b-form-checkbox
            v-model="data.item.status"
            checked="data.item.isVerified"
            value="Approved"
            unchecked-value="Unapproved"
          >
            <strong>{{ data.item.status }}</strong>
          </b-form-checkbox>
        </template>
        <!-- Delete Column -->
        <template v-slot:cell(delete)="data">
          <b-button variant="danger">Delete</b-button>
        </template>
      </b-table>
    </div>
    
    <!-- Test Bootstrap Table -->
    <div>
    <b-table :items="tutors">
    </b-table>
    </div>

    

  </div>
</template>

<style scoped>
table {
  display: table;
  border-collapse: separate;
  border-spacing: 10px;
  border-color: grey;
}
</style>

<script src="./javascript/tutorRegistration.js">
// export default {
//   data() {
//     return {
//       fields: [
//         "ID",
//         { key: "name", label: "Full Name" },
//         "hourlyRate",
//         "status",
//         { key: "delete", label: "Delete" }
//       ],
//       items: [
//         {
//           isActive: true,
//           ID: 160160160,
//           name: { firstName: "John", lastName: "Doe" },
//           hourlyRate: 20.0,
//           isVerifed: true,
//           status: (this.isVerified ? "Approved" : "Unapproved")        
//         },
//         {
//           isActive: true,
//           ID: 601601601,
//           name: { firstName: "Jane", lastName: "Doe" },
//           hourlyRate: 20.5,
//           isVerified: false,
//           status: (this.isVerified ? "Approved" : "Unapproved")
//         }
//       ]
//     };
//   }
// };

</script>