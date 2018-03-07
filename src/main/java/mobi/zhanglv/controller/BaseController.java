package mobi.zhanglv.controller;

import com.alibaba.fastjson.JSONObject;
import mobi.zhanglv.constant.ErrorConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

/**
 * Author cuizhengwei
 * Date   2018/3/2
 * Description 包含日志记录、异常处理
 */
@ControllerAdvice
public class BaseController {

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * 生成错误信息
	 * @param code
	 * @param description
	 * @return
	 */
	private JSONObject generateErrResponse(String code, String description){
		JSONObject resp = new JSONObject();
		JSONObject header = new JSONObject();
		header.put("code", code);
		header.put("description", description);
		resp.put("header", header);
		return resp;
	}

	/**
	 * 通用异常处理
	 * @param e
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(value = Exception.class)
	public JSONObject handleAllException(Exception e) {
		JSONObject resp = generateErrResponse(ErrorConstants.commonErr.getCode(), ErrorConstants.commonErr.getDescription() + " Exception: " + e.getMessage());
		e.printStackTrace();
		logger.error(e.getMessage());
		return resp;
	}

	@ExceptionHandler(value=MethodArgumentNotValidException.class)
	public JSONObject MethodArgumentNotValidHandler(MethodArgumentNotValidException e) {
		logger.error("参数验证失败", e);
		BindingResult result = e.getBindingResult();
		FieldError error = result.getFieldError();
		JSONObject resp = generateErrResponse(ErrorConstants.paramErr.getCode(), ErrorConstants.paramErr.getDescription() + " field: " + error.getField() + " message: " + error.getDefaultMessage());

//		@AssertFalse 校验false
//		@AssertTrue 校验true
//		@DecimalMax(value=,inclusive=) 小于等于value，
//		inclusive=true,是小于等于
//		@DecimalMin(value=,inclusive=) 与上类似
//		@Max(value=) 小于等于value
//		@Min(value=) 大于等于value
//		@NotNull  检查Null
//		@Past  检查日期
//		@Pattern(regex=,flag=)  正则
//		@Size(min=, max=)  字符串，集合，map限制大小
//		@Validate 对po实体类进行校验

		return resp;
	}
}
