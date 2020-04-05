package com.efss.config;
import java.text.ParseException;
import java.util.Date;

import com.efss.utils.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

public class DateConverter implements Converter<String, Date>  {

	private static final String DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
	private static final String DATETIME_PATTERN_NO_SECOND = "yyyy-MM-dd HH:mm";
	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final String MONTH_PATTERN = "yyyy-MM";
	@Override
	public Date convert(String source) {
		try {
			if(StringUtils.isNotBlank(source)){
				return DateUtils.parseDate((String) source, new String[] { DATE_PATTERN, DATETIME_PATTERN,
						DATETIME_PATTERN_NO_SECOND, MONTH_PATTERN });
			}
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}


}
