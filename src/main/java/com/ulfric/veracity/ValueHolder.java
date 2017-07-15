package com.ulfric.veracity;

public interface ValueHolder<T> {

	T actualValue();

	String actualValueAsString();

}