package com.beginner.wechat.constant;

/**
 * @author heqing
 * @date 2018/5/22.
 */
public enum SexType {

    /**
     * IOS :  苹果系统
     */
    MAN("1"),
    /**
     * click :  其他系统
     */
    FEMALE("2");

    SexType(String code) {
        this.code = code;
    }

    String code;

    public String getCode() {
        return code;
    }

    public static String getSex(SexType sexType) {
        String sex = null;
        if(sexType != null) {
            switch (sexType) {
                case MAN:
                    sex = SexType.MAN.getCode();
                    break;
                case FEMALE:
                    sex = SexType.FEMALE.getCode();
                    break;
                default:
                    sex = "";
            }
        }
        return sex;
    }
}
