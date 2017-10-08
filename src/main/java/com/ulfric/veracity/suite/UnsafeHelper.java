package com.ulfric.veracity.suite;

import com.ulfric.dragoon.reflect.Instances;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Proxy;

public class UnsafeHelper {

	private static final sun.misc.Unsafe UNSAFE;

	static {
		try {
			Field field = sun.misc.Unsafe.class.getDeclaredField("theUnsafe");
			field.setAccessible(true);
			UNSAFE = (sun.misc.Unsafe) field.get(null);
		} catch (IllegalAccessException | NoSuchFieldException | SecurityException exception) {
			throw new RuntimeException(exception);
		}
	}

	public static Object instance(Class<?> type) {
		if (type.isArray()) {
			return Array.newInstance(type, 0);
		}
		if (type.isPrimitive()) {
			return Array.get(Array.newInstance(type, 1), 0);
		}
		if (type == Class.class) {
			return Object.class;
		}
		if (type.isInterface()) {
			return Proxy.newProxyInstance(type.getClassLoader(), new Class<?>[] { type },
					(proxy, method, args) -> null);
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

	private UnsafeHelper() {
	}

}