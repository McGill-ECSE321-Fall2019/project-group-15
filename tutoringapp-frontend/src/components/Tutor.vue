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
          <label for="input-small">by ID:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-small" size="sm" placeholder="Enter ID"></b-form-input>
        </b-col>
        <b-col>
          <b-button>Search</b-button>
        </b-col>
      </b-row>
      <!-- by first name -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input-small">by first name:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-small" size="sm" placeholder="Enter first name"></b-form-input>
        </b-col>
        <b-col>
          <b-button>Search</b-button>
        </b-col>
      </b-row>
      <!-- by last name -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input-small">by last name:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-small" size="sm" placeholder="Enter last name"></b-form-input>
        </b-col>
        <b-col>
          <b-button>Search</b-button>
        </b-col>
      </b-row>
      <!-- Search all tutors -->
      <b-row>
        <b-col>
          <b-button>All tutors</b-button>
        </b-col>
        <b-col>
          <b-button>All unverified tutors</b-button>
        </b-col>
      </b-row>
    </b-container>

    <br />

    <!-- Table -->
    <!-- <table>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Hourly Rate</th>
        <th>Status</th>
        <th>Actions</th>
      </tr>
      <tr>
        <td>160160160</td>
        <td>John Doe</td>
        <td>20.00</td>
        <td>
          <b-form-checkbox
            id="checkbox-approval"
            v-model="status1"
            name="checkbox-approval"
            value="Approved"
            unchecked-value="Unapproved"
          >
            <strong>{{ status1 }}</strong>
          </b-form-checkbox>
        </td>
        <td>
          <b-button variant="danger">Delete</b-button>
        </td>
      </tr>
      <tr>
        <td>016016016</td>
        <td>Jane Doe</td>
        <td>20.50</td>
        <td>
          <b-form-checkbox
            id="checkbox-approval-1"
            v-model="status2"
            name="checkbox-approval-1"
            value="Approved"
            unchecked-value="Unapproved"
          >
            <strong>{{ status2 }}</strong>
          </b-form-checkbox>
        </td>
        <td>
          <b-button variant="danger">Delete</b-button>
        </td>
      </tr>
    </table>-->
    <!-- New Table -->
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

<script>
export default {
  data() {
    return {
      // status1: "Unapproved",
      // status2: "Unapproved",
      fields: [
        "ID",
        { key: "name", label: "Full Name" },
        "hourlyRate",
        "status",
        { key: "delete", label: "Delete" }
      ],
      items: [
        {
          isActive: true,
          ID: 160160160,
          name: { firstName: "John", lastName: "Doe" },
          hourlyRate: 20.0,
          isVerifed: true,
          status: (this.isVerified ? "Approved" : "Unapproved")        
        },
        {
          isActive: true,
          ID: 601601601,
          name: { firstName: "Jane", lastName: "Doe" },
          hourlyRate: 20.5,
          isVerified: false,
          status: (this.isVerified ? "Approved" : "Unapproved")
        }
      ]
    };
  }
};
</script>