package com.pettypal.custom;

import javax.persistence.AttributeConverter;

import org.springframework.core.convert.converter.Converter;

import com.pettypal.domain.Phone;

public class PhoneConverter implements AttributeConverter<Phone, String>{


	public String convertToDatabaseColumn(Phone phone) {
		return phone.getArea() + "-" + phone.getPrefix() + "-" + phone.getNumber();
	}

	public Phone convertToEntityAttribute(String phoneNumber) {
		
		Phone phone = new Phone();
		phone.setArea(Integer.parseInt(phoneNumber.substring(0, 3)));
		phone.setPrefix(Integer.parseInt(phoneNumber.substring(4, 7)));
		phone.setNumber(Integer.parseInt(phoneNumber.substring(8, phoneNumber.length())));
		return phone;
	}

}
