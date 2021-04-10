package com.zz.wechat.util;

import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Bsea
 * 2017-06-11 19:12
 */
public class WechatMenuUtil {

	/**
	 * 获得ACCESS_TOKEN
	 * @Title: getAccess_token
	 * @Description: 获得ACCESS_TOKEN
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private static String getAccess_token(){
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ WeiChatConfig.appid + "&secret=" +WeiChatConfig.secretid;
		String accessToken = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();

			http.setRequestMethod("GET"); //必须是get方式请求
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			http.connect();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");

			JSONObject demoJson = new JSONObject(message);
			accessToken = demoJson.getString("access_token");

			System.out.println(message);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}



	/**
	 * 获得ACCESS_TOKEN
	 * @Title: getAccess_token
	 * @Description: 获得ACCESS_TOKEN
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	private static String getAccess_token2(String appid,String sid){
		String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+ appid + "&secret=" +sid;
		String accessToken = null;
		try {
			URL urlGet = new URL(url);
			HttpURLConnection http = (HttpURLConnection) urlGet.openConnection();

			http.setRequestMethod("GET"); //必须是get方式请求
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			http.connect();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");

			JSONObject demoJson = new JSONObject(message);
			accessToken = demoJson.getString("access_token");

			System.out.println(message);
			is.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accessToken;
	}

	/**
	 * @throws UnsupportedEncodingException 
	 * 创建Menu
	* @Title: createMenu
	* @Description: 创建Menu
	* @param @return
	* @param @throws IOException 设定文件
	* @return int 返回类型
	* @throws
	 */
	 public static String createMenu2() throws UnsupportedEncodingException {
	 String menu ="{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://h1882979h5.iask.in/weichat/weichatinit-bsea.html\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}],\"matchrule\":{\"tag_id\":\"100\"}}";
		 //此处改为自己想要的结构体，替换即可
	 String access_token= getAccess_token();
	 System.out.println("access_token=="+access_token);
	 String action = "https://api.weixin.qq.com/cgi-bin/menu/addconditional?access_token="+access_token;
	 try {
	 URL url = new URL(action);
	 HttpURLConnection http = (HttpURLConnection) url.openConnection(); 

	 http.setRequestMethod("POST"); 
	 http.setRequestProperty("Content-Type","application/x-www-form-urlencoded"); 
	 http.setDoOutput(true); 
	 http.setDoInput(true);
	 System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
	 System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
	 http.connect();
	 OutputStream os= http.getOutputStream(); 
	 os.write(menu.getBytes("UTF-8"));//传入参数 
	 os.flush();
	 os.close();

	 InputStream is =http.getInputStream();
	 int size =is.available();
	 byte[] jsonBytes =new byte[size];
	 is.read(jsonBytes);
	 String message=new String(jsonBytes,"UTF-8");
	 return "返回信息"+message;
	 } catch (MalformedURLException e) {
	 e.printStackTrace();
	 } catch (IOException e) {
	 e.printStackTrace();
	 } 
	 return "createMenu 失败";
	 }
	 /**
	  * @throws UnsupportedEncodingException 
	  * 创建Menu
	  * @Title: createMenu
	  * @Description: 创建Menu
	  * @param @return
	  * @param @throws IOException 设定文件
	  * @return int 返回类
	  * @throws
	  */
	 public static String createMenu() throws UnsupportedEncodingException {
		 String url1="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+WeiChatConfig.appid2+"&redirect_uri=";
		 String url2="&response_type=code&scope=snsapi_base&state=123#wechat_redirect";		
		 //智慧党建
		 String v11str="http://d.3kkk.xyz/web/v1?c=f362934f4d8d41b0bb1e66917a87bec4";


		 String v11str2="http://d.3kkk.xyz/core/wechat/v2?c=f362934f4d8d41b0bb1e66917a87bec4";
		 
		 
		 v11str=URLEncoder.encode(v11str, "utf-8");
		 
		 //查看天工位置
		 //String checkPosition="http://www.zizai.pro/life/checkPosition";
		 String checkPosition="http://d.3kkk.xyz/web/checkPosition";
		 checkPosition=URLEncoder.encode(checkPosition, "utf-8");
		 //查看营车位置
		 //String checkCar="http://www.zizai.pro/life/checkCar";		
		 String checkCar="http://d.3kkk.xyz/web/checkCar";	
		 checkCar=URLEncoder.encode(checkCar, "utf-8");
		 //分享营车位置
		 //String shareCar="http://www.zizai.pro/life/shareCar";	
		 String shareCar="http://d.3kkk.xyz/web/shareCar";
		 shareCar=URLEncoder.encode(shareCar, "utf-8");
//		 String menu ="{\"button\":[{\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str+""+url2+"\"},{\"name\":\"位置\",\"sub_button\":[{\"type\":\"view\",\"name\":\"查看天工位置\",\"url\":\""+url1+""+checkPosition+""+url2+"\"},{\"type\":\"view\",\"name\":\"查看营车位置\",\"url\":\""+url1+""+checkCar+""+url2+"\"},{\"type\":\"view\",\"name\":\"分享营车位置\",\"url\":\""+url1+""+shareCar+""+url2+"\"}]}]}";

//		 String menu ="{\"button\":[{\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str+""+url2+"\"},{\"type\":\"view\",\"name\":\"心服务\",\"url\":\""+url1+""+shareCar+""+url2+"\"},{\"type\":\"view\",\"name\":\"心康复\",\"url\":\""+url1+""+shareCar+""+url2+"\"}]}";

		 String u1="";
		 String u2="https://mp.weixin.qq.com/s/ZOTXY8G1gnXDS0_WwIXTDA";
		 String u3="";



		 String u4="http://mp.weixin.qq.com/s?__biz=MzI3MTI4NTYyOA==&mid=100000291&idx=1&sn=f185923b9f9c8d442b4713a17fe679dd&chksm=6ac56e305db2e726bda29e54bbcc52857bc32efa99469a1692e2815ddbcec5634e2e4ec26163&scene=18#wechat_redirect\n";


//		 String menu ="{\"button\":[{\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str2+""+url2+"\"},{\"type\":\"view\",\"name\":\"红色课堂\",\"url\":\""+u1+""+u2+""+u3+"\"}]}";
		 String menu ="{\"button\":[ {\"type\":\"view\",\"name\":\"水务动态\",\"url\":\""+u1+""+u2+""+u3+"\"}, {\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str2+""+url2+"\"},{\"type\":\"view\",\"name\":\"投诉建议\",\"url\":\""+u1+""+u4+""+u3+"\"}]}";


		 // String menu ="{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}],\"matchrule\":{\"tag_id\":\"1\"}}";
		 //此处改为自己想要的结构体，替换即可
		 String access_token= getAccess_token2(WeiChatConfig.appid2,WeiChatConfig.secretid2);
		 System.out.println("access_token=="+access_token);
		 String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
		 try {
			 URL url = new URL(action);
			 HttpURLConnection http = (HttpURLConnection) url.openConnection(); 
			 
			 http.setRequestMethod("POST"); 
			 http.setRequestProperty("Content-Type","application/x-www-form-urlencoded"); 
			 http.setDoOutput(true); 
			 http.setDoInput(true);
			 System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			 System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			 http.connect();
			 OutputStream os= http.getOutputStream(); 
			 os.write(menu.getBytes("UTF-8"));//传入参数 
			 os.flush();
			 os.close();
			 
			 InputStream is =http.getInputStream();
			 int size =is.available();
			 byte[] jsonBytes =new byte[size];
			 is.read(jsonBytes);
			 String message=new String(jsonBytes,"UTF-8");
			 return "返回信息"+message;
		 } catch (MalformedURLException e) {
			 e.printStackTrace();
		 } catch (IOException e) {
			 e.printStackTrace();
		 } 
		 return "createMenu 失败";
	 }

