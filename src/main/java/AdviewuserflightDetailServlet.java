import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdviewuserflightDetailServlet")
public class AdviewuserflightDetailServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	int userid= Integer.parseInt(request.getParameter("userId"));
    	int flightId =getFlightid(userid); 
        HttpSession session=request.getSession();
        String adminUsername = (String) session.getAttribute("admin");
        if ("arun".equals(adminUsername)) {
        if(flightId >0) {
        try {
            Connection connection = DatabaseConnection.getConnection();
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM flights WHERE id=?");
            statement.setInt(1, flightId);
            ResultSet resultSet = statement.executeQuery();
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Flight Detail</title>");
            out.println("<style>");
            out.println("body {");
            out.println("  background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
            out.println("  color: #fff;");
            out.println("  text-align: center;");
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
            out.println("  background-color: none;");
            out.println("color:black;");
            out.println("  text-align: center;");
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
            out.println("<h2>Flight Detail</h2>");
            out.println("<table>");
            out.println("<tr>");
            out.println("<th>Flight Number</th>");
            out.println("<th>Departure City</th>");
            out.println("<th>Destination City</th>");
            out.println("<th>Departure Date</th>");
            out.println("<th>Available Seats</th>");
            out.println("</tr>");
            while (resultSet.next()) {
                String flightNumber = resultSet.getString("flight_number");
                String departureCity = resultSet.getString("departure_city");
                String destinationCity = resultSet.getString("destination_city");
                Date departureDate = resultSet.getDate("departure_date");
                int availableSeats = resultSet.getInt("available_seats");
                
                out.println("<tr>");
                out.println("<td>" + flightNumber + "</td>");
                out.println("<td>" + departureCity + "</td>");
                out.println("<td>" + destinationCity + "</td>");
                out.println("<td>" + departureDate + "</td>");
                out.println("<td>" + availableSeats + "</td>");
                out.println("</tr>");
            }
            out.println("</table>");
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
        	response.sendRedirect("AdminviewUserInformationServlet");
        }
        }else {
        	response.sendRedirect("AdminLogin.jsp");
        }
    }
    private int getFlightid(int userid) {
        int flightid=-1;
        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT flight_id FROM bookings WHERE user_id = ?")) {

            statement.setInt(1, userid);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                     flightid = resultSet.getInt("flight_id");
                                   
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightid;
    }

}
