package it.itcast.web.ServletContextDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**     ServletContext功能
         3. 获取文件的真实(服务器)路径
                1. 方法：String getRealPath(String path)
 */

@WebServlet( "/servletContextDemo5")
public class ServletContextDemo5 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //通过获取文件路径来加载配置文件或者资源
        ServletContext context = this.getServletContext();
        //web目录下资源访问
        String c = context.getRealPath("/c.txt");
        System.out.println(c);
        //WEB-INF目录下的资源访问
        String b = context.getRealPath("/WEB-INF/b.txt");
        System.out.println(b);
        //src目录下的资源访问，也可以通过类加载器来获取
        String a = context.getRealPath("/WEB-INF/classes/a.txt");
        System.out.println(a);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
