package mobi.zhanglv.util;

import java.util.Calendar;
import java.util.Locale;

/**
 * Author cuizhengwei
 * Date   2018/3/1
 * Description 时间工具类
 */
public class TimeUtil {

	/**
	 * 获取当前unix时间
	 * @return
	 */
	public static int getUnixTimeOfBeiJing(){
		long time = System.currentTimeMillis();
		long nowTimeStamp = time / 1000;
		return (int)nowTimeStamp;
	}

}
