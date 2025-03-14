<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionSignup = request.getSession(false);
    if (sessionSignup != null && sessionSignup.getAttribute("user") != null) {
        response.sendRedirect("userdashboard.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Signup - Hotel Booking</title>
         <link rel="stylesheet" href="StyleSheets/indexStyle.css"> 
    <link rel="stylesheet" href="StyleSheets/SignUpAndLogin.css">
</head>
<body>

    
    <div class="signup-container">
        <h2>Signup</h2>
        <form action="SignupServlet" method="post">
            <label for="username">Full Name:</label>
            <input type="text" id="username" name="username" required>
            
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="address">Address:</label>
            <input type="text" id="address" name="address" required>
            
            <label for="aadhar">Aadhar Card No:</label>
            <input type="text" id="aadhar" name="aadhar" required>
            
            <label for="mobile">Mobile No:</label>
            <input type="text" id="mobile" name="mobile" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <button type="submit">Signup</button>
        </form>
        <p>Already have an account? <a href="login.jsp">Login here</a></p>
        <p>Go to home Page<a href="index.html">Home</a></p>
    </div>
</body>
</html>