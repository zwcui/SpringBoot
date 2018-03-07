package mobi.zhanglv.model;

/**
 * Author cuizhengwei
 * Date   2018/3/6
 * Description 用户简略信息
 */
public class UserShort {

	public UserShort(){}

	private Long uId;

	private String phoneNumber;

	private String password;

	private String salt;

	private String nickName;

	public UserShort(Long uId, String phoneNumber, String password, String salt, String nickName) {
		this.uId = uId;
		this.phoneNumber = phoneNumber;
		this.password = password;
		this.salt = salt;
		this.nickName = nickName;
	}

	public Long getuId() {
		return uId;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public String getSalt() {
		return salt;
	}

	public String getNickName() {
		return nickName;
	}

	public void setuId(Long uId) {
		this.uId = uId;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
}
