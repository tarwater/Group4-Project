
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/membership"})

public class MembershipServlet extends HttpServlet {

    private String userFile = "C:\\Users\\Owner\\Desktop\\ITIS-4166\\Group4-Project\\web\\WEB-INF\\users.txt";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = request.getParameter("action"); //Get the parameter from /membership?action=
        String url = ""; //Will hold redirection URL

        if (action.equals("signup")) {
            url = "/signup.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("login")) {
            url = "/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } else if (action.equals("logout")){
            HttpSession session = request.getSession();
            session.invalidate();
            
            url = "/login.jsp";
            request.setAttribute("message", "You are logged out");
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = request.getParameter("action");

        if (action.equals("register")) {

            //create new entry in users.txt
            //redirect to login.jsp
            //String userName = request.getParameter("username");
            String email = request.getParameter("email");
            String firstName = request.getParameter("firstName");
            String lastName = request.getParameter("lastName");
            String password = request.getParameter("password");

            if (password.length() < 8) {
                request.setAttribute("message", "Password is too short");
                String url = "/signup.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            } else {
                User user = new User();
                user.setEmail(email);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setPassword(password);
                UserIO.addRecord(user, userFile);

                String url = "/signup.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
            }

        } else if (action.equals("login")) {
            //compare input to info in users.txt
            //if valid, start session

            String email = request.getParameter("email");
            String password = request.getParameter("password");

            ArrayList<User> users = UserIO.getUsers(userFile);

            if (!users.isEmpty()) {

                for (User u : users) {
                    if (u.getEmail().equals(email)) {
                        if (u.getPassword().equals(password)) {
                            HttpSession session = request.getSession();
                            session.setAttribute("user", u);

                            String url = "/index.jsp";
                            getServletContext().getRequestDispatcher(url).forward(request, response);
                        }
                    }
                }

            }

            request.setAttribute("message", "Invalid login");
            String url = "/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } 

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
