import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Condition.text;

public class SimpleJUnitTest {

    String url;

    @BeforeEach
    void befoerEach() {
        url = "ya.ru";
    }

    @Test
    void firstTest() {
        open("https:" + url + "/");
        $("[name=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("selenide"));

    }

    @Test
    void secondTest() {
        open("https:" + url + "/");
        $("[name=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("selenide"));
    }

    @Test
    void thidTest() {
        open("https:" + url + "/");
        $("[name=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("selenide"));
    }

}
