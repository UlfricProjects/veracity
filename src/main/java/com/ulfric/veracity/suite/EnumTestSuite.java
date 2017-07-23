package com.ulfric.veracity.suite;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Method;

public abstract class EnumTestSuite {

	private final Class<? extends Enum<?>> type;

	public EnumTestSuite(Class<? extends Enum<?>> type) {
		this.type = type;
	}

	@Test
	void testEnumValues() throws Exception {
		Method values = type.getMethod("values");
		values.setAccessible(true);
		values.invoke(null);
	}

	@Test
	void testValueOf() throws Exception {
		Method valueOf = type.getMethod("valueOf", String.class);
		valueOf.setAccessible(true);
		valueOf.invoke(null, type.getEnumConstants()[0].name());
	}

}