package org.stepdefinition;

import org.base.BaseClass;

import cucumber.api.java.Before;

public class HooksClass extends BaseClass {

	@Before
	private void precondition() {
		LaunchBrowser();
		windowMaximize();
	}

	private void postcondition() {
		CloseBrowser();
	}
}
