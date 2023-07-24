<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Booking</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: rgb(2, 0, 36);
            background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        .body {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
        }

        h1 {
            text-align: center;
            color: blue;
        }

        .scrollable-box {
            margin-bottom: 20px;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        select,
        input[type="date"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border: 1px solid #ccc;
            border-radius: 4px;
            box-sizing: border-box;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #ffffff;
            border: none;
            padding: 10px 20px;
            border-radius: 4px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            margin-top: 10px;
            display: inline-block;
            cursor: pointer;
        }

        a:hover {
            background-color: #45a049;
        }

        @media (max-width: 600px) {
            .body {
                max-width: 300px;
            }
        }
    </style>
</head>
<body>
    <div class="body">
        <form action="FlightBookingServlet" method="post">
            <h1>Flight Booking</h1>
            <div class="scrollable-box">
                <label for="departureCity">Departure City:</label>
                <select id="departureCity" name="departureCity" required>
                    <option value="chennai">Chennai</option>
                    <option value="coimbatore">Coimbatore</option>
                    <option value="madurai">Madurai</option>
                </select>
            </div>

            <div class="scrollable-box">
                <label for="destinationCity">Destination City:</label>
                <select id="destinationCity" name="destinationCity" required>
                    <option value="chennai">Chennai</option>
                    <option value="coimbatore">Coimbatore</option>
                    <option value="bangalore">Bangalore</option>
                    <option value="andhra">Andhra</option>
                </select>
            </div>

            <div>
                <label for="departureDate">Departure Date:</label>
                <input type="date" id="departureDate" name="departureDate" required>
            </div>

            <input type="submit" value="Booking Flights">
            <a href="flightAvailability.jsp">Available Flight Tickets</a>
        </form>
    </div>
</body>
</html>
