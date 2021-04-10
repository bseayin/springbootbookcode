package com.zz.wechat.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.net.ssl.HttpsURLConnection;



import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Created by Bsea
 * 2017-06-11 19:12
 */
@Service
public class WeiChatUtil {
	public static void main(String[] args) {
		//  System.out.println("openId="+WeiChatUtil.getOpenId("061VU7RX0be0r02ZLMRX0gGWQX0VU7R3"));
	}

	public static String getMD5Signature(List<String> params) {
		List<Map.Entry<String, String>> list = sortByKey(params);
		StringBuffer strBuffer = new StringBuffer();
		for (Map.Entry<String, String> entry : list) {
			String key = entry.getKey();
			String value = entry.getValue();
			if (strBuffer.length() == 0) {
				strBuffer.append(key + "=" + value);
			} else {
				strBuffer.append("&" + key + "=" + value);
			}
		}
		String signature = MD5Util.MD5Encode(strBuffer.toString(), "");
		System.out.println(strBuffer.toString());
		System.out.println(signature);
		return signature.toUpperCase();
	}
	public static List<Map.Entry<String, String>> sortByKey(List<String> params) {
		Map<String, String> map = new HashMap<>();
		for (String param : params) {
			int equalIndex = param.indexOf("=");
			if (equalIndex > 0) {
				String key = param.substring(0, equalIndex);
				String value = param.substring(equalIndex + 1);
				if (!StringUtils.isEmpty(value)) {
					map.put(key, value);
				}
			}
		}
		List<Map.Entry<String, String>> list = new ArrayList<>(map.entrySet());
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			public int compare(Map.Entry<String, String> mapping1, Map.Entry<String, String> mapping2) {
				return mapping1.getKey().compareTo(mapping2.getKey());
			}
		});
		return list;
	}

	public static Map generateOrder(WeChatPayOrderDTO dto) {
		String requestXML = dto.generateXMLString();
		return null;
	}
	/**
	 *
	 * 在微信接入的时候，需要对三个参数，1.字典排序  2. sha1加密。 
	 * @param token
	 * @param timestamp
	 * @param nonce
	 * @return
	 * @throws AesException
	 * @author bsea
	 */
	public static String getSHA1(String token, String timestamp, String nonce) throws AesException
	{
		try {
			String[] array = new String[] { token, timestamp, nonce };
			StringBuffer sb = new StringBuffer();
			// 字符串排序
			Arrays.sort(array);
			for (int i = 0; i < 3; i++) {
				sb.append(array[i]);
			}
			String str = sb.toString();
			// SHA1签名生成
			MessageDigest md = MessageDigest.getInstance("SHA-1");
			md.update(str.getBytes());
			byte[] digest = md.digest();

			StringBuffer hexstr = new StringBuffer();
			String shaHex = "";
			for (int i = 0; i < digest.length; i++) {
				shaHex = Integer.toHexString(digest[i] & 0xFF);
				if (shaHex.length() < 2) {
					hexstr.append(0);
				}
				hexstr.append(shaHex);
			}
			return hexstr.toString();
		} catch (Exception e) {
			e.printStackTrace();
			throw new AesException(AesException.ComputeSignatureError);
		}
	}

	public  static Map xmlToMap(InputStream input) throws DocumentException{
		Map map=new HashMap();
		SAXReader reader=new SAXReader();
		Document doc=reader.read(input);
		Element root=doc.getRootElement();
		List<Element> elements=root.elements();
		for(Element e: elements){
			String name=e.getName();
			String content=e.getText();
			map.put(e.getName(), e.getText());
		}

		return map;
	}
	public  static String MapToXml(Map map) throws DocumentException, IOException{
		String res="<xml>"+
				"<ToUserName>"+map.get("ToUserName")
				+ "</ToUserName>"
				+ "<FromUserName>"+map.get("FromUserName")+"</FromUserName>"+

				"<CreateTime>"+map.get("CreateTime")+"</CreateTime><MsgType>"+map.get("MsgType")
				+ "</MsgType><Content>"+map.get("Content")+"</Content>"+
				"</xml>";
		return res;
	}

	public static String getAccessToken() throws IOException{
		String accessToken="";
		String url="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+WeiChatConfig.appid+"&secret="+WeiChatConfig.secretid;
		URL url2=new URL(url);
		HttpsURLConnection con=(HttpsURLConnection) url2.openConnection();
		con.setRequestMethod("GET");
		con.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
		con.setDoOutput(true);
		con.setDoInput(true);

		con.connect();
		InputStream input=con.getInputStream();
		byte[] c=new byte[input.available()];
		input.read(c);
		// String有一个构造方法，可以接受一个，字节的数组，来创建一个String.
		//这个过程，就实现了，字节数组转化为String的过程。
		String message=new String(c,"UTF-8");
		input.close();
		con.disconnect();

		JSONObject demoJson;
		try {
			demoJson = new JSONObject(message);
			accessToken=demoJson.getString("access_token");
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println("accessToken======"+accessToken);
		return accessToken;

	}

	public static String getOpenId(String code){
		String openId="";
		String errcode="";
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+WeiChatConfig.appid+"&secret="+WeiChatConfig.secretid+"&code="+code+"&grant_type=authorization_code";
		URL urlGet;
		String msg;
		try {
			urlGet = new URL(url);
			HttpsURLConnection http = (HttpsURLConnection) urlGet.openConnection();

			http.setRequestMethod("GET"); //必须是get方式请求
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("javax.net.ssl.keyStore", "");
			System.setProperty("javax.net.ssl.keyStorePassword", "");
			System.setProperty("javax.net.ssl.trustStore", "");
			System.setProperty("javax.net.ssl.trustStorePassword","");
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			http.connect();
			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			JSONObject demoJson;
			try {
				demoJson = new JSONObject(message);
				msg=demoJson.toString();
				if(msg.indexOf("openid")!=-1){
					openId = demoJson.getString("openid");
				}else if(msg.indexOf("errcode")!=-1){
					errcode=demoJson.getInt("errcode")+"===="+demoJson.getString("errmsg");
				}
				System.out.println("openId====="+openId+"errcode====="+errcode);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return openId;
	}


	public static String getOpenId2(String code,String appid,String sid){
		String openId="";
		String errcode="";
		String url="https://api.weixin.qq.com/sns/oauth2/access_token?appid="+appid+"&secret="+sid+"&code="+code+"&grant_type=authorization_code";
		URL urlGet;
		String msg;
		try {
			urlGet = new URL(url);
			HttpsURLConnection http = (HttpsURLConnection) urlGet.openConnection();

			http.setRequestMethod("GET"); //必须是get方式请求
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("javax.net.ssl.keyStore", "");
			System.setProperty("javax.net.ssl.keyStorePassword", "");
			System.setProperty("javax.net.ssl.trustStore", "");
			System.setProperty("javax.net.ssl.trustStorePassword","");
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			http.connect();
			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			JSONObject demoJson;
			try {
				demoJson = new JSONObject(message);
				msg=demoJson.toString();
				if(msg.indexOf("openid")!=-1){
					openId = demoJson.getString("openid");
				}else if(msg.indexOf("errcode")!=-1){
					errcode=demoJson.getInt("errcode")+"===="+demoJson.getString("errmsg");
				}
				System.out.println("openId====="+openId+"errcode====="+errcode);
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return openId;
	}
	/**
	 * 时间戳--标准北京时间，时区为东八区，自1970年1月1日 0点0分0秒以来的秒数。
	 *
	 * @return 时间戳
	 */
	public static String getTimeStamp() {
		return "" + System.currentTimeMillis() / 1000;
	}

	public static String generateNonSenceStr() {
		String uuid = UUID.randomUUID().toString().replaceAll("-", "");
		return uuid;
	}

}