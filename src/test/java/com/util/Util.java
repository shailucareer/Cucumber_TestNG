package com.util;

import org.openqa.selenium.JavascriptExecutor;

import StepDefs.util.DriverManager;

public class Util {
	public static void wait(int num) {
		try {
			Thread.sleep(num*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void runJavaScript(String script) {
	}
	
	
}
