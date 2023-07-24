<!DOCTYPE html>
<html>
<head>
    <title>Flight Management</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f1f1f1;
            margin: 0;
            padding: 0;
            text-align: center;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
        }

        h1 {
            color: #333;
            margin-bottom: 20px;
        }

        a {
            display: block;
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

            a {
                width: 100%;
            }
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Flight Management</h1>
        <a href="AddFlight.jsp">Add New Flight</a>
        <a href="DeleteFlight.jsp">Delete Flight</a>
        <a href="AdminDashboardServlet">Back to Admin Dashboard</a>
    </div>
</body>
</html>
