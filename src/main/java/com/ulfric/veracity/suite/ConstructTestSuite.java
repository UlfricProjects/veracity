package com.ulfric.veracity.suite;

import org.junit.jupiter.api.Test;

import com.google.common.truth.Truth;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class ConstructTestSuite {

	private final Class<?> type;

	protected ConstructTestSuite(Class<?> type) {
		this.type = type;
	}

	@Test
	void testAllConstructorsCanBeCalled() throws Exception {
		Set<Constructor<?>> constructors = Stream.of(type.getDeclaredConstructors(), type.getConstructors())
			.flatMap(Arrays::stream)
			.filter(constructor -> !constructor.isSynthetic())
			.peek(constructor -> constructor.setAccessible(true))
			.collect(Collectors.toSet());

		for (Constructor<?> constructor : constructors) {
			Class<?>[] parameterTypes = constructor.getParameterTypes();
			Object[] parameters = new Object[parameterTypes.length];
			for (int x = 0; x < parameterTypes.length; x++) {
				parameters[x] = UnsafeHelper.instance(parameterTypes[x]);
			}
			Truth.assertThat(constructor.newInstance(parameters)).isNotNull();
		}
	}

}