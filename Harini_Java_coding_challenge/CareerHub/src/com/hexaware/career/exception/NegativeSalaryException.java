package com.hexaware.career.exception;

public class NegativeSalaryException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NegativeSalaryException(String message) {
        super(message);
    }
}
