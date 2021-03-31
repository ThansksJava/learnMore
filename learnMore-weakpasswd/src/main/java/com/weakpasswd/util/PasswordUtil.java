package com.weakpasswd.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Util Class is used to Encode/Decode the string
 * @author wangjing
 * @date 2018/05/14
 */
public class PasswordUtil {

    private static Logger logger = LoggerFactory.getLogger(PasswordUtil.class);

    /**
     * Encode the string
     * @param str
     * @return
     */
    public static String encoding(String str) {
        if (str == null || str.length() == 0) {
            return "";
        }

        byte[] b = str.getBytes();
        StringBuffer encodedPassword = new StringBuffer();
        for (int i = 0; i < b.length; i++) {
            if ( (int) b[i] < 0) {
                encodedPassword.append(encodedPassword).append(
                        Integer.toHexString( (int) b[i]).substring(6).toUpperCase());
            } else {
                encodedPassword.append(Integer.toHexString( (int) b[i]).toUpperCase());
            }
        }

        return encodedPassword.toString();
    }

    /**
     * Decode the string
     * @param str
     * @return
     */
    public static String decoding(String str) {

        byte[] bt = str.getBytes();
        if (bt.length % 4 == 2) {
            str += "00";
        }
        bt = str.getBytes();
        byte[] b = new byte[bt.length / 2];
        int j;
        try {
            j = 0;
            for (int i = 0; i < str.length(); i += 4) {
                b[i / 4 + j] = Integer.decode("0X" + str.substring(i, i + 2)).
                        byteValue();
                b[i / 4 + 1 + j] = Integer.decode("0X" + str.substring(i + 2, i + 4)).
                        byteValue();
                j++;
            }
            str = new String(b, 0, b.length, "gb2312").trim();
        } catch (Exception e) {
            logger.error("PasswordUtil.decoding() error {}",e);
        }
        return str;
    }

    public static void main(String[] args) {
        System.out.println(PasswordUtil.decoding("217140772365247221"));
    }
}