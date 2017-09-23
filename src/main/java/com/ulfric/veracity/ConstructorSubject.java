package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

public final class ConstructorSubject extends VeracitySubject<ConstructorSubject, Constructor<?>> {

	public ConstructorSubject(FailureMetadata metadata, Constructor<?> actual) {
		super(metadata, actual);
	}

	public void isPrivate() {
		isNotNull();

		if (!Modifier.isPrivate(actual().getModifiers())) {
			failed("is private");
		}
	}

}
