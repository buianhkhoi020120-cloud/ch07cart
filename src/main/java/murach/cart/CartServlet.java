package murach.cart;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import murach.business.Cart;
import murach.business.LineItem;
import murach.business.Product;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/add-cart")
public class CartServlet extends HttpServlet {
    private static final Map<String, Product> PRODUCTS = new HashMap<>();
    static {
        PRODUCTS.put("1", new Product("1", "86 (the band) - True Life Songs and Pictures", 14.95));
        PRODUCTS.put("2", new Product("2", "Paddlefoot - The first CD", 12.95));
        PRODUCTS.put("3", new Product("3", "Paddlefoot - The second CD", 14.95));
        PRODUCTS.put("4", new Product("4", "Joe Rut - Genuine Wood Grained Finish", 14.95));
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        ServletContext sc = getServletContext();
        String action = request.getParameter("action");
        if (action == null) {
            action = "add-cart";
        }
        String url = "/index.html";
        if (action.equals("shop")) {
            url = "/index.html";
        } else if (action.equals("add-cart")) {
            String id = request.getParameter("id");
            String quantityString = request.getParameter("quantity");
            HttpSession session = request.getSession();
            Cart cart = (Cart) session.getAttribute("cart");
            if (cart == null) {
                cart = new Cart();
            }
            int quantity;
            try {
                quantity = Integer.parseInt(quantityString);
                if (quantity < 0) {
                    quantity = 1;
                }
            } catch (NumberFormatException e){
                quantity = 1;
            }
            Product product = PRODUCTS.get(id);
            if (product != null) {
                if (quantity > 0) {
                    LineItem lineItem = new LineItem();
                    lineItem.setProduct(product);
                    lineItem.setQuantity(quantity);
                    cart.addItem(lineItem);
                } else {
                    cart.removeItem(id);
                }
            }
            session.setAttribute("cart", cart);
            url = "/cart.jsp";
        } else if (action.equals("checkout")){
            url = "/checkout.jsp";
        }
        sc.getRequestDispatcher(url).forward(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
