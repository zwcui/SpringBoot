package mobi.zhanglv.service;

import mobi.zhanglv.model.User;
import mobi.zhanglv.model.UserShort;

import java.util.List;

/**
 * Author cuizhengwei
 * Date   2018/3/6
 * Description Service层
 */
public interface UserService {

	public User selectUserByUid(long uId);

	public UserShort selectUserShortByUid(long uId);

	public int deleteUserByUid(long uId);

	//	public  List<User> selectAllUsers();
//
//	public int countAllUsers();
//
	public int addNewUser(User user);

}
