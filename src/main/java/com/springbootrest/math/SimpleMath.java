package com.springbootrest.math;

public class SimpleMath {

	public Double sum(Double numberOne, Double numberTwo) {

		double sum = numberOne + numberTwo;

		return sum;
	}

	public Double sub(Double numberOne, Double numberTwo) throws Exception {

		double sub = numberOne - numberTwo;

		return sub;
	}

	public Double mult(Double numberOne, Double numberTwo) throws Exception {

		double mult = numberOne * numberTwo;

		return mult;
	}

	public Double div(Double numberOne, Double numberTwo) throws Exception {

		double div = numberOne / numberTwo;

		return div;
	}

	public Double mean(Double numberOne, Double numberTwo) throws Exception {

		double mean = (numberOne + numberTwo) / 2.0;

		return mean;
	}

	public Double sqrRoot(Double number) throws Exception {

		double sqrt = number;

		return Math.sqrt(sqrt);
	}
}
