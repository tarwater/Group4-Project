
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
        } else if (action.equals("login")) {
            //compare input to info in users.txt
            //if valid, start session
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
