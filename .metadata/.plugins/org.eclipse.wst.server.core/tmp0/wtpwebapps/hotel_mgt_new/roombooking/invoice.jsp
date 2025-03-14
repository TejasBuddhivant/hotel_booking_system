<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>
<%@ page import="java.io.*, java.util.*, java.awt.image.BufferedImage" %>


<%
    HttpSession sessionUser = request.getSession();
    String userEmail = (String) sessionUser.getAttribute("user");
    String roomNo = (String) sessionUser.getAttribute("roomNo");
    String roomType = (String) sessionUser.getAttribute("roomType");
    String roomPrice = (String) sessionUser.getAttribute("roomPrice");
    String checkInDate = (String) sessionUser.getAttribute("checkInDate");
    String checkOutDate = (String) sessionUser.getAttribute("checkOutDate");
    String totalCost = (sessionUser.getAttribute("totalCost") != null) ? sessionUser.getAttribute("totalCost").toString() : "0";

    // Database Connection
    String userName = "", aadhaarNo = "";
    
    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");

        // Fetch User Details
        String query = "SELECT username, aadhar FROM users WHERE email = ?";
        ps = con.prepareStatement(query);
        ps.setString(1, userEmail);
        rs = ps.executeQuery();

        if (rs.next()) {
            userName = rs.getString("username");
            aadhaarNo = rs.getString("aadhar");
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        try { if (rs != null) rs.close(); } catch (Exception e) {}
        try { if (ps != null) ps.close(); } catch (Exception e) {}
        try { if (con != null) con.close(); } catch (Exception e) {}
    }

    

%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Hotel Invoice</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: #f4f4f4;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }
        .invoice-container {
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            width: 500px;
            text-align: center;
        }
        h2 {
            color: #333;
        }
        p {
            font-size: 18px;
            margin: 8px 0;
        }
        .highlight {
            font-weight: bold;
            color: #d9534f;
        }
        img {
            margin-top: 10px;
            width: 150px;
            height: 150px;
        }
        button {
            background-color: #28a745;
            color: white;
            border: none;
            padding: 10px 15px;
            font-size: 18px;
            cursor: pointer;
            margin-top: 20px;
            width: 100%;
            border-radius: 5px;
        }
        button:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

    <div class="invoice-container">
        <h2>Reva's Lodging</h2>
        <p><strong>Guest Name:</strong> <%= userName %></p>
        <p><strong>Email:</strong> <%= userEmail %></p>
        <p><strong>Aadhaar No:</strong> <%= aadhaarNo %></p>
        <hr>
        <p><strong>Room No:</strong> <%= roomNo %></p>
        <p><strong>Room Type:</strong> <%= roomType %></p>
        <p><strong>Check-in Date:</strong> <%= checkInDate %></p>
        <p><strong>Check-out Date:</strong> <%= checkOutDate %></p>
        <p><strong>Price Per Night:</strong> $<%= roomPrice %></p>
        <hr>
        <p class="highlight"><strong>Total Amount:</strong> $<%= totalCost %></p>
        <p>Scan the QR code for Payment:</p>
        <img src="tej_g_b_qr.png">
        <button onclick="window.print()">Print Invoice</button>
        <a href="http://localhost:8080/hotel_mgt_new/userdashboard.jsp">home</a>
    </div>

</body>
</html>
