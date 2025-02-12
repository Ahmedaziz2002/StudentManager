<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="java.sql.*"%>
<!doctype html>
<html>
    <head>
        <title>Marks</title>
    </head>
    <body>
        <h2>Add new marks</h2>
        <form action="MarksServlet" method="post">
            Student ID: <input type="number" name="studentId" required><br> 
            Subject: <input type="text" name="subject" required><br>
            Grade: <input type="text" name="grade" required><br>
            Semester: <input type="text" name="semester" required><br>
            <button type="submit">Add Marks</button>
        </form>
        <br>
        <a href="MarksView">View the students Marks List</a>

    </body>
</html>