<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<link rel="stylesheet" href="main.css">
</head>
<body>
<div="container">
<ul class="nav">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="#">Home</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="#">Link</a>
  </li>

</ul>
	
<div class="row">
    <div class="col">
     <div class="card-1">
     	 <table id="table_id" class="table">
    <thead class="table-primary">
        <tr>
            <th>S.Number</th>
            <th>Name</th>
            <th>Category</th>
            <th>Company</th>
            <th>Price</th>
            <th>Quantity</th>
            <th>expDate</th>
            <th>fabDate</th>
            <th>Action</th>
        </tr>
    </thead>
    <tbody>
    	<c:forEach items="${medies}" var="medi">
        <tr>
            <td>${medi.getId()}</td>
            <td>${medi.getName()}</td>
            <td>${medi.getCategory()}</td>
            <td>${medi.getCompany()}</td>
            <td>${medi.getPrice()}</td>
            <td>${medi.getQuantity()}</td>
            <td>${medi.getExpdate()}</td>
            <td>${medi.getFabDate()}</td>
            <td><button type="button" class="btn btn-primary" style="margin: 0 4px;"  onclick="location.href='HomeController?action=EDIT&id=${medi.getId()}';">Edit</button><button type="button" class="btn btn-danger" onclick="location.href='HomeController?action=DELETE&id=${medi.getId()}';">Delete</button> </td>
        </tr>
       </c:forEach>
    </tbody>
</table>
     </div>
    </div>
    <div class="col">
    <div class = "card-heading">
    	<h1>Add Medicine</h1>
    </div>
    
     	<div class="card-2">
     	<form action="${pageContext.request.contextPath}/HomeController?action=ADD" method="post">
	
  <div class="form-group">
    <label for="exampleInputEmail1">Medicine Name</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Medicine Name" name="medicalname">
  </div>
 <div class="form-group">
    <label for="exampleInputEmail1">Stock Availability</label>
    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Stock Availability" name="stock">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Category</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Category" name="category">
  </div>
  <div class="form-group">
    <label for="exampleInputEmail1">Price</label>
    <input type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Price" name="price">
  </div>
    <div class="form-group">
    <label for="exampleInputEmail1">Quantity</label>
    <input type="number" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Enter Quantity" name="quantity">
  </div>
  <center><button type="submit" class="btn btn-primary">ADD</button></center>
	
	
	</form>
     	</div>
    </div>
  </div>
</div>
</body>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

<script type="text/javascript" charset="utf8" src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.24/js/jquery.dataTables.min.js"></script>
<script >
$(document).ready( function () {
    $('#table_id').DataTable();
} );
</script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

</html>
