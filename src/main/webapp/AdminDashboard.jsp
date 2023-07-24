<!DOCTYPE html>
<html>
<head>
    <title>Admin Dashboard</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            margin: 0;
            padding: 0;
            background: rgb(2, 0, 36);
            background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);
        }

        .container {
            max-width: 1200px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            text-align: center;
            color: #FFFB7D; /* Light yellow color for "Welcome, Admin!" */
            margin-bottom: 20px;
        }

        h2 {
            color: #FFFB7D; /* Light yellow color for "Flights" */
            margin-bottom: 10px;
            text-align: center;
        }

        a {
            display: block;
            text-align: center;
            text-decoration: none;
            color: #fff;
            background-color: #4CAF50;
            padding: 10px 20px;
            border-radius: 4px;
            margin: 10px auto;
            width: 200px;
        }

        a:hover {
            background-color: #45a049;
        }

        @media (max-width: 600px) {
            h1 {
                font-size: 24px;
            }

            h2 {
                font-size: 20px;
            }

            a {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Welcome, Admin!</h1>
        <h2>Flights</h2>
        <a href="AvailableFlightServlet">Available Flight</a>
        <a href="AddFlight.jsp">Add New Flight</a>
        <a href="Admin.jsp">Back</a>
    </div>
</body>
</html>
