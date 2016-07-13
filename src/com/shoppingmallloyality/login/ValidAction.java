package com.shoppingmallloyality.login;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidAction {

	public static boolean checkFirstName(String fnm) {

		if ((!fnm.isEmpty()) && fnm.matches("[a-zA-Z]+")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkLastName(String lnm) {

		if ((!lnm.isEmpty()) & lnm.matches("[a-zA-Z]+")) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkRequired(String value) {
		if (!value.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPostal(String post) {
		if ((!post.isEmpty()) && (post.matches("[0-9]+"))
				&& (post.length() == 6) && (!post.equals("000000"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkContact(String con) {
		if ((!con.isEmpty()) && (con.matches("[0-9]+")) && (con.length() == 10)
				&& (!con.equals("0000000000"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkEmail(String email) {
		String validExpression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
		Pattern compare = Pattern.compile(validExpression,
				Pattern.CASE_INSENSITIVE);
		Matcher matcher = compare.matcher(email);
		if (matcher.matches()) {
			return true;
		} else {
			return false;
		}

	}

	public static boolean checkUser(String usernm) {
		if (!usernm.isEmpty() && (usernm.matches("[a-zA-Z]+" + "[0-9]+"))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkPass(String pass) {

		if ((!pass.isEmpty()) && (pass.length() >= 5)) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkConfirmPass(String pass, String con_pass) {
		if ((!con_pass.isEmpty()) && (pass.equals(con_pass))) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean checkNumber(String num) {
		if ((num.matches("[0-9]+"))) {
			return true;
		} else {
			return false;
		}
	}
}
