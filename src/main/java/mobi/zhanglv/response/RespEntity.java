package mobi.zhanglv.response;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Author cuizhengwei
 * Date   2018/2/27
 * Description 定义公共返回报文头
 */
public class RespEntity {

    /**
     * 正常访问公共报文头
     * @param data
     * @return
     */
    public static JSONObject generateResp(Object data){
        JSONObject resp = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("code", "1000");
        header.put("description", "success");
        resp.put("header", header);
        resp.put("data", data);
        return resp;
    }

    /**
     * 异常访问报文头
     * @param code
     * @param description
     * @return
     */
    public static JSONObject generateErrorResp(String code, String description){
        JSONObject resp = new JSONObject();
        JSONObject header = new JSONObject();
        header.put("code", code);
        header.put("description", description);
        resp.put("header", header);
        return resp;
    }
}
