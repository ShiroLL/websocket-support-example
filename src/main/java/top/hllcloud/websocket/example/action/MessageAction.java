package top.hllcloud.websocket.example.action;

import top.hllcloud.platform.supports.websocket.annotation.Action;
import top.hllcloud.platform.supports.websocket.annotation.ActionMapping;
import top.hllcloud.websocket.example.group.Message;
import top.hllcloud.websocket.example.vo.MessageVO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Action
public class MessageAction {

    @ActionMapping(value = "message", check = false)
    public MessageVO message(@Valid @NotNull(message = "{vo.null}", groups = {Message.class}) MessageVO message) {
        return message;
    }
}
