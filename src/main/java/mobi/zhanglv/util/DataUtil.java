package mobi.zhanglv.util;

import mobi.zhanglv.dao.UserMapper;
import mobi.zhanglv.model.User;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Author cuizhengwei
 * Date   2018/3/5
 * Description 数据类工具
 */
public class DataUtil {

	@Autowired
	private static UserMapper userMapper;

//	public static User getUserWithUId(int uId){
//		return userMapper.selectUserByUid(uId);
//	}

	public static User getUserWithUId(long uId){
		return userMapper.selectByPrimaryKey(uId);
	}

}
