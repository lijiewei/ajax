package com.ljw.ajax.servlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
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
@WebServlet("/xhr2Servlet")
public class Xhr2Servlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //默认转换成了iso-8859-1的编码格式；和前端设置一处就可以了
        resp.setContentType("application/json;charset=UTF-8");
        String name = req.getParameter("name");
        String age = req.getParameter("age");
        JSONObject data = new JSONObject();
        data.put("名字：", name);
        data.put("年龄：", age);
        resp.getWriter().print(data);
    }
}
