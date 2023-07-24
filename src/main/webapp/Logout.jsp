<!DOCTYPE html>
<html>
<head>
    <title>Logged Out</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background: rgb(2,0,36);
background: linear-gradient(90deg, rgba(2,0,36,1) 0%, rgba(9,9,121,1) 0%, rgba(0,212,255,1) 100%);
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
            margin-top:20vh;
        }

        h1 {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
        }

        p {
            text-align: center;
            color: #333;
            margin-bottom: 20px;
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
            .container {
                padding: 10px;
            }

            h1 {
                font-size: 24px;
            }

            p {
                font-size: 18px;
            }

            a {
                width: 100%;
            }
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Logged Out</h1>
    <p>You have been logged out successfully.</p>
    <a href="Welcome.jsp">Back to Login</a>
</div>
</body>
</html>
