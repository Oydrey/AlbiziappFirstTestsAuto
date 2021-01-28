package com.automation.selenium;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.automation.selenium.goran.AllTestsGoran;
import com.automation.selenium.manal.AllTestsManal;
import com.automation.selenium.matheo.AllTestsMatheo;
import com.automation.selenium.salim.TestSalim;

@RunWith(Suite.class)
@SuiteClasses({ AllTestsGoran.class, AllTestsManal.class, AllTestsMatheo.class, TestSalim.class, TestsCommonMethods.class })
public class AlbiziappTest {

}
