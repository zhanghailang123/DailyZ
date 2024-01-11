package zhilian.z2023.z231115;

import lombok.Getter;

@Getter
public enum BizTypeEnum {

    A(1, "业务A"),
    B(2, "业务B"),
    C(3, "业务C"),
    D(4, "业务D"),
    ;

    private int code;
    private String msg;

    BizTypeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 整形值转换为枚举类
     *
     * @param value 值
     * @return 枚举类
     */
    public static BizTypeEnum valueOf(int value) {
        for (BizTypeEnum anEnum : values()) {
            if (value == anEnum.getCode()) {
                return anEnum;
            }
        }
        return null;
    }
}
