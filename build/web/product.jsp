<%-- 
    Document   : product
    Created on : Sep 22, 2016, 10:23:57 AM
    Author     : Owner
--%>

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
        <h1>Product</h1>
        
        <form action="productManagement" method="post">
            <label>Code: </label><input type="text" name="code" value="${code}"><br>
            <div id="label-textbox"><label>Description: </label><textarea cols="40px" rows="5px" name="description">${description}</textarea></div><br>
            <label>Price: </label><input type="text" name="price" value="${price}"><br>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Update Product">
        </form>
        
        <button onclick="window.location.href='productManagement?action=displayProducts'" >View Products</button>
    </body>
</html>
