package com.website.exception;

import com.website.Common.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice(basePackages = {"com.website"})
public class ExceptionControllerAdvice {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public Response handlerValidException(MethodArgumentNotValidException e) {
        Map<String, String> map = new HashMap<>();
        e.getFieldErrors().forEach(fieldError -> {
            map.put(fieldError.getField(), fieldError.getDefaultMessage());
        });
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        response.setStatus(500);
        log.error("ERROR HAPPENED:", e);
        return Response.error(100102,"参数错误",map);
    }

    @ExceptionHandler(value = Throwable.class)
    public Response handlerException(Throwable throwable){
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletResponse response = requestAttributes.getResponse();
        response.setStatus(500);
        log.error("ERROR HAPPENED:", throwable);
        return Response.error(100101,"未知异常",throwable.getMessage());
    }

    @ExceptionHandler(value = CommonResException.class)
    public Response handlerCommonException(CommonResException e){
        int code = e.getCode();
        if (code >= 500){
            ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
            HttpServletResponse response = requestAttributes.getResponse();
            response.setStatus(500);
        }
        log.error("ERROR HAPPENED:", e);
        String msg = e.getMsg();
        if (msg.contains(":")) msg = msg.substring(msg.indexOf(":") + 1);
        return Response.error(code,msg);
    }






}
