/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.95
 * Generated at: 2025-03-11 11:24:54 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.HttpSession;

public final class userdashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(6);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(2);
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>User Dashboard</title>\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"StyleSheets/userdashboard.css\">\r\n");
      out.write("    \r\n");
      out.write("    <style type=\"text/css\">\r\n");
      out.write("            .dropdown {\r\n");
      out.write("            position: relative;\r\n");
      out.write("            display: inline-block;\r\n");
      out.write("            margin-top:15px\r\n");
      out.write("            background: rgba(255, 255, 255, 0.1);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("        }\r\n");
      out.write(".button {\r\n");
      out.write("    padding: 15px 25px;\r\n");
      out.write("    background: rgba(255, 255, 255, 0.1);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    border: none;\r\n");
      out.write("    color: white;\r\n");
      out.write("    font-size: 22px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    transition: 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".button:hover {\r\n");
      out.write("    background: #0c0c0c;\r\n");
      out.write("}\r\n");
      out.write("        .dropdown-content {\r\n");
      out.write("            display: none;\r\n");
      out.write("            position: absolute;\r\n");
      out.write("            right: 0;\r\n");
      out.write("            background-color: white;\r\n");
      out.write("            min-width: 250px;\r\n");
      out.write("            box-shadow: 0px 8px 16px rgba(0, 0, 0, 0.2);\r\n");
      out.write("            padding: 10px;\r\n");
      out.write("            z-index: 0;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("            color:black;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .dropdown-content p {\r\n");
      out.write("            margin: 5px 0;\r\n");
      out.write("            padding: 8px;\r\n");
      out.write("            border-bottom: 1px solid #ddd;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .toggle-btn {\r\n");
      out.write("            background-color: #364858;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        .toggle-btn:hover {\r\n");
      out.write("            background-color: #0c0c0c;\r\n");
      out.write("        }\r\n");
      out.write("        \r\n");
      out.write("		.cancel-btn {\r\n");
      out.write("            background-color: #FF0000;\r\n");
      out.write("            color: white;\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            border: none;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        .cancel-btn:hover {\r\n");
      out.write("            background-color: #B20000;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("    ");

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
    
      out.write('\r');
      out.write('\n');

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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("    <header>\r\n");
      out.write("        <nav>\r\n");
      out.write("            <h1>Welcome, ");
      out.print( userName );
      out.write("😊</h1>\r\n");
      out.write("            <div class=\"logo\">HotelBooking</div>\r\n");
      out.write("            <!-- My Room Toggle Button -->\r\n");
      out.write("            <div class=\"dropdown\">\r\n");
      out.write("                <button class=\"toggle-btn\" onclick=\"toggleDropdown()\">My Room</button>\r\n");
      out.write("                <div class=\"dropdown-content\" id=\"roomDropdown\">\r\n");
      out.write("    ");
 
        boolean hasRooms = false;
        while (rs.next()) { 
            hasRooms = true;
    
      out.write("\r\n");
      out.write("        <p><strong>");
      out.print( rs.getString("room_name") );
      out.write("</strong> - Room No: ");
      out.print( rs.getString("room_no") );
      out.write(' ');
      out.write('(');
      out.write('$');
      out.print( rs.getString("room_rate") );
      out.write(" per night)</p>\r\n");
      out.write("        <form method=\"post\">\r\n");
      out.write("            <input type=\"hidden\" name=\"roomNo\" value=\"");
      out.print( rs.getString("room_no") );
      out.write("\">\r\n");
      out.write("            <a href=\"roombooking/invoice.jsp\">View Invoice</a>\r\n");
      out.write("            <button type=\"submit\" name=\"cancelBooking\" class=\"cancel-btn\">Cancel Reservation</button>\r\n");
      out.write("        </form>\r\n");
      out.write("    ");
 
        } 
        if (!hasRooms) { 
    
      out.write("\r\n");
      out.write("        <p>No booked rooms</p>\r\n");
      out.write("    ");
 } 
      out.write("\r\n");
      out.write("</div>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("            <a href=\"logoutServlet\">Logout</a>\r\n");
      out.write("        </nav>\r\n");
      out.write("    </header>\r\n");
      out.write("<br><br><br><br><br><br><br><br><br><br><br>\r\n");
      out.write("    <div class=\"cards-container\">\r\n");
      out.write("        <div class=\"card\">\r\n");
      out.write("            <h2>Book a Hotel</h2>\r\n");
      out.write("            <p>Find the best hotels at the best prices.</p>\r\n");
      out.write("            <a href=\"#\">Book Now</a>\r\n");
      out.write("        </div>\r\n");
      out.write("    </div>\r\n");
      out.write("\r\n");
      out.write("    <section class=\"featured-rooms\">\r\n");
      out.write("        <h2>Featured Rooms</h2>\r\n");
      out.write("        <form action=\"roombooking/bookroom.jsp\" method=\"post\">\r\n");
      out.write("            <div class=\"room-list\">\r\n");
      out.write("                <!-- Room 1 -->\r\n");
      out.write("                <div class=\"room\">\r\n");
      out.write("                    <img src=\"images/room3.jpg\" alt=\"Deluxe Room\">\r\n");
      out.write("                    <h3>Deluxe Room</h3>\r\n");
      out.write("                 \r\n");
      out.write("                    <button type=\"submit\" name=\"roomType\" value=\"Deluxe Room\" class=\"bookbutton\" onclick=\"setRoomSession('Deluxe Room', '100', '101')\">$100 Per Night</button>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Room 2 -->\r\n");
      out.write("                <div class=\"room\">\r\n");
      out.write("                    <img src=\"images/room2.jpg\" alt=\"Luxury Suite\">\r\n");
      out.write("                    <h3>Luxury Suite</h3>\r\n");
      out.write("               \r\n");
      out.write("                    <button type=\"submit\" name=\"roomType\" value=\"Luxury Suite\" class=\"bookbutton\" onclick=\"setRoomSession('Luxury Suite', '200', '202')\">$200 Per Night</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <br>\r\n");
      out.write("            <br>\r\n");
      out.write("				<div class=\"room-list\">\r\n");
      out.write("                <!-- Room 3 -->\r\n");
      out.write("                <div class=\"room\">\r\n");
      out.write("                    <img src=\"images/room4.png\" alt=\"Executive Suite\">\r\n");
      out.write("                    <h3>Executive Suite</h3>\r\n");
      out.write("                 \r\n");
      out.write("                    <button type=\"submit\" name=\"roomType\" value=\"Executive Suite\" class=\"bookbutton\" onclick=\"setRoomSession('Executive Suite', '300', '301')\">$300 Per Night</button>\r\n");
      out.write("                </div>\r\n");
      out.write("\r\n");
      out.write("                <!-- Room 4 -->\r\n");
      out.write("                <div class=\"room\">\r\n");
      out.write("                    <img src=\"images/room5.jpg\" alt=\"Presidential Suite\">\r\n");
      out.write("                    <h3>Presidential Suite</h3>\r\n");
      out.write("               \r\n");
      out.write("                    <button type=\"submit\" name=\"roomType\" value=\"Presidential Suite\" class=\"bookbutton\" onclick=\"setRoomSession('Luxury Suite', '500', '401')\">$500 Per Night</button>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            \r\n");
      out.write("        </form>\r\n");
      out.write("    </section>\r\n");
      out.write("    <script>\r\n");
      out.write("        function toggleDropdown() {\r\n");
      out.write("            var dropdown = document.getElementById(\"roomDropdown\");\r\n");
      out.write("            if (dropdown.style.display === \"block\") {\r\n");
      out.write("                dropdown.style.display = \"none\";\r\n");
      out.write("            } else {\r\n");
      out.write("                dropdown.style.display = \"block\";\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("\r\n");
      out.write("        // Close dropdown if clicked outside\r\n");
      out.write("        window.onclick = function(event) {\r\n");
      out.write("            if (!event.target.matches('.toggle-btn')) {\r\n");
      out.write("                var dropdown = document.getElementById(\"roomDropdown\");\r\n");
      out.write("                if (dropdown.style.display === \"block\") {\r\n");
      out.write("                    dropdown.style.display = \"none\";\r\n");
      out.write("                }\r\n");
      out.write("            }\r\n");
      out.write("        }\r\n");
      out.write("    </script>\r\n");
      out.write("<script src=\"JavaScripts/dashboardJavaScript.js\"></script>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>\r\n");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
