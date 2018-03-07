package mobi.zhanglv.aop;

import mobi.zhanglv.response.RespEntity;
import mobi.zhanglv.util.RSAUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Author cuizhengwei
 * Date   2018/3/7
 * Description 接口签名rsa验证，公钥私钥放内存中更快
 */
@Component
@Aspect
@Order(1)    //order越小越是最先执行，但更重要的是最先执行的最后结束
public class BaseVisitAop {

	private static final String signSource = "zhanglv";

	private static final String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdytrFtV8V5j1RrIyAS4Jj3m0Le0PucxFtbzKf" +
			"7dp2AMhoKnKmTrvSJgEa5i/x6SLOrS6/2yNADR3K+U6O5RKekf8dKjzpG0Sp8kEsh98aMUliOleu" +
			"1SSOkSp4OG2BsOWOvIUeNeRvFIyDiYUy9Xjad0x4EkaBReaJEd+Pvc+3dQIDAQAB";

	private static final String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ3K2sW1XxXmPVGsjIBLgmPebQt7" +
			"Q+5zEW1vMp/t2nYAyGgqcqZOu9ImARrmL/HpIs6tLr/bI0ANHcr5To7lEp6R/x0qPOkbRKnyQSyH" +
			"3xoxSWI6V67VJI6RKng4bYGw5Y68hR415G8UjIOJhTL1eNp3THgSRoFF5okR34+9z7d1AgMBAAEC" +
			"gYBFszaCAMTYspRBgJurjC8zmCvI15FBQhjfoy/Uj0dhuqTLxnxQVBUJFfqE/EsPa7ERZFRzMQRY" +
			"JbMUVp3J5wwaw+e45grLLDPAu2/5mExGeY2pBLmXadxKz4k1Mip+H1X1+YNHQ/gIUjx3mSGAdQ4i" +
			"o8kNzwQdKhMEs4x8HISNIQJBAPehOXPH4LuXgHpn4sHI2hULCPd2VOtcoygtGj28rdBmXT2J5tw1" +
			"udM4s24zf4g8iTj1UqMkT3NMsi9x2mHkCP0CQQCjIEErSV0HdTrO0JYULEfbwhj33g0vpzYys5dX" +
			"ZWbni0m7GoOX+s875Ac9Bz7MaLiw9YNCWkRx1DA7BHghEE3ZAkA6Sl5ezccuAWzB46ByI1iKqY1T" +
			"yywUNztE4tERhU+ZBe+e485POepjOS6rmz3DERTwLndkZdC6AGzVVESm1Gn1AkA1oH/sJBUiQ4bO" +
			"wMHl5dzFwRyGOAirttPZfTLut1ZKHn9htEi4qOqB7Of4Ry588pxtCHlbUeOYbEJi1IhNjleZAkAW" +
			"1PLAh83SmXFTbWwr7nhu+3hsai53fkRZ4BVrrE1GHq3UAbWP3ZTA1lLdBSP7st1pzUjOMfb7i06t" +
			"v66bErZm";

	protected final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Pointcut("execution(* mobi.zhanglv.controller.*.*(..))")
	public void executeService(){

	}

	@Around("executeService()")
	public Object doAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) throws Exception {
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();

		byte[] encodedData = signSource.getBytes();
		String sign = request.getHeader("sign");
		boolean status = false;
		try{
			status = RSAUtil.verify(encodedData, publicKey, sign);
		}catch(Exception e){
			logger.info("------接口访问签名验证异常------- request.getRemoteHost()="+request.getRemoteHost()+" request.getRemoteAddr()="+request.getRemoteAddr()+" request.getRemotePort()="+request.getRemotePort());
			return RespEntity.generateErrorResp("999","签名验证异常");
		}

		if(!status){
			logger.info("------接口访问签名验证异常------- request.getRemoteHost()="+request.getRemoteHost()+" request.getRemoteAddr()="+request.getRemoteAddr()+" request.getRemotePort()="+request.getRemotePort());
			return RespEntity.generateErrorResp("999","签名验证失败");
		}

		try {
			Object obj = proceedingJoinPoint.proceed();
			return obj;
		} catch (Exception e) {
			throw e;
		} catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		return null;
	}

}
