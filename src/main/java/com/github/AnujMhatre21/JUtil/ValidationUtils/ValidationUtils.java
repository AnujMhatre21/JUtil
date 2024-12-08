package com.github.AnujMhatre21.JUtil.ValidationUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtils {
	private ValidationUtils() {
		throw new UnsupportedOperationException("Utility class");
	}

	// Check if a string is a valid email address
	public static boolean isValidEmail(String email) {
		String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(email);
		return matcher.matches();
	}

	// Check if a string contains only digits
	public static boolean isNumeric(String str) {
		return str != null && str.matches("[0-9]+");
	}

	// Check if a string is a valid phone number (simple check)
	public static boolean isValidPhoneNumber(String phoneNumber) {
		return phoneNumber != null && phoneNumber.matches("\\+?[0-9]{10,15}");
	}

	// Check if a string is a valid URL
	public static boolean isValidURL(String url) {
		String regex = "^(http|https|ftp)://[a-zA-Z0-9\\-\\.]+\\.[a-zA-Z]{2,3}(\\S*)?$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(url);
		return matcher.matches();
	}

	// Check if a string is a valid IP address (IPv4)
	public static boolean isValidIPAddress(String ipAddress) {
		String regex = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\."
				+ "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\." + "(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(ipAddress);
		return matcher.matches();
	}

	// Check if a string is a valid postal code (simple check for US postal codes)
	public static boolean isValidPostalCode(String postalCode) {
		String regex = "^[0-9]{5}(?:-[0-9]{4})?$"; // Matches 12345 or 12345-6789
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(postalCode);
		return matcher.matches();
	}

	// Check if a string contains only alphabetic characters (A-Z, a-z)
	public static boolean isAlpha(String str) {
		return str != null && str.matches("[a-zA-Z]+");
	}

	// Check if a string contains only alphanumeric characters (A-Z, a-z, 0-9)
	public static boolean isAlphanumeric(String str) {
		return str != null && str.matches("[a-zA-Z0-9]+");
	}

	// Check if a string contains only alphabets and spaces (A-Z, a-z, space)
	public static boolean isAlphaWithSpaces(String str) {
		return str != null && str.matches("[a-zA-Z ]+");
	}

	// Check if a string is a valid credit card number using Luhn's algorithm
	public static boolean isValidCreditCard(String cardNumber) {
		if (cardNumber == null || cardNumber.length() < 13 || cardNumber.length() > 19) {
			return false;
		}
		int sum = 0;
		boolean shouldDouble = false;
		for (int i = cardNumber.length() - 1; i >= 0; i--) {
			int digit = Character.getNumericValue(cardNumber.charAt(i));
			if (shouldDouble) {
				digit *= 2;
				if (digit > 9) {
					digit -= 9;
				}
			}
			sum += digit;
			shouldDouble = !shouldDouble;
		}
		return sum % 10 == 0;
	}

	// Check if a string is a valid date in the format "yyyy-MM-dd"
	public static boolean isValidDate(String date) {
		String regex = "^\\d{4}-\\d{2}-\\d{2}$"; // Format: yyyy-MM-dd
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(date);
		return matcher.matches();
	}

	// Check if a string is a valid time in the format "HH:mm"
	public static boolean isValidTime(String time) {
		String regex = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$"; // Format: HH:mm
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(time);
		return matcher.matches();
	}

	// Check if a string is a valid UUID
	public static boolean isValidUUID(String uuid) {
		String regex = "^[0-9a-fA-F]{8}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{4}-[0-9a-fA-F]{12}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(uuid);
		return matcher.matches();
	}

	// Check if a string has a minimum length
	public static boolean hasMinLength(String str, int minLength) {
		return str != null && str.length() >= minLength;
	}

	// Check if a string has a maximum length
	public static boolean hasMaxLength(String str, int maxLength) {
		return str != null && str.length() <= maxLength;
	}

	// Check if a string is not null and not empty
	public static boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}
}
