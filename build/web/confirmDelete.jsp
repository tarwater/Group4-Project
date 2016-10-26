
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Product Management</title>
    </head>
    <body>
        User <a href="#">Logout</a>
        <h1>Are you sure you want to delete this product?</h1>
        
        <label>Code: </label>${code}<br>
        <label>Description: </label>${description}<br>
        <label>Price: </label>${price}<br>
        <div id="delete-form-buttons">
        <form method="post" action="productManagement" id="delete-form">
            <input type="hidden" name="code" value="${code}">
            <input type="hidden" name="action" value="confirmDelete">
            
            <input type="submit" value="Yes">
        </form>
        
            <button onclick="window.location.href='productManagement?action=displayProducts'" >No</button></div>
    </body>
</html>
