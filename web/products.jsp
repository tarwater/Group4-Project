<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        User <a href="#">Logout</a>
        <h1>Products</h1>
    <table>
  <tr>
    <th>Code</th>
    <th>Description</th>
    <th>Price</th>
    <th></th>
    <th></th>
  </tr>
  <tr>
    <td>8601</td>
    <td>86 (the band) True Life Songs and Pictures</td>
    <td>15.95</td>
    <td><a href="#">Edit</a></td>
    <td><a href="confirmDelete.jsp">Delete</a></td>
  </tr>
  <tr>
    <td>p101</td>
    <td>Paddlefoot - The first CD</td>
    <td>12.95</td>
    <td><a href="#">Edit</a></td>
    <td><a href="#">Delete</a></td>
  </tr>
  <tr>
    <td>p102</td>
    <td>Paddlefoot - The second CD</td>
    <td>14.95</td>
    <td><a href="#">Edit</a></td>
    <td><a href="#">Delete</a></td>
  </tr>
  <tr>
    <td>jr01</td>
    <td>Joe Rut - Genuine Wood Grained Finish</td>
    <td>14.95</td>
    <td><a href="#">Edit</a></td>
    <td><a href="#">Delete</a></td>
  </tr>
</table>
        <form action="product.jsp">
            <input type="submit" value="Add Product">
        </form>
    
    </body>
</html>
