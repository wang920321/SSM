/**
 * 
 */
package com.study.connect.controller;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import net.sf.json.JSONObject;



/**
 * @author Administrator
 *
 */
@Controller
public class PhoneContorller {
	private static final String DEF_CHATSET = "UTF-8";
	private static final int DEF_CONN_TIMEOUT = 30000;
	private static final int DEF_READ_TIMEOUT = 30000;
	private static String userAgent =  "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";
    private static final String KEY="9898533e26009a3bc9acc6fc7a02cf3f";
    @RequestMapping("/query")
    public String query(@RequestParam("phoneNum") String phoneNum){
    	System.out.println(phoneNum);
    	String result =null;
        String url ="http://apis.juhe.cn/mobile/get";//请求接口地址
        Map<String, String> params = new HashMap<String, String>();//请求参数
            params.put("phone",phoneNum);//需要查询的手机号码或手机号码前7位
            params.put("key",KEY);//应用APPKEY(应用详细页查询)
            params.put("dtype","json");//返回数据的格式,xml或json，默认json
            result=net(url,params,"GET");
            System.out.println(result);
            JSONObject object=JSONObject.fromObject(result);
            if(object.getInt("error_code")==0){
            	System.out.println(object.get("result"));
            }else{
            	System.out.println(object.get("error_code")+":"+object.get("reason"));
            }
		return null;
    	
    }
    private String net(String strUrl, Map<String, String> params,String method){
    	 HttpURLConnection conn = null;
         BufferedReader reader = null;
         String rs = null;
     try {
         StringBuffer sb=new StringBuffer();
         if(method==null||method.equals("GET")){
        	 strUrl=strUrl+"?"+urlencode(params);
         }
         
			URL url=new URL(strUrl);
			System.out.println(strUrl);
			conn=(HttpURLConnection)url.openConnection();
			if((method==null)||method.equals("GET")){
				conn.setRequestMethod("GET");
			}else{
				conn.setRequestMethod("POST");
				conn.setDoOutput(true);
			}
			conn.setRequestProperty("User-agent", userAgent);
			conn.setUseCaches(false);
			conn.setConnectTimeout(DEF_CONN_TIMEOUT);
			conn.setReadTimeout(DEF_READ_TIMEOUT);
			conn.setInstanceFollowRedirects(false);
			System.out.println(conn);
			conn.connect();
			System.out.println(111);
			if(params!=null && method.equals("POST")){
				DataOutputStream out=new DataOutputStream(conn.getOutputStream());
				out.writeBytes(urlencode(params));
			}
			InputStream is=conn.getInputStream();
			reader=new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
			String strRead=null;
			while((strRead=reader.readLine())!=null){
				sb.append(strRead);
			}
			rs=sb.toString();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(reader!=null){
				try {
					reader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				conn.disconnect();
			}
		}
		return rs;
    }
    private String urlencode(Map<String,String> data){
    	StringBuilder sb=new StringBuilder();
    	for (Map.Entry<String, String> i:data.entrySet()) {
			try {
				sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue()+"","UTF-8")).append("&");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		return sb.toString();
    }
}
