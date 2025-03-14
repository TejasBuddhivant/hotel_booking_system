package com.Admin;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AddEmployeeServlet")
public class AddEmployeeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String dateOfBirth = request.getParameter("dateofbirth");
        String gender = request.getParameter("gender");
        String position = request.getParameter("position");
        String salary = request.getParameter("salary");
        String hireDate = request.getParameter("hireDate");
        String address = request.getParameter("address");
        String city = request.getParameter("City");
        String state = request.getParameter("State");
        String zipCode = request.getParameter("zipCode");
        String country = request.getParameter("Country");
        String emergencyContactName = request.getParameter("emergency_contact_name");
        String emergencyContactPhone = request.getParameter("emergency_contact_phone");
        
        Connection conn = null;
        PreparedStatement pst = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");
            
            String sql = "INSERT INTO emp (first_name, last_name, email, phone, dob, gender, position, salary, hire_date, address, city, state, zip_code, country, emergency_contact_name, emergency_contact_phone) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(sql);
            
            pst.setString(1, firstName);
            pst.setString(2, lastName);
            pst.setString(3, email);
            pst.setString(4, phone);
            pst.setString(5, dateOfBirth);
            pst.setString(6, gender);
            pst.setString(7, position);
            pst.setString(8, salary);
            pst.setString(9, hireDate);
            pst.setString(10, address);
            pst.setString(11, city);
            pst.setString(12, state);
            pst.setString(13, zipCode);
            pst.setString(14, country);
            pst.setString(15, emergencyContactName);
            pst.setString(16, emergencyContactPhone);
            
            int rowsInserted = pst.executeUpdate();
            if (rowsInserted > 0) {
                response.sendRedirect("Admin/Admindashboard.jsp?success=true");
            } else {
                response.sendRedirect("Admin/Admindashboard.jsp?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("Admin/Admindashboard.jsp?error=true");
        } finally {
            try {
                if (pst != null) pst.close();
                if (conn != null) conn.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
