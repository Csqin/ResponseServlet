package it.itcast.web.Response;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字节输出流
 */
@WebServlet("/responseServlet4")
public class responseServlet4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //告诉浏览器响应体使用的编码
        response.setContentType("text/html;charset=utf-8");
        ServletOutputStream outputStream = response.getOutputStream();
        //设置该流的默认编码
        outputStream.write("你好呀,李银河。".getBytes("utf-8"));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
