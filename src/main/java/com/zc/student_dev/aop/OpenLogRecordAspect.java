package com.zc.student_dev.aop;

/*import com.yingying.callcenter.common.ShiroUtils;
import com.yingying.callcenter.domain.SysLog;
import com.yingying.callcenter.domain.SysPermission;
import com.yingying.callcenter.domain.SysUser;
import com.yingying.callcenter.service.SysLogService;
import com.yingying.callcenter.service.SysPermissionService;*/
import com.zc.student_dev.service.ISysPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @description: 日志切面类
 */
@Slf4j
@Aspect
@Component
public class OpenLogRecordAspect {

   /* @Autowired
    private SysLogService sysLogService;
    @Autowired
    private ISysPermissionService sysPermissionService;

    @Pointcut("@within(com.yingying.callcenter.annotation.OpenLogRecord) || @annotation(com.yingying.callcenter.annotation.OpenLogRecord)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object doAfter(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        StringBuffer data = new StringBuffer();
        for (Object arg : args) {
            data.append(arg.toString());
        }
        Object proceed = point.proceed();
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Method method = methodSignature.getMethod();
        RequiresPermissions requiresPermissions = method.getAnnotation(RequiresPermissions.class);
        if (requiresPermissions == null) {
            return proceed;
        }
        String[] permissions = requiresPermissions.value();
        if (ArrayUtils.isNotEmpty(permissions) && permissions.length > 0) {
            String permissionCode = permissions[0];
            SysPermission sysPermission = sysPermissionService.selectOneByCode(permissionCode);
            if (sysPermission == null) {
                return proceed;
            }
            SysLog sysLog = new SysLog();
            SysUser currentUser = ShiroUtils.getSessionUser();
            if (currentUser != null) {
                sysLog.setUserId(currentUser.getId());
                sysLog.setOperator(currentUser.getUsername());
            }else{
                return proceed;
            }
            SysPermission parent = sysPermissionService.selectById(sysPermission.getPid());
            sysLog.setTitle(parent.getName());
            sysLog.setAction(sysPermission.getName());
            HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
            sysLog.setUrl(request.getRequestURI());
            sysLog.setData(data.toString());
            sysLog.setOperationTime(new Date());
            sysLog.setStatus(1);
            sysLogService.insert(sysLog);
        }
        return proceed;
    }*/
}
