package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;

public final class ThreadSubject extends VeracitySubject<ThreadSubject, Thread> {

	public ThreadSubject(FailureMetadata metadata, Thread actual) {
		super(metadata, actual);
	}

	public void isAlive() {
		isNotNull();

		if (!actual().isAlive()) {
			failed("is alive");
		}
	}

	public void isNotAlive() {
		isNotNull();

		if (actual().isAlive()) {
			failed("is not alive");
		}
	}

}
