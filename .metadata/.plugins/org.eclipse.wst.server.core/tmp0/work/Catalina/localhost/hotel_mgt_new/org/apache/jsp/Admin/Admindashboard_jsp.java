/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.95
 * Generated at: 2025-03-14 07:10:25 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.Admin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public final class Admindashboard_jsp extends org.apache.jasper.runtime.HttpJspBase
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
    _jspx_imports_classes = null;
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
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("    <style>\r\n");
      out.write("    \r\n");
      out.write("    body {\r\n");
      out.write("    font-family: Arial, sans-serif;\r\n");
      out.write("    margin: 0;\r\n");
      out.write("    padding: 0;\r\n");
      out.write("    box-sizing: border-box;\r\n");
      out.write("  	background-image: url('https://wallpapers.com/images/high/monkey-d-luffy-wide-smile-iuu9hxoxvbky3yo8.webp');\r\n");
      out.write("    background-size: cover; /* Ensures the image covers the entire screen */\r\n");
      out.write("    background-repeat: no-repeat; /* Prevents repetition */\r\n");
      out.write("    background-position: center center; /* Centers the image */\r\n");
      out.write("    background-attachment: fixed;\r\n");
      out.write("/*  https://images7.alphacoders.com/135/thumb-1920-1350478.jpeg */\r\n");
      out.write("}\r\n");
      out.write("        \r\n");
      out.write("        table { width: 80%; margin: auto; border-collapse: collapse; }\r\n");
      out.write("        th, td { border: 1px solid black; padding: 10px; text-align: left; color: white;}\r\n");
      out.write("        th { background-color: #4CAF50; color: white; }\r\n");
      out.write("      /*   tr { background-color: #f2f2f2; }  */\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("        .addemp {\r\n");
      out.write("    background: rgba(255, 255, 255, 0.2);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    padding: 30px;\r\n");
      out.write("    border-radius: 15px;\r\n");
      out.write("    margin-left:500px;\r\n");
      out.write("    box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);\r\n");
      out.write("    width: 400px;\r\n");
      out.write("    text-align: center;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Form Title */\r\n");
      out.write("addemp h2 {\r\n");
      out.write("    margin-bottom: 20px;\r\n");
      out.write("    font-size: 22px;\r\n");
      out.write("    color: #fff;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Input Fields */\r\n");
      out.write("label {\r\n");
      out.write("    display: block;\r\n");
      out.write("    font-size: 14px;\r\n");
      out.write("    margin: 10px 0 5px;\r\n");
      out.write("    color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("input[type=\"text\"],\r\n");
      out.write("input[type=\"email\"],\r\n");
      out.write("input[type=\"date\"],\r\n");
      out.write("input[type=\"number\"],\r\n");
      out.write("input[type=\"radio\"] {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 10px;\r\n");
      out.write("    border: 2px solid black;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    outline: none;\r\n");
      out.write("    font-size: 16px;\r\n");
      out.write("    background: rgba(255, 255, 255, 0.3);\r\n");
      out.write("    color: black;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Radio Buttons */\r\n");
      out.write("input[type=\"radio\"] {\r\n");
      out.write("    width: auto;\r\n");
      out.write("    margin-right: 10px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Input Focus Effect */\r\n");
      out.write("input:focus {\r\n");
      out.write("    background: rgba(255, 255, 255, 0.5);\r\n");
      out.write("    transition: 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Submit Button */\r\n");
      out.write("button {\r\n");
      out.write("    width: 100%;\r\n");
      out.write("    padding: 12px;\r\n");
      out.write("    border: none;\r\n");
      out.write("    border-radius: 8px;\r\n");
      out.write("    background: linear-gradient(45deg, #ff6f61, #de4263);\r\n");
      out.write("    color: #fff;\r\n");
      out.write("    font-size: 18px;\r\n");
      out.write("    cursor: pointer;\r\n");
      out.write("    transition: 0.3s;\r\n");
      out.write("    margin-top: 15px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Button Hover Effect */\r\n");
      out.write("button:hover {\r\n");
      out.write("    background: linear-gradient(45deg, #de4263, #ff6f61);\r\n");
      out.write("    transform: scale(1.05);\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Responsive Design */\r\n");
      out.write("@media (max-width: 450px) {\r\n");
      out.write("    form {\r\n");
      out.write("        width: 90%;\r\n");
      out.write("    }\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("/* Navbar */\r\n");
      out.write("nav {\r\n");
      out.write("    display: flex;\r\n");
      out.write("    justify-content: space-between;\r\n");
      out.write("    align-items: center;\r\n");
      out.write("     background: rgba(255, 255, 255, 0.1);\r\n");
      out.write("    backdrop-filter: blur(10px);\r\n");
      out.write("    padding: 20px 5%;\r\n");
      out.write("   \r\n");
      out.write("    color: white;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav .logo {\r\n");
      out.write("    font-size: 24px;\r\n");
      out.write("    font-weight: bold;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav a {\r\n");
      out.write("    list-style: none;\r\n");
      out.write("    display: flex;\r\n");
      out.write("    gap: 10px;\r\n");
      out.write("    font-size: 20px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav  a {\r\n");
      out.write("    text-decoration: none;\r\n");
      out.write("    \r\n");
      out.write("    color:black;\r\n");
      out.write("    transition: 0.3s;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("nav a:hover {\r\n");
      out.write("    color: #f39c12;\r\n");
      out.write("}\r\n");
      out.write("nav h1{\r\n");
      out.write("margin-top:-30px;\r\n");
      out.write("margin-bottom:-20px;\r\n");
      out.write("}\r\n");
      out.write("p{\r\n");
      out.write("display:inline;\r\n");
      out.write("margin-top:-30px;\r\n");
      out.write("\r\n");
      out.write("font-size: 70px\r\n");
      out.write("}\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write(" ");

        HttpSession sessionUser = request.getSession(false);
        if (sessionUser == null || sessionUser.getAttribute("Admin") == null) {
            response.sendRedirect("AdminLogin.jsp");
            return;
        }
        String userEmail = (String) sessionUser.getAttribute("Admin");
        String userName = "";
        String userMobile = "";



    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

    // Database connection settings
    String dbURL = "jdbc:mysql://localhost:3306/hotel_booking"; // Replace with your DB name
    String dbUser = "root"; // Replace with your DB user
    String dbPass = "Tejas@412301"; // Replace with your DB password

    Connection conn = null;
    Statement stmt = null;
    ResultSet rs = null;

    try {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        // Establish Connection
        conn = DriverManager.getConnection(dbURL, dbUser, dbPass);
        stmt = conn.createStatement();

        // SQL Query to Fetch Data from 'emp' Table
        String sql = "SELECT * FROM emp";
        rs = stmt.executeQuery(sql);
    } catch (Exception e) {
        out.println("Database Connection Error: " + e.getMessage());
    }
    
    

      out.write("\r\n");
      out.write("<nav>\r\n");
      out.write("<h1>Helllow Admin <p claas=\"emoji\">🐵</p></h1>\r\n");
      out.write("<a href=\"../AdminlogoutServlet\">Logout</a>\r\n");
      out.write("</nav>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" <h2 align=\"center\">Employee List</h2>\r\n");
      out.write("\r\n");
      out.write("    <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>ID</th>\r\n");
      out.write("            <th>Name</th>\r\n");
      out.write("            <th>Email</th>\r\n");
      out.write("            <th>Phone</th>\r\n");
      out.write("            <th>Position</th>\r\n");
      out.write("            <th>Salary</th>\r\n");
      out.write("            <th>Delete Record</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        ");

            if (rs != null) {
                while (rs.next()) {
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print( rs.getInt("emp_id") );
      out.write("</td> \r\n");
      out.write("            <td>");
      out.print( rs.getString("first_name") + " " + rs.getString("last_name") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getString("email") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getString("phone") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( rs.getString("position") );
      out.write("</td>\r\n");
      out.write("            <td>₹");
      out.print( rs.getDouble("salary") );
      out.write("</td>\r\n");
      out.write("               <td>\r\n");
      out.write("                <form action=\"http://localhost:8080/hotel_mgt_new/DeleteEmployeeServlet\" method=\"post\" style=\"display:inline;\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"emp_id\" value=\"");
      out.print( rs.getInt("emp_id") );
      out.write("\">\r\n");
      out.write("                    <button type=\"submit\" class=\"delete-btn\">Delete</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

                }
            } else {
                out.println("<tr><td colspan='6'>No data available</td></tr>");
            }
        
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    ");

        // Close resources
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    
      out.write("\r\n");
      out.write("    \r\n");
      out.write("<br><br><br>\r\n");
      out.write("    <form action=\"http://localhost:8080/hotel_mgt_new/AddEmployeeServlet\" method=\"post\" class=\"addemp\">\r\n");
      out.write("        <h2>Add New Employee</h2>\r\n");
      out.write("        <label>First Name:</label>\r\n");
      out.write("        <input type=\"text\" name=\"first_name\" required>\r\n");
      out.write("\r\n");
      out.write("        <label>Last Name:</label>\r\n");
      out.write("        <input type=\"text\" name=\"last_name\" required>\r\n");
      out.write("\r\n");
      out.write("        <label>Email:</label>\r\n");
      out.write("        <input type=\"email\" name=\"email\" required>\r\n");
      out.write("\r\n");
      out.write("        <label>Phone:</label>\r\n");
      out.write("        <input type=\"text\" name=\"phone\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>Date of Birth:</label>\r\n");
      out.write("        <input type=\"date\" name=\"dateofbirth\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>Gender:</label>\r\n");
      out.write("        <input type=\"radio\" name=\"gender\" value=\"male\" required>Male\r\n");
      out.write("		<input type=\"radio\" name=\"gender\" value=\"female\" required>Female\r\n");
      out.write("		\r\n");
      out.write("		\r\n");
      out.write("        <label>Position:</label>\r\n");
      out.write("        <input type=\"text\" name=\"position\" required>\r\n");
      out.write("\r\n");
      out.write("        <label>Salary:</label>\r\n");
      out.write("        <input type=\"number\" name=\"salary\" step=\"0.01\" required>\r\n");
      out.write("\r\n");
      out.write("        <label>Hire Date:</label>\r\n");
      out.write("        <input type=\"date\" name=\"hireDate\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>Address:</label>\r\n");
      out.write("        <input type=\"text\" name=\"address\" required>\r\n");
      out.write("        \r\n");
      out.write("        \r\n");
      out.write("        <label>City:</label>\r\n");
      out.write("        <input type=\"text\" name=\"City\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>state:</label>\r\n");
      out.write("        <input type=\"text\" name=\"State\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>Zip Code:</label>\r\n");
      out.write("        <input type=\"number\" name=\"zipCode\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>Country:</label>\r\n");
      out.write("        <input type=\"text\" name=\"Country\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>emergency contact name:</label>\r\n");
      out.write("        <input type=\"text\" name=\"emergency_contact_name\" required>\r\n");
      out.write("        \r\n");
      out.write("        <label>emergency contact phone:</label>\r\n");
      out.write("        <input type=\"number\" name=\"emergency_contact_phone\" required>\r\n");
      out.write("        \r\n");
      out.write("        <button type=\"submit\" class=\"btn\">Add Employee</button>\r\n");
      out.write("    </form>\r\n");
      out.write("    \r\n");
      out.write("    \r\n");

Connection uconn = null;
Statement ustmt = null;
ResultSet urs = null;

try {
    // Load MySQL JDBC Driver
    Class.forName("com.mysql.cj.jdbc.Driver");

    // Establish Connection
    uconn = DriverManager.getConnection(dbURL, dbUser, dbPass);
    ustmt = uconn.createStatement();

    // SQL Query to Fetch Data from 'emp' Table
    String sql = "SELECT * FROM users";
    urs = ustmt.executeQuery(sql);
} catch (Exception e) {
    out.println("Database Connection Error: " + e.getMessage());
}


      out.write("\r\n");
      out.write("    <br><br><br><br>\r\n");
      out.write("    <h2 align=\"center\">User List</h2>\r\n");
      out.write("\r\n");
      out.write("    <table>\r\n");
      out.write("        <tr>\r\n");
      out.write("            <th>ID</th>\r\n");
      out.write("            <th>Name</th>\r\n");
      out.write("            <th>Email</th>\r\n");
      out.write("            <th>Phone</th>\r\n");
      out.write("            <th>Aadhar Card</th>\r\n");
      out.write("            <th>Delete Record</th>\r\n");
      out.write("        </tr>\r\n");
      out.write("\r\n");
      out.write("        ");

            if (urs != null) {
                while (urs.next()) {
        
      out.write("\r\n");
      out.write("        <tr>\r\n");
      out.write("            <td>");
      out.print( urs.getInt("id") );
      out.write("</td> \r\n");
      out.write("            <td>");
      out.print( urs.getString("username"));
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( urs.getString("email") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( urs.getString("mobile") );
      out.write("</td>\r\n");
      out.write("            <td>");
      out.print( urs.getString("aadhar") );
      out.write("</td>\r\n");
      out.write("            \r\n");
      out.write("               <td>\r\n");
      out.write("                <form action=\"http://localhost:8080/hotel_mgt_new/DeleteUserServlet\" method=\"post\" style=\"display:inline;\">\r\n");
      out.write("                    <input type=\"hidden\" name=\"id\" value=\"");
      out.print( urs.getInt("id") );
      out.write("\">\r\n");
      out.write("                    <button type=\"submit\" class=\"delete-btn\">Delete</button>\r\n");
      out.write("                </form>\r\n");
      out.write("            </td>\r\n");
      out.write("        </tr>\r\n");
      out.write("        ");

                }
            } else {
                out.println("<tr><td colspan='6'>No data available</td></tr>");
            }
        
      out.write("\r\n");
      out.write("    </table>\r\n");
      out.write("\r\n");
      out.write("    ");

        // Close resources
        if (urs != null) urs.close();
        if (ustmt != null) ustmt.close();
        if (uconn != null) uconn.close();
    
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
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
