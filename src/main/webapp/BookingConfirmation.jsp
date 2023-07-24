<!DOCTYPE html>
<html>
<head>
    <title>Booking Confirmation</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background: rgb(2,0,36);
            background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 0%, rgba(0,212,255,1) 100%);
        }

        .container {
            max-width: 400px;
            max-height:400px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            margin-bottom: 20px;
            color: white; /* Set text color to white */
        }

        p {
            margin: 10px 0;
            
        }

        .booking-details {
            border: 1px solid #ccc;
            padding: 20px;
            background-color: #0093E9;

            color: #333; /* Set text color for the booking details box */
        }

        .confirmation-msg {
            text-align: center;
            font-size: 18px;
            margin-bottom: 30px;
           color:white;
        }

        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: white; 
            text-decoration: none;
            background-color: #4CAF50; /* Set background color for the anchor tag button */
            padding: 10px 20px;
            border-radius: 5px;
            
        }

        .back-link:hover {
            text-decoration: none; 
            background-color: #45a049; 
        }

        @media screen and (max-width: 600px) {
            .container {
                padding: 10px;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Booking Confirmation</h1>
        <div class="booking-details">
            <p class="confirmation-msg">Your booking for flight ${flightNumber} is confirmed.</p>
            <p class="confirmation-msg">Seat: ${selectedSeat}</p>
            <a class="back-link" href="BookingHistoryServlet">Back to Booking History</a>
        </div>
        
    </div>
</body>
</html>
