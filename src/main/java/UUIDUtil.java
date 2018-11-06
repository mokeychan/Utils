package ink.lombok.utils;

import java.util.UUID;

/**
 * @Description: UUID工具类
 * @Author: chenfeixiang
 * @Date: Created in 11:03 2018/10/23
 */
public class UUIDUtil {

    public static String getUuid(){
        return UUID.randomUUID().toString().replace("-","");
    }
}
