package com.capgemini.stockmanagement.validations;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {

	// for Id
	public static boolean isNumber(String id) {
		String regex = ("[1-9][0-9]*");
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) id);
		return matcher.matches();
	}

	// for Cost and Quantity
	public static boolean isLong(String cost) {
		String regex = ("[1-9][0-9]*");
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher((CharSequence) cost);
		return matcher.matches();
	}

	// for Name
	public static boolean stringOnlyAlphabet(String str) {

		return ((str != null) && (!str.equals("")) && (str.matches("^[a-zA-Z]*$")));
	}

	// for Address
	public static boolean validAddress(String address) {

		Pattern pattern = Pattern.compile("\\d{1,5}\\s\\w.\\s(\\b\\w*\\b\\s){1,2}\\w*\\.");
		Matcher matcher = pattern.matcher(address);
		return (matcher.equals(matcher));
	}

	// for EmailId
	public static boolean validEmail(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}

	// for Telephone Number
	public static boolean validTelephone(String s) {
		Pattern p = Pattern.compile("(0/91)?[6-9][0-9]{9}");

		Matcher m = p.matcher(s);
		return (m.find() && m.group().equals(s));
	}

	// for PostalCode
	public static boolean isValidPostalCode(String postalcode) {
		return ((postalcode != null) && (!postalcode.equals("")) && (postalcode.matches("^\\d{3}\\s?\\d{3}$")));
	}

	// for date
	public static boolean validDate(String s) {
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
		simpleDateFormat.setLenient(false);
		try {
			Date date = simpleDateFormat.parse(s);
			Date today = new Date();
			return date.before(today);
		} catch (Exception e) {
			return true;
		}
	}

	public static int passwordFormat(String password) {

		// total score of password
		int iPasswordScore = 0;

		if (password.length() < 8)
			return 0;
		else if (password.length() >= 8)
			iPasswordScore += 2;
		else
			iPasswordScore += 1;

		// if it contains one digit, add 2 to total score
		if (password.matches("(?=.*[0-9]).*"))
			iPasswordScore += 2;

		// if it contains one lower case letter, add 2 to total score
		if (password.matches("(?=.*[a-z]).*"))
			iPasswordScore += 2;

		// if it contains one upper case letter, add 2 to total score
		if (password.matches("(?=.*[A-Z]).*"))
			iPasswordScore += 2;

		// if it contains one special character, add 2 to total score
		if (password.matches("(?=.*[~!@#$%^&*()_-]).*"))
			iPasswordScore += 2;

		return iPasswordScore;
	}
}