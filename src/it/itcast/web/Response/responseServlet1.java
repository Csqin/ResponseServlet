package it.itcast.web.Response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 请求重定向
 *  	重定向的特点:redirect
                 1. 地址栏发生变化
                 2. 重定向可以访问其他站点(服务器)的资源
                3. 重定向是两次请求。不能使用request对象来共享数据
 */
@WebServlet( "/responseServlet1")
public class responseServlet1 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("demo1...........");
        // 重定向：资源跳转的方式

        //1. 设置状态码为302
        //   response.setStatus(302);

        //2.设置响应头location
        //  response.setHeader("location","/Csqin/responseServlet2");

         //简单的重定向方法
        //动态获取虚拟路径
        String contextPath = request.getContextPath();
        response.sendRedirect(contextPath+"/responseServlet2");
     //      访问github
    //        response.sendRedirect("https://github.com/");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doPost(request,response);
    }
}
