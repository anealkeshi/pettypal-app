package com.pettypal.domain.converters;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Converter to convert from java.time.LocalDate to java.sql.Date and back.
 *
 */
@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDateTime, Timestamp> {

	public Timestamp convertToDatabaseColumn(LocalDateTime localDate) {
		return null == localDate ? null : Timestamp.valueOf(localDate);
	}

	public LocalDateTime convertToEntityAttribute(Timestamp date) {
		return null == date ? null : date.toLocalDateTime();
	}
}