<template>
  <div class="evaluation">
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
            <b-nav-item href="#evaluation">Evaluations</b-nav-item>
          </b-navbar-nav>
        </b-collapse>
      </b-navbar>
    </div>
    <!-- Header -->
    <h1>Moderate Evaluations</h1>
    <!-- Search  -->
    <b-container fluid>
      <!-- by Tutor ID -->
      <b-row class="my-1">
        <b-col sm="2">
          <label for="input-1">by Tutor ID:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-1" size="sm" placeholder="Enter Tutor ID"></b-form-input>
        </b-col>
        <b-col>
          <b-button id="button-1">Search</b-button>
        </b-col>
      </b-row>
      <!-- by Student ID -->
      <b-row class="my-2">
        <b-col sm="2">
          <label for="input-2">by Student ID:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-2" size="sm" placeholder="Enter Student ID"></b-form-input>
        </b-col>
        <b-col>
          <b-button id="button-2">Search</b-button>
        </b-col>
      </b-row>
      <!-- by Session ID -->
      <b-row class="my-3">
        <b-col sm="2">
          <label for="input-3">by Session ID:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-3" size="sm" placeholder="Enter Session ID"></b-form-input>
        </b-col>
        <b-col>
          <b-button id="button-3">Search</b-button>
        </b-col>
      </b-row>
      <!-- by Evaluation ID -->
      <b-row class="my-4">
        <b-col sm="2">
          <label for="input-4">by Evaluation ID:</label>
        </b-col>
        <b-col sm="5">
          <b-form-input id="input-4" size="sm" placeholder="Enter Evaluation ID"></b-form-input>
        </b-col>
        <b-col>
          <b-button id="button-4">Search</b-button>
        </b-col>
      </b-row>
      <!-- Search all Evaluations -->
      <b-row class="my-5">
        <b-col>
          <b-button id="button-5">All Evaluations</b-button>
        </b-col>
      </b-row>
    </b-container>

    <br />

    <!-- Table -->
    <div>
      <b-table small :fields="fields" :items="items" responsive="sm">
        <!-- Flagged Column -->
        <template v-slot:cell(isFlagged)="data">
          <b-form-checkbox
            v-model="data.item.isFlagged"
            checked="data.item.isFlagged"
            value="true"
            unchecked-value="false"
          >
            <strong>{{ data.item.isFlagged }}</strong>
          </b-form-checkbox>
        </template>
        <!-- Rating -->
        <template v-slot:cell(rating)="data">
            {{ data.item.rating }}/5
        </template>
      </b-table>
    </div>
  </div>
</template>

<style scoped>
</style>

<script>
export default {
  data() {
    return {
      fields: [
        "evaluationID",
        "tutorID",
        "studentID",
        "rating",
        "isFlagged",
        "comment"
        
      ],
      items: [
        {
          evaluationID: 1231,
          rating: 4,
          comment: "Best tutor ever!!!",
          isFlagged: false,
          tutorID: 160160160,
          studentID: 696969
        },
        {
          evaluationID: 2312,
          rating: 1,
          comment: "Worst tutor ever!!! Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed pulvinar ante nec risus maximus, ut eleifend justo suscipit. Phasellus eros nunc, semper ac nisi et, dignissim ultricies mi. Etiam ut odio id tellus blandit lacinia eu ac dolor. Sed sagittis libero eget lectus viverra, non pharetra risus accumsan. Integer vitae ex tortor. Phasellus a urna dui. Donec consequat mollis justo id vestibulum. Proin dictum et lectus ac volutpat. Proin maximus sem ante, non pretium ex accumsan sit amet. Curabitur in turpis leo. Mauris libero leo, pellentesque quis tortor eget, rutrum consequat dolor. Aliquam quis finibus urna. Vivamus vitae vulputate mi.",
          isFlagged: true,
          tutorID: 601601601,
          studentID: 969696
        }
      ]
    };
  }
};
</script>