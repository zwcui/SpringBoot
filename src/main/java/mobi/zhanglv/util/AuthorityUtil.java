package mobi.zhanglv.util;

import mobi.zhanglv.model.User;

/**
 * Author cuizhengwei
 * Date   2018/3/5
 * Description 权限匹配
 */
public class AuthorityUtil {

	//普通用户
	private static final int normal = 0;

	//超级管理员
	private static final int superAdmin = 2;

	//管理员
	private static final int Admin = 4;

	//特殊管理员
	private static final int specialAdmin = 8;

	/**
	 * 判断用户是否为管理员
	 * @param uId
	 * @return
	 */
	public static boolean isAdmin(int uId){
		User user = DataUtil.getUserWithUId(uId);
		if(user.getuId() == 0){
			return false;
		}
		if(user.getType() != normal){
			return true;
		}
		return false;
	}

	/**
	 * 判断用户是否为超级管理员
	 * @param uId
	 * @return
	 */
	public static boolean isSuperAdmin(int uId){
		User user = DataUtil.getUserWithUId(uId);
		if(user.getuId() == 0){
			return false;
		}
		if(user.getType() != superAdmin){
			return true;
		}
		return false;
	}

	/**
	 * 判断用户是否为其他管理员
	 * @param uId
	 * @return
	 */
	public static boolean isSpecialAdmin(int uId){
		User user = DataUtil.getUserWithUId(uId);
		if(user.getuId() == 0){
			return false;
		}
		if(user.getType() != specialAdmin){
			return true;
		}
		return false;
	}

}
