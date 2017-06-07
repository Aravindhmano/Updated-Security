<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <title>product Details</title>
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
  </style>
  
  <script>
function sum() {
      var txtFirstNumberValue = document.getElementById('txt1').value;
      var txtSecondNumberValue = document.getElementById('txt2').value;
      var result = parseInt(txtFirstNumberValue) * parseInt(txtSecondNumberValue);
      if (!isNaN(result)) {
         document.getElementById('txt3').value = result;
      }
}
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
      <a class="navbar-brand" href="./"><img src="./resources/images/logo.png" style="width:75px;height:50px;position:relative;top:-15px;left:0px;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./">Home</a></li>
        
        
       
        
         <li class="active"><a  data-toggle="dropdown" href=" ">Product<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <br>
         <c:forEach items="${clist}" var="p">
         <li><a href="productfilter?id=${p.categoryId}"> ${p.categoryName }</a></li>
         
          <br>
       </c:forEach>
        </ul>
      </li>
        
        
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="login"><span class="glyphicon glyphicon-log-in"></span>SignIn</a></li>
         <li><a href="registration"><span class="glyphicon glyphicon-log-in"></span>SignUp</a></li>
      </ul>
    </div>
  </div>
</nav>



<div id="x">
<div id="logdiv">
<br/>
		
		 <div class="container-fluid">		
			<div class="col-md-12 product-info">
					<ul id="myTab" class="nav nav-tabs nav_tabs">
						
						<li class="active"><a href="#service-one" >DESCRIPTION</a></li><br>
						<div class="product-desc">${product.prodDescription}</div>
						
					</ul>
				
					
				</div>
				<hr>
    <div class="container-fluid">
    <div class="content-wrapper">	
		<div class="item-container">	
			<div class="container">	
				<div class="col-md-12">
					<div class="product col-md-3 service-image-left">
                 
                 <img id="item-display" src="./resources/images/${product.image}" alt="" width="150" height="150"></img>
                 <div class="product-title">${product.prodName}</div>
				<h4>Rs.${product.prodPrice}</h4>	
					</div>
					
					
				</div>
					
				<div class="col-md-7">
				
				
					<div class="product-rating"><i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star gold"></i> <i class="fa fa-star-o"></i> </div>
					<hr>
					<form action="productdetails">
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					<input type="hidden"  name="prodid" value="${product.prodId}"  onkeyup="sum();"/><br><br>
					ProductPrice:&nbsp;&nbsp;&nbsp;
					
					<input type="text" id="txt1" name="prodprice" class="fa fa-inr" aria-hidden="true" value="${product.prodPrice}" readonly onkeyup="sum();"/></i><br><br>
					ProductQuantity:<input type="text" id="txt2" name="prodquantity" value="" onkeyup="sum();"/><br><br><br>
					
					TotalPrice:<input type="text"  id="txt3" name="pricetot" value=""/>
					</div>
					<div class="product-stock">In Stock</div>
					<hr>
					<div class="btn-group cart">
						<input type="submit" class="btn btn-success" value="ADDCART"/>
							
					</div>
					</form>
					
					
				
					<!-- <div class="btn-group wishlist">
						<button type="button" class="btn btn-danger">
							Add to wishlist 
						</button>
					</div> -->
				</div>
			</div> 
		
			</div>
		</div>
		
	</div>
	
		<footer class="container-fluid text-center">

</footer>
		
</div>
</div>
</body>
</html>
 