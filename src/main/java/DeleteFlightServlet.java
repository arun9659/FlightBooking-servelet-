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

@WebServlet("/DeleteFlightServlet")
public class DeleteFlightServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");
        HttpSession session = request.getSession();
        String admin = (String) session.getAttribute("admin");
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (admin=="arun") {
        try {
            connection = DatabaseConnection.getConnection();

            String deleteQuery = "DELETE FROM flights WHERE flight_number = ?";
            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setString(1, flightNumber);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Flight deleted successfully
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Flight Deleted</title>");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("<style>");
                out.println("body {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    background: rgb(2, 0, 36);");
                out.println("    background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
                out.println("    margin: 0;");
                out.println("    padding: 0;");
                out.println("    display: flex;");
                out.println("    justify-content: center;");
                out.println("    align-items: center;");
                out.println("    min-height: 100vh;");
                out.println("}");
                out.println(".container {");
                out.println("    background-color: #ffffff;");
                out.println("    padding: 20px;");
                out.println("    border-radius: 8px;");
                out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
                out.println("    max-width: 400px;");
                out.println("    width: 100%;");
                out.println("}");
                out.println("h1 {");
                out.println("    text-align: center;");
                out.println("    color: blue;");
                out.println("}");
                out.println("p {");
                out.println("    text-align: center;");
                out.println("}");
                out.println("a.button {");
                out.println("    display: block;");
                out.println("    text-align: center;");
                out.println("    background-color: #4CAF50;");
                out.println("    color: #ffffff;");
                out.println("    border: none;");
                out.println("    padding: 10px 20px;");
                out.println("    border-radius: 4px;");
                out.println("    text-decoration: none;");
                out.println("    cursor: pointer;");
                out.println("    margin-top: 20px;");
                out.println("}");
                out.println("a.button:hover {");
                out.println("    background-color: #45a049;");
                out.println("}");
                out.println("@media (max-width: 600px) {");
                out.println("    .container {");
                out.println("        max-width: 300px;");
                out.println("    }");
                out.println("}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("    <h1>Flight Deleted Successfully</h1>");
                out.println("    <p>Flight " + flightNumber + " has been deleted from the system.</p>");
                out.println("    <a href=\"DeleteFlight.jsp\" class=\"button\">Back</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Failed to delete flight
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Flight Deletion Failed</title>");
                out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
                out.println("<style>");
                out.println("body {");
                out.println("    font-family: Arial, sans-serif;");
                out.println("    background: rgb(2, 0, 36);");
                out.println("    background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
                out.println("    margin: 0;");
                out.println("    padding: 0;");
                out.println("    display: flex;");
                out.println("    justify-content: center;");
                out.println("    align-items: center;");
                out.println("    min-height: 100vh;");
                out.println("}");
                out.println(".container {");
                out.println("    background-color: #ffffff;");
                out.println("    padding: 20px;");
                out.println("    border-radius: 8px;");
                out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
                out.println("    max-width: 400px;");
                out.println("    width: 100%;");
                out.println("}");
                out.println("h1 {");
                out.println("    text-align: center;");
                out.println("    color: blue;");
                out.println("}");
                out.println("p {");
                out.println("    text-align: center;");
                out.println("}");
                out.println("a.button {");
                out.println("    display: block;");
                out.println("    text-align: center;");
                out.println("    background-color: #4CAF50;");
                out.println("    color: #ffffff;");
                out.println("    border: none;");
                out.println("    padding: 10px 20px;");
                out.println("    border-radius: 4px;");
                out.println("    text-decoration: none;");
                out.println("    cursor: pointer;");
                out.println("    margin-top: 20px;");
                out.println("}");
                out.println("a.button:hover {");
                out.println("    background-color: #45a049;");
                out.println("}");
                out.println("@media (max-width: 600px) {");
                out.println("    .container {");
                out.println("        max-width: 300px;");
                out.println("    }");
                out.println("}");
                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class=\"container\">");
                out.println("    <h1>Flight Deletion Failed</h1>");
                out.println("    <p>Failed to delete the flight. Please try again.</p>");
                out.println("    <a href=\"DeleteFlight.jsp\" class=\"button\">Back</a>");
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
            response.sendRedirect("AdminLogin.jsp");
        }
    }
}
