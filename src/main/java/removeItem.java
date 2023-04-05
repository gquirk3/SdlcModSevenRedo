import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "removeItem", value = "/removeItem")
public class removeItem extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int item= Integer.parseInt(request.getParameter("remove"));
        Main.removeItem(item);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int item= Integer.parseInt(request.getParameter("remove"));
        Main.removeItem(item);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
