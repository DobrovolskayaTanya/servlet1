package by.dobrovolskaya;

import by.dobrovolskaya.dao.UserDao;
import by.dobrovolskaya.list.ListService;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/LoginServlet", name = "LoginServlet")

public class LoginServlet extends HttpServlet {

//    public boolean checkLogin (String name, String pass) {
//
//        return (name.equals("admin")&& pass.equals("admin"));
//    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              request.setCharacterEncoding("UTF-8");
              String name  = request.getParameter("name");
             // request.getRequestDispatcher("/WEB-INF/View/Welcom.jsp")
             // .forward(request,response);
             // request.setAttribute("password", request.getParameter("password"));
              String pass  = request.getParameter("password");
        UserDao  daoUser = new UserDao();


              if (daoUser.isValidUser(name, pass))
              {
                  //request.setAttribute("group", ListService.retriveList());
                  //request.getRequestDispatcher("/WEB-INF/View/Welcom.jsp")
                  //       .forward(request,response);

                  request.setAttribute("name",name);
                  request.getRequestDispatcher("/GroupServlet")
                          .forward(request,response);
              }
              else{
                  request.setAttribute("error", "invalid password or/and name");
                  request.getRequestDispatcher("/WEB-INF/View/Login.jsp")
                          .forward(request,response);
              }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/View/Login.jsp")
                .forward(request,response);

    }
    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("Init");
    }
    @Override
    public void destroy() {
        super.destroy();
        System.out.println("Destroy");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("Service");
    }
}
