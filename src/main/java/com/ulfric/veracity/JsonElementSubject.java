package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;
import com.google.gson.JsonElement;

public class JsonElementSubject extends JsonSubject<JsonElement> {

	public JsonElementSubject(FailureMetadata metadata, JsonElement actual) {
		super(metadata, actual);
	}

}