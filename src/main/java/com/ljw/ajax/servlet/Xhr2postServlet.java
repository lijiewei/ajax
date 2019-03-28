package com.ljw.ajax.servlet;

import com.alibaba.fastjson.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @Description ajax测试
 * @Author lijiewei
 * @Date 2019/3/28 10:52
 * @Version v1.0
 */
@WebServlet("/xhr2postServlet")
public class Xhr2postServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //默认转换成了iso-8859-1的编码格式；和前端设置一处就可以了
        resp.setContentType("application/json;charset=UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        InputStream inputStream = null;
        try {
            List<FileItem> fileItems = upload.parseRequest(req);
            for (FileItem item : fileItems) {
                //普通字段
                if (item.isFormField()) {
                    String fieldName = item.getFieldName();
                    String value = item.getString("UTF-8");
                } else {
                    //文件名称
                    String fileName = item.getName();
                    //文件输入流
                    inputStream = item.getInputStream();
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(inputStream);
        }
        JSONObject data = new JSONObject();
        data.put("success", true);
        data.put("info", "成功了");
        resp.getWriter().print(data);
    }
}
