<!DOCTYPE html>
<html>
<head>
    <title>Flight Availability</title>
</head>
<body>
    <h1>Flight Availability</h1>
    <form action="FlightAvailabilityServlet" method="post">
        <label>Departure City: </label>
        <input type="text" name="departureCity" required><br>
        <label>Destination City: </label>
        <input type="text" name="destinationCity" required><br>
        <label>Departure Date: </label>
        <input type="date" name="departureDate" required><br>
        <input type="submit" value="Check Availability">
    </form>
</body>
</html>
