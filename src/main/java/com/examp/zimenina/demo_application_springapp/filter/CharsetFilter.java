package com.examp.zimenina.demo_application_springapp.filter;

import javax.servlet.*;
import java.io.IOException;

public class CharsetFilter implements Filter {
    private String encoding;

    public CharsetFilter() {
    }

    public void init(FilterConfig fConfig) throws ServletException {
        this.encoding = fConfig.getInitParameter("requestEncoding");
        if (this.encoding == null) {
            this.encoding = "UTF-8";
        }
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if (request.getCharacterEncoding() == null) {
            request.setCharacterEncoding(this.encoding);
        }
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }
}
