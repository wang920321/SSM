package com.movit.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;

import org.apache.commons.collections.CollectionUtils;

import com.movit.entity.City;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class WeatherUtil {

	public final static String WEATHER_URL = "http://v.juhe.cn/weather/index" /* "http://apis.baidu.com/heweather/weather/free" */;

	/**
	 * @param urlAll
	 *            :请求接口
	 * @param httpArg
	 *            :参数
	 * @return 返回结果
	 * @throws UnsupportedEncodingException
	 */
	/* public static String request(String httpUrl, String city) { */
	public static String request(String httpUrl, String cityname) throws UnsupportedEncodingException {
		BufferedReader reader = null;
		String result = null;
		StringBuffer sbf = new StringBuffer();
		/* httpUrl = httpUrl + "?" + "city=" + city; */
		httpUrl = httpUrl + "?" + "cityname=" + URLEncoder.encode(cityname, "utf-8")
				+ "&dtype=json&format=1&key=ebe0647a6468786f1c6893e2ba4764c9";
		System.out.println(httpUrl);
		try {
			URL url = new URL(httpUrl);
			System.out.println(url);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			System.out.println("----");
			connection.setRequestMethod("GET");
			System.out.println("====");
			// 填入apikey到HTTP header
			/*
			 * connection.setRequestProperty("apikey",
			 * "3a2ff4fd61ad15418b99179669499dfc");
			 */

			/*
			 * connection.setRequestProperty("key",
			 * "ebe0647a6468786f1c6893e2ba4764c9");
			 */

			connection.connect();
			System.out.println("123");
			InputStream is = connection.getInputStream();
			System.out.println(321);
			reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String strRead = null;
			while ((strRead = reader.readLine()) != null) {
				sbf.append(strRead);
				sbf.append("\r\n");
			}
			reader.close();
			result = sbf.toString();
			System.out.println(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static ArrayList<City> parseJsonData(String jsonData) {
		ArrayList<City> cityList = new ArrayList<City>();

		JSONObject json = JSONObject.fromObject(jsonData);
		JSONArray results = json.getJSONArray("HeWeather data service 3.0");

		if (CollectionUtils.isNotEmpty(results)) {
			for (int i = 0; i < results.size(); i++) {
				JSONObject jsonObj = results.getJSONObject(i);

				City city = new City();
				JSONObject basicObj = jsonObj.getJSONObject("basic");
				city.setCity(basicObj.getString("city"));
				city.setCnty(basicObj.getString("cnty"));
				city.setId(basicObj.getString("id"));
				city.setLat(basicObj.getString("lat"));
				city.setLon(basicObj.getString("lon"));

				cityList.add(city);

			}
		}
		return cityList;
	}
}
