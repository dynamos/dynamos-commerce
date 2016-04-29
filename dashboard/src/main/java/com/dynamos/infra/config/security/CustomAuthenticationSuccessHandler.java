package com.dynamos.infra.config.security;

import com.dynamos.domain.entity.User;
import com.dynamos.domain.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 * Created by adelmo on 06/02/16.
 */
@Component
public class CustomAuthenticationSuccessHandler implements
        AuthenticationSuccessHandler {

    @Autowired
    private UserRepository userRepository;

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response, Authentication authentication) throws IOException,
            ServletException {


        saveDateTimeLoginUser(request, authentication);

        redirectStrategy.sendRedirect(request, response, "/");
    }

    private void saveDateTimeLoginUser(HttpServletRequest request, Authentication authentication)throws IOException, ServletException{
        HttpSession session = request.getSession();

        String login = authentication.getName();
        User user = userRepository.findOneByLogin(login).get();

        session.setAttribute("latestUserLoginTime", user.getLatestLogin());

        user.setLatestLogin(LocalDateTime.now());

        userRepository.save(user);
    }

}
