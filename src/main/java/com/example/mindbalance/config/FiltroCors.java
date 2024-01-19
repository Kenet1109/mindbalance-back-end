package com.example.mindbalance.config;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class FiltroCors  implements Filter {

    private static final String OPTIONS = "OPTIONS";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
                        throws IOException, ServletException {
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");
        httpResponse.setHeader("Access-Control-Allow-Methods","POST, GET, OPTIONS, DELETE, PUT");
        String allowedHeaders = "x-requested-with, Content-Type, Authorization, skip";
        httpResponse.setHeader("Access-Control-Allow-Headers", allowedHeaders);

        HttpServletRequest httpRequest = (HttpServletRequest) request;
        if(OPTIONS.equalsIgnoreCase(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpServletResponse.SC_OK);
        }else{
            chain.doFilter(request, response);
        }


    }
}

