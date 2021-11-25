<%-- 
    Document   : resetPassword
    Created on : Nov 24, 2021, 4:34:29 PM
    Author     : 854638
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Reset account password</title>
    </head>
    <body>
        <h1>Please enter your new account password</h1>
        <form action="reset" method="POST">
            <input type="password" name="password">
            <input type="hidden" name="uuid" value="${uuid}">
            <input type="submit" value="Submit">
        </form>
    </body>
</html>
