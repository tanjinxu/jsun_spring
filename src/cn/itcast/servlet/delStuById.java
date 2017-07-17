package cn.itcast.servlet;

import cn.itcast.service.StuService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class delStuById extends HttpServlet
{
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException
  {
    WebApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
    StuService stuService = (StuService)applicationContext
      .getBean("StuService");
    stuService.delById(request.getParameter("id"));
  }

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request, response);
  }
}