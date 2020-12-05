package com.csis3275.automated_blackbox_test_epe_07;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNot.not;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import java.util.*;
import java.net.MalformedURLException;
import java.net.URL;
public class ViewRoomPhotosTest {
  private WebDriver driver;
  private Map<String, Object> vars;
  JavascriptExecutor js;
  @Before
  public void setUp() {
	System.setProperty("webdriver.chrome.drive", "C:/temp/chromedriver.exe");
    driver = new ChromeDriver();
    js = (JavascriptExecutor) driver;
    vars = new HashMap<String, Object>();
  }
  @After
  public void tearDown() {
    driver.quit();
  }
  @Test
  public void viewRoomPhotosTest() {
    driver.get("http://localhost:8080/StrugglingDevelopers_RoomBookingSystem/");
    driver.manage().window().setSize(new Dimension(968, 1040));
    driver.findElement(By.linkText("Login")).click();
    driver.findElement(By.id("email")).click();
    driver.findElement(By.id("email")).sendKeys("etakisa@shutterfly.com");
    driver.findElement(By.id("password")).click();
    driver.findElement(By.id("password")).sendKeys("NBDhya6K");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".text-center")).click();
    driver.findElement(By.id("password")).sendKeys("NBDhya6k");
    driver.findElement(By.cssSelector(".btn")).click();
    driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
    driver.findElement(By.linkText("Room Photos")).click();
    //assertThat(driver.findElement(By.xpath("//table[3]/tbody/tr[2]/td")).getText(), is("Lab room photo"));
    //assertEquals(driver.findElement(By.xpath("//table[3]/tbody/tr[2]/td")).getText(), is("Lab room photo"));
  }
}
