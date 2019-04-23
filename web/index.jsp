
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>验证码</title>
    <script>
      //页面加载完成后获取id
       window.onload=function () {

            var img = document.getElementById("img");
            //获取毫秒值，让请求参数不重复
           img.onclick=function () {
               var  date=new Date().getTime();
               img.src="/Csqin/Checkimg?"+date;
           }
       }
    </script>
  </head>
  <body>
  <img  id="img" src="/Csqin/Checkimg">
  <p>点击图片更换验证码</p>

  </body>
</html>
