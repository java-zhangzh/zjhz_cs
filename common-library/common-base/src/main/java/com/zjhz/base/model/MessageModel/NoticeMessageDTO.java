package com.zjhz.base.model.MessageModel;

import com.zjhz.base.enums.MessageTypeEnum;
import com.zjhz.base.enums.ProcuctCodeEnum;
import lombok.Data;

import java.util.Date;

/**
 * <b>功能名：</b>noticeMessageDTO<br>
 * <b>说明：个人通知 参数对象</b><br>
 * <b>著作权：</b> Copyright (C) 2019 zjhz  CORPORATION<br>
 * <b>修改履历：
 *
 * @author 2019-06-14 Cheng
 */
@Data
public class NoticeMessageDTO {

//    @NotNull(message = "接收人ID不能为空")
    private Long id;

//    @NotNull(message = "头像url不能为空")
    private String imageUrl;

//    @NotNull(message = "接受人姓名不能为空")
    private String name;

//    @NotNull(message = "端类型不能为空")
    private ProcuctCodeEnum platformType;

//    @NotNull(message = "消息类型不能为空")
    private MessageTypeEnum messageType;

    private String title;

//    @NotNull(message = "内容不能为空")
    private String content;

//    @NotNull(message = "通知时间不能为空")
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date releaseDate;
}
