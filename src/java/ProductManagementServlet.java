
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

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

        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            request.setAttribute("message", "You must register and log in.");
            String url = "/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }

        String url = ""; //Redirection url
        String action = request.getParameter("action"); //Parameter from /productManagement?action= 

        List<Product> products = ProductTable.selectProducts();

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

        HttpSession session = request.getSession();

        if (session.getAttribute("user") == null) {
            request.setAttribute("message", "You must register and log in.");
            String url = "/login.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);
        }

        String action = request.getParameter("action");

        if (action.equals("add")) {

            action = "";
            String code = request.getParameter("code");
            String description = request.getParameter("description");
            String price = request.getParameter("price");

            boolean validEntries = testForValidEntries(code, description, price);

            if (validEntries) {
                Product p = new Product();
                p.setPrice(Double.parseDouble(price));
                p.setCode(code);
                p.setDescription(description);

                if (ProductTable.exists(code)) {

                    ProductTable.updateProduct(p);

                } else {
                    ProductTable.insertProduct(p);

                }
            } else {
                request.setAttribute("message", "One or more entries was invalid!");
            }

            String url = "/product.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

        } else if (action.equals("edit")) {

            action = "";

            String code = request.getParameter("code");

            Product p = ProductTable.selectProduct(code);

            String description = p.getDescription();
            String price = p.getPrice() + "";

            request.setAttribute("price", price);
            request.setAttribute("code", code);
            request.setAttribute("description", description);

            String url = "/product.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

        } else if (action.equals("delete")) {

            action = "";

            String code = request.getParameter("code");

            Product p = ProductTable.selectProduct(code);
            String description = p.getDescription();
            String price = p.getPrice() + "";

            request.setAttribute("price", price);
            request.setAttribute("code", code);
            request.setAttribute("description", description);

            String url = "/confirmDelete.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

        } else if (action.equals("confirmDelete")) {
            action = "";

            String code = request.getParameter("code");

            Product p = ProductTable.selectProduct(code);
            ProductTable.deleteProduct(p);

            String url = "/index.jsp";
            getServletContext().getRequestDispatcher(url).forward(request, response);

        }

    }

    public boolean testForValidEntries(String code, String desc, String price) {

        if (code.equals("") || desc.equals("") || price.equals("")) {
            return false;
        }

        try {
            Double.parseDouble(price);
        } catch (Exception e) {
            return false;
        }

        return true;

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
