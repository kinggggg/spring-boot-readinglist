package com.readinglist;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ServerWebTests {
  
  private static FirefoxDriver browser;

  private static int port;

  @BeforeClass
  public static void openBrowser() {
    System.out.println(port);

    browser = new FirefoxDriver();
    browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @Test
  public void addBookToEmptyList() {
    String baseUrl = "http://localhost:8080" ;
    System.out.println(port);
    browser.get(baseUrl);
    assertEquals("You have no books in your book list",browser.findElementByTagName("div").getText());

    browser.findElementByName("title")
            .sendKeys("BOOK TITLE");
    browser.findElementByName("author")
            .sendKeys("BOOK AUTHOR");
    browser.findElementByName("isbn")
            .sendKeys("1234567890");
    browser.findElementByName("description")
            .sendKeys("DESCRIPTION");
    browser.findElementByTagName("form")
            .submit();
    WebElement dl =
            browser.findElementByCssSelector("dt.bookHeadline");
    assertEquals("BOOK TITLE by BOOK AUTHOR (ISBN: 1234567890)",
            dl.getText());
    WebElement dt =
            browser.findElementByCssSelector("dd.bookDescription");
    assertEquals("DESCRIPTION", dt.getText());
  }
  
  @AfterClass
  public static void closeBrowser() {
    browser.quit();
  }

}
