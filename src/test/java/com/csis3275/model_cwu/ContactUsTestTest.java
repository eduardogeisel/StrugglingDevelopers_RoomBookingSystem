package com.csis3275.model_cwu;

//Generated by Selenium IDE
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
import java.util.concurrent.TimeUnit;
import java.net.MalformedURLException;
import java.net.URL;
public class ContactUsTestTest {
private WebDriver driver;
private Map<String, Object> vars;
JavascriptExecutor js;
@Before
public void setUp() {
	System.setProperty("webdriver.chrome.driver", "c:/temp/chromedriver.exe");
 driver = new ChromeDriver();
 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 js = (JavascriptExecutor) driver;
 vars = new HashMap<String, Object>();
}
@After
public void tearDown() {
 driver.quit();
}
@Test
public void contactUsTest() {
 driver.get("http://localhost:8080/StrugglingDevelopers_RoomBookingSystem/");
 driver.manage().window().setSize(new Dimension(1082, 839));
 driver.findElement(By.linkText("Login")).click();
 driver.findElement(By.id("email")).click();
 driver.findElement(By.id("email")).sendKeys("etakisa@shutterfly.com");
 driver.findElement(By.id("password")).click();
 driver.findElement(By.id("password")).sendKeys("NBDhya6k");
 driver.findElement(By.cssSelector(".btn")).click();
 driver.findElement(By.cssSelector(".nav-item:nth-child(6) > .nav-link")).click();
 driver.findElement(By.cssSelector(".form-row:nth-child(1) > .form-group:nth-child(1) > .form-control")).click();
 driver.findElement(By.cssSelector(".form-row:nth-child(1) > .form-group:nth-child(1) > .form-control")).sendKeys("Travis");
 driver.findElement(By.cssSelector(".form-row:nth-child(1) > .form-group:nth-child(2) > .form-control")).sendKeys("cwu@gmail.com");
 driver.findElement(By.cssSelector(".form-row:nth-child(2) > .form-group:nth-child(1) > .form-control")).sendKeys("1234567");
 driver.findElement(By.cssSelector(".form-row:nth-child(2) > .form-group:nth-child(2) > .form-control")).click();
 {
   WebElement dropdown = driver.findElement(By.cssSelector(".form-row:nth-child(2) > .form-group:nth-child(2) > .form-control"));
   dropdown.findElement(By.xpath("//option[. = 'China']")).click();
 }
 driver.findElement(By.cssSelector(".form-row:nth-child(2) > .form-group:nth-child(2) > .form-control")).click();
 driver.findElement(By.cssSelector(".form-row:nth-child(3) .form-control")).click();
 driver.findElement(By.cssSelector(".form-row:nth-child(3) .form-control")).sendKeys("Issue");
 driver.findElement(By.id("content")).sendKeys("How to fix that?");
 driver.findElement(By.cssSelector(".btn")).click();
 driver.findElement(By.linkText("Home")).click();
 driver.findElement(By.linkText("Logout")).click();
 driver.findElement(By.id("email")).click();
 driver.findElement(By.id("email")).sendKeys("admin@admin.com");
 driver.findElement(By.id("password")).click();
 driver.findElement(By.id("password")).sendKeys("admin");
 driver.findElement(By.cssSelector(".btn")).click();
 driver.findElement(By.cssSelector(".nav-item:nth-child(2) > .nav-link")).click();
 assertThat(driver.findElement(By.cssSelector("tr:nth-child(12) > td:nth-child(3)")).getText(), is("100029323"));
}
}
