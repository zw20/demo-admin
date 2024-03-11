package com.website.advice;

import cn.hutool.core.util.NumberUtil;
import com.alibaba.fastjson2.JSON;
import com.website.common.Response;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Map;

@RestControllerAdvice
public class ResponseControllerAdvice implements ResponseBodyAdvice {
    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (body == null) return Response.ok();
        if (body instanceof String){
            return JSON.toJSONString(Response.ok(body));
        }
        var s = JSON.toJSONString(body);
        if (!(s.startsWith("[")&&s.endsWith("]"))){
            Object code = JSON.parseObject(s, Map.class).get("code");
            if (code !=null && (NumberUtil.isNumber(code +"")) && 200 != Integer.parseInt(code + "")){
                return body;
            }
        }
        return Response.ok(body);
    }
}
