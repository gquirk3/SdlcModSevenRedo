import entity.Tasks;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "showList", value = "/showList")
public class showList extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tasks> list = Main.showList();
        for (Tasks s : list){
            response.setContentType("text/plain");
            response.getWriter().println(s);
        }
        response.getWriter().println("get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Tasks> list = Main.showList();
        for (Tasks s : list) {
            response.setContentType("text/plain");
            response.getWriter().println(s);
        }
        response.getWriter().println("post");
    }
}
