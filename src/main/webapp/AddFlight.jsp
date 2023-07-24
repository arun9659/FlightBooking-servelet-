<!DOCTYPE html>
<html>
<head>
    <title>Add New Flight</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            margin: 0;
            padding: 0;
        }

        .container {
            max-width: 600px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        input[type="text"],
        input[type="date"],
        input[type="number"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
        }

        input[type="submit"] {
            display: block;
            width: 100%;
            padding: 10px;
            background-color: #4CAF50;
            color: #fff;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        a.back-button {
            display: block;
            width: 100px;
            margin: 20px auto;
            padding: 10px;
            text-align: center;
            background-color: #4CAF50;
            color: #fff;
            text-decoration: none;
            border: none;
            border-radius: 4px;
        }

        a.back-button:hover {
            background-color: #45a049;
        }

        @media (max-width: 600px) {
            .container {
                padding: 10px;
            }

            h1 {
                font-size: 24px;
            }

            input[type="submit"] {
                width: auto;
            }

            a.back-button {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Add New Flight</h1>
    <form action="AddFlightServlet" method="post">
        <label>Flight Number: </label>
        <input type="text" name="flightNumber" required><br>
        <label>Departure City: </label>
        <input type="text" name="departureCity" required><br>
        <label>Destination City: </label>
        <input type="text" name="destinationCity" required><br>
        <label>Departure Date: </label>
        <input type="date" name="departureDate" required pattern="\d{4}-\d{2}-\d{2}"><br>
        <label>Available Seats: </label>
        <input type="number" name="availableSeats" required><br>
        <input type="submit" value="Add Flight">
    </form>
    <a class="back-button" href="AdminDashboard.jsp">Back</a>
</div>
</body>
</html>
