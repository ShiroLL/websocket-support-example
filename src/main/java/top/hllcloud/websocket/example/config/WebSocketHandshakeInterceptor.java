package top.hllcloud.websocket.example.config;

import cn.hutool.http.HttpUtil;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;
import top.hllcloud.platform.supports.websocket.consts.WebSocketConstant;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * @author hllshiro
 * @date 2022/9/1 15:41
 */
@Component
public class WebSocketHandshakeInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) {
        /*// 拒绝没有UA标识的连接
        UserAgent userAgent = UaUtil.getUserAgent(request.getHeaders());
        if (userAgent == null) {
            response.setStatusCode(HttpStatus.UNAUTHORIZED);
            return false;
        }*/
        // 将一些参数放入session属性域
        // header
        attributes.put(request.getHeaders().getClass().getSimpleName(), request.getHeaders());
        // uri
        attributes.put(WebSocketConstant.ENDPOINT, request.getURI().getPath());
        // query参数
        HttpUtil.decodeParamMap(request.getURI().getQuery(), StandardCharsets.UTF_8).forEach(attributes::put);
        return true;
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}
