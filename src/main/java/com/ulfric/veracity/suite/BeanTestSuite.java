package com.ulfric.veracity.suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.google.common.truth.Truth;

import com.ulfric.dragoon.reflect.Instances;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

import sun.misc.Unsafe;

@SuppressWarnings("restriction")
public abstract class BeanTestSuite<T> {

	private static final sun.misc.Unsafe UNSAFE;

	static {
		try {
			Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			UNSAFE = (Unsafe) field.get(null);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException exception) {
			throw new RuntimeException(exception);
		}
	}

	private final Class<T> beanType;
	protected T bean;

	protected BeanTestSuite(Class<T> beanType) {
		Objects.requireNonNull(beanType, "beanType");

		this.beanType = beanType;
	}

	@BeforeEach
	final void setupBeanSuite() {
		bean = Instances.instance(beanType);
	}

	@Test
	void testBeanMethodsModifyFields() throws Exception {
		for (Field field : FieldUtils.getAllFieldsList(beanType)) {
			if (field.isSynthetic()) {
				continue;
			}

			String name = field.getName();
			name = Character.toUpperCase(name.charAt(0)) + name.substring(1);

			Method getter = beanType.getMethod("get" + name);
			Method setter = beanType.getMethod("set" + name, field.getType());
			if (!Modifier.isPublic(beanType.getModifiers())) {
				getter.setAccessible(true);
				setter.setAccessible(true);
			}

			Object original = getter.invoke(bean);
			Object newValue = instance(field.getType());
			if (original == newValue) {
				continue;
			}

			setter.invoke(bean, newValue);
			Truth.assertThat(getter.invoke(bean)).isSameAs(newValue);
		}
	}

	private Object instance(Class<?> type) {
		if (type.isArray()) {
			return Array.newInstance(type, 0);
		}
		if (type.isPrimitive()) {
			return Array.get(Array.newInstance(type, 1), 0);
		}

		Object regular = Instances.instance(type);
		if (regular != null) {
			return regular;
		}

		try {
			return UNSAFE.allocateInstance(type);
		} catch (InstantiationException exception) {
			throw new RuntimeException(exception);
		}
	}

}