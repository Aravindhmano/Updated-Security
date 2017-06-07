<!DOCTYPE html>
<html lang="en">
<head>
  <title>Registration</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {
      margin-bottom: 0;
      border-radius: 0;
    }
    
    /* Add a gray background color and some padding to the footer */
    footer {
     	 background-color: #17202A  ;
     	 padding: 25px;
     	 position: absolute;
  		right: 0;
 		 bottom: 0;
  left: 0;
      }
    
  .carousel-inner img {
      width: 100%; /* Set width to 100% */
      margin: auto;
      height:200px;
  }
  
 

  /* Hide the carousel text when the screen is less than 600 pixels wide */
  @media (max-width: 600px) {
    .carousel-caption {
      display: none; 
    }
  }
  
 form {
    border: 3px solid #f1f1f1;
}

input[type=text], input[type=password],input[type=email],input[type=number] {
    width: 50%;
    padding: 5px 5px;
    margin: 1px 0;
    display:block;
    border: 1px solid #ccc;
    box-sizing: border-box;
}

button {
    background-color: #4CAF50;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 50%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}



.container {
    padding:5px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
       display: block;
       float: none;
    }
    .cancelbtn {
       width: 100%;
    }
}
</style>
  
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>                        
      </button>
      <a class="navbar-brand" href=" "><img src="./resources/images/logo.png" style="width:75px;height:50px;position:relative;top:-15px;left:0px;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="/">Home</a></li>
       
      </ul>
      
    </div>
  </div>
</nav>


<h2>Registration  Form</h2> 
<form action="register">
  <div class="container">
    <label><b>Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required="required">
    
     <label><b>Age</b></label>
    <input type="number" placeholder="Enter Age" name="age"  required="required">
    
    <label><b>email</b></label>
    <input type="email" placeholder="Enter email" name="mail" required="required">

    <label><b>Password</b></label>
    <input type="password" placeholder="Enter Password" name="passwd" pattern="[a-z]{2}[0-9]{2}" required="required">
    
    <label><b>Phone Number</b></label>
    <input type="text" placeholder="Enter Phone-Number" name="phone" pattern="[0-9]{10}" title="Pattern Dose not Match:please provide two letters and two numbers" required="required">
    
     <label><b>Address</b></label><br>
    <textarea rows="4" cols="75" name="address" required="required"></textarea><br>
    <button type="submit">Login</button>
   
  </div>

</form>

</body>
</html>


<!-- <footer class="container-fluid text-center">

</footer> -->

</body>
</html>
