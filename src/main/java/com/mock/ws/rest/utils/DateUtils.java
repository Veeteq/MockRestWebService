package com.mock.ws.rest.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateUtils {

	private static final String DATE_PATTERN = "yyyy-MM-dd";
	private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern(DATE_PATTERN);

	public static LocalDateTime parse(String dateString) {
		return DATE_FORMATTER.parse(dateString, LocalDateTime::from);
	}

	public static String format(LocalDateTime localDate) {
		if (localDate == null)
			return null;
		return DATE_FORMATTER.format(localDate);
	}
}