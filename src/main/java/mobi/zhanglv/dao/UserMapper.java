package mobi.zhanglv.dao;

import mobi.zhanglv.model.User;
import mobi.zhanglv.model.UserShort;

public interface UserMapper {
    int deleteUser(Long uId);

    int addNewUser(User user);

    int insertSelective(User record);

    User selectByPrimaryKey(Long uId);

    UserShort selectUserShortByUid(Long uId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}