	public static String createMenucore(String appid2,String secretid2,String menu) throws UnsupportedEncodingException {

		String access_token= getAccess_token2(appid2,secretid2);
		System.out.println("access_token=="+access_token);
		String action = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+access_token;
		try {
			URL url = new URL(action);
			HttpURLConnection http = (HttpURLConnection) url.openConnection();

			http.setRequestMethod("POST");
			http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
			http.setDoOutput(true);
			http.setDoInput(true);
			System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
			System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
			http.connect();
			OutputStream os= http.getOutputStream();
			os.write(menu.getBytes("UTF-8"));//传入参数
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			return "返回信息"+message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "createMenu 失败";
	}
//文联
	public static void createMenuwenliang(String appid,String secretid) throws UnsupportedEncodingException {
		String url1="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri=";
		String url2="&response_type=code&scope=snsapi_base&state=123#wechat_redirect";


		String v11str2="http://d.3kkk.xyz/core/wechat/v3?c=a45f27858da84429bfe7e9124469d1cb";
		String u1="";
		String u2="http://nxxt.dygbxx.com";
		String u3="";
		 String menu ="{\"button\":[{\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str2+""+url2+"\"},{\"type\":\"view\",\"name\":\"红色课堂\",\"url\":\""+u1+""+u2+""+u3+"\"}]}";
		System.out.println(menu);
		 createMenucore(appid,secretid,menu);
	 }


	public static void createMenuJinWei(String appid,String secretid) throws UnsupportedEncodingException {
		String url1="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid+"&redirect_uri=";
		String url2="&response_type=code&scope=snsapi_base&state=123#wechat_redirect";
		//智慧党建
		//String v11str="http://d.3kkk.xyz/web/v1?c=f362934f4d8d41b0bb1e66917a87bec4";
		String v11str2="http://d.3kkk.xyz/core/wechat/v1?c=a0ec5f6665144ac2b343324bb9a2b90e";
		String u1="http://www.cnjwweixin.com/wx_postget.aspx";
		String u2="http://www.cnjwweixin.com/wx_postget.aspx";
		String u3="http://d.3kkk.xyz/core/wechat/v404";
		String menu ="{\"button\":[{\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str2+""+url2+"\"},{\"type\":\"view\",\"name\":\"心服务\",\"url\":\""+url1+""+u3+""+url2+"\"},{\"type\":\"view\",\"name\":\"心康复\",\"url\":\""+url1+""+u3+""+url2+"\"}]}";
//		String menu ="{\"button\":[{\"type\":\"view\",\"name\":\"智慧党建\",\"url\":\""+url1+""+v11str2+""+url2+"\"},{\"type\":\"view\",\"name\":\"心服务\",\"url\":\""+u3+""+u1+""+u3+"\"},{\"type\":\"view\",\"name\":\"心康复\",\"url\":\""+u3+""+u2+""+u3+"\"}]}";
		System.out.println(menu);
		createMenucore(appid,secretid,menu);
	}



	 /**
	 * 删除当前Menu
	 * @Title: deleteMenu
	 * @Description: 删除当前Menu
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	 public static String deleteMenu()
	 {
	 String access_token= getAccess_token();
	 String action = "https://api.weixin.qq.com/cgi-bin/menu/delete? access_token="+access_token;
	 try {
	 URL url = new URL(action);
	 HttpURLConnection http = (HttpURLConnection) url.openConnection();

	 http.setRequestMethod("GET");
	 http.setRequestProperty("Content-Type","application/x-www-form-urlencoded");
	 http.setDoOutput(true);
	 http.setDoInput(true);
	 System.setProperty("sun.net.client.defaultConnectTimeout", "30000");//连接超时30秒
	 System.setProperty("sun.net.client.defaultReadTimeout", "30000"); //读取超时30秒
	 http.connect();
	 OutputStream os= http.getOutputStream();
	 os.flush();
	 os.close();

	 InputStream is =http.getInputStream();
	 int size =is.available();
	 byte[] jsonBytes =new byte[size];
	 is.read(jsonBytes);
	 String message=new String(jsonBytes,"UTF-8");
	 is.close();
	 return "deleteMenu返回信息:"+message;
	 } catch (MalformedURLException e) {
	 e.printStackTrace();
	 } catch (IOException e) {
	 e.printStackTrace();
	 }
	 return "deleteMenu 失败";
	 }
	public static void main(String[] args) throws IOException {


		createMenuwenliang(WeiChatConfig.appid4,WeiChatConfig.secretid4);


	}
	}
