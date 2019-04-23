package it.itcast.web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 字符输出流
 */
@WebServlet("/responseServlet3")
public class responseServlet3 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
                 1. PrintWriter pw = response.getWriter();获取的流的默认编码是ISO-8859-1
                        response.setContentType("text/html;charset=utf-8");
                 2. 设置该流的默认编码
                 3. 告诉浏览器响应体使用的编码
         */
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        printWriter.write("你好呀");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
