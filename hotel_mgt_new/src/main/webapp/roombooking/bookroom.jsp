<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession(true);
    String roomType = request.getParameter("roomType");

    if (roomType != null) {
        sessionUser.setAttribute("roomType", roomType);
    } else {
        roomType = (String) sessionUser.getAttribute("roomType");
    }

    String roomNo = "";
    String roomPrice = "";

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");

        // Get an available room
        String query = "SELECT room_no, room_rate FROM rooms WHERE room_name = ? AND booked_by IS NULL LIMIT 1";
        ps = con.prepareStatement(query);
        ps.setString(1, roomType);
        rs = ps.executeQuery();

        if (rs.next()) {
            roomNo = rs.getString("room_no");
            roomPrice = rs.getString("room_rate");
            sessionUser.setAttribute("roomNo", roomNo);
            sessionUser.setAttribute("roomPrice", roomPrice);
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
    <title>Book Room</title>
    <link rel="stylesheet" href="StyleSheets/bookroom.css">
    <style type="text/css">
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
            background-color: #f4f4f4;
        }

        .container {
            display: flex;
            background: white;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);
            max-width: 800px;
            width: 100%;
        }

        .image-container img {
            max-width: 300px;
            border-radius: 10px;
        }

        .details-container {
            flex: 1;
            padding-left: 20px;
        }

        h2 {
            font-size: 28px;
            margin-bottom: 20px;
        }

        p {
            font-size: 20px;
            margin: 10px 0;
        }

        input[type="date"] {
            font-size: 18px;
            padding: 8px;
            margin-bottom: 10px;
            width: 100%;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        button {
            padding: 10px 15px;
            font-size: 18px;
            background-color: #28a745;
            color: white;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            width: 100%;
        }

        button:hover {
            background-color: #218838;
        }

        .total-cost {
            font-size: 22px;
            font-weight: bold;
            color: #d9534f;
            margin-top: 10px;
        }
    </style>
</head>

</head>
<body>

    <div class="container">
        <div class="image-container">
            <img src="https://cdn.pixabay.com/photo/2016/11/19/00/32/boy-1837466_1280.png" alt="Deluxe Room">
        </div>
        <div class="details-container">
            <h2>Room Booking Details</h2>
            <p><strong>Room Type:</strong> <%= roomType %></p>
            <p><strong>Room No:</strong> <%= roomNo %></p>
            <p><strong>Price Per Night:</strong> $<%= roomPrice %></p>

            <form action="http://localhost:8080/hotel_mgt_new/confirmBooking" method="post">
                <input type="hidden" name="roomNo" value="<%= roomNo %>">
                <input type="hidden" name="roomType" value="<%= roomType %>">
                <input type="hidden" name="roomPrice" value="<%= roomPrice %>">

                <label for="checkInDate"><strong>Check-in Date:</strong></label>
                <input type="date" id="checkInDate" name="checkInDate" required onchange="calculateTotalCost()">

                <label for="checkOutDate"><strong>Check-out Date:</strong></label>
                <input type="date" id="checkOutDate" name="checkOutDate" required onchange="calculateTotalCost()">

                <p class="total-cost">Total Cost: $<span id="totalCost">0</span></p>

                <button type="submit">Confirm Booking</button>
            </form>
        </div>
    </div> 
    <script>
        function calculateTotalCost() {
            const checkInDate = new Date(document.getElementById("checkInDate").value);
            const checkOutDate = new Date(document.getElementById("checkOutDate").value);
            const roomPrice = parseFloat("<%= roomPrice %>");

            if (!isNaN(checkInDate.getTime()) && !isNaN(checkOutDate.getTime()) && checkOutDate > checkInDate) {
                const timeDiff = checkOutDate.getTime() - checkInDate.getTime();
                const daysDiff = Math.ceil(timeDiff / (1000 * 3600 * 24));
                const totalCost = daysDiff * roomPrice;
                document.getElementById("totalCost").innerText = totalCost.toFixed(2);
            } else {
                document.getElementById("totalCost").innerText = "0";
            }
        }
    </script>
</body>
</html>
