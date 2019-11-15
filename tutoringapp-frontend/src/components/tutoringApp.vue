<template>
<div class="row">
    <div class="col-sm">
         Name
    </div>
    <div class="col-sm">
        <p class="title">ID</p>
    </div>
    <div class="col-sm">
        Rating
    </div>
    <div
        class="col-sm">
        <button class="btn-grad">Delete</button>
    </div>
</div>
</template>

<style>
.row{
    border-bottom-style: solid;
    border-bottom-color: lightgray;
    border-bottom-width: 3px;
    padding:2px;
    position: relative;
    width:100%;
  margin:0 auto;
}
.title{
    position: absolute;
    top: 50%;
    font-family: "Open Sans";
    font-size: 1em;
    -ms-transform: translateY(-50%);
    transform: translateY(-50%);
    margin:0 auto;
    padding-left:20%;
}

.btn-grad {
    background-image: linear-gradient(to right, #F09819 0%, #F09819 50%, #edcc00 100%);
    border-radius: 25px;
    color: white;
    font-weight: bold;
    border: none;
    box-shadow: 0 8px 16px 0 rgba(0,0,0,0.2), 0 6px 20px 0 rgba(0,0,0,0.19);
    outline:none;
    outline-style:none;
    box-shadow:none;
    border-color:transparent;
}
.btn-grad:hover { background-position: right center; }

</style>
<script>
</script>

