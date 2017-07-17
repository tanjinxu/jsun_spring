package cn.itcast.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import cn.itcast.service.StuService;

public class getList extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        WebApplicationContext applicationContext = WebApplicationContextUtils
                .getWebApplicationContext(getServletContext());
        StuService stuService = (StuService) applicationContext.getBean("StuService");
        request.setCharacterEncoding("utf-8");
        String search = request.getParameter("search");
        List stuList = stuService.findAll(search);
        request.setAttribute("stuList", stuList);
        request.setAttribute("search", search);
        request.getRequestDispatcher("/stu.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}