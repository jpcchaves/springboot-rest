package com.springbootrest.converters;

public class NumberConverter {

	public static Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}

		String number = doublePattern(strNumber);

		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}

		return 0D;

	}

	public static String doublePattern(String strNumber) {
		return strNumber.replaceAll(",", ".");
	}

	public static boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		String number = doublePattern(strNumber);

		return number.matches("[+-]?[0-9]*\\.?[0-9]+");

	}

}
