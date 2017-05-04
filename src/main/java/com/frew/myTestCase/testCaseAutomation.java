package com.frew.myTestCase;
/*
 * The test case has worked fine and passed all the test. 
 * However, I could not rectify the errors that I am getting 
 * from Selinum.
 * 
 */

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class testCaseAutomation {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/");
		selenium.start();
	}

	@Test
	public void testMyTestCases() throws Exception {
		selenium.open("/");
		selenium.type("id=Name", "Frew Getaneh");
		selenium.type("id=Email", "frewgetaneh@gmail.com");
		selenium.type("id=shift", "Monday Morning");
		selenium.click("id=Create");
		selenium.type("id=Name", "Steve Long");
		selenium.type("id=Email", "steve@email.com");
		selenium.type("id=shift", "Monday Afternoon");
		selenium.click("id=Create");
		selenium.click("id=refresh");
		selenium.type("id=ID", "31");
		selenium.type("id=Name", "Steve");
		selenium.type("id=Email", "Jobs");
		selenium.type("id=shift", "For long");
		selenium.click("id=Update");
		selenium.click("id=refresh");
		selenium.type("id=ID", "31");
		selenium.click("id=Delete");
		selenium.click("id=refresh");
		selenium.type("id=Name", "Frew Getaneh");
		selenium.type("id=Email", "frew@email.com");
		selenium.type("id=shift", "Tuesday Night");
		selenium.click("id=Create");
		selenium.type("id=Name", "Amy");
		selenium.type("id=Email", "Green");
		selenium.type("id=shift", "Wednesday Night");
		selenium.click("id=Create");
		selenium.type("id=Name", "Sophie");
		selenium.type("id=Email", "Jones");
		selenium.type("id=shift", "Monday Day");
		selenium.click("id=Create");
		selenium.click("id=refresh");
		selenium.type("id=ID", "37");
		selenium.click("id=Delete");
		selenium.click("id=refresh");
		selenium.type("id=ID", "36");
		selenium.type("id=Name", "Emily");
		selenium.type("id=Email", "Morris");
		selenium.type("id=shift", "Friday Night");
		selenium.click("id=Update");
		selenium.click("id=refresh");
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
