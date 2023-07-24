<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Flight Availability</title>
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

        h1 {
            text-align: center;
            color: blue;
        }

        form {
            background-color: #ffffff;
            padding: 20px;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            max-width: 400px;
            width: 100%;
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

        @media (max-width: 600px) {
            form {
                max-width: 300px;
            }
        }

        /* Additional styles for the buttons */
        .buttons-container {
            display: flex;
            justify-content: space-between;
            margin-top: 10px;
        }

        .buttons-container input[type="submit"],
        .book-flight-button {
            flex: 1;
            text-align: center;
            color: white;
            background-color: #4CAF50;
            text-decoration: none;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            margin-top: 10px;
            margin-left:5px;
            display: inline-block;
            cursor: pointer;
        }

        .buttons-container input[type="submit"]:hover,
        .book-flight-button:hover {
            background-color: #45a049;
        }

        @media (max-width: 600px) {
            /* Styles for screens with a width of 600px or less */
            .body {
                max-width: 300px;
            }

            /* Added styles for smaller screens to stack buttons vertically */
            .buttons-container {
                flex-direction: column;
            }
        }
    </style>
</head>
<body>
    <div class="body">
        <form action="FlightAvailabilityServlet" method="post">
            <h1>Flight Availability</h1>
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

            <div class="buttons-container">
                <input type="submit" value="Check Flights">
                <c:if test="${not empty param.departureCity && not empty param.destinationCity && not empty param.departureDate}">
                    <a href="flightBooking1.jsp" class="book-flight-button">Book Flight Now</a>
                </c:if>
            </div>
        </form>
    </div>
</body>
</html>
