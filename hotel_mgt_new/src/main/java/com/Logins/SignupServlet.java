package com.Logins;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SignupServlet")
public class SignupServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String aadhar = request.getParameter("aadhar");
        String mobile = request.getParameter("mobile");
        String password = request.getParameter("password");
        
        Connection con = null;
        PreparedStatement ps = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_booking", "root", "Tejas@412301");
            
            String query = "INSERT INTO users (username, email, address, aadhar,mobile, password) VALUES (?, ?, ?, ?, ?, ?)";
            ps = con.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, address);
            ps.setString(4, aadhar);
            ps.setString(5, mobile);
            ps.setString(6, password);
            
            int rowsInserted = ps.executeUpdate();
            
            if (rowsInserted > 0) {
                HttpSession session = request.getSession();
                session.setAttribute("user", email);
                response.sendRedirect("userdashboard.jsp"); // Redirect to user dashboard
            } else {
                out.println("<script type='text/javascript'>");
                out.println("alert('Signup failed! Please try again.');");
                out.println("location='signup.jsp';");
                out.println("</script>");
            }
        } catch (Exception e) {
        	   e.printStackTrace();
        	    out.println("Error: " + e.getMessage());
        } finally {
            try { if (ps != null) ps.close(); } catch (Exception e) {}
            try { if (con != null) con.close(); } catch (Exception e) {}
        }
    }
}
