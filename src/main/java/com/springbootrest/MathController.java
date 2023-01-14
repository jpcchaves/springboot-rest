package com.springbootrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {
	public final AtomicLong count = new AtomicLong();

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new Exception();
		}

		double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);

		return sum;
	}

	private Double convertToDouble(String strNumber) {
		if (strNumber == null) {
			return 0D;
		}

		String number = doublePattern(strNumber);

		if (isNumeric(number)) {
			return Double.parseDouble(number);
		}

		return 0D;

	}

	private String doublePattern(String strNumber) {
		return strNumber.replaceAll(",", ".");
	}

	private boolean isNumeric(String strNumber) {
		if (strNumber == null) {
			return false;
		}
		String number = doublePattern(strNumber);

		return number.matches("[+-]?[0-9]*\\.?[0-9]+");

	}

}
