package de.mb.selenium;

import static org.junit.Assert.assertTrue;

import java.net.MalformedURLException;
import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class GoogleStartPageTest {

	private WebDriver driver;

	@Before
	public void setUp() throws MalformedURLException {
		String serverUrl = System.getProperty("grid.server.url");
		String gridServerUrl = "http://192.168.99.1:4444/wd/hub";
		if (serverUrl != null) {
			gridServerUrl = serverUrl;
		}
		DesiredCapabilities capability = DesiredCapabilities.firefox();
		URL gridUrl = new URL(gridServerUrl);
		driver = new RemoteWebDriver(gridUrl, capability);
		driver.get("http://www.google.com");
	}

	@After
	public void tearDownWebDriver() {
		driver.quit();
	}

	@Test
	public void pageTitleIsNotNull() throws MalformedURLException {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		assertTrue(driver.getTitle() != null);
	}

	@Test
	public void pageTitleContainsGoogle() throws MalformedURLException {
		WebElement element = driver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		assertTrue(driver.getTitle().contains("Google"));
	}

}