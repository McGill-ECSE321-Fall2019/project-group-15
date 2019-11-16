<template>
<span class="container">

  <div class="hello">
  <div>
  <b-navbar toggleable="lg" type="dark" variant="info">
    <b-navbar-brand href="#">Tutoring S15stem</b-navbar-brand>

    <b-navbar-toggle target="nav-collapse"></b-navbar-toggle>

    <b-collapse id="nav-collapse" is-nav>
      <b-navbar-nav>
        <b-nav-item href="#">Home</b-nav-item>
		<b-nav-item href="#about" >About</b-nav-item>
        <b-nav-item href="#contact" >Contact</b-nav-item>
      </b-navbar-nav>

     
    </b-collapse>
  </b-navbar>
</div>

<img src="./banner.png" alt="Banner">
    <h2>{{ msg }}</h2>
    
    <!-- Login Form-->

    <div>
    
    <div class="login-form">
    <br>

    <p>Login as a Manager</p>
  <b-form inline>
    

    <label class="sr-only" for="inline-form-input-username">Username</label>
    <b-input-group prepend="@" class="mb-2 mr-sm-2 mb-sm-0">
      <b-input id="inline-form-input-username" placeholder="Username"></b-input>
    </b-input-group>
<label class="sr-only" for="inline-form-input-name">Password</label>
    <b-input
      id="inline-form-input-name"
      class="mb-2 mr-sm-2 mb-sm-0"
      placeholder="enter password"
    ></b-input>
    <b-form-checkbox class="mb-2 mr-sm-2 mb-sm-0">Remember me</b-form-checkbox>

    <b-button variant="primary">Login</b-button>
  </b-form>
</div>
<!-- Login form ends -->
<img src="./banner-info.png" alt="Banner">
   
   <div class="sign-up">
   <h3>Not a member?</h3>
    <b-form @submit="onSubmit" @reset="onReset" v-if="show">
      
      

      <b-form-group id="input-group-2" label="Your First Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.firstname"
          required
          placeholder="Enter First name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Your Last Name:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.lastname"
          required
          placeholder="Enter Last name"
        ></b-form-input>
      </b-form-group>

      <b-form-group id="input-group-2" label="Pick a username:" label-for="input-2">
        <b-form-input
          id="input-2"
          v-model="form.username"
          required
          placeholder="Enter username"
        ></b-form-input>
      </b-form-group>

      

      <b-form-group id="input-group-4">
        <b-form-checkbox-group v-model="form.checked" id="checkboxes-4">
          <b-form-checkbox value="me">Send me confirmation email</b-form-checkbox>
          <b-form-checkbox value="that">Check that out</b-form-checkbox>
        </b-form-checkbox-group>
      </b-form-group>

      <b-button type="submit" variant="primary">Submit</b-button>
      <b-button type="reset" variant="danger">Reset</b-button>
    </b-form>
    <b-card class="mt-3" header="Form Data Result">
      <pre class="m-0">{{ form }}</pre>
    </b-card>
  </div>
  
   
  </div>
  <section class="about" id="about">

<img src="./banner-about.png" alt="Banner">
<p></p>
<p></p>
</section>
  
  <section class="contact" id="contact">
<img src="./banner-contact.png" alt="Banner">

</section>
  
  <footer>
  <p> All Right reserved to Group 15 </p>
  </footer>
  
  </span>
</template>

<script>
export default {
  name: 'hello',
  data () {
    return {
      msg: '',
      form: {
          email: '',
          firstname: '',
          lastname: '',
          checked: []
      },
      
      show: true
    }
  },
   methods: {
      onSubmit(evt) {
        evt.preventDefault()
        alert(JSON.stringify(this.form))
      },
      onReset(evt) {
        evt.preventDefault()
        // Reset our form values
        this.form.email = ''
        this.form.name = ''
        this.form.food = null
        this.form.checked = []
        // Trick to reset/clear native browser form validation state
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      }
}
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
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

.login-form {
	width: 70%;
	text-align: left;
	margin-left: 50px;
}
.sign-up {
	width: 70%;
	text-align: left;
	margin-left: 50px;
}
</style>
