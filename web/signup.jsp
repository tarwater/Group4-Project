
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="styles.css">
        <title>Sign up</title>
    </head>
    <body>
        <h1>Sign-up Form</h1>
        <div id="login-form">
            <form action="membership" method="post">
                <label>First name:</label><input type="text" name="firstName"><br>
                <label>Last name:</label><input type="text" name="lastName"><br>
                <label>Email:</label><input type="text" name="email"><br>
                <label>Username:</label><input type="text" name="username"><br>
                <label>Password:</label><input type="password" name="password"><br>
                <input type="hidden" name="action" value="register">
                <input type="submit" value="Sign up" id="right-form-button"><br>
            </form>
            <p id="message">${message}</p>
        </div>

    </body>
</html>