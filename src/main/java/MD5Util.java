package ink.lombok.utils;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @Description: 封装两次MD5加密
 * @Author: chenfeixiang
 * @Date: Created in 10:43 2018/10/23
 */
public class MD5Util {

    public static String md5(String src){
        return DigestUtils.md5Hex(src);
    }

    private static final String salt = "1a2b3c4d";// 定义加密盐

    /**
     * 第一次MD5
     * 用于 通过输入的密码生成 传输的密码 ：方法 通过固定盐值和明文密码之间的拼接在生成md5
     * @param inputPass
     * @return
     */
    public static String inputPassToFormPass(String inputPass){
        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 第二次MD5
     * 通过输入的密码和数据库随机盐值 继续生成 密码
     * @param formPass
     * @param salt
     * @return
     */
    public static String formPassToDBPass(String formPass,String salt){
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    /**
     * 最终生成加密密码的方法
     * @param input
     * @param saltDB
     * @return
     */
    public static String inputPassToDBPass(String input,String saltDB){
        String formPass = inputPassToFormPass(input);
        return formPassToDBPass(formPass,saltDB);
    }

    public static void main(String[] args) {
        System.out.println(inputPassToDBPass("123456","1a2b3c4d"));
    }

}
