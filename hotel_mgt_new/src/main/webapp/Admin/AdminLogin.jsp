<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpSession" %>
<%
    HttpSession sessionUser = request.getSession(false);
    if (sessionUser != null && sessionUser.getAttribute("user") != null) {
        response.sendRedirect("userdashboard.jsp");
        return;
    }
%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login - Hotel Booking</title>
      <!--  <link rel="stylesheet" href="StyleSheets/indexStyle.css"> -->
                <link rel="stylesheet" href="StyleSheets/SignUpAndLogin.css">
    <link rel="stylesheet" href="styles.css">
</head>
<body>

<!--         <header>
        <nav>
            <div class="logo">HotelBooking
            </div>
            
        <a href="#contact">Contact</a>
		<a href="SignUp.jsp">SignUp</a>
        <a href="index.html">Home</a>
             
        </nav>
    </header> -->
    
    <div class="login-container">
        <h2>Admin Login</h2>
        <form action="http://localhost:8080/hotel_mgt_new/AdminLogin" method="post">
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
            
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
            
            <button type="submit">Login</button>
        </form>
    </div>
</body>
</html>