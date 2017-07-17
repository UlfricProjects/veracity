package com.ulfric.veracity.suite;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.apache.commons.lang3.reflect.FieldUtils;

import com.ulfric.dragoon.reflect.Instances;

import java.lang.reflect.Field;
import java.util.Objects;

public abstract class BeanTestSuite<T> {

	private final Class<T> beanType;
	protected T bean;

	BeanTestSuite(Class<T> beanType) {
		Objects.requireNonNull(beanType, "beanType");

		this.beanType = beanType;
	}

	@BeforeEach
	final void setupBeanSuite() {
		bean = Instances.instance(beanType);
	}

	@Test
	void testBeanFields() {
		for (Field field : FieldUtils.getAllFieldsList(beanType)) {
			
		}
	}

}