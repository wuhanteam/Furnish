package com.softeem.exception;

import org.springframework.core.NestedRuntimeException;

public class BaseRuntimeException extends NestedRuntimeException {
	public BaseRuntimeException(String msg) {
		super(msg);
	}

	public BaseRuntimeException(String msg, Throwable ex) {
		super(msg, ex);
	}

	public BaseRuntimeException(Throwable ex) {
		super("", ex);
	}
}
