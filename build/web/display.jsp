<%-- 
    Document   : display
    Created on : 11 Feb 2025, 17:03:16
    Author     : Ahmed
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>DISPLAY STUDENTS</title>
    </head>
    <body>
        <h1>LIST OF REGISTERED STUDENTS</h1>
        <ul>
            <%
                java.util.List<String>students=(java.util.List<String>)request.getAttribute("students");
                if(students!=null && !students.isEmpty()){
                for(String student:students){
                %>
                <li><%=student%></li>
                <%
                }
                }else{
                %>
                <li>No students registered yet</li>
                <% } %>
        </ul>
        <br>
        <a href="register.jsp">Register another student</a>

    </body>
</html>
