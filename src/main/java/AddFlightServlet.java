import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//... (imports and other parts of the servlet remain the same)

@WebServlet("/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
 private static final long serialVersionUID = 1L;

 protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
     String flightNumber = request.getParameter("flightNumber");
     String departureCity = request.getParameter("departureCity");
     String destinationCity = request.getParameter("destinationCity");
     String departureDateStr = request.getParameter("departureDate");
     int availableSeats = 0;
     HttpSession session = request.getSession();
     String adminUsername = (String) session.getAttribute("admin");

     // Convert the string representation of the departure date to java.sql.Date
     java.sql.Date departureDate = null;

     Connection connection = null;
     PreparedStatement preparedStatement = null;
     if ("arun".equals(adminUsername)) {
     try {
         // Parse the availableSeats value, if not a valid number, it will throw NumberFormatException
         availableSeats = Integer.parseInt(request.getParameter("availableSeats"));

         // Validate the date format
         SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
         dateFormat.setLenient(false); // Avoid lenient parsing
         java.util.Date parsedDate = dateFormat.parse(departureDateStr);
         departureDate = new java.sql.Date(parsedDate.getTime());

         connection = DatabaseConnection.getConnection();

         String insertQuery = "INSERT INTO flights (flight_number, departure_city, destination_city, departure_date, available_seats) VALUES (?, ?, ?, ?, ?)";
         preparedStatement = connection.prepareStatement(insertQuery);
         preparedStatement.setString(1, flightNumber);
         preparedStatement.setString(2, departureCity);
         preparedStatement.setString(3, destinationCity);
         preparedStatement.setDate(4, departureDate);
         preparedStatement.setInt(5, availableSeats);

         int rowsAffected = preparedStatement.executeUpdate();

         if (rowsAffected > 0) {
             // Flight added successfully
             PrintWriter out = response.getWriter();
             out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Flight Added</title>");
             out.println("<style>");
             out.println("body { font-family: Arial, sans-serif; background: rgb(2,0,36);\r\n"
             		+ "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 0%, rgba(0,212,255,1) 100%); margin: 0; padding: 0; }");
             out.println(".container { max-width: 600px; margin: 0 auto;margin-top:20vh; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }");
             out.println("h1 { text-align: center; color: #333; margin-bottom: 20px; }");
             out.println("p { text-align: center; color: #333; margin-bottom: 20px; }");
             out.println(".button { display: block; text-align: center; text-decoration: none; color: #fff; background-color: #4CAF50; padding: 10px 20px; border-radius: 4px; margin: 10px auto; width: 200px; }");
             out.println(".button:hover { background-color: #45a049; }");
             out.println("</style>");
             out.println("</head>");
             out.println("<body>");
             out.println("<div class=\"container\">");
             out.println("<h1>Flight Added Successfully</h1>");
             out.println("<p>Flight " + flightNumber + " has been added to the system.</p>");
             out.println("<a class=\"button\" href=\"AddFlight.jsp\">Back to Add Flight</a>");
             out.println("</div>");
             out.println("</body>");
             out.println("</html>");
         } else {
             // Failed to add flight
             PrintWriter out = response.getWriter();
             out.println("<!DOCTYPE html>");
             out.println("<html>");
             out.println("<head>");
             out.println("<title>Flight Addition Failed</title>");
             out.println("<style>");
             out.println("body { font-family: Arial, sans-serif; background: rgb(2,0,36);\r\n"
             		+ "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 0%, rgba(0,212,255,1) 100%); margin: 0; padding: 0; }");
             out.println(".container { max-width: 600px; margin: 0 auto;margin-top:20vh; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }");
             out.println("h1 { text-align: center; color: #333; margin-bottom: 20px; }");
             out.println("p { text-align: center; color: #333; margin-bottom: 20px; }");
             out.println(".button { display: block; text-align: center; text-decoration: none; color: #fff; background-color: #4CAF50; padding: 10px 20px; border-radius: 4px; margin: 10px auto; width: 200px; }");
             out.println(".button:hover { background-color: #45a049; }");
             out.println("</style>");
             out.println("</head>");
             out.println("<body>");
             out.println("<div class=\"container\">");
             out.println("<h1>Flight Addition Failed</h1>");
             out.println("<p>Failed to add the flight. Please try again.</p>");
             out.println("<a class=\"button\" href=\"AddFlight.jsp\">Back to Add Flight</a>");
             out.println("</div>");
             out.println("</body>");
             out.println("</html>");
         }
     } catch (NumberFormatException | ParseException | SQLException e) {
         // Handle the errors gracefully and display an error message to the user
         PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Error</title>");
         out.println("<style>");
         out.println("body { font-family: Arial, sans-serif;background: rgb(2,0,36);\r\n"
         		+ "background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 0%, rgba(0,212,255,1) 100%); margin: 0; padding: 0; }");
         out.println(".container { max-width: 600px; margin: 0 auto;margin-top:20vh; padding: 20px; background-color: #fff; border-radius: 5px; box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1); }");
         out.println("h1 { text-align: center; color: #333; margin-bottom: 20px; }");
         out.println("p { text-align: center; color: #333; margin-bottom: 20px; }");
         out.println(".button { display: block; text-align: center; text-decoration: none; color: #fff; background-color: #4CAF50; padding: 10px 20px; border-radius: 4px; margin: 10px auto; width: 200px; }");
         out.println(".button:hover { background-color: #45a049; }");
         out.println("</style>");
         out.println("</head>");
         out.println("<body>");
         out.println("<div class=\"container\">");
         out.println("<h1>Error</h1>");
         out.println("<p>Invalid date or number format. Please check your input and try again.</p>");
         out.println("<a class=\"button\" href=\"AddFlight.jsp\">Back to Add Flight</a>");
         out.println("</div>");
         out.println("</body>");
         out.println("</html>");
         return; 
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
 