package it.itcast.web.DownloadDemo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.Buffer;

@WebServlet("/DownloadServlet")
public class DownloadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取请求参数
        String filename = request.getParameter("filename");
        //2.把资源通过字节输入流加载进内存
        //2.1通过ServletContext对象获取资源路径
        ServletContext context = this.getServletContext();
        String path = context.getRealPath("/img/" + filename);

        //2.2字节流关联
        FileInputStream fileInputStream=new FileInputStream(path);


        //3.设置响应头参数
        String mimeType = context.getMimeType(filename);
        //设置响应类型
        response.setHeader("content-type",mimeType);
        //设置浏览器打开方式 content-disposition:attachment;filename=xxx
        response.setHeader("content-disposition","attachment;filename="+filename);
        //4.将输入流数据写到输出流中
        ServletOutputStream outputStream = response.getOutputStream();

        byte[] buff=new byte[1024*8];
        int len=0;
        while ((len=fileInputStream.read(buff))!=-1)
        {
            outputStream.write(buff,0,len);
        }
        fileInputStream.close();

    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                this.doPost(request,response);
    }
}
