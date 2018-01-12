package com.yb2g.ssm.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.propertyeditors.CustomDateEditor;

/**
 * 
 * @ClassName: CustomPropertyEditor
 * @Description: 自定义属性编辑器
 * @author: Administrator
 * @date: 2017年12月7日 下午12:36:42
 */
public class CustomPropertyEditor implements PropertyEditorRegistrar {

	@Override
	public void registerCustomEditors(PropertyEditorRegistry binder) {
		binder.registerCustomEditor(Date.class,
				new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"), true));

	}

}
