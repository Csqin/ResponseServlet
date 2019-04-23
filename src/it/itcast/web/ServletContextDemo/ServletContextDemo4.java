package it.itcast.web.ServletContextDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**     ServletContext功能
                2. 域对象：共享数据
                    先访问Demo3
                    获取Demo3共享的数据
 */

@WebServlet( "/servletContextDemo4")
public class ServletContextDemo4 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ServletContext context = this.getServletContext();
        Object msg = context.getAttribute("msg");
        System.out.println("共享的数据:"+msg);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
