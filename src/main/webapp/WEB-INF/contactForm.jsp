<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

   <head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
   <div class="container"><h1>contact</h1>
<br/><h2>form</h2><br><form action="addContact" method="post" >
<div class="form-group"><input name="num"  type="number"  placeholder="num" /><br> </div>
<div class="form-group"><input name="name"  type="text"  placeholder="name" /><br> </div>
<div class="form-group"><input name="address"  type="text"  placeholder="address" /><br> </div>
<div class="form-group"><input name="phone"  type="text"  placeholder="phone" /><br> </div>
<br><button type="submit" class="btn btn-success">send</button></form>

</div></body>
</html>