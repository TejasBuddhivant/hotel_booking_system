<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*, java.time.LocalDate, java.time.temporal.ChronoUnit" %>
<%@ page import="javax.servlet.http.HttpSession" %>

<%
    HttpSession sessionUser = request.getSession(false);
    if (sessionUser == null || sessionUser.getAttribute("username") == null) {
        response.sendRedirect("login.jsp");
        return;
    }

    String username = (String) sessionUser.getAttribute("username");
    String roomNo = request.getParameter("roomNo");
    String roomType = request.getParameter("roomType");
    String roomPrice = request.getParameter("roomPrice");
    String checkInDate = request.getParameter("checkInDate");
    String checkOutDate = request.getParameter("checkOutDate");

    LocalDate checkIn = LocalDate.parse(checkInDate);
    LocalDate checkOut = LocalDate.parse(checkOutDate);
    long totalDays = ChronoUnit.DAYS.between(checkIn, checkOut);

    // Validate that check-out is after check-in
    if (totalDays <= 0) {
        out.println("<script>alert('Invalid dates! Check-out must be after Check-in.'); window.location='bookroom.jsp';</script>");
        return;
    }

    double roomPriceDouble = Double.parseDouble(roomPrice);
    int totalCost = (int) (roomPriceDouble * totalDays);

    Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    boolean bookingSuccess = false;

    try {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");

        // Check if room is still available
        String checkQuery = "SELECT booked_by FROM rooms WHERE room_no = ? AND booked_by IS NULL";
        ps = con.prepareStatement(checkQuery);
        ps.setString(1, roomNo);
        rs = ps.executeQuery();

        if (rs.next()) { // Room is available
            rs.close();
            ps.close();

            // Update booking details
            String updateQuery = "UPDATE rooms SET booked_by = ?, check_in_date = ?, check_out_date = ? WHERE room_no = ?";
            ps = con.prepareStatement(updateQuery);
            ps.setString(1, username);
            ps.setString(2, checkInDate);
            ps.setString(3, checkOutDate);
            ps.setString(4, roomNo);

            int rowsUpdated = ps.executeUpdate();
            if (rowsUpdated > 0) {
                bookingSuccess = true;
            }
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
    <title>Booking Confirmation</title>
</head>
<body>
    <div>
        <% if (bookingSuccess) { %>
            <h2>Booking Confirmed!</h2>
            <p>Customer Name: <%= username %></p>
            <p>Room Type: <%= roomType %></p>
            <p>Room No: <%= roomNo %></p>
            <p>Total Cost: $<%= totalCost %></p>
        <% } else { %>
            <h2 style="color: red;">Booking Failed! Room may not be available.</h2>
        <% } %>
    </div>
</body>
</html>
