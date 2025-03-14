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
    
    <style type="text/css">
            .dropdown {
            position: relative;
            display: inline-block;
            margin-top:15px
            background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(10px);
        }
.button {
    padding: 15px 25px;
    background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(10px);
    text-decoration: none;
    border: none;
    color: white;
    font-size: 22px;
    cursor: pointer;
    transition: 0.3s;
}

.button:hover {
    background: #0c0c0c;
}
        .dropdown-content {
            display: none;
            position: absolute;
            right: 0;
            background-color: white;
            min-width: 250px;
            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);
            padding: 10px;
            z-index: 0;
            border-radius: 5px;
            color:black;
        }

        .dropdown-content p {
            margin: 5px 0;
            padding: 8px;
            border-bottom: 1px solid #ddd;
        }

        .toggle-btn {
            background-color: #364858;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }

        .toggle-btn:hover {
            background-color: #0c0c0c;
        }
        
		.cancel-btn {
            background-color: #FF0000;
            color: white;
            padding: 10px 15px;
            border: none;
            cursor: pointer;
            border-radius: 5px;
        }
        .cancel-btn:hover {
            background-color: #B20000;
        }
    </style>
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

            // Fetch user details
            String query = "SELECT username, mobile FROM users WHERE email=?";
            ps = con.prepareStatement(query);
            ps.setString(1, userEmail);
            rs = ps.executeQuery();

            if (rs.next()) {
                userName = rs.getString("username");
                userMobile = rs.getString("mobile");
                sessionUser.setAttribute("username", userName);
            }
            
            rs.close();
            ps.close();

            // Fetch booked rooms
            String roomQuery = "SELECT room_name, room_no, room_rate FROM rooms WHERE booked_by=?";
            ps = con.prepareStatement(roomQuery);
            ps.setString(1, userEmail);
            rs = ps.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>
<%
    if (request.getParameter("cancelBooking") != null) {
        String roomNo = request.getParameter("roomNo");
        String cancelQuery = "UPDATE rooms SET booked_by = NULL, check_in_date = NULL, check_out_date = NULL WHERE room_no = ? AND booked_by = ?";
        
        try {
            PreparedStatement cancelStmt = con.prepareStatement(cancelQuery);
            cancelStmt.setString(1, roomNo);
            cancelStmt.setString(2, userEmail);
            int rowsAffected = cancelStmt.executeUpdate();
            cancelStmt.close();
            
            if (rowsAffected > 0) {
                response.sendRedirect("userdashboard.jsp?msg=Reservation Canceled");
                return;
            } else {
                out.println("<script>alert('Failed to cancel reservation');</script>");
            }
        } catch (Exception e) {
            e.printStackTrace();
            out.println("<script>alert('Error: " + e.getMessage() + "');</script>");
        }
    }
%>


    <header>
        <nav>
            <h1>Welcome, <%= userName %>😊</h1>
            <div class="logo">HotelBooking</div>
            <!-- My Room Toggle Button -->
            <div class="dropdown">
                <button class="toggle-btn" onclick="toggleDropdown()">My Room</button>
                <div class="dropdown-content" id="roomDropdown">
    <% 
        boolean hasRooms = false;
        while (rs.next()) { 
            hasRooms = true;
    %>
        <p><strong><%= rs.getString("room_name") %></strong> - Room No: <%= rs.getString("room_no") %> ($<%= rs.getString("room_rate") %> per night)</p>
        <form method="post">
            <input type="hidden" name="roomNo" value="<%= rs.getString("room_no") %>">
            <a href="roombooking/invoice.jsp">View Invoice</a>
            <button type="submit" name="cancelBooking" class="cancel-btn">Cancel Reservation</button>
        </form>
    <% 
        } 
        if (!hasRooms) { 
    %>
        <p>No booked rooms</p>
    <% } %>
</div>

            </div>
            <a href="logoutServlet">Logout</a>
        </nav>
    </header>
<br><br><br><br><br><br><br><br><br><br><br>
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
                 
                    <button type="submit" name="roomType" value="Deluxe Room" class="bookbutton" onclick="setRoomSession('Deluxe Room', '100', '101')">$100 Per Night</button>
                </div>

                <!-- Room 2 -->
                <div class="room">
                    <img src="images/room2.jpg" alt="Luxury Suite">
                    <h3>Luxury Suite</h3>
               
                    <button type="submit" name="roomType" value="Luxury Suite" class="bookbutton" onclick="setRoomSession('Luxury Suite', '200', '202')">$200 Per Night</button>
                </div>
            </div>
            <br>
            <br>
				<div class="room-list">
                <!-- Room 3 -->
                <div class="room">
                    <img src="images/room4.png" alt="Executive Suite">
                    <h3>Executive Suite</h3>
                 
                    <button type="submit" name="roomType" value="Executive Suite" class="bookbutton" onclick="setRoomSession('Executive Suite', '300', '301')">$300 Per Night</button>
                </div>

                <!-- Room 4 -->
                <div class="room">
                    <img src="images/room5.jpg" alt="Presidential Suite">
                    <h3>Presidential Suite</h3>
               
                    <button type="submit" name="roomType" value="Presidential Suite" class="bookbutton" onclick="setRoomSession('Luxury Suite', '500', '401')">$500 Per Night</button>
                </div>
            </div>
            
        </form>
    </section>
    <script>
        function toggleDropdown() {
            var dropdown = document.getElementById("roomDropdown");
            if (dropdown.style.display === "block") {
                dropdown.style.display = "none";
            } else {
                dropdown.style.display = "block";
            }
        }

        // Close dropdown if clicked outside
        window.onclick = function(event) {
            if (!event.target.matches('.toggle-btn')) {
                var dropdown = document.getElementById("roomDropdown");
                if (dropdown.style.display === "block") {
                    dropdown.style.display = "none";
                }
            }
        }
    </script>
<script src="JavaScripts/dashboardJavaScript.js"></script>

</body>
</html>
