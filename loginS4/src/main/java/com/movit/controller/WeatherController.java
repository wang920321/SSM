package com.movit.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.movit.entity.City;
import com.movit.util.WeatherUtil;

@Controller
@RequestMapping(value = "movit/weather")
public class WeatherController {

	@RequestMapping(value = "/query", method = { RequestMethod.POST, RequestMethod.GET })
	public String callWeatherApi(HttpServletRequest request, @RequestParam("cityname") String cityname, Model model)
			throws UnsupportedEncodingException {
		System.out.println(cityname);
		cityname = new String(cityname.getBytes("8859_1"), "utf8");
		System.out.println(cityname);
		String jsonData = WeatherUtil.request(WeatherUtil.WEATHER_URL, cityname);
		List<City> cityList = WeatherUtil.parseJsonData(jsonData);

		model.addAttribute("jsonData", jsonData);
		model.addAttribute("cityList", cityList);
		return "weather";
	}
}
