package com.zjhz.base.enums;

public enum DeviceTypeEnum {
    Bracelet(10L,"手环"),
    VehiclePositioner(20L,"车载定位刷卡器"),
    BluetoothSensor(30L,"蓝牙基站"),
    Ibeacon(40L,"蓝牙ibeacon");

    private Long code;
    private String name;

    DeviceTypeEnum(Long code, String name) {
        this.code = code;
        this.name = name;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }
}
