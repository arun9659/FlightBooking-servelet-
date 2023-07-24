import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/FlightStatusServlet")
public class FlightStatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String flightNumber = request.getParameter("flightNumber");

        // Use appropriate APIs or services to fetch real-time flight status information
        String flightStatus = getRealTimeFlightStatus(flightNumber);

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Flight Status</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Flight Status</h1>");
        out.println("<p>Flight " + flightNumber + " status: " + flightStatus + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    // Simulated method to fetch real-time flight status
    private String getRealTimeFlightStatus(String flightNumber) {
        // Implement logic to fetch real-time flight status using APIs or services
        // For demonstration purposes, we'll return a sample status
        return "On-time";
    }
}
