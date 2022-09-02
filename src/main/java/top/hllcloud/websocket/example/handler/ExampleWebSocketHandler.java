package top.hllcloud.websocket.example.handler;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import top.hllcloud.platform.supports.websocket.annotation.WebSocketHandler;
import top.hllcloud.platform.supports.websocket.dispatcher.ActionDispatcher;
import top.hllcloud.platform.supports.websocket.handler.BaseWebSocketHandler;
import top.hllcloud.websocket.example.config.WebSocketHandshakeInterceptor;

import javax.annotation.Resource;

@WebSocketHandler(value = "/ws", interceptor = WebSocketHandshakeInterceptor.class)
public class ExampleWebSocketHandler extends BaseWebSocketHandler {

    @Resource
    private ActionDispatcher actionDispatcher;

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // 直接调用请求分发器
        actionDispatcher.doAction(session, message);
    }

    @Override
    public void handleTransportError(WebSocketSession session, Throwable exception) throws Exception {
        super.handleTransportError(session, exception);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
    }
}
