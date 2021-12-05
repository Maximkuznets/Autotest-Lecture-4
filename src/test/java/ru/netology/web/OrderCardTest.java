package ru.netology.web;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class OrderCardTest {

    @Test
    public void shouldTest() {
        open("http://localhost:9999/");


        $("[data-test-id=city] [class=input__control]").setValue("Саратов");
        $("[data-test-id=date] [class=input__control]").setValue("11.12.2021");

        $("[data-test-id=name] [class=input__control]").setValue("Иванов Иван");
        $("[data-test-id=phone] [class=input__control]").setValue("+79012347790");
        $(".checkbox__box").click();

        $("button").click();

        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));


    }

    @Test
    public void shouldTestCollection() {
        open("http://localhost:9999/");

        ElementsCollection fields = $$("[class=input__control]");
        fields.get(0).setValue("Волгоград");
        fields.get(1).setValue("10.12.2021");
        fields.get(2).setValue("Петров Иван");
        fields.get(3).setValue("+79012347790");

        $(".checkbox__box").click();

        $("button").click();

        $(withText("Встреча успешно забронирована")).shouldBe(visible, Duration.ofSeconds(15));


    }
}
