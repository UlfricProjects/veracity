package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.Truth;
import com.google.gson.JsonElement;

import javax.script.ScriptEngine;

import java.lang.reflect.Constructor;
import java.nio.file.Path;
import java.util.function.BiFunction;

public class Veracity {

	public static ThreadSubject assertThat(Thread value) {
		return subject(ThreadSubject::new, value);
	}

	public static CheckedRunnableSubject assertThat(CheckedRunnable value) {
		return subject(CheckedRunnableSubject::new, value);
	}

	public static JsonElementSubject assertThat(JsonElement value) {
		return (JsonElementSubject) subject(JsonElementSubject::new, value);
	}

	public static ConstructorSubject assertThat(Constructor<?> value) {
		return subject(ConstructorSubject::new, value);
	}

	public static PathSubject assertThat(Path value) {
		return subject(PathSubject::new, value);
	}

	public static ScriptEngineSubject assertThat(ScriptEngine value) {
		return subject(ScriptEngineSubject::new, value);
	}

	private static <T, S extends Subject<S, T>> S subject(BiFunction<FailureStrategy, T, S> function, T value) {
		return Truth.assertAbout(SubjectFactories.of(function)).that(value);
	}

	private Veracity() {
	}

}
