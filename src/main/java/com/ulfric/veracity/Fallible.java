package com.ulfric.veracity;

public interface Fallible {

	void failed(String verb);

	void failed(String verb, Object other);

	void failed(String verb, Object... others);

	void failedWithRawMessage(String message, Object... parameters);

}