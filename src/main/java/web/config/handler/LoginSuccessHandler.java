package web.config.handler;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Set;

@Component
public class LoginSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse,
                                        Authentication authentication) throws IOException {
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());
        System.out.println("Just test String here: " + roles.toString());
        if (roles.contains("ADMIN")) {
            System.out.println("loginSuccessHandler roles contains: " + roles.toString());
            httpServletResponse.sendRedirect("/adminusers");
        } else if (roles.contains("USER")) {
            System.out.println("loginSuccessHandler roles contains: " + roles.toString());
            httpServletResponse.sendRedirect("/users");
        } else {
            System.out.println("loginSuccessHandler roles contains: " + roles.toString());
            httpServletResponse.sendRedirect("/");
        }
    }
}