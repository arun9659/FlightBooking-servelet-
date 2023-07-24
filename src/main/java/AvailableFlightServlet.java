

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

/**
 * Servlet implementation class AvailableFlightServlet
 */
@WebServlet("/AvailableFlightServlet")
public class AvailableFlightServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
	    // Check if the user is logged in as admin
	    HttpSession session = request.getSession();
	    String adminUsername = (String) session.getAttribute("admin");
	    if ("arun".equals(adminUsername)) { 
	    	 try (Connection connection = DatabaseConnection.getConnection();
		             PreparedStatement statement = connection.prepareStatement(
		                     "SELECT id, flight_number, departure_city, destination_city, departure_date, available_seats FROM flights");
		             ResultSet resultSet = statement.executeQuery()) {

	    		 response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                out.println("<!DOCTYPE html>");
	                out.println("<html>");
	                out.println("<head>");
	                out.println("<title>Booking History</title>");
	                out.println("<style>");
	                out.println("body {");
	                out.println("    color: white;");
	                out.println("    font-family: Arial, sans-serif;");
	                out.println("    margin: 0;");
	                out.println("    padding: 0;");
	                out.println("    background: rgb(2, 0, 36);");
	                out.println("    background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
	                out.println("}");
	                out.println("a.back-button {");
	                out.println("    text-decoration: none;");
	                out.println("    color: white;");
	                out.println("    background-color: #4CAF50;");
	                out.println("    padding: 10px 20px;");
	                out.println("    border: 1px solid white;");
	                out.println("    border-radius: 4px;");
	                out.println("    margin: 10px auto;");
	                out.println("    display: flex;"); // Use flexbox to center the content
	                out.println("    justify-content: center;"); // Horizontally center the content
	                out.println("    align-items: center;"); // Vertically center the content
	                out.println("    width: 50px;");
	                out.println("    height: 15px;");
	                out.println("}");
	                out.println("a.back-button:hover {");
	                out.println("    background-color: rgba(255, 255, 255, 0.1);");
	                out.println("}");
	                out.println("table {");
	                out.println("    width: 100%;");
	                out.println("    border-collapse: collapse;");
	                out.println("    margin-bottom: 20px;");
	                out.println("}");
	                out.println("th, td {");
	                out.println("    padding: 8px;");
	                out.println("    text-align: left;");
	                out.println("    border-bottom: 1px solid #ddd;");
	                out.println("}");
	                out.println("th {");
	                out.println("    color: red;");
	                out.println("}");
	                out.println("</style>");


	                out.println("</head>");
	                out.println("<body>");
	                out.println("<h1 style=text-align:center;color:white;>Flights Available</h1>");
	                out.println("<table>");
	                out.println("<tr><th>FlightId</th><th>Flight Number</th><th>Departure City</th><th>Destination City</th><th>Departure Date</th></tr>");
	                while (resultSet.next()) {
	                    out.println("<tr>");
	                    out.println("<td>" + resultSet.getString("id") + "</td>");
	                    out.println("<td>" + resultSet.getString("flight_number") + "</td>");
	                    out.println("<td>" + resultSet.getString("departure_city") + "</td>");
	                    out.println("<td>" + resultSet.getString("destination_city") + "</td>");
	                    out.println("<td>" + resultSet.getString("departure_date") + "</td>");
	                    out.println("</tr>");
	                }
	                out.println("</table>");
	                out.println("<a class=\"back-button\" href=\"AdminDashboard.jsp\">Back</a>"); 
	                out.println("</body>");

	                out.println("</html>");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	    } else {
	        response.sendRedirect("AdminLogin.jsp");
	    }
	}


}
