package com.chris.pisco.util;

import java.security.MessageDigest;

/**
 * Created by chris on 2018/2/7.
 */

public class MDigest5 {

    public static String MD5(String s) {
        String hexStr = null;
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] bytes = md.digest(s.getBytes("utf-8"));
            hexStr = toHex(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return hexStr;
    }

    private static String toHex(byte[] bytes) {
        final char[] HEX_DIGITS = "0123456789ABCDEF".toCharArray();
        StringBuilder ret = new StringBuilder(bytes.length * 2);
        for (int i = 0; i < bytes.length; i++) {
            ret.append(HEX_DIGITS[(bytes[i] >> 4) & 0x0f]);
            ret.append(HEX_DIGITS[bytes[i] & 0x0f]);
        }
        return ret.toString();
    }
}
