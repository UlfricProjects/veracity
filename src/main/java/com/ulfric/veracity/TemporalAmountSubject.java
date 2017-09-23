package com.ulfric.veracity;

import com.google.common.truth.FailureMetadata;

import java.time.Duration;
import java.time.temporal.TemporalAmount;

public final class TemporalAmountSubject extends VeracitySubject<TemporalAmountSubject, TemporalAmount> {

	public TemporalAmountSubject(FailureMetadata metadata, TemporalAmount actual) {
		super(metadata, actual);
	}
	public void isEqualToWithinMarginOfError(Duration duration) {
		isNotNull();

		long difference = Math.abs(Duration.from(actual()).toMillis() - duration.toMillis());
		if (difference > 1) {
			failed("within margin of error");
		}
	}

}
