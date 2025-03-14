<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
    <style>
    
    body {
    font-family: Arial, sans-serif;
    margin: 0;
    padding: 0;
    box-sizing: border-box;
  	background-image: url('https://wallpapers.com/images/high/monkey-d-luffy-wide-smile-iuu9hxoxvbky3yo8.webp');
    background-size: cover; /* Ensures the image covers the entire screen */
    background-repeat: no-repeat; /* Prevents repetition */
    background-position: center center; /* Centers the image */
    background-attachment: fixed;
/*  https://images7.alphacoders.com/135/thumb-1920-1350478.jpeg */
}
        
        table { width: 80%; margin: auto; border-collapse: collapse; }
        th, td { border: 1px solid black; padding: 10px; text-align: left; color: white;}
        th { background-color: #4CAF50; color: white; }
      /*   tr { background-color: #f2f2f2; }  */


        .addemp {
    background: rgba(255, 255, 255, 0.2);
    backdrop-filter: blur(10px);
    padding: 30px;
    border-radius: 15px;
    margin-left:500px;
    box-shadow: 0px 4px 15px rgba(0, 0, 0, 0.2);
    width: 400px;
    text-align: center;
}

/* Form Title */
addemp h2 {
    margin-bottom: 20px;
    font-size: 22px;
    color: #fff;
}

/* Input Fields */
label {
    display: block;
    font-size: 14px;
    margin: 10px 0 5px;
    color: black;
}

input[type="text"],
input[type="email"],
input[type="date"],
input[type="number"],
input[type="radio"] {
    width: 100%;
    padding: 10px;
    border: 2px solid black;
    border-radius: 8px;
    outline: none;
    font-size: 16px;
    background: rgba(255, 255, 255, 0.3);
    color: black;
}

/* Radio Buttons */
input[type="radio"] {
    width: auto;
    margin-right: 10px;
}

/* Input Focus Effect */
input:focus {
    background: rgba(255, 255, 255, 0.5);
    transition: 0.3s;
}

/* Submit Button */
button {
    width: 100%;
    padding: 12px;
    border: none;
    border-radius: 8px;
    background: linear-gradient(45deg, #ff6f61, #de4263);
    color: #fff;
    font-size: 18px;
    cursor: pointer;
    transition: 0.3s;
    margin-top: 15px;
}

/* Button Hover Effect */
button:hover {
    background: linear-gradient(45deg, #de4263, #ff6f61);
    transform: scale(1.05);
}

/* Responsive Design */
@media (max-width: 450px) {
    form {
        width: 90%;
    }
}

/* Navbar */
nav {
    display: flex;
    justify-content: space-between;
    align-items: center;
     background: rgba(255, 255, 255, 0.1);
    backdrop-filter: blur(10px);
    padding: 20px 5%;
   
    color: white;
}

nav .logo {
    font-size: 24px;
    font-weight: bold;
}

nav a {
    list-style: none;
    display: flex;
    gap: 10px;
    font-size: 20px;
}

nav  a {
    text-decoration: none;
    
    color:black;
    transition: 0.3s;
}

nav a:hover {
    color: #f39c12;
}
nav h1{
margin-top:-30px;
margin-bottom:-20px;
}
p{
display:inline;
margin-top:-30px;

font-size: 70px
}
    </style>
</head>
<body>
 <%
        HttpSession sessionUser = request.getSession(false);
        if (sessionUser == null || sessionUser.getAttribute("Admin") == null) {
            response.sendRedirect("AdminLogin.jsp");
            return;
        }
        String userEmail = (String) sessionUser.getAttribute("Admin");
        String userName = "";
        String userMobile = "";



    %>
    <%@ page import="java.sql.*" %>
<%@ page import="javax.servlet.*" %>
<%@ page import="javax.servlet.http.*" %>

<%
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
    
    
%>
<nav>
<h1>Helllow Admin <p claas="emoji">🐵</p></h1>
<h1>Reva's Lodging</h1>
<a href="../AdminlogoutServlet">Logout</a>
</nav>


 <h2 align="center">Employee List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Position</th>
            <th>Salary</th>
            <th>Delete Record</th>
        </tr>

        <%
            if (rs != null) {
                while (rs.next()) {
        %>
        <tr>
            <td><%= rs.getInt("emp_id") %></td> 
            <td><%= rs.getString("first_name") + " " + rs.getString("last_name") %></td>
            <td><%= rs.getString("email") %></td>
            <td><%= rs.getString("phone") %></td>
            <td><%= rs.getString("position") %></td>
            <td>₹<%= rs.getDouble("salary") %></td>
               <td>
                <form action="http://localhost:8080/hotel_mgt_new/DeleteEmployeeServlet" method="post" style="display:inline;">
                    <input type="hidden" name="emp_id" value="<%= rs.getInt("emp_id") %>">
                    <button type="submit" class="delete-btn">Delete</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
                out.println("<tr><td colspan='6'>No data available</td></tr>");
            }
        %>
    </table>

    <%
        // Close resources
        if (rs != null) rs.close();
        if (stmt != null) stmt.close();
        if (conn != null) conn.close();
    %>
    
<br><br><br>
    <form action="http://localhost:8080/hotel_mgt_new/AddEmployeeServlet" method="post" class="addemp">
        <h2>Add New Employee</h2>
        <label>First Name:</label>
        <input type="text" name="first_name" required>

        <label>Last Name:</label>
        <input type="text" name="last_name" required>

        <label>Email:</label>
        <input type="email" name="email" required>

        <label>Phone:</label>
        <input type="text" name="phone" required>
        
        <label>Date of Birth:</label>
        <input type="date" name="dateofbirth" required>
        
        <label>Gender:</label>
        <input type="radio" name="gender" value="male" required>Male
		<input type="radio" name="gender" value="female" required>Female
		
		
        <label>Position:</label>
        <input type="text" name="position" required>

        <label>Salary:</label>
        <input type="number" name="salary" step="0.01" required>

        <label>Hire Date:</label>
        <input type="date" name="hireDate" required>
        
        <label>Address:</label>
        <input type="text" name="address" required>
        
        
        <label>City:</label>
        <input type="text" name="City" required>
        
        <label>state:</label>
        <input type="text" name="State" required>
        
        <label>Zip Code:</label>
        <input type="number" name="zipCode" required>
        
        <label>Country:</label>
        <input type="text" name="Country" required>
        
        <label>emergency contact name:</label>
        <input type="text" name="emergency_contact_name" required>
        
        <label>emergency contact phone:</label>
        <input type="number" name="emergency_contact_phone" required>
        
        <button type="submit" class="btn">Add Employee</button>
    </form>
    
    
<%
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

%>
    <br><br><br><br>
    <h2 align="center">User List</h2>

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Email</th>
            <th>Phone</th>
            <th>Aadhar Card</th>
            <th>Delete Record</th>
        </tr>

        <%
            if (urs != null) {
                while (urs.next()) {
        %>
        <tr>
            <td><%= urs.getInt("id") %></td> 
            <td><%= urs.getString("username")%></td>
            <td><%= urs.getString("email") %></td>
            <td><%= urs.getString("mobile") %></td>
            <td><%= urs.getString("aadhar") %></td>
            
               <td>
                <form action="http://localhost:8080/hotel_mgt_new/DeleteUserServlet" method="post" style="display:inline;">
                    <input type="hidden" name="id" value="<%= urs.getInt("id") %>">
                    <button type="submit" class="delete-btn">Delete</button>
                </form>
            </td>
        </tr>
        <%
                }
            } else {
                out.println("<tr><td colspan='6'>No data available</td></tr>");
            }
        %>
    </table>

    <%
        // Close resources
        if (urs != null) urs.close();
        if (ustmt != null) ustmt.close();
        if (uconn != null) uconn.close();
    %>
</body>
</html>