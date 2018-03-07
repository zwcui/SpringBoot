package mobi.zhanglv.util;

import mobi.zhanglv.constant.CommonConstants;

/**
 * Author cuizhengwei
 * Date   2018/3/1
 * Description 常用工具类
 */
public class CommonUtil {

	/**
	 * 获取分页大小
	 * @param pageSize
	 * @return
	 */
	public static int getPageSize(Integer pageSize){
		return pageSize == null || pageSize <=1 ? CommonConstants.pageSize : pageSize;
	}

}
