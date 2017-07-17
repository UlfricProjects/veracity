package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;

import java.util.Arrays;

public final class ClassSubject extends VeracitySubject<ClassSubject, Class<?>> implements NamedAssertions<Class<?>> {

	public ClassSubject(FailureStrategy failureStrategy, Class<?> actual) {
		super(failureStrategy, actual);
	}

	@Override
	public String getName() {
		return actual().getSimpleName();
	}

	public void hasMethod(String name, Class<?>... parameterTypes) {
		isNotNull();

		try {
			actual().getMethod(name, parameterTypes);
		} catch (NoSuchMethodException | SecurityException e) {
			fail("has method", name, Arrays.toString(parameterTypes));
		}
	}

}
