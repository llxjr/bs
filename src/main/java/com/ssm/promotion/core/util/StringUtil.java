package com.ssm.promotion.core.util;

import java.util.UUID;

public class StringUtil {

    /**
     * @param str
     * @return
     */
    public static boolean isEmpty(String str) {
        if (str == null || "".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param str
     * @return
     */
    public static boolean isNotEmpty(String str) {
        if ((str != null) && !"".equals(str.trim())) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * @param str
     * @return
     */
    public static String formatLike(String str) {
        if (isNotEmpty(str)) {
            return "%" + str + "%";
        } else {
            return null;
        }
    }
    
    /**
     * 获取uuid
     * @return
     */
    public static String getUUID() {
    	UUID uuid = UUID.randomUUID();
    	String result = uuid.toString().replaceAll("-", "");
    	return result;
    }
    
}
