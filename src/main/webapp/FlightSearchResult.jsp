<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Search Result</title>
</head>
<body>
    <h1>Flight Search Result</h1>
    <table>
        <tr>
            <th>Flight Number</th>
            <th>Departure City</th>
            <th>Destination City</th>
            <th>Departure Date</th>
            <th>Available Seats</th>
            <th>Action</th>
        </tr>
        <c:forEach var="flight" items="${flightList}">
            <tr>
                <td>${flight.flightNumber}</td>
                <td>${flight.departureCity}</td>
                <td>${flight.destinationCity}</td>
                <td>${flight.formattedDepartureDate}</td>
                <td>${flight.availableSeats}</td>
                <td><a href="SeatSelection.jsp?flightNumber=${flight.flightNumber}">Book</a></td>
            </tr>
        </c:forEach>
    </table>
    <a href="FlightAvailability.jsp">Back to Flight Availability</a>
</body>
</html>
