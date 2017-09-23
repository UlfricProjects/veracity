package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;

import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.Files;
import java.nio.file.Path;

public final class PathSubject extends VeracitySubject<PathSubject, Path> {

	public PathSubject(FailureMetadata metadata, Path actual) {
		super(metadata, actual);
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

	public void contentEquals(String expected) {
		isNotNull();

		try {
			String contents = new String(Files.readAllBytes(actual()));
			if (!contents.equals(expected)) {
				failed("content equals", contents, expected);
			}
		} catch (IOException e) {
			throw new UncheckedIOException(e);
		}
	}

}
