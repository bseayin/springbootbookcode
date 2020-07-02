package com.xsz.filter;

import com.xsz.entity.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 ** 使用注解标注过滤器
 * @WebFilter将一个实现了javax.servlet.Filter接口的类定义为过滤器
 * 属性filterName声明过滤器的名称,可选
 * 属性urlPatterns指定要过滤的URL模式,也可使用属性value来声明.(指定要过滤的URL模式是必选属性) * @author Angel(QQ:412887952)
 * @version
 *
 */
@WebFilter(filterName = "bseaFilter",urlPatterns = "/*")
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("过滤器初始了");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse resp = (HttpServletResponse)response;

        User loginUser= (User)req.getSession().getAttribute("loginuser");

        String path=req.getServletPath();


        if(path.contains("login") || path.contains("register")){
            System.out.println("doFilter***path**"+path);

            chain.doFilter(request,response);
        }else if(loginUser == null){
            resp.sendRedirect(req.getContextPath() + "/login.html");
        } else{
            chain.doFilter(request,response);
        }

    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁了");
    }
}
