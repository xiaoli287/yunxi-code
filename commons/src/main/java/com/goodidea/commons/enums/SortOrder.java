package com.goodidea.commons.enums;

/**
 * @author lsh
 * @date 2023/8/15 10:19
 */
public enum SortOrder {
    DESC,
    ASC;

    private final int value = 0;

    private SortOrder() {
    }

    public static SortOrder findByValue(int value) {
        switch (value) {
            case 0:
                return DESC;
            case 1:
                return ASC;
            default:
                return null;
        }
    }

    public int getValue() {
        this.getClass();
        return 0;
    }


}
