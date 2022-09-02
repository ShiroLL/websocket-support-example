package top.hllcloud.websocket.example.vo;

import lombok.Data;
import top.hllcloud.websocket.example.group.Add;
import top.hllcloud.websocket.example.group.Detail;
import top.hllcloud.websocket.example.group.Edit;
import top.hllcloud.websocket.example.group.Message;

import javax.validation.constraints.*;
import java.io.Serializable;

@Data
public class UserVO implements Serializable {

    @Positive(message = "{vo.err.id}", groups = {Detail.class, Edit.class, Message.class})
    @NotNull(message = "{vo.null.id}", groups = {Detail.class, Edit.class, Message.class})
    private Long id;

    @NotBlank(message = "{vo.null.name}", groups = {Add.class})
    private String userName;

    @NotNull(message = "{vo.null.sex}", groups = {Add.class})
    @Max(value = 2L, message = "{vo.num.more}", groups = {Add.class})
    @Min(value = 1L, message = "{vo.num.less}", groups = {Add.class})
    private Integer sex;

}
