<!DOCTYPE html>
<html>
<head>
    <title>Flight Booking Confirmation</title>
</head>
<body>
    <h1>Confirm Flight Booking</h1>
    <p>Flight: ${flight}</p>
    <form action="BookingConfirmationServlet" method="post">
        <input type="hidden" name="flight" value="${flight}">
        <input type="submit" value="Confirm Booking">
    </form>
    <a href="FlightAvailabilityServlet">Back to Flight Availability</a>
</body>
</html>
