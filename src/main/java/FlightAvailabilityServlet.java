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

@WebServlet("/FlightAvailabilityServlet")
public class FlightAvailabilityServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String departureCity = request.getParameter("departureCity");
        String destinationCity = request.getParameter("destinationCity");
        String departureDate = request.getParameter("departureDate");

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            connection = DatabaseConnection.getConnection();

            String query = "SELECT * FROM flights WHERE departure_city = ? AND destination_city = ? AND departure_date = ?";
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, departureCity);
            preparedStatement.setString(2, destinationCity);
            preparedStatement.setString(3, departureDate);

            resultSet = preparedStatement.executeQuery();

            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Flight Availability</title>");
            out.println("<style>");
            out.println("body {");
            out.println("  font-family: Arial, sans-serif;");
            out.println("  background: rgb(2, 0, 36);");
            out.println("  background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
            out.println("  margin: 0;");
            out.println("  padding: 0;");
            out.println("  display: flex;");
            out.println("  justify-content: center;");
            out.println("  align-items: center;");
            out.println("  height: 100vh;");
            out.println("}");

            out.println(".container {");
            out.println("  text-align: center;");
            out.println("}");

            out.println("a {");
            out.println("  text-decoration: none;");
            out.println("  color: white;");
            out.println("  background-color: #4CAF50;");
            out.println("  padding: 20px;");
            out.println("  border: 1px solid white;");
            out.println("  border-radius: 4px;");
            out.println("  margin: 5px 0 0 0;");
            out.println("  display: block;");
            out.println("  width: 200px;");
            out.println("  box-sizing: border-box;");
            out.println("  text-align: center;");
            out.println("  margin: 0 auto; /* Center the button horizontally */");
            out.println("}");

            out.println(".container {");
            out.println("  text-align: center;");
            out.println("}");

            out.println("</style>");

            out.println("</head>");
            out.println("<body>");
            out.println("<div class='container'>");
            out.println("<h1>Available Flights</h1><br>");

            // Check if any flights are available
            if (!resultSet.isBeforeFirst()) {
                out.println("<p>No available flights to your destination.</p>");
            } else {
                out.println("<ul>");
                while (resultSet.next()) {
                    out.println("<li>" + resultSet.getString("flight_number") + " - "
                            + resultSet.getString("departure_city") + " to "
                            + resultSet.getString("destination_city") + " on "
                            + resultSet.getString("departure_date") + " ("
                            + resultSet.getInt("available_seats") + " seats available)</li>");
                }
                out.println("</ul>");
            }
            out.println("<br>");
            out.println("<a href='flightAvailability.jsp'>Back</a>");
            out.println("</div>");
            out.println("</body>");
            out.println("</html>");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (resultSet != null)
                    resultSet.close();
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
