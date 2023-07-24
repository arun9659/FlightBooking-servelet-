import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/AdminviewUserInformationServlet")
public class AdminviewUserInformationServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	 HttpSession session=request.getSession();
         String adminUsername = (String) session.getAttribute("admin");
         if ("arun".equals(adminUsername)) {
        try {
            Connection connection = DatabaseConnection.getConnection();            
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users");
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>User Information</title>");
            out.println("<style>");
            out.println("body {");
            out.println("  background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
            out.println("  color: #fff;");
            out.println("  text-align: center;"); // Center align the content
            out.println("}");
            out.println("table {");
            out.println("  width: 100%;");
            out.println("  border-collapse: collapse;");
            out.println("  margin-bottom: 20px;");
            out.println("}");
            out.println("th, td {");
            out.println("  border: 1px solid #ddd;");
            out.println("  padding: 8px;");
            out.println("  text-align: center;");
            out.println("}");
            out.println("th {");
            out.println("  text-align: center;"); // Center align the table heading
            out.println("}");
            out.println("#back-link {");
            out.println("  display: inline-block;"); // Display as an inline-block element
            out.println("  padding: 10px 20px;"); // Add padding to the button
            out.println("  background-color: green;"); // Green background color for the button
            out.println("  color: white;"); // White text color for the button
            out.println("  text-decoration: none;"); // Remove underline for the link
            out.println("  border: none;"); // Remove border
            out.println("  border-radius: 5px;"); // Add rounded corners
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h2>User Information</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>UserID</th>");
            out.println("<th>Username</th>");
            out.println("<th>Email</th>");
            out.println("<th>Action</th>");
            out.println("</tr>");
            while (resultSet.next()) {
                int userId = resultSet.getInt("id");
                String username = resultSet.getString("username");
                String email = resultSet.getString("emailid");
                String link = "<a href='AdviewuserflightDetailServlet?userId=" + userId + "'>View Details</a>";
                out.println("<tr>");
                out.println("<td>" + userId + "</td>");
                out.println("<td>" + username + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + link + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
            // Add the back button to Admin.jsp
            out.println("<a href='Admin.jsp' id='back-link'>Back</a>");
            out.println("</body>");
            out.println("</html>");
            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
         }else {
         	response.sendRedirect("AdminLogin.jsp");
         }
    }
}
