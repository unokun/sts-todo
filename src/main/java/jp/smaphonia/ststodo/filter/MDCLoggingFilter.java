package jp.smaphonia.ststodo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.MDC;

public class MDCLoggingFilter implements Filter {
	private static final String KEY_REQUEST_ID = "REQUEST_ID";
	private static final String KEY_LOGIN_USER_ID = "LOGIN_USER_ID";

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		putMDC(request);
		try {
			chain.doFilter(request, response);
		} finally {
			clearMDC();
		}
	}
	
	private void putMDC(ServletRequest request) {
		if (request instanceof HttpServletRequest) {
			HttpServletRequest httpRequest = (HttpServletRequest)request;
			
			String requestId = httpRequest.getHeader("X-Request-Id");
			if (requestId != null) {
				MDC.put(KEY_REQUEST_ID, requestId);
			}
			
			// [TODO]Session情報から取得
			String loginUserId = "aaa";
			if (loginUserId != null) {
				MDC.put(KEY_LOGIN_USER_ID, loginUserId);
			}
		}
	}

	private void clearMDC() {
		MDC.remove(KEY_REQUEST_ID);
		MDC.remove(KEY_LOGIN_USER_ID);
	}

}
