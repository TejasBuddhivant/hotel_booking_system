<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Book Room</title>
    <link rel="stylesheet" href="StyleSheets/bookroom.css">
</head>
<body>

<%
    HttpSession sessionBook = request.getSession(false);
    if (sessionBook == null || sessionBook.getAttribute("user") == null) {
        response.sendRedirect("../index.html");
        return;
    }

    String userEmail = (String) sessionBook.getAttribute("user");
    String roomType = (String) sessionBook.getAttribute("roomType");

    String roomNo = "";
    String roomPrice = "";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");

        // Fetch room details based on session room type
        String query = "SELECT room_no, room_rate FROM rooms WHERE room_name = ? LIMIT 1";
        ps = con.prepareStatement(query);
        ps.setString(1, roomType);
        rs = ps.executeQuery();

        if (rs.next()) {
            roomNo = rs.getString("room_no");
            roomPrice = rs.getString("room_rate");

            // Store room details in session
            sessionBook.setAttribute("roomNo", roomNo);
            sessionBook.setAttribute("roomPrice", roomPrice);
        } else {
            roomNo = "Not Available";
            roomPrice = "N/A";
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
        <h1>Book Your Room</h1>
        <a href="userdashboard.jsp">Back to Dashboard</a>
    </nav>
</header>

<div class="booking-info">
    <h2>Room Details</h2>
    <p><strong>Room Type:</strong> <%= roomType %></p>
    <p><strong>Room No:</strong> <%= roomNo %></p>
    <p><strong>Price:</strong> $<%= roomPrice %> Per Night</p>
</div>

</body>
</html>
