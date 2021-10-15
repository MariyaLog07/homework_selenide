package ru.desnol;

import com.codeborne.selenide.Configuration;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byLinkText;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WikiSelenide {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    void findWiki() {
        open("https://github.com/selenide/selenide");
        $("#wiki-tab").click();
        $(byText("Show 2 more pages…")).scrollTo();
        $("#wiki-pages-box").$(byText("Show 2 more pages…")).click();
        $(byLinkText("SoftAssertions")).shouldHave(text(" SoftAssertions"));
        $(byLinkText("SoftAssertions")).click();
        $(byText("Using JUnit5 extend test class:")).shouldBe(visible);
    }
}




