
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.io.File;

@WebServlet(urlPatterns = {"/productManagement"})
public class ProductManagementServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String url = ""; //Redirection url
        String action = request.getParameter("action"); //Parameter from /productManagement?action= 

        List<Product> products = ProductIO.selectProducts("products.txt");

        request.setAttribute("products", products);

        switch (action) {
            case "displayProducts":
                url = "/products.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "addProduct":
                url = "/product.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "displayProduct":
                url = "/product.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            case "confirmDelete":
                url = "/confirmDelete.jsp";
                getServletContext().getRequestDispatcher(url).forward(request, response);
                break;
            default:
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        String action = request.getParameter("action");

        if (action.equals("add")) {

            action = "";
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            Double price = Double.parseDouble(request.getParameter("price"));

            Product p = new Product();

            p.setPrice(price);
            p.setCode(code);
            p.setDescription(description);

            ProductIO.insertProduct(p, "products.txt");

            String url = "/product.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

        } else if(action.equals("delete")){
            
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
