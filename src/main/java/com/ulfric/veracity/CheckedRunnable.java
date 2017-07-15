package com.ulfric.veracity;

@FunctionalInterface
public interface CheckedRunnable {

	void run() throws Throwable;

}