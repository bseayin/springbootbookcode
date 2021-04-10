package com.zz.wechat.util;

import org.json.JSONObject;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Bsea
 * 2017-06-11 19:12
 */
@Component
public class MessageTool {

	/**
	 * 查看 公众号应用的模板消息
	 * 
	 * @return
	 * @throws IOException 
	 */
	 public   String getTemplate() throws IOException {
			
		 
		 
		 String access_token= "CrHZNUf5cyeA2eYBQW8aPzsHgOMeugJKck1JwvCjTRLsMXDPW8dkm56K18vl6Bt8XcgiHT_iPFP0oXhWrq684IQiZ1zmuFZjnHlNbT7RGswAD9XlFqcFHQjWeDckP9AoPZBgABALVX";
		 System.out.println("access_token=="+access_token);
		 String action = "https://api.weixin.qq.com/cgi-bin/template/get_all_private_template?access_token="+access_token;
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
	 
		public     String  sendMsg(String openid,String first,String keyword1,String keyword2) throws IOException{
			 String access_token=getAccess_token3();
			 System.out.println("access_token=="+access_token);
			 String action = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
			 
			 
			 String Msg ="{\"touser\":\""+openid+"\""
			 		+ ",\"template_id\":\"6kvGhSUgXAEBf2xJzeeid-zROcn8xDNaofBpsnQwCc8\","
			 		+ "\"data\":{"
			 		+ "\"first\":{"
			 		+ "\"value\":\""+first+"\","
			 		+ "\"color\":\"#173177\""
			 		+ "},"
			 		+ "\"param1\":{"
			 		+ "\"value\":\""+keyword1+"\","
			 		+ "\"color\":\"#173177\""
			 		+ "},"
			 		+ "\"param2\":{"
			 		+ "\"value\":\""+keyword2+"\","
			 		+ "\"color\":\"#173177\""
			 		+ "}"
			 		+ "}"
			 		+ "}";
			 
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
				 os.write(Msg.getBytes("UTF-8"));//传入参数 
				 os.flush();
				 os.close();

				 InputStream is =http.getInputStream();
				 int size =is.available();
				 byte[] jsonBytes =new byte[size];
				 is.read(jsonBytes);
				 String message=new String(jsonBytes,"UTF-8");
				 System.out.println("message----------------"+message);
				 return "返回信息"+message;
				 } catch (MalformedURLException e) {
				 e.printStackTrace();
				 } catch (IOException e) {
				 e.printStackTrace();
				 } 
				 return " 失败";
			 
			 
			 
		}


