package com.ulfric.veracity.suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.google.common.truth.Truth;

import com.ulfric.dragoon.reflect.Instances;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Objects;

public abstract class BeanTestSuite {

	private final Class<?> beanType;
	protected Object bean;

	protected BeanTestSuite(Class<?> beanType) {
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

			if (Modifier.isStatic(field.getModifiers())) {
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
			Object newValue = UnsafeHelper.instance(field.getType());
			if (original == newValue) {
				continue;
			}

			setter.invoke(bean, newValue);
			Truth.assertThat(getter.invoke(bean)).isSameAs(newValue);
		}
	}

}