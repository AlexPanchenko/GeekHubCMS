package org.geekhub.servlet;

import javax.servlet.*;
import java.io.IOException;

public class Gateway implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        response.setCharacterEncoding("UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig arg0) throws ServletException { }

    @Override
    public void destroy() { }

}
