import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
       // String fullName = request.getParameter("fullName");
        String email = request.getParameter("email");

        UserDAO userDAO = new UserDAO(); 

        boolean usernameExists = userDAO.checkUsernameExists(username);
        if (usernameExists) {
           
            response.sendRedirect("register.jsp?error=UsernameExists");
            return;
        }

       
        boolean registrationSuccess = userDAO.createUser(username, password, email);

        if (registrationSuccess) {
           
            response.sendRedirect("login.jsp?success=RegistrationSuccess");
        } else {
           
            response.sendRedirect("register.jsp?error=RegistrationFailed");
        }
    }
}
