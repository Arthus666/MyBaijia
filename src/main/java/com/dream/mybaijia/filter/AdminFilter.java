package com.dream.mybaijia.filter;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.filter.CharacterEncodingFilter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Arthus
 */

@WebFilter("/admin/dashboard.html")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession();

        System.out.println(session.getAttribute("adminId"));

        if (session.getAttribute("adminId") == null) {
            response.sendRedirect("/admin/login");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }
}
