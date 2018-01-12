package com.yb2g.ssm.util.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * @ClassName: StringTrimConverter
 * @Description: 去掉字符串两边空格
 * @author: Administrator
 * @date: 2017年11月28日 下午4:59:08
 */
public class StringTrimConverter implements Converter<String, String> {

	@Override
	public String convert(String source) {

		try {
			// 去掉字符串两边空格，如果去除后为空设置为null
			if (source != null) {
				source = source.trim();
				if (source.equals("")) {
					return null;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return source;
	}

}
