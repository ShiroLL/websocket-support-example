package top.hllcloud.websocket.example.vo;

import lombok.Data;
import top.hllcloud.websocket.example.group.Message;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Data
public class MessageVO implements Serializable {

    @Valid
    @NotNull(message = "{vo.message.from}", groups = {Message.class})
    private UserVO from;

    @Valid
    @NotNull(message = "{vo.message.to}", groups = {Message.class})
    private UserVO to;

    @NotBlank(message = "{vo.message.content}", groups = {Message.class})
    private String content;
}
