package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;
import com.google.common.truth.Subject;

import java.util.function.BiFunction;

public class SubjectFactories {

	public static <T, S extends Subject<S, T>> Subject.Factory<S, T> of(BiFunction<FailureMetadata, T, S> function) {
		return new Subject.Factory<S, T>() {

			@Override
			public S createSubject(FailureMetadata failure, T target) {
				return function.apply(failure, target);
			}

		};
	}

	private SubjectFactories() {
	}

}