package com.springbootrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.exceptions.UnsupportedMathOperationException;

@RestController
public class MathController {
	public final AtomicLong count = new AtomicLong();

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);

		return sum;
	}

	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);

		return sub;
	}

	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double mult = convertToDouble(numberOne) * convertToDouble(numberTwo);

		return mult;
	}

	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		if (convertToDouble(numberTwo) <= 0.0) {
			throw new UnsupportedMathOperationException("Um número não pode ser dividido por 0.");
		}

		double div = convertToDouble(numberOne) / convertToDouble(numberTwo);

		return div;
	}

	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double mean = (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2.0;

		return mean;
	}

	@GetMapping("/sqrroot/{number}")
	public Double sqrRoot(@PathVariable(value = "number") String number) throws Exception {

		if (!isNumeric(number) || !isNumeric(number)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double mean = convertToDouble(number);

		return Math.sqrt(mean);
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
