package murach.download;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import murach.business.User;
import murach.util.CookieUtil;

@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String action = request.getParameter("action");
        if (action == null) {
            action = "viewAlbums";
        }

        String url = "/albums.jsp";
        if (action.equals("viewAlbums")) {
            url = "/albums.jsp";
        } else if (action.equals("checkUser")) {
            url = checkUser(request, response);
        } else if (action.equals("viewCookies")) {
            url = "/view_cookies.jsp";
        } else if (action.equals("deleteCookies")) {
            url = deleteCookies(request, response);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");

        String url = "/albums.jsp";
        if (action != null && action.equals("registerUser")) {
            url = registerUser(request, response);
        }

        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    private String checkUser(HttpServletRequest request, HttpServletResponse response) {
        String productCode = request.getParameter("productCode");
        HttpSession session = request.getSession();
        session.setAttribute("productCode", productCode);

        User user = (User) session.getAttribute("user");
        String url;

        if (user == null) {
            Cookie[] cookies = request.getCookies();
            String emailAddress = CookieUtil.getCookieValue(cookies, "emailCookie");
            String firstName = CookieUtil.getCookieValue(cookies, "firstNameCookie");

            if (emailAddress == null || emailAddress.isEmpty()) {
                url = "/register.jsp";
            } else {
                user = new User();
                user.setEmail(emailAddress);
                user.setFirstName(firstName);
                session.setAttribute("user", user);
                url = "/download.jsp";
            }
        } else {
            url = "/download.jsp";
        }
        return url;
    }

    private String registerUser(HttpServletRequest request, HttpServletResponse response) {
        String email = request.getParameter("email");
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");

        User user = new User(firstName, lastName, email);

        HttpSession session = request.getSession();
        session.setAttribute("user", user);

        // Lưu cookie (tồn tại 3 năm)
        Cookie emailCookie = new Cookie("emailCookie", email);
        emailCookie.setMaxAge(60 * 60 * 24 * 365 * 3);
        emailCookie.setPath("/");
        response.addCookie(emailCookie);

        Cookie firstNameCookie = new Cookie("firstNameCookie", firstName);
        firstNameCookie.setMaxAge(60 * 60 * 24 * 365 * 3);
        firstNameCookie.setPath("/");
        response.addCookie(firstNameCookie);

        return "/download.jsp";
    }

    private String deleteCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                cookie.setMaxAge(0); // Xóa cookie
                cookie.setPath("/");
                response.addCookie(cookie);
            }
        }
        HttpSession session = request.getSession();
        session.removeAttribute("user");

        return "/delete_cookies.jsp";
    }
}