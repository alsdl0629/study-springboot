package com.example.socketcommunication.global.error;

import com.example.socketcommunication.global.error.exception.BusinessException;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (BusinessException e) {
            ErrorResponse errorResponse =
                    new ErrorResponse(e.getErrorCode().getStatus(), e.getErrorCode().getMessage());

            response.setStatus(e.getErrorCode().getStatus());
            response.setContentType("application/json");
            response.getWriter().write(errorResponse.convertObjectToJson(errorResponse));
        }
    }

}
