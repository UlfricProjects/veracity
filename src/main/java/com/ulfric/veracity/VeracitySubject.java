package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;

public abstract class VeracitySubject<S extends Subject<S, T>, T> extends Subject<S, T> implements ObjectAssertions<T> {

	public VeracitySubject(FailureStrategy failureStrategy, T actual) {
		super(failureStrategy, actual);
	}

	@Override
	public final T actualValue() {
		return actual();
	}

	@Override
	public final String actualValueAsString() {
		return actualAsString();
	}

	@Override
	public final void failed(String verb) {
		fail(verb);
	}

	@Override
	public final void failed(String verb, Object other) {
		fail(verb, other);
	}

	@Override
	public final void failed(String verb, Object... others) {
		fail(verb, others);
	}

	@Override
	public final void failedWithRawMessage(String message, Object... parameters) {
		failWithRawMessage(message, parameters);
	}

}