package ru.netology.test;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import ru.netology.data.SQLHelper;
import ru.netology.pages.MainPage;

import static com.codeborne.selenide.Selenide.open;

public class TestBase {
    protected MainPage mainPage;

    @BeforeAll
    static void setUp() {
        Configuration.screenshots = false;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterAll
    static void tearDown() {
        SelenideLogger.removeListener("allure");
    }

    @BeforeEach
    void setUpUrl() {
      mainPage =  open(System.getProperty("sut.url"), MainPage.class);
    }

    @AfterEach
    void cleanDb() {
        SQLHelper.cleanDb();
    }
}