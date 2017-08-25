package com.ulfric.veracity;

import org.w3c.dom.Node;

import com.google.common.truth.FailureStrategy;

public final class NodeSubject extends VeracitySubject<NodeSubject, Node> implements NamedAssertions<Node> {

	public NodeSubject(FailureStrategy failureStrategy, Node actual) {
		super(failureStrategy, actual);
	}

	@Override
	public String getName() {
		return actual().getNodeName();
	}

}
