package com.jsystems.qa.qugui;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class FrontendTest extends ConfigFrontend {

  @Test
  public void frontTest() {
    driver.get("https://wordpress.com/");
    WebElement textElement_1 = driver.findElement(By.cssSelector(".lpc-headline-title.lp-headline-title span:nth-child(1)"));
    String text1 = textElement_1.getText();
    assertTrue(text1.equals("WordPress powers"));

    WebElement textElement_2 = driver.findElement(By.cssSelector(".lpc-headline-title.lp-headline-title span:nth-child(2)"));
    String text2 = textElement_2.getText();
    assertTrue(text2.matches("\\d+(% of the internet.)"));

    try{
      Thread.sleep(2000);
    } catch (InterruptedException e){
      e.printStackTrace();
    }
  }
}