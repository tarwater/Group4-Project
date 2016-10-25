<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Product Management</title>
        <link rel="stylesheet" type="text/css" href="styles.css">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
  
    <c:forEach items="${products}" var="item">
        <tr>
    <td>${item.code}</td>
    <td>${item.description}</td>
    <td>${item.price}</td>
    <td><form action="productManagement" method="post"><input type="hidden" name="action" value="edit"><input type="hidden" name="code" value="${item.code}">
         <input type="submit" value="Edit"></form></td>
    <td><form action="productManagement" method="post"><input type="hidden" name="action" value="delete"><input type="hidden" name="code" value="${item.code}">
         <input type="submit" value="Delete"></form>              </td>
    </tr>
</c:forEach>
  

  
</table>
        <form action="product.jsp">
            <input type="submit" value="Add Product">
        </form>
    
    </body>
</html>
