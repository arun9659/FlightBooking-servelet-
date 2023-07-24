<!DOCTYPE html>
<html>
<head>
    <title>Flight Status</title>
</head>
<body>
    <h1>Flight Status</h1>
    <form action="FlightStatusServlet" method="get">
        <label>Flight Number: </label>
        <input type="text" name="flightNumber" required><br>
        <input type="submit" value="Check Status">
    </form>
</body>
</html>
