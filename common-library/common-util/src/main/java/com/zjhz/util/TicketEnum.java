package com.zjhz.util;

/**
 * Created by songabao on 2018/12/26.
 */

public enum TicketEnum {
    /**
     * 电子票  1
     */
     ETicket(1 << 0),
    /**
     * 纸制票  2
     */
     PaperTicket(1 << 1),
    /**
     * 纸制票方式快递 4
     */
     Express(1 << 2),
    /**
     * 纸制票方式自取 8
     */
    Obtain(1 << 3);
    public Integer code;
    private TicketEnum(Integer code) {
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
