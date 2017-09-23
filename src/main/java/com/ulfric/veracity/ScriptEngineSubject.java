package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;

import javax.script.ScriptEngine;

import java.util.Objects;

public final class ScriptEngineSubject extends VeracitySubject<ScriptEngineSubject, ScriptEngine> implements NamedAssertions<ScriptEngine> {

	public ScriptEngineSubject(FailureMetadata metadata, ScriptEngine actual) {
		super(metadata, actual);
	}

	@Override
	public String getName() {
		return actual().getFactory().getEngineName();
	}

	public void isUsingLanguage(String name) {
		isNotNull();

		String actual = actual().getFactory().getLanguageName();
		if (!Objects.equals(name, actual)) {
			failedWithRawMessage("Not true that %s (%s) is using language %s",
					actualValueAsString(), actual, name);
		}
	}

}
