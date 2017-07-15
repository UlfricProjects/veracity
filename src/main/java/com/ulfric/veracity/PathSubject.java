package com.ulfric.veracity;

import com.google.common.truth.FailureStrategy;

import java.nio.file.Files;
import java.nio.file.Path;

public final class PathSubject extends VeracitySubject<PathSubject, Path> {

	public PathSubject(FailureStrategy failureStrategy, Path actual) {
		super(failureStrategy, actual);
	}

	public void exists() {
		isNotNull();

		if (Files.notExists(actual())) {
			failed("exists");
		}
	}

	public void doesNotExist() {
		isNotNull();

		if (Files.exists(actual())) {
			failed("does not exist");
		}
	}

	public void isRegularFile() {
		isNotNull();

		if (!Files.isRegularFile(actual())) {
			failed("is regular file");
		}
	}

}
