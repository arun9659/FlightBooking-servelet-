<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Cancel Flight Booking</title>
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

        input[type="text"] {
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
            display: block;
            text-align: center;
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            margin-top: 10px;
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
        <form action="CancelBookingServlet" method="post">
            <h1>Cancel Flight Booking</h1>
            <div class="scrollable-box">
                <label for="flightNumber">Flight Number:</label>
                <input type="text" id="flightNumber" name="flightNumber" required>
            </div>

            <div class="scrollable-box">
                <label for="seatNumber">Seat Number:</label>
                <input type="text" id="seatNumber" name="seatNumber" required>
            </div>

            <input type="submit" value="Cancel Booking">
        </form>
        <a href="BookingHistory.jsp">Back to Booking History</a>
    </div>
</body>
</html>
