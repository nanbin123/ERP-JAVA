package com.efss.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: JsonUtils
 * @Description: json工具
 * @author liucz
 * @date 2018年4月10日
 */
public class JsonUtils {
	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param object
	 * @param features
	 * @return
	 */
	public static String toJSONString(Object object,
			SerializerFeature... features) {
		return JSON.toJSONString(object, features);
	}
	
	/**
	  * <p>toJSONString</p>
	  * @Description:将java对象转换成json字符串
	  * @param object
	  * @param excludeStrs
	  * @return
	 */
	public static String toJSONStringExclude(Object object,
			String... excludeStrs) {
		SimplePropertyPreFilter propertyPreFilter = null;
		if(excludeStrs != null){
			propertyPreFilter = new SimplePropertyPreFilter();
			propertyPreFilter.getExcludes().addAll(
					Arrays.asList(excludeStrs));
		}
		return JSON.toJSONString(object, propertyPreFilter);
	}
	
	

	/**
	 * enum类型输出value
	 * @param object
	 * @return
	 */
	public static final String toJSONStringWithEnumValue(Object object) {
		SerializeWriter out = new SerializeWriter();

		try {
			JSONSerializer serializer = new JSONSerializer(out);
			serializer.config(SerializerFeature.WriteEnumUsingToString, false);
			serializer.write(object);
			return out.toString();
		} finally {
			out.close();
		}
	}

	/**
	 * 将java对象转换成json字符串(使用定制序列化处理)
	 * 
	 * @param object
	 * @param filter
	 *            PropertyPreFilter , PropertyFilter , NameFilter , ValueFilter
	 *            , BeforeFilter , AfterFilter
	 * @param features
	 * @return
	 */
	public static String toJSONString(Object object, SerializeFilter filter,
			SerializerFeature... features) {
		return JSON.toJSONString(object, filter, features);
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param object
	 * @param dateFormat
	 *            日期格式
	 * @param features
	 * @return
	 */
	public static String toJSONString(Object object, String dateFormat,
			SerializerFeature... features) {
		return JSON.toJSONStringWithDateFormat(object, dateFormat, features);
	}

	/**
	 * 将java对象转换成json字符串
	 * 
	 * @param object
	 * @param dateFormat
	 * @param filter
	 * @param features
	 * @return
	 */
	public static String toJSONString(Object object, String dateFormat,
                                      SerializeFilter filter, SerializerFeature... features) {
		JsonConfig config = new JsonConfig();
		config.setDateFormat(dateFormat);
		config.setFilters(new SerializeFilter[] { filter });
		return toJSONString(object, config);
	}

	/**
	 * 将java对象转换成json字符串，使用jsonConfig配置
	 * 
	 * @param object
	 * @param config
	 * @return
	 */
	public static String toJSONString(Object object, JsonConfig config) {
		SerializeWriter out = new SerializeWriter();
		try {
			JSONSerializer serializer = new JSONSerializer(out);
			SerializerFeature[] features = config.getFeatures();
			if (features != null && features.length > 0) {
				for (com.alibaba.fastjson.serializer.SerializerFeature feature : features) {
					serializer.config(feature, true);
				}
			}
			
			//日期转换策略
			String dateFormat = config.getDateFormat();
			if (dateFormat != null && !"".equals(dateFormat)) {
				serializer.config(SerializerFeature.WriteDateUseDateFormat,
						true);
				serializer.setDateFormat(dateFormat);
			}
			//属性过滤策略
			SerializeFilter[] filters = config.getFilters();
			String[] includeProperties = config.getIncludeProperties();
			String[] excludeProperties = config.getExcludeProperties();
			SimplePropertyPreFilter propertyPreFilter = null;
			if (includeProperties != null && includeProperties.length > 0) {
				propertyPreFilter = new SimplePropertyPreFilter(includeProperties);
			}
			if (excludeProperties != null && excludeProperties.length > 0) {
				propertyPreFilter = new SimplePropertyPreFilter();
				propertyPreFilter.getExcludes().addAll(
						Arrays.asList(excludeProperties));
			}
			if (filters != null) {
				filters = Arrays.copyOf(filters, filters.length + 1);
			} else {
				filters = new SerializeFilter[1];
			}
			if((filters.length - 1)>=0){
				filters[filters.length - 1] = propertyPreFilter;
			}
			config.setFilters(filters);
			if (filters != null && filters.length > 0) {
				for (SerializeFilter filter : filters) {
					if (filter instanceof PropertyPreFilter) {
						serializer.getPropertyPreFilters().add(
								(PropertyPreFilter) filter);
					} else if (filter instanceof NameFilter) {
						serializer.getNameFilters().add((NameFilter) filter);
					} else if (filter instanceof ValueFilter) {
						serializer.getValueFilters().add((ValueFilter) filter);
					} else if (filter instanceof PropertyFilter) {
						serializer.getPropertyFilters().add(
								(PropertyFilter) filter);
					} else if (filter instanceof BeforeFilter) {
						serializer.getBeforeFilters()
								.add((BeforeFilter) filter);
					} else if (filter instanceof AfterFilter) {
						serializer.getAfterFilters().add((AfterFilter) filter);
					}
				}
			}
			serializer.write(object);
			return out.toString();
		} finally {
			out.close();
		}
	}

	/**
	 * 用于重命名属性
	 * 
	 * @param renameMap
	 *            key : 原始属性名　　value : 重命名后的属性名
	 * @return
	 */
	public static NameFilter createNameFilter(
			final Map<String, String> renameMap) {
		NameFilter nameFilter = new NameFilter() {
			public String process(Object source, String name, Object value) {
				if (renameMap.containsKey(name)) {
					return renameMap.get(name);
				}
				return name;
			}
		};
		return nameFilter;
	}

	/**
	 * 将json字符串转换成指定javaBean，若json字符串中包含日期，则日期格式必须为yyyy-MM-dd
	 * HH:mm:ss或yyyy-MM-dd
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> T parseObject(String json, Class<T> clazz,
			Feature... features) {
		T value = JSON.parseObject(json, clazz, features);
		return value;
	}

	/**
	 * 将json字符串转换成指定list，若json字符串中包含日期，则日期格式必须为yyyy-MM-dd HH:mm:ss或yyyy-MM-dd
	 * 
	 * @param <T>
	 * @param json
	 * @param clazz
	 * @return
	 */
	public static <T> List<T> parseArray(String json, Class<T> clazz) {
		return JSON.parseArray(json, clazz);
	}
}
