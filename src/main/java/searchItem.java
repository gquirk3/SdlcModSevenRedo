import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "searchItem", value = "/searchItem")
public class searchItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String item=request.getParameter("search");
        Main.searchItem(item);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String item=request.getParameter("search");
        Main.searchItem(item);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
