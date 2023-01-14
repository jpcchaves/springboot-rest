package com.springbootrest;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.springbootrest.converters.NumberConverter;
import com.springbootrest.exceptions.UnsupportedMathOperationException;
import com.springbootrest.math.SimpleMath;

@RestController
public class MathController {
	public final AtomicLong count = new AtomicLong();

	private SimpleMath math = new SimpleMath();

	@GetMapping("/sum/{numberOne}/{numberTwo}")
	public Double sum(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double sum = math.sum(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

		return sum;
	}

	@GetMapping("/sub/{numberOne}/{numberTwo}")
	public Double sub(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double sub = math.sub(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

		return sub;
	}

	@GetMapping("/mult/{numberOne}/{numberTwo}")
	public Double mult(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double mult = math.mult(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

		return mult;
	}

	@GetMapping("/div/{numberOne}/{numberTwo}")
	public Double div(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		if (NumberConverter.convertToDouble(numberTwo) <= 0.0) {
			throw new UnsupportedMathOperationException("Um número não pode ser dividido por 0.");
		}

		double div = math.div(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

		return div;
	}

	@GetMapping("/mean/{numberOne}/{numberTwo}")
	public Double mean(@PathVariable(value = "numberOne") String numberOne,
			@PathVariable(value = "numberTwo") String numberTwo) throws Exception {

		if (!NumberConverter.isNumeric(numberOne) || !NumberConverter.isNumeric(numberTwo)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double mean = math.mean(NumberConverter.convertToDouble(numberOne), NumberConverter.convertToDouble(numberTwo));

		return mean;
	}

	@GetMapping("/sqrroot/{number}")
	public Double sqrRoot(@PathVariable(value = "number") String number) throws Exception {

		if (!NumberConverter.isNumeric(number) || !NumberConverter.isNumeric(number)) {
			throw new UnsupportedMathOperationException("Por favor, insira apenas números!");
		}

		double sqrt = math.sqrRoot(NumberConverter.convertToDouble(number));

		return Math.sqrt(sqrt);
	}

}
