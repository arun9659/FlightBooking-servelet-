import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/CancelBookingServlet")
public class CancelBookingServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        BookingDAO s = new BookingDAO();   
        int userid=s.getUserIdByUsername(username);
        String flightNumber = request.getParameter("flightNumber");
        int seatno = Integer.parseInt(request.getParameter("seatNumber"));
        int flightId = s.getFlightIdByFlightNumber(flightNumber);
        System.out.println(userid);
        System.out.println(flightNumber);
        System.out.println(flightId);
        System.out.println(username);
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        if (userid != -1) {
        try {
            connection = DatabaseConnection.getConnection();
            
            String deleteQuery ="DELETE FROM bookings WHERE id=? AND flight_id = ? AND user_id=?";

            preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1, seatno);
            preparedStatement.setInt(2, flightId);
            preparedStatement.setInt(3, userid);

            int rowsAffected = preparedStatement.executeUpdate();

            if (rowsAffected > 0) {
                // Increase available seats count
                String updateQuery = "UPDATE flights SET available_seats = available_seats + 1 WHERE flight_number = ?";
                preparedStatement = connection.prepareStatement(updateQuery);
                preparedStatement.setString(1, flightNumber);

                preparedStatement.executeUpdate();

                // Show cancellation confirmation message
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cancellation Confirmation</title>");
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

                out.println("a {");
                out.println("    display: block;");
                out.println("    text-align: center;");
                out.println("    text-decoration: none;");
                out.println("    color: white;");
                out.println("    background-color: #4CAF50;");
                out.println("    padding: 10px 20px;");
                out.println("    border: none;");
                out.println("    border-radius: 4px;");
                out.println("    margin-top: 10px;");
                out.println("}");

                out.println("@media (max-width: 600px) {");
                out.println("    .container {");
                out.println("        max-width: 300px;");
                out.println("    }");
                out.println("}");

                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h1>Cancellation Confirmation</h1>");
                out.println("<p>Your booking for flight " + flightNumber + " and seat number " + seatno + " has been cancelled.</p>");
                out.println("<a href=\"BookingHistory.jsp\">Back to Booking History</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            } else {
                // Show cancellation failed message
                PrintWriter out = response.getWriter();
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Cancellation Failed</title>");
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
                out.println("    color: red;");
                out.println("}");

                out.println("p {");
                out.println("    text-align: center;");
                out.println("}");

                out.println("a {");
                out.println("    display: block;");
                out.println("    text-align: center;");
                out.println("    text-decoration: none;");
                out.println("    color: white;");
                out.println("    background-color: #4CAF50;");
                out.println("    padding: 10px 20px;");
                out.println("    border: none;");
                out.println("    border-radius: 4px;");
                out.println("    margin-top: 10px;");
                out.println("}");

                out.println("@media (max-width: 600px) {");
                out.println("    .container {");
                out.println("        max-width: 300px;");
                out.println("    }");
                out.println("}");

                out.println("</style>");
                out.println("</head>");
                out.println("<body>");
                out.println("<div class='container'>");
                out.println("<h1>Cancellation Failed</h1>");
                out.println("<p>Failed to cancel booking Flightno:"+flightNumber+"And seat"+seatno+"Please try again.</p>");
                out.println("<a href=\"BookingHistory.jsp\">Back to Booking History</a>");
                out.println("</div>");
                out.println("</body>");
                out.println("</html>");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close the database resources
            try {
                if (preparedStatement != null)
                    preparedStatement.close();
                if (connection != null)
                    connection.close();
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
