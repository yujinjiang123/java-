package servlet;

import dao.UserDao;
import dao.daoimpl.UserDaoImpl;
import entity.User;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@WebServlet(name = "AddUserInfo",urlPatterns = "/addUserInfo")
public class AddUserInfoServlet extends HttpServlet {

    private UserDao userDao = new UserDaoImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        HttpSession session=request.getSession();
        String schoolName=(String)session.getAttribute("schoolName");
        String profession=(String)session.getAttribute("profession");
        String[] technology=request.getParameterValues("technology");
        List<String> technologyList= Arrays.stream(technology).collect(Collectors.toList());
        User user=(User)session.getAttribute("user");
        user.setSchoolName(schoolName);
        user.setProfession(profession);
        user.setTechnologyList(technologyList);
        try{
            userDao.updateUser(user);
        }catch (Exception e){
            e.printStackTrace();
            user=(User)session.getAttribute("user");
        }finally {
            session.setAttribute("user",user);
            response.sendRedirect("/userinfo.jsp");
        }
    }
}
