package com.ulfric.veracity;

import org.w3c.dom.Node;

import com.google.common.truth.FailureStrategy;

import java.util.Objects;

public final class NodeSubject extends VeracitySubject<NodeSubject, Node> implements NamedAssertions<Node> {

	public NodeSubject(FailureStrategy failureStrategy, Node actual) {
		super(failureStrategy, actual);
	}

	@Override
	public String getName() {
		return actual().getNodeName();
	}

	public void hasNodeValue(String expected) {
		if (expected == null) {
			doesNotHaveNodeValue();
			return;
		}

		hasNodeValue();

		if (!actual().getNodeValue().equals(expected)) {
			fail("has expected node value", expected);
		}
	}

	public void hasNodeValue() {
		isNotNull();

		if (actual().getNodeValue() == null) {
			fail("has node value");
		}
	}

	public void doesNotHaveNodeValue() {
		isNotNull();

		if (actual().getNodeValue() == null) {
			fail("has node value");
		}
	}

	public void hasAttributeWithValue(String attribute, String expected) {
		hasAttribute(attribute);

		String actual = actual().getAttributes().getNamedItem(attribute).getNodeValue();
		if (!Objects.equals(expected, actual)) {
			fail("has attribute with expected", attribute, expected, actual);
		}
	}

	public void hasAttribute(String attribute) {
		hasAttributes();

		if (actual().getAttributes().getNamedItem(attribute) == null) {
			fail("has attribute", attribute);
		}
	}

	public void hasAttributes() {
		isNotNull();

		if (!actual().hasAttributes()) {
			fail("has attributes");
		}
	}

}
