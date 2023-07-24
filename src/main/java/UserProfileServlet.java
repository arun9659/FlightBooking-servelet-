import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UserProfileServlet")
public class UserProfileServlet extends HttpServlet {
  
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        BookingDAO s=new BookingDAO();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        int userId = s.getUserIdByUsername(username);
        if (userId != -1) {
        } else {
            // If the user ID is -1, redirect to the login page
            response.sendRedirect("login.jsp");
            return; // It's a good practice to add a return statement after redirecting.
        }

        try {
            connection = DatabaseConnection.getConnection();

            String query = "SELECT * FROM users WHERE username = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, username);

            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                // Display user profile information
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>User Profile</title>");
                out.println("<style>");
                out.println("body {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    background: rgb(2, 0, 36);");
                out.println("    background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
                out.println("    margin: 0;");
                out.println("    padding: 0;");
                out.println("    display: flex;");
                out.println("    flex-direction: column;"); // Display elements in a column
                out.println("    align-items: center;");
                out.println("    justify-content: center;");
                out.println("    height: 100vh;");
                out.println("}");
                out.println("h1 {");
                out.println("    text-align: center;");
                out.println("    color: blue;");
                out.println("    margin-bottom: 20px;");
                out.println("}");
                out.println("p {");
                out.println("    text-align: center;");
                out.println("    color: white;");
                out.println("}");
                out.println("a {");
                out.println("    display: block;");
                out.println("    text-align: center;");
                out.println("    color: white;");
                out.println("    text-decoration: none;");
                out.println("    padding: 10px;");
                out.println("    margin: 5px;");
                out.println("    border: 1px solid white;");
                out.println("    border-radius: 4px;");
                out.println("    width: 150px;");
                out.println("    background-color: #4CAF50;"); // Set the background color to green
                out.println("}");
                out.println("a:hover {");
                out.println("    background-color: rgba(255, 255, 255, 0.1);");
                out.println("}");
                out.println("@media (max-width: 768px) {"); // Add media query for smaller screens
                out.println("    a {");
                out.println("        width: 100%;"); // Make the links take up the full width
                out.println("    }");
                out.println("}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>User Profile</h1>");
                out.println("<p>Username: " + resultSet.getString("username") + "</p>");
                out.println("<p>Email: " + resultSet.getString("emailid") + "</p>");
                out.println("<a href=\"UpdateProfile.jsp\">Update Profile</a>");
                out.println("<a href=\"UserProfile.jsp\">Back</a>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Redirect to the login page if the user is not found
                response.sendRedirect("login.jsp");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
