package com.ulfric.veracity;

public interface ObjectAssertions<T> extends Fallible, ValueHolder<T> {

	void isNotNull();

}