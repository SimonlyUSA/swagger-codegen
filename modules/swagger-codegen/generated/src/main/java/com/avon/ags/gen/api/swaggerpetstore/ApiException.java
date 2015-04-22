package com.avon.ags.gen.api.swaggerpetstore;

public class ApiException extends Exception{
	private int code;
	public ApiException (int code, String msg) {
		super(msg);
		this.code = code;
	}
}
