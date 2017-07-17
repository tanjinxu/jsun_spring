package cn.itcast.servlet;

import cn.itcast.bean.User;
import cn.itcast.service.LoginService;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Login extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    response.setContentType("text/html;charset=UTF-8");
    User user = new User();
    try {
      BeanUtils.populate(user, request.getParameterMap());
      WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
      LoginService loginService = (LoginService)applicationContext
        .getBean("LoginService");

      User u = loginService.doLogin(user);
      if (u == null) {
        response.getWriter().write("用户名或密码错误！~");
      } else {
        request.getSession().setAttribute("user", u);
        response.sendRedirect(request.getContextPath() + "/getList");
      }
    }
    catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
  {
    doGet(request, response);
  }
}