package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public final class ConstructorSubject extends VeracitySubject<ConstructorSubject, Constructor<?>> {

	public ConstructorSubject(FailureStrategy failureStrategy, Constructor<?> actual) {
		super(failureStrategy, actual);
	}

	public void isPrivate() {
		isNotNull();

		if (!Modifier.isPrivate(actual().getModifiers())) {
			failed("is private");
		}
	}

}
