<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CustomerDetails</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
<style type="text/css">
 footer {
     	 background-color: #17202A  ;
     	 padding: 25px;
     	 position: absolute;
  		right: 0;
 		 bottom: 0;
  left: 0;
      }
  

.centered-form{
	margin-top: 60px;
}

.centered-form .panel{
	background: rgba(255, 255, 255, 0.8);
	box-shadow: rgba(0, 0, 0, 0.3) 20px 20px 20px;
}
 .navbar {
      margin-bottom: 0;
      border-radius: 0;
      
    }
    

</style>

</script>
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
      <a class="navbar-brand" href="./"><img src='<c:url value="/resources/images/logo.png" />' style="width:75px;height:50px;position:relative;top:-15px;left:0px;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./">Home</a></li></ul></div></div></nav>
        
    
        
<div class="container">
        <div class="row centered-form">
        <div class="col-xs-25 col-sm-8 col-md-20 col-sm-offset-2 col-md-offset-15">
        	<div class="panel panel-default">
        		<div class="panel-heading">
			    		<h3 class="panel-title"> Invoice 	Details</h3>
			 			</div>
			 			<div class="panel-body">
			    		<form  action="summary">
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					<label>NAME:</label>
			                <input type="text" name="name" id="first_name" class="form-control input-sm" placeholder="First Name">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					<label>E-mail:</label>
			    						<input type="text" name="email" id="email" class="form-control input-sm" placeholder="Email">
			    					</div>
			    				</div>
			    			</div>

			    			<div class="form-group">
			    			<label>Phone number:</label>
			    				<input type="text" name="phone" id="Phone" class="form-control input-sm" placeholder="phone">
			    			</div>

			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					<label>Address:</label>
			    						<input type="textarea" name="textarea" id="textarea" class="form-control input-sm" placeholder="address">
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    					<label>Date:</label>
			    						<input type="date" id="myDate" name="date" value="2017-06-02" class="form-control input-sm" placeholder="">
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<input type="submit" value=" Get Invoice" class="btn btn-info btn-block">
			    		
			    		</form>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
 
   <br>
   <footer class="container-fluid text-center">

</footer>
</body>

</html>
