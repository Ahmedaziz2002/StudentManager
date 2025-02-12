<%-- 
    Document   : register
    Created on : 11 Feb 2025, 16:22:06
    Author     : Ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Students Registration</title>
    </head>
    <body>
        <h1>Register a Student</h1>
        <form action="StudentServlet" method="post">
            <label for="name">Student Name:</label>
            <input type="text" name="name" id="name" required>
            <button type="submit">Register</button>
        </form>
        <br>
        <a href="DisplayStudentsServlet">View Registered Students</a>
    </body>
</html>
