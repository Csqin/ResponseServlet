package it.itcast.web.ServletContextDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 *       ServletContext功能
                	1. 获取MIME类型：
                         * MIME类型:在互联网通信过程中定义的一种文件数据类型
                         * 格式： 大类型/小类型   text/html		image/jpeg
                        * 获取：String getMimeType(String file)
 */

@WebServlet( "/servletContextDemo2")
public class ServletContextDemo2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ServletContext context = this.getServletContext();
        //文件名称
        String filename="a.jpg";
        //通过context获取文件MIME值
        String mimeType = context.getMimeType(filename);

        System.out.println(mimeType);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
