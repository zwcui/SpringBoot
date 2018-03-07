package mobi.zhanglv.service.impl;

import mobi.zhanglv.dao.UserMapper;
import mobi.zhanglv.model.User;
import mobi.zhanglv.model.UserShort;
import mobi.zhanglv.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Author cuizhengwei
 * Date   2018/3/6
 * Description
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	@Override
	@Transactional
	public User selectUserByUid(long uId) {
		return userMapper.selectByPrimaryKey(uId);
	}

	@Override
	@Transactional
	public UserShort selectUserShortByUid(long uId) {
		return userMapper.selectUserShortByUid(uId);
	}

	@Override
	@Transactional
	public int deleteUserByUid(long uId) {
		return userMapper.deleteUser(uId);
	}

	@Override
	@Transactional
	public int addNewUser(User user) {
		return userMapper.addNewUser(user);
	}

//	@Override
//	public List<User> selectAllUsers() {
//		return userMapper.selectAllUsers();
//	}
//
//	@Override
//	public int countAllUsers() {
//		return userMapper.countAllUsers();
//	}
//
//	@Override
//	public int addNewUser(User user) {
//		return userMapper.addNewUser(user);
//	}

}
