import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateProfileServlet")
public class UpdateProfileServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        BookingDAO s=new BookingDAO();
        String newUsername = request.getParameter("newUsername");
        String newPassword = request.getParameter("newPassword");
        String newemailid=request.getParameter("emailid");
        int userId = s.getUserIdByUsername(username);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (userId != -1) {
        
        try {
            connection = DatabaseConnection.getConnection();
            if(newUsername!="" && newPassword!="" && newemailid!="") {
            String updateQuery = "UPDATE users SET username = ?, password = ?,emailid=? WHERE username = ?";
            preparedStatement = connection.prepareStatement(updateQuery);
            preparedStatement.setString(1, newUsername);
            preparedStatement.setString(2, newPassword);
            preparedStatement.setString(3, newemailid);
            preparedStatement.setString(4, username);
            }else if(newUsername!="" && newPassword!="" &&newemailid==""){
            	String updateQuery = "UPDATE users SET username = ?, password = ? WHERE username = ?";
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, newPassword);
                preparedStatement.setString(3, username);
            }else if(newUsername!=""&& newPassword=="" &&newemailid=="") {
            	String updateQuery = "UPDATE users SET username = ? WHERE username = ?";
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, newUsername);
                preparedStatement.setString(2, username);
            }
            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Update successful, redirect to user profile
                session.setAttribute("username", newUsername);
                response.sendRedirect("UserProfileServlet");
            } else {
                // Update failed, display error message
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Update Failed</title>");
                out.println("<style>");
                out.println("body { font-family: Arial, sans-serif; background-color: #f1f1f1; text-align: center; }");
                out.println(".container { max-width: 400px; margin: 0 auto; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2); }");
                out.println("h1 { color: #333; }");
                out.println("p { color: #333; margin-top: 20px; }");
                out.println("a { display: block; margin-top: 20px; text-decoration: none; color: #fff; background-color: #4CAF50; padding: 10px 20px; border-radius: 4px; }");
                out.println("a:hover { background-color: #45a049; }");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("<h1>Update Failed</h1>");
                out.println("<p>Failed to update user profile. Please try again.</p>");
                out.println("<a href=\"UserProfileServlet\">Back to User Profile</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    } else {
        // If the user ID is -1, redirect to login page
        response.sendRedirect("login.jsp");
    }
    }
}
