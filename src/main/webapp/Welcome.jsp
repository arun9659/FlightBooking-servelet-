<!DOCTYPE html>
<html>
<head>
    <title>Welcome</title>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);
            color: white;
            font-family: Arial, sans-serif;
            text-align: center;
        }

        a {
            text-decoration: none;
            color: white;
            background-color: #4CAF50;
            padding: 20px;
            border: 1px solid white;
            border-radius: 4px;
            margin: 10px;
            display: inline-block;
            width: 200px;
            box-sizing: border-box;
        }

        a:hover {
            background-color: rgba(255, 255, 255, 0.1);
        }

        .body {
            display: flex;
            flex-direction: column;
            justify-content: center;
            align-items: center;
            height: 100vh;
        }

        h1 {
            margin-bottom: 30px;
        }

        .logo-img {
            max-width: 200px;
            margin-bottom: 20px;
            transition: transform 0.1s ease;
        }

        .move-right {
            transform: translateX(100px);
        }
    </style>
    <script>
        function moveImageRight() {
            const logoImg = document.getElementById('logo-img');
            logoImg.classList.add('move-right');
            setTimeout(() => {
                logoImg.classList.remove('move-right');
            }, 500);
        }
    </script>
</head>
<body>
    <div class="body">
        <img id="logo-img" class="logo-img" src="https://www.pngkey.com/png/detail/220-2209228_southwest-airlines-logo2-southwest-airline-logo-white-and.png" alt="Flight Logo">
        <h1>Welcome to Flight Booking System</h1>
        <a href="login.jsp" onclick="moveImageRight()">Login</a>
        <a href="AdminLogin.jsp" onclick="moveImageRight()">Admin login</a>
        <a href="register.jsp" onclick="moveImageRight()">New User</a>
    </div>
</body>
</html>
