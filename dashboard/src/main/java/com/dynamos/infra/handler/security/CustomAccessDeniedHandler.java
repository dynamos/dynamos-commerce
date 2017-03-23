package br.com.dynamos.infra.handler.security;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.security.web.csrf.CsrfException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {

	private AccessDeniedHandlerImpl accessDeniedHandlerImpl = new AccessDeniedHandlerImpl();

	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
		if (accessDeniedException instanceof CsrfException && !response.isCommitted()) {
			String pCookieName = "CSRF-TOKEN";
			Cookie cookie = new Cookie(pCookieName, "");
			cookie.setMaxAge(0);
			cookie.setHttpOnly(false);
			cookie.setPath("/");
			response.addCookie(cookie);
		}

		accessDeniedHandlerImpl.handle(request, response, accessDeniedException);
	}
}
