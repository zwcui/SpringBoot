package mobi.zhanglv.response;

import com.alibaba.fastjson.JSONObject;
import mobi.zhanglv.model.User;
import mobi.zhanglv.util.TimeUtil;

import java.util.List;

/**
 * Author cuizhengwei
 * Date   2018/2/28
 * Description response的data容器
 */
public class BaseContainer extends RespEntity{

	/**
	 * 列表容器
	 * @param totalCount
	 * @param pageNum
	 * @param pageTime
	 * @param arrayName
	 * @param data
	 * @return
	 */
	public static JSONObject generateListContainer(int totalCount, int pageNum, int pageTime, String arrayName, Object data){
		JSONObject listContainer = new JSONObject();
		listContainer.put("totalCount", totalCount);
		listContainer.put("pageNum", pageNum);
		listContainer.put("pageTime", pageTime);
		listContainer.put(arrayName, data);
		return listContainer;
	}

	/**
	 * 一般容器
	 * @param result
	 * @param description
	 * @return
	 */
	public static JSONObject generateResultContainer(boolean result, String description){
		JSONObject resultContainer = new JSONObject();
		if(result){
			resultContainer.put("result", "succeed");
			resultContainer.put("description", description == null || "".equals(description) ? "处理成功" : description);
		}else{
			resultContainer.put("result", "fail");
			resultContainer.put("description", description == null || "".equals(description) ? "处理失败" : description);
		}
		resultContainer.put("time", TimeUtil.getUnixTimeOfBeiJing());
		return resultContainer;
	}


}
