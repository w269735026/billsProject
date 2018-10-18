package com.wwl.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 自定义Date参数绑定
 * @author wenwenliang
 *
 */
public class CustomDate implements Converter<String, Date>{
	//resource是jsp表单传入用户输入的值  
	public Date convert(String resource) {    
		try {  
			//进行字符串转换时间类操作
			if(resource.indexOf("-")!=-1) {
				SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
				return	sdf.parse(resource);          //把转换的时间值返回
			};		
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
