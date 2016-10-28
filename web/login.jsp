
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <form action="membership" method="post">
            <div id="login-form">
                <label>Email:</label><input type="text" name="email"><br>
                <label>Password:</label><input type="password" name="password"><br>
                <input type="hidden" name="action" value="login">
                <input type="submit" value="Login" id="right-form-button"><br></form>
            </div>
            <a href="signup.jsp">New user? Click here to register.</a>
            <p id="message">${message}</p>
    </body>
</html>
