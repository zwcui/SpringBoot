package mobi.zhanglv.constant;

/**
 * Author cuizhengwei
 * Date   2018/3/2
 * Description 错误结构定义
 */
public class Error {

	private String code;

	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Error(String code, String description){
		this.code = code;
		this.description = description;
	}
}
