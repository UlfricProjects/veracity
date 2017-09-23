package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;

public final class CheckedRunnableSubject extends VeracitySubject<CheckedRunnableSubject, CheckedRunnable> {

	public CheckedRunnableSubject(FailureMetadata metadata, CheckedRunnable actual) {
		super(metadata, actual);
	}

	public void runsWithoutExceptions() {
		isNotNull();

		Throwable thrown = run();
		if (run() != null) {
			failed("runs without exceptions", thrown);
		}
	}

	public void doesThrow(Class<? extends Throwable> expected) {
		isNotNull();

		Throwable thrown = run();
		if (!expected.isInstance(thrown)) {
			failed("does throw", expected, thrown);
		}
	}

	private Throwable run() {
		try {
			actual().run();
			return null;
		} catch (Throwable thrown) {
			return thrown;
		}
	}

}
