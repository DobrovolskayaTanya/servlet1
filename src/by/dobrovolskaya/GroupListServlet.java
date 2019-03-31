package by.dobrovolskaya;

import by.dobrovolskaya.list.ListService;
import by.dobrovolskaya.list.Person;

import  javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/GroupServlet", name = "GroupServlet")
public class GroupListServlet  extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private ListService todoService = new ListService();

       protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("group",
                ListService.retriveList());
        request.getRequestDispatcher("/WEB-INF/View/Welcom.jsp")
                .forward(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nname = request.getParameter("nname");
        String nphone = request.getParameter("nphone");
        String nemail= request.getParameter("nemail");
        if (("".equals(nname))|| ("".equals(nphone)) || ("".equals(nemail))) {
            request.setAttribute("errorMessage", "Заполните все поля");
        } else {
            ListService.addPerson(new Person(nname, nphone,nemail));
        }
        request.setAttribute("group", ListService.retriveList());
        request.getRequestDispatcher("/WEB-INF/View/Welcom.jsp").forward(request,
                response);
    }



}
