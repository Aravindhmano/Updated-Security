<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <title>ProductEdit</title>
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

<h2>Edit Product Details</h2>
<hr/>
  <form action="product_update" method="post" enctype="multipart/form-data">
    <div class="form-group">
      <label for="p_id">Product  ID :</label>
      <input type="number" class="form-control" id="p_id" placeholder="Enter Product ID" name="p_id" value="${product.prodId}">
    </div>
    <div class="form-group">
      <label for="p_name">Product Name :</label>
      <input type="text" class="form-control" id="p_name" placeholder="Enter Product Name " name="p_name" value="${product.prodName}">
    </div>
    <div class="form-group">
      <label for="p_desc">Product Description :</label>
      <input type="text" class="form-control" id="p_desc" placeholder="Enter Product Description " name="p_desc" value="${product.prodDescription}" >
    </div>
    <div class="form-group">
      <label for="p_price">Product Price :</label>
      <input type="number" class="form-control" id="p_price" placeholder="Enter Product Price " name="p_price" value="${product.prodPrice}" >
    </div>
    <div class="form-group">
  <label class="col-md-4 control-label" for="c_id" >Select Category</label>
  <div class="col-md-4">
    <select id="c_id" class="form-control" name="c_id">
      <c:forEach var="clist" items="${clist}">

                <option value="${clist.categoryId}">${clist.categoryName}</option>

            </c:forEach>
    </select>
  </div>
</div>
<br/>
<br/>
<div class="form-group">
  <label class="col-md-4 control-label" for="s_id" >Select Supplier</label>
  <div class="col-md-4">
    <select id="s_id" class="form-control" name="s_id">
      <c:forEach var="slist" items="${slist}">

                <option value="${slist.supplierId}">${slist.supplierName}</option>

            </c:forEach>
    </select>
  </div>
</div>
<br/>
<br/>
<br/>

<div class="form-group">
      <label for="img">Upload Image:</label>
      <input type="file" id="img" name="file">
    </div>
    <button type="submit" class="btn btn-primary" >Save</button>
  </form>
  
  	<footer class="container-fluid text-center">

</footer>
		
</body>
</html>