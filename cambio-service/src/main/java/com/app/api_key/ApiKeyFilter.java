package com.app.api_key;


import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ApiKeyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request,
                         ServletResponse response,
                         FilterChain chain)
            throws IOException, ServletException {

        var httpRequest = (HttpServletRequest) request;
        var apiKey = httpRequest.getHeader("X-API-KEY");
        var httpResponse = (HttpServletResponse) response;

        var API_KEY = System.getenv("MAGO_CAMBIO_API_KEY");

        if (API_KEY.equals(apiKey)) {
            // Chave foi válida
            chain.doFilter(request, response);
        } else {
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED); // Retorna 401 Unauthorized
            httpResponse.setContentType("application/json");
            httpResponse.getWriter().write("{\"error\": \"X-API-KEY Inválida\"}");
        }
    }

    @Override
    public void destroy() {
    }
}

