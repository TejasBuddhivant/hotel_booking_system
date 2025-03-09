<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Dashboard</title>
    <link rel="stylesheet" href="StyleSheets/userdashboard.css">
</head>
<body>
    <%
        HttpSession sessionUser = request.getSession(false);
        if (sessionUser == null || sessionUser.getAttribute("user") == null) {
            response.sendRedirect("index.html");
            return;
        }
        String userEmail = (String) sessionUser.getAttribute("user");
        String userName = "";
        String userMobile = "";
        
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");
            
            String query = "SELECT username, mobile FROM users WHERE email=?";
            ps = con.prepareStatement(query);
            ps.setString(1, userEmail);
            rs = ps.executeQuery();
            
            if (rs.next()) {
                userName = rs.getString("username");
                userMobile = rs.getString("mobile");
                sessionUser.setAttribute("username", userName);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try { if (rs != null) rs.close(); } catch (Exception e) {}
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    %>

    <header>
        <nav>
            <h1>Welcome, <%= userName %>!</h1>
            <div class="logo">HotelBooking</div>
            <a href="logoutServlet">Logout</a>
        </nav>
    </header>

    <div class="cards-container">
        <div class="card">
            <h2>Book a Hotel</h2>
            <p>Find the best hotels at the best prices.</p>
            <a href="#">Book Now</a>
        </div>
    </div>

    <section class="featured-rooms">
        <h2>Featured Rooms</h2>
        <form action="roombooking/bookroom.jsp" method="post">
            <div class="room-list">
                <!-- Room 1 -->
                <div class="room">
                    <img src="images/room3.jpg" alt="Deluxe Room">
                    <h3>Deluxe Room</h3>
                 
                    <button type="submit" name="roomType" value="Deluxe Room" onclick="setRoomSession('Deluxe Room', '100', '101')">$100 Per Night</button>
                </div>

                <!-- Room 2 -->
                <div class="room">
                    <img src="images/room2.jpg" alt="Luxury Suite">
                    <h3>Luxury Suite</h3>
               
                    <button type="submit" name="roomType" value="Luxury Suite" onclick="setRoomSession('Luxury Suite', '200', '202')">$200 Per Night</button>
                </div>
            </div>
        </form>
    </section>

<script src="JavaScripts/dashboardJavaScript.js"></script>

</body>
</html>
