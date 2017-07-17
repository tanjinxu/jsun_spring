package cn.itcast.servlet;

import cn.itcast.bean.Stu;
import cn.itcast.service.StuService;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class editStu extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    Stu stu = new Stu();
    request.setCharacterEncoding("UTF-8");
    try {
      BeanUtils.populate(stu, request.getParameterMap());
      WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
      StuService stuService = (StuService)applicationContext
        .getBean("StuService");
      stuService.editById(stu);
      response.sendRedirect("getList");
    } catch (IllegalAccessException e) {
      e.printStackTrace();
    } catch (InvocationTargetException e) {
      e.printStackTrace();
    }
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}