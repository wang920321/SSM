package com.movit.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.movit.entity.User;
import com.movit.util.UrlConstantsUtil;

public class LoginFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest servletRequest,
	    ServletResponse servletResponse, FilterChain filterChain)
	    throws IOException, ServletException {
	if (!(servletRequest instanceof HttpServletRequest)
		|| !(servletResponse instanceof HttpServletResponse)) {
	    throw new ServletException(
		    "OncePerRequestFilter just supports HTTP requests");
	}
	HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
	HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
	HttpSession session = httpRequest.getSession(true);
	User user = (User) session.getAttribute("currentUser");
	String url = httpRequest.getRequestURL().toString();

	if (url.endsWith("signIn") || url.endsWith("loginS4/")
		|| url.endsWith("logout")) {
	    filterChain.doFilter(servletRequest, servletResponse);
	} else if (user == null) {
	    httpRequest.setCharacterEncoding("GBK");
	    httpResponse.setCharacterEncoding("GBK");
	    PrintWriter out = httpResponse.getWriter();
	    StringBuilder builder = new StringBuilder();
	    builder.append("<script type=\"text/javascript\">");
	    builder.append("alert('login expire!');");
	    builder.append("window.top.location.href='");
	    builder.append(UrlConstantsUtil.getLogoutUrl(httpRequest) + "';");
	    builder.append("</script>");
	    out.print(builder.toString());
	} else {
	    filterChain.doFilter(servletRequest, servletResponse);
	}

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }

}
