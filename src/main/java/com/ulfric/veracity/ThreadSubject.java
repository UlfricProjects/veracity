package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;

public final class ThreadSubject extends VeracitySubject<ThreadSubject, Thread> {

	public ThreadSubject(FailureStrategy failureStrategy, Thread actual) {
		super(failureStrategy, actual);
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
