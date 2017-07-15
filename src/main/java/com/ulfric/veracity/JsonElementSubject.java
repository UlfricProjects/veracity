package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;
import com.google.gson.JsonElement;

public class JsonElementSubject extends JsonSubject<JsonElement> {

	public JsonElementSubject(FailureStrategy failureStrategy, JsonElement actual) {
		super(failureStrategy, actual);
	}

}