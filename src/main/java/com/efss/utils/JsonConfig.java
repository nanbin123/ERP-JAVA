package com.efss.utils;

import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
  * @ClassName: JsonConfig
  * @Description: json初始化配置
  * @author liucz
  * @date 2018年4月10日
 */
public class JsonConfig {
	/**
	 * 所包含的属性
	 */
	private String[] includeProperties;
	
	/**
	 * 不包含的属性
	 */
	private String[] excludeProperties;
	
	/**
	 * 包含日期时使用的日期格式
	 */
	private String dateFormat;
	
	/**
	 * 所使用的filter(PropertyPreFilter , PropertyFilter , NameFilter , ValueFilter , BeforeFilter , AfterFilter)
	 */
	private SerializeFilter[] filters;
	
	/**
	 * features
	 */
	private SerializerFeature[] features;
	
	
	public JsonConfig() {
		
	}

	public JsonConfig(String dateFormat, SerializerFeature... features) {
		this.dateFormat = dateFormat;
		this.features = features;
	}
	
	public JsonConfig(String[] includeProperties, String[] excludeProperties, String dateFormat, SerializerFeature... features) {
		this.includeProperties = includeProperties;
		this.excludeProperties = excludeProperties;
		this.dateFormat = dateFormat;
		this.features = features;
	}
	
	public JsonConfig(String[] includeProperties, String[] excludeProperties, String dateFormat, SerializeFilter[] filters, SerializerFeature... features) {
		this.includeProperties = includeProperties;
		this.excludeProperties = excludeProperties;
		this.dateFormat = dateFormat;
		this.filters = filters;
		this.features = features;
	}

	public String[] getIncludeProperties() {
		return includeProperties;
	}

	public void setIncludeProperties(String[] includeProperties) {
		this.includeProperties = includeProperties;
	}

	public String[] getExcludeProperties() {
		return excludeProperties;
	}

	public void setExcludeProperties(String[] excludeProperties) {
		this.excludeProperties = excludeProperties;
	}

	public String getDateFormat() {
		return dateFormat;
	}

	public void setDateFormat(String dateFormat) {
		this.dateFormat = dateFormat;
	}

	public SerializeFilter[] getFilters() {
		return filters;
	}

	public void setFilters(SerializeFilter[] filters) {
		this.filters = filters;
	}

	public SerializerFeature[] getFeatures() {
		return features;
	}

	public void setFeatures(SerializerFeature[] features) {
		this.features = features;
	}
}
