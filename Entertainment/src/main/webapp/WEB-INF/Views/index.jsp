<!DOCTYPE html>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">

<head>
  <title>Home</title>
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
      background-color: #17202A;
      padding: 25px;
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
      <a class="navbar-brand" href="./"><img src='<c:url value="resources/images/logo.png" />' style="width:75px;height:50px;position:relative;top:-15px;left:0px;"></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav">
        <li class="active"><a href="./">Home</a></li>
        
       
       
        
         <li class="active"><a  data-toggle="dropdown" href=" ">Categorys<span class="caret"></span></a>
        <ul class="dropdown-menu">
        <br>
         <c:forEach items="${clist}" var="p">
         <li><a href="productfilter?id=${p.categoryId}"> ${p.categoryName }</a></li>
         
          <br>
       </c:forEach>
        </ul>
      </li>
      
      <li><a href="<c:url value="admin/add"/>" role="button" aria-haspopup="true"
					aria-expanded="false">Add</a></li>
      
      <c:if test="${pageContext.request.userPrincipal.name  == 'admin'}">
                                <li><a href="<c:url value="/admin" />">Admin</a></li>
                 </c:if>
        
       <%--  <li><a href="<c:url value="admin/CategoryList" />">CategoryList</a></li>
         <li><a href="<c:url value="admin/SupplierList" />">SupplierList</a></li>
         <li><a href="<c:url value="admin/ProductList" />">ProductList</a></li> --%>
      </ul>
     
         <ul class="nav navbar-nav navbar-right">
			  <c:if test="${pageContext.request.userPrincipal.name == null }">
					<li>
					<a href=' <c:url value="/login" />'><span class="glyphicon glyphicon-log-in"></span>Signin</a>
					</li>
				<li><a href="registration"><span class="glyphicon glyphicon-log-in"></span>SignUp</a></li>
				
				</c:if>
				<c:if test="${pageContext.request.userPrincipal.name  != null}">
                               <li><a>Welcome: ${pageContext.request.userPrincipal.name}</a></li>
	              				<li><a href='<c:url value="/logout" />'>Signout</a></li>
                 </c:if>
				
				</ul>
         
      </ul>
    </div>
  </div>
</nav>


<div id="myCarousel" class="carousel slide" data-ride="carousel">
    <!-- Indicators -->
    <ol class="carousel-indicators">
      <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
      <li data-target="#myCarousel" data-slide-to="1"></li>
      <li data-target="#myCarousel" data-slide-to="2"></li>
      <li data-target="#myCarousel" data-slide-to="3"></li>
    </ol>

    <!-- Wrapper for slides -->
    <div class="carousel-inner" role="listbox">
      <div class="item active">
        <img class="im" src="./resources/images/sld1.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>      
      </div>

      <div class="item">
        <img class="im" src="./resources/images/sld2.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>      
      </div>
      <div class="item">
        <img class="im" src="./resources/images/sld4.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>      
      </div>
      <div class="item">
        <img class="im" src="./resources/images/sld5.jpg" alt="Image">
        <div class="carousel-caption">
          <h3></h3>
          <p></p>
        </div>      
      </div>
    </div>

    <!-- Left and right controls -->
    <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
      <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
      <span class="sr-only">Previous</span>
    </a>
    <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
      <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
      <span class="sr-only">Next</span>
    </a>
</div>
  
<div class="container text-center">    
  <h3>What We Sale</h3><br>
  <div class="row">
    <div class="col-sm-4">
      <img src="./resources/images/tvv.jpg" class="img-responsive" style="width:100%" alt="Image">
      <h4>SONY</h4>
    </div>
    <div class="col-sm-4"> 
      <img src="./resources/images/tv7.jpg" class="img-responsive" style="width:100%" alt="Image">
      <h4>LG</h4>    
    </div>
      <div class="col-sm-4"> 
      <img src="./resources/images/tv5.jpg" class="img-responsive" style="width:100%" alt="Image">
      <h4>SAMSUNG</h4>    
    </div>
    <!-- <div class="col-sm-4">
      <div class="well">
       <p>Some text..</p>
      </div>
      <div class="well">
       <p>Some text..</p>
      </div>
    </div> -->
  </div>
</div><br>

<footer class="container-fluid text-center">

</footer>

</body>
</html>
