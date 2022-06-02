package com.dream.mybaijia.filter;

import org.springframework.context.annotation.ComponentScan;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author Arthus
 */

@WebFilter("/admin/*")
public class AdminFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        HttpSession session = request.getSession();

        Object attribute = session.getAttribute("adminId");

        if (attribute == null) {
            request.getRequestDispatcher("/admin/login");
        } else {
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

}