	public     String  sendMsg2(String openid,String first,String keyword1,String keyword2,String remark,String url00,String keyword3) throws IOException{
		String access_token=getAccess_token3();
		System.out.println("access_token=="+access_token);
		String action = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
		String url01="http://d.3kkk.xyz:5000/dj/?openid="+openid+"&zhibuid=a0ec5f6665144ac2b343324bb9a2b90e&routeto=meetingDetail&fieldname1=meetingid&fieldvalue1="+url00;

		String Msg ="{\"touser\":\""+openid+"\""
				+ ",\"template_id\":\"vv5xWzDz8VMjLfZCXbe6T5md2PD6rcPi1iwoT8Xco4s\","
				+ "\"url\":\""+url01+"\","
				+ "\"data\":{"
				+ "\"first\":{"
				+ "\"value\":\""+first+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword1\":{"
				+ "\"value\":\""+keyword1+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword2\":{"
				+ "\"value\":\""+keyword2+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword3\":{"
				+ "\"value\":\""+keyword3+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"remark\":{"
				+ "\"value\":\""+remark+"\","
				+ "\"color\":\"#173177\""
				+ "}"
				+ "}"
				+ "}";

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
			os.write(Msg.getBytes("UTF-8"));//传入参数
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			System.out.println("message----------------"+message);
			return "返回信息"+message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return " 失败";



	}


//水务
	public     String  sendMsg3(String openid,String first,String keyword1,String keyword2,String remark,String url00) throws IOException{
		String access_token=getAccess_token4(WeiChatConfig.appid2,WeiChatConfig.secretid2);
		System.out.println("access_token=="+access_token);
		String action = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
		String url01="http://d.3kkk.xyz:5000/dj/?openid="+openid+"&zhibuid=f362934f4d8d41b0bb1e66917a87bec4&routeto=meetingDetail&fieldname1=meetingid&fieldvalue1="+url00;

		String Msg ="{\"touser\":\""+openid+"\""
				+ ",\"template_id\":\"jwjwox5BBd4m5ObmNGNOSD0imcop1a0ArqV_PXp2PY4\","
				+ "\"url\":\""+url01+"\","
				+ "\"data\":{"
				+ "\"first\":{"
				+ "\"value\":\""+first+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword1\":{"
				+ "\"value\":\""+keyword1+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword2\":{"
				+ "\"value\":\""+keyword2+"\","
				+ "\"color\":\"#173177\""
				+ "},"

				+ "\"remark\":{"
				+ "\"value\":\""+remark+"\","
				+ "\"color\":\"#173177\""
				+ "}"
				+ "}"
				+ "}";

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
			os.write(Msg.getBytes("UTF-8"));//传入参数
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			System.out.println("message----------------"+message);
			return "返回信息"+message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return " 失败";



	}
//文联
	public     String  sendMsgwenliang(String openid,String first,String keyword1,String keyword2,String remark,String url00) throws IOException{
		String access_token=getAccess_token4(WeiChatConfig.appid3,WeiChatConfig.secretid3);
		System.out.println("access_token=="+access_token);
		String action = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
		String url01="http://d.3kkk.xyz:5000/dj/?openid="+openid+"&zhibuid=a45f27858da84429bfe7e9124469d1cb&routeto=meetingDetail&fieldname1=meetingid&fieldvalue1="+url00;

		String Msg ="{\"touser\":\""+openid+"\""
				+ ",\"template_id\":\"jwjwox5BBd4m5ObmNGNOSD0imcop1a0ArqV_PXp2PY4\","
				+ "\"url\":\""+url01+"\","
				+ "\"data\":{"
				+ "\"first\":{"
				+ "\"value\":\""+first+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword1\":{"
				+ "\"value\":\""+keyword1+"\","
				+ "\"color\":\"#173177\""
				+ "},"
				+ "\"keyword2\":{"
				+ "\"value\":\""+keyword2+"\","
				+ "\"color\":\"#173177\""
				+ "},"

				+ "\"remark\":{"
				+ "\"value\":\""+remark+"\","
				+ "\"color\":\"#173177\""
				+ "}"
				+ "}"
				+ "}";

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
			os.write(Msg.getBytes("UTF-8"));//传入参数
			os.flush();
			os.close();

			InputStream is =http.getInputStream();
			int size =is.available();
			byte[] jsonBytes =new byte[size];
			is.read(jsonBytes);
			String message=new String(jsonBytes,"UTF-8");
			System.out.println("message----------------"+message);
			return "返回信息"+message;
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return " 失败";



	}

//bsea 测试号
    public     String  sendMsg4(String openid,String first,String keyword1,String keyword2,String remark,String url00) throws IOException{
        String access_token=getAccess_token4(WeiChatConfig.appid2,WeiChatConfig.secretid2);
        System.out.println("access_token=="+access_token);
        String action = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+access_token;
        String url01="http://d.3kkk.xyz:5000/dj/?openid="+openid+"&zhibuid=f362934f4d8d41b0bb1e66917a87bec4&routeto=meetingDetail&fieldname1=meetingid&fieldvalue1="+url00;

        String Msg ="{\"touser\":\""+openid+"\""
                + ",\"template_id\":\"flrP8RtcKt6VisHY-0HAkllFNx2NktvBVfHNvS3smDE\","
                + "\"url\":\""+url01+"\","
                + "\"data\":{"
                + "\"first\":{"
                + "\"value\":\""+first+"\","
                + "\"color\":\"#173177\""
                + "},"
                + "\"keyword1\":{"
                + "\"value\":\""+keyword1+"\","
                + "\"color\":\"#173177\""
                + "},"
                + "\"keyword2\":{"
                + "\"value\":\""+keyword2+"\","
                + "\"color\":\"#173177\""
                + "},"

                + "\"remark\":{"
                + "\"value\":\""+remark+"\","
                + "\"color\":\"#173177\""
                + "}"
                + "}"
                + "}";

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
            os.write(Msg.getBytes("UTF-8"));//传入参数
            os.flush();
            os.close();

            InputStream is =http.getInputStream();
            int size =is.available();
            byte[] jsonBytes =new byte[size];
            is.read(jsonBytes);
            String message=new String(jsonBytes,"UTF-8");
            System.out.println("message----------------"+message);
            return "返回信息"+message;
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return " 失败";



    }


	 
		
		
		private static String getAccess_token3(){ 
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


	private static String getAccess_token4(String appid,String sid){
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

	 
	 public static void main(String[] args) throws IOException {

			//System.out.println(deleteMenu());
				MessageTool mt=new MessageTool();
			//mt.doSendMsg2("到期提醒","晚上放手机" ,"20:10" ,11);

		 String url="http://d.3kkk.xyz:5000/dj/?openid=oh7VS1XR-G_A4-PgRDhQYsRbjGR4&zhibuid=a0ec5f6665144ac2b343324bb9a2b90e&routeto=meetingDetail&fieldname1=meetingid&fieldvalue1=1";

//		 mt.sendMsg3("oJPy1wClqxJ_nm40WjcAjSaT0y2o","唐晓静，您好","XX产品交流会","XX会议中心二楼会议厅","届时请您正装参会，提前到签到处签到。",url);
//oJPy1wD3zVlyz6CseyR_wGvVmyU8
		 mt.sendMsg3("oJPy1wA0lYsEUDPvknV2QqJHKqJs","唐晓静，您好","内部审计工作会议","会议室","届时请您正装参会，提前到签到处签到。","31");
			}
}
