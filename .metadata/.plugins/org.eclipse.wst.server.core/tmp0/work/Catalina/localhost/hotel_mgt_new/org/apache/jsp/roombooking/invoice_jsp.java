/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.95
 * Generated at: 2025-03-11 10:51:34 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.roombooking;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.sql.*;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import java.awt.image.BufferedImage;

public final class invoice_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.LinkedHashSet<>(8);
    _jspx_imports_packages.add("java.sql");
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("java.util");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("java.io");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.LinkedHashSet<>(3);
    _jspx_imports_classes.add("javax.servlet.http.HttpSession");
    _jspx_imports_classes.add("java.awt.image.BufferedImage");
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
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");

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

    


      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("<head>\r\n");
      out.write("    <meta charset=\"UTF-8\">\r\n");
      out.write("    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("    <title>Hotel Invoice</title>\r\n");
      out.write("    <style>\r\n");
      out.write("        body {\r\n");
      out.write("            font-family: Arial, sans-serif;\r\n");
      out.write("            background: #f4f4f4;\r\n");
      out.write("            display: flex;\r\n");
      out.write("            justify-content: center;\r\n");
      out.write("            align-items: center;\r\n");
      out.write("            height: 100vh;\r\n");
      out.write("        }\r\n");
      out.write("        .invoice-container {\r\n");
      out.write("            background: white;\r\n");
      out.write("            padding: 20px;\r\n");
      out.write("            border-radius: 10px;\r\n");
      out.write("            box-shadow: 0px 4px 10px rgba(0, 0, 0, 0.1);\r\n");
      out.write("            width: 500px;\r\n");
      out.write("            text-align: center;\r\n");
      out.write("        }\r\n");
      out.write("        h2 {\r\n");
      out.write("            color: #333;\r\n");
      out.write("        }\r\n");
      out.write("        p {\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("            margin: 8px 0;\r\n");
      out.write("        }\r\n");
      out.write("        .highlight {\r\n");
      out.write("            font-weight: bold;\r\n");
      out.write("            color: #d9534f;\r\n");
      out.write("        }\r\n");
      out.write("        img {\r\n");
      out.write("            margin-top: 10px;\r\n");
      out.write("            width: 150px;\r\n");
      out.write("            height: 150px;\r\n");
      out.write("        }\r\n");
      out.write("        button {\r\n");
      out.write("            background-color: #28a745;\r\n");
      out.write("            color: white;\r\n");
      out.write("            border: none;\r\n");
      out.write("            padding: 10px 15px;\r\n");
      out.write("            font-size: 18px;\r\n");
      out.write("            cursor: pointer;\r\n");
      out.write("            margin-top: 20px;\r\n");
      out.write("            width: 100%;\r\n");
      out.write("            border-radius: 5px;\r\n");
      out.write("        }\r\n");
      out.write("        button:hover {\r\n");
      out.write("            background-color: #218838;\r\n");
      out.write("        }\r\n");
      out.write("    </style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("    <div class=\"invoice-container\">\r\n");
      out.write("        <h2>Reva's Lodging</h2>\r\n");
      out.write("        <p><strong>Guest Name:</strong> ");
      out.print( userName );
      out.write("</p>\r\n");
      out.write("        <p><strong>Email:</strong> ");
      out.print( userEmail );
      out.write("</p>\r\n");
      out.write("        <p><strong>Aadhaar No:</strong> ");
      out.print( aadhaarNo );
      out.write("</p>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <p><strong>Room No:</strong> ");
      out.print( roomNo );
      out.write("</p>\r\n");
      out.write("        <p><strong>Room Type:</strong> ");
      out.print( roomType );
      out.write("</p>\r\n");
      out.write("        <p><strong>Check-in Date:</strong> ");
      out.print( checkInDate );
      out.write("</p>\r\n");
      out.write("        <p><strong>Check-out Date:</strong> ");
      out.print( checkOutDate );
      out.write("</p>\r\n");
      out.write("        <p><strong>Price Per Night:</strong> $");
      out.print( roomPrice );
      out.write("</p>\r\n");
      out.write("        <hr>\r\n");
      out.write("        <p class=\"highlight\"><strong>Total Amount:</strong> $");
      out.print( totalCost );
      out.write("</p>\r\n");
      out.write("        <p>Scan the QR code for Payment:</p>\r\n");
      out.write("        <img src=\"tej_g_b_qr.png\">\r\n");
      out.write("        <button onclick=\"window.print()\">Print Invoice</button>\r\n");
      out.write("        <a href=\"http://localhost:8080/hotel_mgt_new/userdashboard.jsp\">home</a>\r\n");
      out.write("    </div>\r\n");
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
