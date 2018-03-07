package mobi.zhanglv.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;


import org.springframework.util.Base64Utils;
import org.springframework.util.ResourceUtils;

/**
 * Author cuizhengwei
 * Date   2018/3/7
 * Description 验签
 */
public class RSAUtil {

	/** 指定加密算法为RSA */
	private static final String ALGORITHM = "RSA";

	public static void main(String[] args) throws Exception {

		String source = "zhanglv";// 要加密的字符串
		System.out.println("准备用公钥加密的字符串为：" + source);

		byte[] encodedData = source.getBytes();

		String privateKey = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAJ3K2sW1XxXmPVGsjIBLgmPebQt7" +
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
		String publicKey = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCdytrFtV8V5j1RrIyAS4Jj3m0Le0PucxFtbzKf" +
				"7dp2AMhoKnKmTrvSJgEa5i/x6SLOrS6/2yNADR3K+U6O5RKekf8dKjzpG0Sp8kEsh98aMUliOleu" +
				"1SSOkSp4OG2BsOWOvIUeNeRvFIyDiYUy9Xjad0x4EkaBReaJEd+Pvc+3dQIDAQAB";


		System.err.println("私钥签名——公钥验证签名");
		String sign = sign(encodedData, privateKey);
		System.err.println("签名:\r" + sign);
		boolean status =verify(encodedData, publicKey, sign);
		System.err.println("验证结果:\r" + status);

	}

	private static Key getKey(String fileName) throws Exception, IOException {
		Key key;
		ObjectInputStream ois = null;

		File file = ResourceUtils.getFile(fileName);

		try {
			/** 将文件中的私钥对象读出 */
			ois = new ObjectInputStream(new FileInputStream(fileName));
			key = (Key) ois.readObject();
		} catch (Exception e) {
			throw e;
		} finally {
			ois.close();
		}
		return key;
	}

	/**
	 * 校验数字签名
	 *
	 * @param data 已加密数据
	 * @param publicKey 公钥(BASE64编码)
	 * @param sign 数字签名
	 *
	 * @return
	 * @throws Exception
	 *
	 */
	public static boolean verify(byte[] data, String publicKey, String sign)
			throws Exception {
		byte[] keyBytes = Base64Utils.decode(publicKey.getBytes());
		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicK = keyFactory.generatePublic(keySpec);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initVerify(publicK);
		signature.update(data);
		return signature.verify(Base64Utils.decode(sign.getBytes()));
	}

	/**
	 * 用私钥对信息生成数字签名
	 *
	 * @param data 已加密数据
	 * @param privateKey 私钥(BASE64编码)
	 *
	 * @return
	 * @throws Exception
	 */
	public static String sign(byte[] data, String privateKey) throws Exception {
		byte[] keyBytes = Base64Utils.decode(privateKey.getBytes());
		PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateK = keyFactory.generatePrivate(pkcs8KeySpec);
		Signature signature = Signature.getInstance("MD5withRSA");
		signature.initSign(privateK);
		signature.update(data);
		return new String(Base64Utils.encode(signature.sign()));
	}

}
