package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;
import com.google.common.truth.Subject;
import com.google.common.truth.Truth;
import com.google.gson.JsonElement;

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

	private static <T, S extends Subject<S, T>> S subject(BiFunction<FailureStrategy, T, S> function, T value) {
		return Truth.assertAbout(SubjectFactories.of(function)).that(value);
	}

	private Veracity() {
	}

}
