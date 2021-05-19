package shop.ryuseulgi.goodCasting.security.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import shop.ryuseulgi.goodCasting.security.domain.SecurityProvider;
import shop.ryuseulgi.goodCasting.security.exception.SecurityRuntimeException;
import shop.ryuseulgi.goodCasting.user.login.domain.UserDTO;
import shop.ryuseulgi.goodCasting.user.login.domain.UserVO;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class SecurityFilter extends OncePerRequestFilter {
    private final SecurityProvider provider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {
        System.out.println("doFilterInternal : 진입");

        String token = provider.resolveToken(request);
        System.out.println("token " + token);

        try {
            if(token != null && provider.validateToken(token)) {
                Authentication auth = provider.getAuthentication(token);
                System.out.println("auth : " + auth);
                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        } catch(SecurityRuntimeException e) {
            System.out.println("SecurityRuntimeException!!!!!!");
            SecurityContextHolder.clearContext();
            response.sendError(e.getHttpStatus().value(), e.getMessage());
        } catch(Exception e) {
            e.printStackTrace();
        }
        filterChain.doFilter(request, response);
    }
}