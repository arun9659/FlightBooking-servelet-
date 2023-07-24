<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
            height:50px;
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
    </style>
</head>
<body>
 <div class="body">
 <h1>Admin page</h1>
<a href="AdminDashboard.jsp">admin</a>
<a href="AddFlight.jsp">Add flight</a>
<a href="DeleteFlight.jsp">Delete flight</a>
<a href="AdminviewUserInformationServlet">Userdetails</a>
<a href="Welcome.jsp">Logout</a>
</div>
</body>
</html>