package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;
import java.time.LocalDate;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class OrderCardTest {
    String dateMeeting;

    @BeforeEach
    public void setupDate() {
        LocalDate date = LocalDate.now();
        date = date.plusDays(3);
        int year = date.getYear();
        int month = date.getMonthValue();
        int day = date.getDayOfMonth();
        dateMeeting = day + "." + month + "." + year;

    }

    @Test
    public void shouldTest() {
        open("http://localhost:9999/");

        $("[data-test-id=city] input").setValue("Саратов");

        $("[data-test-id=date] input").doubleClick().sendKeys(Keys.BACK_SPACE);

        $("[data-test-id=date] input").setValue(dateMeeting);

        $("[data-test-id=name] input").setValue("Иванов Иван");
        $("[data-test-id=phone] input").setValue("+79012347790");
        $(".checkbox__box").click();

        $(".button__text").click();

        $("[data-test-id=\"notification\"]").shouldHave(text("Встреча успешно забронирована на " + dateMeeting), Duration.ofSeconds(15));
    }

}
