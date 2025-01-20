package ro.uvt.filters;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@WebFilter("/*")
public class RequestLoggingFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, jakarta.servlet.ServletException {
        System.out.println("Request received: " + request.toString());
        chain.doFilter(request, response);
        System.out.println("Response sent: " + response.toString());
    }
}