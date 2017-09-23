package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;
import com.google.gson.JsonElement;

public abstract class JsonSubject<T extends JsonElement> extends VeracitySubject<JsonSubject<T>, T> {

	public JsonSubject(FailureMetadata metadata, T actual) {
		super(metadata, actual);
	}

	public final void isJsonArray() {
		isNotNull();

		if (!actual().isJsonArray()) {
			fail("is json array");
		}
	}

	public final void isNotJsonArray() {
		isNotNull();

		if (actual().isJsonArray()) {
			fail("is not json array");
		}
	}

	public final void isJsonObject() {
		isNotNull();

		if (!actual().isJsonObject()) {
			fail("is json object");
		}
	}

	public final void isNotObject() {
		isNotNull();

		if (actual().isJsonObject()) {
			fail("is not json object");
		}
	}

	public final void isJsonPrimitive() {
		isNotNull();

		if (!actual().isJsonPrimitive()) {
			fail("is json primitive");
		}
	}

	public final void isNotJsonPrimitive() {
		isNotNull();

		if (actual().isJsonPrimitive()) {
			fail("is not json primitive");
		}
	}

	public final void isJsonNull() {
		isNotNull();

		if (!actual().isJsonNull()) {
			fail("is json null");
		}
	}

	public final void isNotJsonNull() {
		isNotNull();

		if (actual().isJsonNull()) {
			fail("is not json null");
		}
	}

}
