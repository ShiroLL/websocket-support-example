package top.hllcloud.websocket.example.action;

import org.springframework.validation.annotation.Validated;
import top.hllcloud.platform.supports.websocket.annotation.Action;
import top.hllcloud.platform.supports.websocket.annotation.ActionMapping;
import top.hllcloud.websocket.example.group.Add;
import top.hllcloud.websocket.example.group.Detail;
import top.hllcloud.websocket.example.group.Edit;
import top.hllcloud.websocket.example.vo.UserVO;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author hllshiro
 * @date 2022/9/1 17:33
 */
@Action("user")
public class UserAction {
    private static final AtomicLong FEDERATE_ID = new AtomicLong(0);

    private final ConcurrentHashMap<Long, UserVO> map = new ConcurrentHashMap<>();

    @ActionMapping("/add")
    public Long add(@Valid @NotNull(message = "{vo.null}", groups = {Add.class}) UserVO user) {
        user.setId(FEDERATE_ID.addAndGet(1));
        map.put(user.getId(), user);
        return user.getId();
    }

    @ActionMapping("/detail")
    public UserVO detail(@Valid @NotNull(message = "{vo.null}", groups = {Detail.class}) UserVO user) {
        return map.get(user.getId());
    }

    @ActionMapping("/edit")
    public Boolean edit(@Valid @NotNull(message = "{vo.null}", groups = {Edit.class}) UserVO user) {
        map.put(user.getId(), user);
        return true;
    }
}
