import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/AdminLoginServlet")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Replace these with your actual admin username and password
        String adminUsername = "arun";
        String adminPassword = "1234";

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Admin Login Result</title>");
        out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">");
        out.println("<style>");
        out.println("body {");
        out.println("    font-family: Arial, sans-serif;");
        out.println("    background: rgb(2, 0, 36);");
        out.println("    background: linear-gradient(90deg, rgba(2, 0, 36, 1) 0%, rgba(9, 9, 121, 1) 0%, rgba(0, 212, 255, 1) 100%);");
        out.println("    margin: 0;");
        out.println("    padding: 0;");
        out.println("    display: flex;");
        out.println("    justify-content: center;");
        out.println("    align-items: center;");
        out.println("    min-height: 100vh;");
        out.println("}");
        out.println(".container {");
        out.println("    background-color: #ffffff;");
        out.println("    padding: 20px;");
        out.println("    border-radius: 8px;");
        out.println("    box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);");
        out.println("    max-width: 400px;");
        out.println("    width: 100%;");
        out.println("}");
        out.println("h1 {");
        out.println("    text-align: center;");
        out.println("    color: blue;");
        out.println("}");
        out.println("p {");
        out.println("    text-align: center;");
        out.println("}");
        out.println("a.button {");
        out.println("    display: block;");
        out.println("    text-align: center;");
        out.println("    background-color: #4CAF50;");
        out.println("    color: #ffffff;");
        out.println("    border: none;");
        out.println("    padding: 10px 20px;");
        out.println("    border-radius: 4px;");
        out.println("    text-decoration: none;");
        out.println("    cursor: pointer;");
        out.println("    margin-top: 20px;");
        out.println("}");
        out.println("a.button:hover {");
        out.println("    background-color: #45a049;");
        out.println("}");
        out.println("@media (max-width: 600px) {");
        out.println("    .container {");
        out.println("        max-width: 300px;");
        out.println("    }");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">");

        if (username.equals(adminUsername) && password.equals(adminPassword)) {
            HttpSession session = request.getSession();
            session.setAttribute("admin", adminUsername);
            out.println("<h1>Login Successful</h1>");
            response.sendRedirect("Admin.jsp");
            // You can redirect the admin to the dashboard or any other admin page here
        } else {
            out.println("<h1>Login Failed</h1>");
            out.println("<p>Invalid username or password. Please try again.</p>");
            // Show "Back to login" anchor tag as a button
            out.println("<a href=\"AdminLogin.jsp\" class=\"button\">Back to login</a>");
        }

        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
