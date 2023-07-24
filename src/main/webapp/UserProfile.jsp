<!DOCTYPE html>
<html>
<head>
    <title>User Profile</title>
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
            flex-direction: column; /* Added to align items in a column */
        }

        h1 {
            text-align: center;
            color: white;
            margin-bottom: 20px; /* Added some margin between the title and links */
        }

        p {
            text-align: center;
            color: white;
        }

        a {
            display: block;
            text-align: center;
            color: white;
            text-decoration: none;
            padding: 10px;
            margin: 5px;
            border: 1px solid white;
            border-radius: 4px;
             background-color: #4CAF50;
            width: 150px; /* Added fixed width to make links the same size */
        }

        a.back-button {
            background-color: #4CAF50; /* Set the background color to green */
        }

        a:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        @media (max-width: 600px) {
            /* Styles for screens with a width of 600px or less */
            a {
                padding: 8px;
                margin: 3px;
                width: 100%; /* Full width for small screens */
            }
        }
    </style>
</head>
<body>
    <h1>User Profile</h1>
    <p>Username: <%= session.getAttribute("username") %></p>
    <!-- Display other user information as required (e.g., email, contact, etc.) -->
    <a href="UserProfileServlet">About User</a>
    <a href="flightBooking1.jsp">Flight Booking</a>
    <a href="BookingHistory.jsp">History</a>
    <a href="UpdateProfile.jsp">Update Profile</a>
    <a href="cancelBooking.jsp">cancelbooking</a>
    <a href="Logout.jsp" class="back-button">Logout</a> <!-- Use the "back-button" class for the Logout link -->
</body>
</html>
