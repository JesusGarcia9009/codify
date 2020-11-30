package com.ms.codify.config;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.ms.codify.config.security.KeyClaimsTokenEnum;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

/**
 * Get vars from Headers and set to local storage - Spring Boot
 *
 * @author Jesus Garcia
 * @since 1.0
 * @version jdk-11
 */
@Component
public class TenantNameInterceptor extends HandlerInterceptorAdapter {
	
	private static final String JWT_SECRET ="CODIFY-SOS-SECRET";
	public static final String DEFAULT_TENANT = "codify_default";
	public static final String DEFAULT_AUTH = "Authorization";
	
	@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // example code we are just extracting a Header value:
        String authorization = request.getHeader(DEFAULT_AUTH);
        
        String tenant = null;
        if(authorization != null)
        	tenant = getTenantDtos(authorization.substring(7, authorization.length()));

        // could still be persisted within the ThreadLocal:
        ThreadLocalStorage.setTenantName(tenant == null ? DEFAULT_TENANT : tenant);

        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        // After completing the request, make sure to erase the Tenant from the current Thread. It's
        // because Spring may reuse the Thread in the Thread Pool and you don't want to leak this
        // information:
        ThreadLocalStorage.setTenantName(null);
    }
    
    /**
	 * getTenant from token - Spring Boot
	 *
	 * @author Jesus Garcia
	 * @since 1.0
	 * @version jdk-11
	 * @param token  - token del usuario, extraer caracteristica de tenant
	 * @return Tenhant key
	 */
	public String getTenantDtos(String token) throws IOException {
		Claims claims = Jwts.parser().setSigningKey(JWT_SECRET).parseClaimsJws(token).getBody();
		return claims.get(KeyClaimsTokenEnum.TENANT.getDescripcion(), String.class);
	}
	
}
