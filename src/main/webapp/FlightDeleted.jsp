<!DOCTYPE html>
<html>
<head>
    <title>Flight Deleted Successfully</title>
</head>
<body>
    <h1>Flight Deleted Successfully</h1>
    <p>Flight <%= request.getParameter("flightNumber") %> has been deleted from the system.</p>
    <a href="AdminDashboardServlet">Back to Admin Dashboard</a>
</body>
</html>
