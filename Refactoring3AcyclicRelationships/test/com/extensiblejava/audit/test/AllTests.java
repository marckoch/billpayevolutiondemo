package com.extensiblejava.audit.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

public class AllTests extends TestCase {

	public AllTests(String name) {
		super(name);
	}

	public static void main(String[] args) {
		TestRunner.run(AllTests.suite());
	}

	public static Test suite() {
		TestSuite packageTests = new TestSuite(AllTests.class.getName());
		packageTests.addTestSuite(AuditFacade1Test.class);

		return packageTests;

	}

}