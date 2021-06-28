//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.aspect;

import com.pojo.Staff;
import com.service.StaffService;
import com.utils.JWTUtil;
import com.utils.R;
import io.jsonwebtoken.Claims;
import java.lang.reflect.Method;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Component
@Aspect
public class AdminHandle {
    private static final Logger log = LoggerFactory.getLogger(AdminHandle.class);
    @Autowired
    private R r;
    @Autowired
    private StaffService staffService;

    public AdminHandle() {
    }

    @Pointcut("@annotation(com.annotation.Admin)")
    public void Admin() {
    }

    @Around("Admin()")
    public Object Around(ProceedingJoinPoint joinPoint) throws Throwable {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes)requestAttributes).getRequest();
        String token = request.getHeader("token");
        Claims claims = null;
        if (token == null) {
            return this.r.error();
        } else {
            try {
                claims = JWTUtil.parseToken(token);
            } catch (Exception var9) {
                return this.r.error().message("身份验证失败");
            }

            String username = (String)claims.get("username");
            String password = (String)claims.get("password");
            Staff staff = this.staffService.queryUserAndPass(username, password);
            if (token.equals(staff.getToken())) {
                if (staff.getState() == 0 || staff.getJobId() == 0) {
                    return this.r.error().message("您无权操作");
                }

                joinPoint.proceed();
            }

            return this.r.error().message("身份信息不一致");
        }
    }

    public Method getMethod(ProceedingJoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature)joinPoint.getSignature();
        return methodSignature.getMethod();
    }
}
