package by.dobrovolskaya;

import by.dobrovolskaya.dao.UserDao;
import by.dobrovolskaya.list.ListService;
import by.dobrovolskaya.util.HashPassword;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

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


              if (daoUser.isValidUser(name, HashPassword.getHash(pass)))
              {
                  request.getSession().setAttribute("username",name);
                  //request.setAttribute("group", ListService.retriveList());
                  //request.getRequestDispatcher("/WEB-INF/View/Welcom.jsp")
                  //       .forward(request,response);

                  request.getSession().setAttribute("name",name);
                  request.getRequestDispatcher("/GroupServlet")
                          .forward(request,response);
              }
              else{
                  request.setAttribute("error", "invalid password or/and name");
                  request.getRequestDispatcher("/WEB-INF/View/Login.jsp")
                          .forward(request,response);
              }
    }

    //Добавим работу с файлом Cookie
/*
    Cookie userCookie = new Cookie(name, LocalDateTime.now().toString());
    userCookie.setMaxAge(60 * 60 * 24 * 365); //хранить куки год
    response.addCookie(userCookie);

    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for(int i=0; i<cookies.length; i++)
        {
            Cookie cookie = cookies[i];
            if (name.equals(cookie.getName())) {
                request.setAttribute("lastdate", cookie.getValue());
            }
        }
*/
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
