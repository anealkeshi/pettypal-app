package com.pettypal.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;

import com.pettypal.domain.Phone;

public class PhoneFormatter implements Formatter<Phone> {

	public Phone parse(String phoneNumber, Locale arg1) throws ParseException {

		if (!phoneNumber.matches("\\d{3}[-]\\d{3}[-]\\d{4}")) {
			
			throw new ParseException("Invalid phone number format: nnn-nnn-nnnn", 1);
		}

		Phone phone = new Phone();
		phone.setArea(Integer.parseInt(phoneNumber.substring(0, 3)));
		phone.setPrefix(Integer.parseInt(phoneNumber.substring(4, 7)));
		phone.setNumber(Integer.parseInt(phoneNumber.substring(8, phoneNumber.length())));
		
		return phone;
	}

	public String print(Phone phone, Locale arg1) {
		return phone.getArea() + "-" + phone.getPrefix() + "-" + phone.getNumber();
	}

}
