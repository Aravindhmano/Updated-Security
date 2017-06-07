<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <title>Supplier List</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="./resources/css/bootstrap.min.css">
	<script src="./resources/js/jquery.min.js"></script>
	<script src="./resources/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="./resources/css/jquery.dataTables.min.css">
	<link href="./resources/css/font-awesome.min.css" rel='stylesheet' type='text/css'>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
  <style>
    /* Remove the navbar's default margin-bottom and rounded borders */ 
    .navbar {"src/main/webapp/WEB-INF/Views/viewcart.jsp"
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
      <a class="navbar-brand" href="./"><img src='<c:url value="/resources/images/logo.png" />' style="width:75px;height:50px;position:relative;top:-15px;left:0px;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./">Home</a></li>
        
      </ul>
     
    </div>
  </div>
</nav>

 <div class="col-md-10 col-md-offset-1">

           <div class="panel panel-default panel-table">
             <div class="panel-heading">
               <div class="row">
                 <div class="col col-xs-6">
                   <h3 class="panel-title">Your Cart</h3>
                 </div>
               </div>
             </div>
             <div class="panel-body">
               <table class="table table-striped table-bordered table-list">
                 <thead>
                   <tr>
                     
                       <th>Name</th>
                       <th>Price</th>
                       <th>Quantity</th>
                       <th>Image</th> 
                       <th>Total</th>
                                                                                              
                   </tr> 
                 </thead>
                 <tbody>
                         
                        <c:set var="tot" value="0"></c:set>
                        <c:forEach items="${cartlist}" var="p">
                        <c:set var="t" value="${p.prices*p.quantity}"></c:set>
                		<c:set var="tot" value="${tot+t }"/>
                         <tr>
                        
                           <td>${p.productid.prodName}</td> 
                              
                           <td>Rs.${p.prices}</td>
                           <td>${p.quantity }</td>
                           <td><img src="./resources/images/${p.productid.image}"  class="img-rounded" alt="${p.productid.prodName }" width="75px" height="50px"/></td>         
                           <td>${p.prices*p.quantity}</td>
                           <td>
                             <a class="btn btn-danger" href="./cart_delete?id=${p.cartid}"><em class="fa fa-trash"></em></a>
                           </td>
                           <tr>  
                            </c:forEach>     
                       
                       </tbody>
               </table> 
           
             </div>
             <div class="panel-footer">
               <div class="row">
                 <h4 style="text-align: center;">Grand Total = <c:out value="Rs.${tot}"/></h4> 
                 <a href="./">
					<div class="btn-group cart" style="position: relative;left: 100px">
						<input type="button" class="btn btn-success" value="Continue Shopping"/>
							
					</div></a> 
					
					<a href="Checkout">
					<div class="btn-group cart" style="position: relative;left: 700px" >
						<input type="button" class="btn btn-success" value="Checkout"/>
							
					</div></a> 
					
					
               </div>
             </div>
           </div>

</div>
  	<footer class="container-fluid text-center">

</footer>
</body>
</html>
