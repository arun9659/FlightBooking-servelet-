import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.protocol.Resultset;

@WebServlet("/FlightBookingServlet")
public class FlightBookingServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String departureCity = request.getParameter("departureCity");
        String destinationCity = request.getParameter("destinationCity");
        String departureDate = request.getParameter("departureDate");

        // Assuming you have a method to get the flight_id from the database based on the selected cities and date
        int flightId = getFlightIdFromDatabase(departureCity, destinationCity, departureDate);

        if (flightId != -1) {
            // If the flight is available, book the ticket
            HttpSession session = request.getSession();
            String username = (String) session.getAttribute("username"); // Assuming you have set the username in the session during login

            // Assuming you have a method to get the user_id from the database based on the username
            int userId = getUserIdFromDatabase(username);

            if (userId != -1) {
                // If the user is logged in and their ID is valid
                Date bookingDate = new Date(); // Current date

                // Fetch flight details from the database based on the flightId
                Flight flight = getFlightDetailsFromDatabase(flightId);

                // Save the booking details to the database
                boolean bookingSuccess = saveBookingToDatabase(userId, flightId, bookingDate);
                boolean  b=decreaseAvailableSeats(flightId);
                if (bookingSuccess&&b) {
                    // Booking successful, show confirmation message
                	int flightnumber=getFlightNumberinbookings(flightId);
                    request.setAttribute("flightNumber", flightnumber);
                    // Check if the user selected a seat or not
                    int seatno=getseatnumber(flightId);
                    request.setAttribute("selectedSeat", seatno);
                    if (seatno == 0 ) {
                        request.setAttribute("selectedSeat", 1);
                    } else {
                        // If the user didn't select a seat, assign booking ID as seat number
                       
                    }
                    if(flightnumber!=0 && seatno!=0) {
                    request.getRequestDispatcher("BookingConfirmation.jsp").forward(request, response);
                    }
                    } else {
                    // Booking failed, show error message
                    response.sendRedirect("bookingError.jsp");
                }
            } else {
                // User not logged in or invalid user, show error message
                response.sendRedirect("login.jsp");
            }
        } else {
            // Flight not available, show error message
            response.sendRedirect("flightNotAvailable.jsp");
        }
    }

    private int getseatnumber(int flightId) {
    	int seatno = -1;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT max(id) AS id FROM bookings WHERE flight_id = ?")) {

            statement.setInt(1, flightId);
           

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    seatno = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		return seatno;
	}

	private int getFlightNumberinbookings(int flightId) {
		int flightnumber = -1;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT flight_number FROM flights WHERE id=?")) {

                     statement.setInt(1, flightId);
            

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    flightnumber = resultSet.getInt("flight_number");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightnumber;
	}

	// Method to get the flight_id from the database based on the selected cities and date
    private int getFlightIdFromDatabase(String departureCity, String destinationCity, String departureDate) {
        int flightId = -1;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id FROM flights WHERE departure_city = ? AND destination_city = ? AND departure_date = ?")) {

            statement.setString(1, departureCity);
            statement.setString(2, destinationCity);
            statement.setString(3, departureDate);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    flightId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flightId;
    }

    // Method to get the user_id from the database based on the username
    private int getUserIdFromDatabase(String username) {
        int userId = -1;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT id FROM users WHERE username = ?")) {

            statement.setString(1, username);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    userId = resultSet.getInt("id");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userId;
    }

 // Method to fetch flight details from the database based on the flightId
    private Flight getFlightDetailsFromDatabase(int flightId) {
        Flight flight = null;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "SELECT flight_number, departure_city, destination_city, departure_date, available_seats FROM flights WHERE id = ?")) {

            statement.setInt(1, flightId);

            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    String flightNumber = resultSet.getString("flight_number");
                    String departureCity = resultSet.getString("departure_city");
                    String destinationCity = resultSet.getString("destination_city");
                    String departureDate = resultSet.getString("departure_date");
                    int availableSeats = resultSet.getInt("available_seats");

                    // Creating a new Flight object with the retrieved data
                    flight = new Flight(flightId, flightNumber, departureCity, destinationCity, departureDate, availableSeats);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return flight;
    }

    // Method to save the booking details to the database
    private boolean saveBookingToDatabase(int userId, int flightId, Date bookingDate) {
        boolean bookingSuccess = false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "INSERT INTO bookings (user_id, flight_id, booking_date) VALUES (?, ?, ?)")) {

            statement.setInt(1, userId);
            statement.setInt(2, flightId);
            statement.setTimestamp(3, new java.sql.Timestamp(bookingDate.getTime()));

            int rowsInserted = statement.executeUpdate();

            if (rowsInserted > 0) {
                bookingSuccess = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return bookingSuccess;
    }

    // Method to decrease available seats in the flights table
    private boolean decreaseAvailableSeats(int flightId) {
       int a = 0;
        boolean updateSeatsSuccess=false;

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(
                     "select availableseats from flights WHERE id = ?")) {

            statement.setInt(1, flightId);

            ResultSet rs= statement.executeQuery();

            while(rs.next()){
             a=rs.getInt("available_seats");
             a=a-1;
            }
            try (Connection connectio = DatabaseConnection.getConnection();
                    PreparedStatement statemen = connectio.prepareStatement(
                            "UPDATE flights SET available_seats = ? WHERE id = ?")) {
            	   statemen.setInt(1, a);
                   statemen.setInt(2, flightId);

                   int rowsUpdated = statement.executeUpdate();

                   if (rowsUpdated > 0) {
                       updateSeatsSuccess = true;
                   }
               } catch (SQLException e) {
                   e.printStackTrace();
               }

            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return updateSeatsSuccess;
    }
 
}
