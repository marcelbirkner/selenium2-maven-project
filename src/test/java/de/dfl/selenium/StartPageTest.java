package de.dfl.selenium;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class StartPageTest extends AbstractPageTest {

	private String pageLink = "/";
	
	@Test
	public void openPageAndValidateTitle() {
		open(pageLink);
		assertTrue("Page title does not match", driver.getTitle() != null );
	}
	
	@Test
	public void checkThatLoginDropdownButtonIsDisplayed() {
		open(pageLink);
		WebElement searchField = driver.findElement(By.id("lst-ib"));
		assertTrue(searchField.isDisplayed());
	}

}