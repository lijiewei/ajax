package com.ljw.ajax.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Description ajax测试
 * @Author lijiewei
 * @Date 2019/3/28 10:52
 * @Version v1.0
 */
@WebServlet("/xhr1Servlet")
public class Xhr1Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //和前端设置只一处就可以了，get通常后端设置，后端设置浏览器响应头才能看见
        resp.setContentType("text/html;charset=UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        resp.getWriter().print("名字：" + name + " 年龄：" + age);
    }
}
