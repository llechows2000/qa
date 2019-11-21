package com.jsystems.qa.qugui;

import com.jsystems.qa.qugui.page.LoginPage;
import com.jsystems.qa.qugui.page.MainWordpressPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ActionTest extends ConfigFrontend {

    //MainWordpressPage mainPage;

    @Test
    public void actionTest() {

        driver.navigate().to(Configuration.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.loginIcon.click();

        Actions action = new Actions(driver);
        action.moveToElement(
                mainPage.loginIcon,
                5, 5);
        action.clickAndHold(); // mouse click
        action.moveByOffset(5, 5); // przeciągnij
        action.release(); // uwolnj
        action.build().perform(); //zbuduj i wykonaj wszystkie akcje
    }

    @Test
    public void actionNextTest() {

        driver.get(Configuration.BASE_URL);
        MainWordpressPage mainPage = new MainWordpressPage(driver);
        mainPage.loginIcon.click();
        LoginPage loginPage = new LoginPage(driver);

        // akcje możemy budować wielo-etapowe
        Actions action = new Actions(driver);
        action.moveToElement(loginPage.usernameInput) //przesuwa kursor na pole
                .sendKeys(Configuration.LOGIN) //wstawia tekst login
                .moveToElement(loginPage.usernameButton) //przesuwa kursor na button
                // jak po . klikniecie Ctrl + space to rozwinie wam się lista dostępnych metod z klasy Actions
                .click() //mouse click
                .build().perform(); //zbuduj i wykonaj wszystkie akcje

        loginPage.waitForElementToBeVisibility(loginPage.inputPassword,15);
        assertTrue(loginPage.inputPassword.isDisplayed());

        //passwordPage = new PasswordPage(driver);
        //passwordPage.waitForVisibilityOfElement(passwordPage.passwordInput, 15);
        //passwordPage.isContentPresent();
    }

    @Test
    public void testBasicRInteraction() {
        Actions do42 = new Actions(driver);
        do42.sendKeys(Keys.chord(Keys.CONTROL, "l"));
        do42.sendKeys(Keys.ESCAPE);
        do42.sendKeys("41 + 1");
        do42.sendKeys(Keys.ENTER);
        do42.perform();
    }

}
