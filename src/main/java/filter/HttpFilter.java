package filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public interface HttpFilter extends Filter {
    private boolean isHttp(ServletRequest servletRequest,
                           ServletResponse servletResponse) {
        return servletRequest instanceof HttpServletRequest
                && servletResponse instanceof HttpServletResponse;
    }

    @Override
    default void init(FilterConfig filterConfig) throws ServletException {}

    void doHttpFilter(HttpServletRequest rq,
                      HttpServletResponse rs,
                      FilterChain filterChain) throws IOException, ServletException;

    @Override
    default void doFilter(ServletRequest servletRequest,
                          ServletResponse servletResponse,
                          FilterChain filterChain) throws IOException, ServletException {
        if (isHttp(servletRequest, servletResponse)) {
            HttpServletRequest rq = (HttpServletRequest) servletRequest;
            HttpServletResponse rs = (HttpServletResponse) servletResponse;
            doHttpFilter(rq, rs, filterChain);
        }
        else filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    default void destroy() {}

}
