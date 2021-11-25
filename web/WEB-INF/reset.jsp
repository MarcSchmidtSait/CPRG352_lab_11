<%-- 
    Document   : reset
    Created on : Nov 24, 2021, 3:33:47 PM
    Author     : 854638
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset Password</title>
    </head>
    <body>
        <h1>Reset Password</h1>
        <br>
        <h4>Please enter your email address to reset your password</h4>
        <br>
        <form method="POST" action="reset">
            <label>Email Address: </label>
            <input id="email" name="email" type="test">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
